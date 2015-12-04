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

public class TopicClassifier extends JCasAnnotator_ImplBase {

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
			FastVector fvClassVal = new FastVector(9);
			fvClassVal.addElement("accidentes");fvClassVal.addElement("deporte");fvClassVal.addElement("ecologia");
			fvClassVal.addElement("economia");fvClassVal.addElement("judicial");fvClassVal.addElement("politica");
			fvClassVal.addElement("salud");fvClassVal.addElement("tecnologia");fvClassVal.addElement("entretenimiento");
			fvClassVal.addElement("sociedad");fvClassVal.addElement("obituario");
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
		
		HashMap<String,Float> lemmasMap=new HashMap<String,Float>();
		// Browse for all those token annotations and complete the lemmas map
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token tokenAnnotation = itToken.next();
			if (!lemmasMap.containsKey(tokenAnnotation.getLemma())){
				lemmasMap.put(tokenAnnotation.getLemma(), tokenAnnotation.getTextMetric().getTFIDF());
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
			String stringResult="";
			switch (new Double(result).intValue()) {
            case 0:  stringResult = "tecnologia";
                     break;
            case 1:  stringResult = "obituario";
                     break;
            case 2:  stringResult = "judicial";
            		 break;
            case 3:  stringResult= "entretenimiento";
                     break;
            case 4:  stringResult = "accidentes";
                     break;
            case 5:  stringResult = "deporte";
                     break;
            case 6:  stringResult = "economia";
                     break;
            case 7:  stringResult = "ecologia";
                     break;
            case 8:  stringResult = "politica";
                     break;
            case 9:  stringResult = "salud";
            		 break;
            case 10:  stringResult = "sociedad";
            		 break;
            default: stringResult = "error";
                     break;
        }
			topic.setCategory(stringResult);
			
			//Annotate Reference for training purpose
			Reference reference = new Reference(jcas);
			reference.setBegin(0);
			reference.setEnd(jcas.getDocumentText().length());
			reference.addToIndexes();
			reference.setTopic(stringResult);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		
	}

}
