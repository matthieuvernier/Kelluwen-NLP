package cl.uach.kelluwen.nlp.engines.weka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
import weka.classifiers.Classifier;
import weka.core.Instance;

public class TopicClassifier extends JCasAnnotator_ImplBase {

	private final static String PARAM_MODELPATH = "ModelFilename";
	private final static String PARAM_ATTRIBUTESLISTPATH = "AttributesListFilename";
	private String modelPath;
	private String attributesPath;
	private Classifier clasifier;
	private ArrayList<String> attributes;

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
			clasifier = (Classifier) weka.core.SerializationHelper.read(modelPath);
			//load attributes list
			String text = FileUtils.file2String(new File(attributesPath.trim()), "UTF-8");
			StringTokenizer stLines= new StringTokenizer(text,"\n");
			while (stLines.hasMoreTokens()){
				attributes.add(stLines.nextToken());
			}		
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
		/*for (int i=0;i<lemmasMap.size();i++){
			String lemma = lemmasMap.get(i);
			if (lemmasMap.containsKey(lemma)){
				instance.setValue(, value);
			}
			else {
				
			}
			
		}*/

		//Classify

		//Annotate

	}

}
