package cl.uach.kelluwen.nlp.engines.weka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;

import cl.uach.kelluwen.nlp.types.Token;
import cl.uach.kelluwen.nlp.types.Topic;
import cl.uach.kelluwen.nlp.types.evaluation.Reference;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class TopicClassifier2 extends JCasAnnotator_ImplBase {

	private final static String PARAM_MODELPATH = "modelFilename";
	private final static String PARAM_ATTRIBUTESLISTPATH = "attributesListFilename";
	private String modelPath;
	private String attributesPath;
	private Classifier clasifier;
	private ArrayList<String> attributes;
	private Instances dataUnlabeled;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		// Parent initialization
		super.initialize(aContext);
		// Parameter
		modelPath = (String) aContext.getConfigParameterValue(PARAM_MODELPATH);
		attributesPath = (String) aContext.getConfigParameterValue(PARAM_ATTRIBUTESLISTPATH);
		attributes = new ArrayList<String>();

		//deserialize model and load attributes list
		try {
			clasifier = (Classifier) SerializationHelper.read(modelPath);
			//load attributes list
			String text = FileUtils.file2String(new File(attributesPath.trim()), "UTF-8");
			StringTokenizer stLines= new StringTokenizer(text,"\n");
			while (stLines.hasMoreTokens()){
				attributes.add(stLines.nextToken());
			}

			//Declare the dataset
			FastVector fvWekaAttributes = new FastVector();
			for(String attribute: attributes) {
				Attribute anAttribute = new Attribute(attribute);
				fvWekaAttributes.addElement(anAttribute);
			}
			// Declare the class attribute along with its values
			FastVector fvClassVal = new FastVector(3);
			fvClassVal.addElement("1");fvClassVal.addElement("2");fvClassVal.addElement("3");
			
			Attribute classAttribute = new Attribute("theClass", fvClassVal);
			//add the class in the feature vector
			fvWekaAttributes.addElement(classAttribute);

			// Create an empty training set
			dataUnlabeled = new Instances("Topic", fvWekaAttributes, 0);
			// Set class index
			dataUnlabeled.setClassIndex(dataUnlabeled.numAttributes()-1);

		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		HashMap<String,Integer> lemmasMap=new HashMap<String,Integer>();
		// Browse for all those token annotations and complete the lemmas map
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token tokenAnnotation = (Token) itToken.next();
			//Filter stop words
			if (!tokenAnnotation.getStopWord()){
				String lemma = tokenAnnotation.getLemma();

				if (tokenAnnotation.getCoveredText().startsWith("http://")){
					if (tokenAnnotation.getCoveredText().contains("youtube")){
						lemma="youtube";
					}
					else lemma="http";
				}
				//Integer tfIdf = new Integer((int) tokenAnnotation.getTextMetric().getTFIDF());
				if (!lemmasMap.containsKey(lemma)){
					lemmasMap.put(lemma, 1);
				}
				else {lemmasMap.put(lemma, lemmasMap.get(lemma)+1);}
			}
		}

		//Build instance
		Instance instance = new Instance(attributes.size());
		for (int i = 0 ; i<attributes.size();i++){
			String attributeName = attributes.get(i);
			if (lemmasMap.containsKey(attributeName)){
				instance.setValue(i, lemmasMap.get(attributeName));
			}
			else instance.setValue(i,0.0);
		}
		
		dataUnlabeled.add(instance);
		
		//Classify
		try {
			double result = clasifier.classifyInstance(dataUnlabeled.lastInstance());
			//Annotate
			Topic topic = new Topic(jcas);
			topic.setBegin(0);
			topic.setEnd(jcas.getDocumentText().length());
			topic.addToIndexes();
			topic.setCategory(new Integer(new Double(result).intValue()).toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		
	}

}
