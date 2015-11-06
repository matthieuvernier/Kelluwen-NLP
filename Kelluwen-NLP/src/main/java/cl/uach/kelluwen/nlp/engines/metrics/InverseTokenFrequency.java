package cl.uach.kelluwen.nlp.engines.metrics;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import cl.uach.kelluwen.nlp.types.Token;


public class InverseTokenFrequency extends JCasAnnotator_ImplBase {


	/** Parameter for the lexicon path */
	private final static String PARAM_LEXICON = "Filename";
	private String theLexiconFile;
	private HashMap<String,Float> inverseTokenFrequency;

	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		// Obtain the path to the lexicon of stop-words
		theLexiconFile     = (String) context.getConfigParameterValue(PARAM_LEXICON);

		//Parse the lexicon file : add each entry/line in the lexicon (an arraylist)
		Scanner sc;
		inverseTokenFrequency = new HashMap<String,Float>();
		try {
			sc = new Scanner(new File(theLexiconFile));

			while (sc.hasNextLine())
			{
				String s = sc.nextLine();
				StringTokenizer stTok = new StringTokenizer(s,";");
				if (stTok.countTokens()!=2){
					sc.close();
					throw new ResourceInitializationException();
				}
				String token = stTok.nextToken();
				Float inverseFrequency = new Float(stTok.nextToken().replace(",", "."));
				if(inverseTokenFrequency.containsKey(token)){
					//should not happen
				}
				else {inverseTokenFrequency.put(token, inverseFrequency);}
			}
			sc.close();
			 
		} catch (FileNotFoundException e) {
			throw new ResourceInitializationException();
		}
	}


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// Browse all the tokens and annotate its inverse frequency
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token mTokenAnnotation = (Token) itToken.next();
			String mToken = mTokenAnnotation.getLemma().toLowerCase();
			//Test if the current token is in inversefrequency hashmap
			if (inverseTokenFrequency.containsKey(mToken)){
				Float inverseFrequency = inverseTokenFrequency.get(mToken);
				mTokenAnnotation.setInverseTokenFrequency(inverseFrequency);
			}
			else {
				//the token is an hapax
				mTokenAnnotation.setInverseTokenFrequency(new Float(0.000000001));
			}

		}

	}

}