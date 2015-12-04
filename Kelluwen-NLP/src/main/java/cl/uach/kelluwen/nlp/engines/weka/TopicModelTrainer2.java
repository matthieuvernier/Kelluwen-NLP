package cl.uach.kelluwen.nlp.engines.weka;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import cl.uach.kelluwen.nlp.types.KelluwenMessage;
import cl.uach.kelluwen.nlp.types.Token;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

public class TopicModelTrainer2 extends JCasAnnotator_ImplBase {

	private HashMap<String,ArrayList<HashMap<String,Integer>>> instancesMap;
	private int nbInstances=0;
	private final static String PARAM_MODELPATH = "ModelFilename";
	private final static String PARAM_ATTRIBUTESLISTPATH = "AttributesListFilename";
	private String modelPath;
	private String attributesPath;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		// Parent initialization
		super.initialize(aContext);
		// The hash map collecting the instances
		instancesMap = new HashMap<String,ArrayList<HashMap<String,Integer>>>();
		// Parameter
		modelPath = (String) aContext.getConfigParameterValue(PARAM_MODELPATH);
		attributesPath = (String) aContext.getConfigParameterValue(PARAM_ATTRIBUTESLISTPATH);
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// Prepare the hash map to collect the lemmas and their TF.IDF value
		HashMap<String,Integer> lemmasMap = new HashMap<String,Integer>();

		// Browse tokens in the document
		AnnotationIndex<Token> idxTokens = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itTokens       = idxTokens.iterator();
		while ( itTokens.hasNext() ) {
			Token tokenAnnotation = (Token) itTokens.next();
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
		// Finally store the instance into the global hash map
		String theDocClass = getDocumentClass(jcas);


		if (!instancesMap.containsKey(theDocClass)){
			instancesMap.put(theDocClass, new ArrayList<HashMap<String, Integer>>());
		}
		instancesMap.get(theDocClass).add(lemmasMap);

		nbInstances=nbInstances+1;
	}

	@Override
	public void collectionProcessComplete()
			throws AnalysisEngineProcessException {
		try {

			// Collect all the different values we have
			HashSet<String> vSet = new HashSet<String>();
			for(String k: instancesMap.keySet()) {
				for (HashMap<String, Integer> inst: instancesMap.get(k)) {
					vSet.addAll( inst.keySet() );
				}
			}
			String[] mLemmas = vSet.toArray( new String[vSet.size()] );

			// Declare all the numeric attributes
			// Declare the feature vector
			FastVector fvWekaAttributes = new FastVector();
			for(String lemma: mLemmas) {
				Attribute attribute = new Attribute(lemma);
				fvWekaAttributes.addElement(attribute);
			}

			// Declare the class attribute along with its values
			FastVector fvClassVal = new FastVector(instancesMap.keySet().size());
			Iterator<String> itClasses = instancesMap.keySet().iterator();
			while ( itClasses.hasNext() ) {
				String c = itClasses.next();
				fvClassVal.addElement(c);
			}
			Attribute classAttribute = new Attribute("theClass", fvClassVal);
			//add the class in the feature vector
			fvWekaAttributes.addElement(classAttribute);

			// Create an empty training set
			Instances trainingSet = new Instances("Topic", fvWekaAttributes, 0);
			// Set class index
			trainingSet.setClassIndex(trainingSet.numAttributes()-1);
			// Create the instances
			for(String c: instancesMap.keySet()) {
				for(HashMap<String,Integer> i: instancesMap.get(c)) {
					Instance anInstance = new Instance(mLemmas.length+1);
					int cursor=0;
					for(String lemma: mLemmas) {
						if (i.containsKey(lemma)){
							anInstance.setValue((Attribute)fvWekaAttributes.elementAt(cursor), i.get(lemma));
						}
						else {
							anInstance.setValue((Attribute)fvWekaAttributes.elementAt(cursor), 0.0);
						}
						cursor=cursor+1;
					}
					anInstance.setValue((Attribute)fvWekaAttributes.elementAt(cursor), c);
					// add the instance
					trainingSet.add(anInstance);
				}
			}

			//System.out.println(trainingSet);

			//5.save dataset
			String file = "/home/matthieu/weka_test.arff";
			ArffSaver saver = new ArffSaver();
			saver.setInstances(trainingSet);
			saver.setFile(new File(file));
			saver.writeBatch();

			// Create a classifier
			Classifier cModel = (Classifier)new SMO();
			cModel.buildClassifier(trainingSet);

			// Test the model
			Evaluation eval = new Evaluation(trainingSet);
			eval.crossValidateModel(cModel, trainingSet, 10, new Random(1));
			System.out.println(eval.toSummaryString("\nResults\n======\n", false));

			// Get the confusion matrix
			double[][] cmMatrix = eval.confusionMatrix();


			//Serialization
			//SerializationHelper.write(modelPath, cModel);

			// deserialize model
			//Classifier cls = (Classifier) weka.core.SerializationHelper.read("/some/where/j48.model");


			/*write attributes list*/
		/*	try {
				BufferedWriter out
				= new BufferedWriter(new FileWriter(attributesPath));

				for (int i=0;i<mLemmas.length;i++){
					out.write(mLemmas[i]+"\n");
				}
				out.close();
			} catch (IOException e) {
				throw new AnalysisEngineProcessException(e);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method returns the class of the document based on the feature path
	 * passed in parameter of the component.
	 */
	private String getDocumentClass(JCas jcas) throws AnalysisEngineProcessException {
		// Get the kelluwen message
		AnnotationIndex<KelluwenMessage> idxKelluwenMessage = jcas.getAnnotationIndex(KelluwenMessage.type);
		FSIterator<KelluwenMessage> itKelluwenMessage = idxKelluwenMessage.iterator();
		if ( itKelluwenMessage.hasNext() ) {
			KelluwenMessage kelluwenMessageAnnotation = (KelluwenMessage) itKelluwenMessage.next();
			return kelluwenMessageAnnotation.getTopic();
		}
		return null;
	}
}
