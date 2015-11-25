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


public class LanguageTokenFrequency extends JCasAnnotator_ImplBase {


	/** Parameter for the lexicon path */
	private final static String PARAM_LEXICON = "Filename";
	private String theLexiconFile;
	private HashMap<String,Float>  languageTokenFrequency;
	private HashMap<String,Integer> languageTokenRank;

	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		// Obtain the path to the lexicon of stop-words
		theLexiconFile     = (String) context.getConfigParameterValue(PARAM_LEXICON);

		//Parse the lexicon file : add each entry/line in the lexicon (an arraylist)
		Scanner sc;
		languageTokenFrequency = new HashMap<String,Float>();
		languageTokenRank = new HashMap<String,Integer>();
		try {
			sc = new Scanner(new File(theLexiconFile));

			while (sc.hasNextLine())
			{
				String s = sc.nextLine();
				StringTokenizer stTok = new StringTokenizer(s,";");
				if (stTok.countTokens()!=4){
					sc.close();
					throw new ResourceInitializationException();
				}
				Integer rank = new Integer(stTok.nextToken());
				String token = stTok.nextToken();
				String pos = stTok.nextToken();
				Float inverseFrequency = new Float(stTok.nextToken().replace(",", "."));
				if(languageTokenFrequency.containsKey(token)){
					//should not happen
				}
				else {languageTokenFrequency.put(token, inverseFrequency);}
				if(languageTokenRank.containsKey(token)){
					//should not happen
				}
				else {languageTokenRank.put(token, rank);}
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
			//Test if the current token is in language frequency hashmap
			if (languageTokenFrequency.containsKey(mToken)){
				Float inverseFrequency = languageTokenFrequency.get(mToken);
				//mTokenAnnotation.setLanguageTokenFrequency(inverseFrequency);
			}
			else {
				//the token is an hapax
				//mTokenAnnotation.setLanguageTokenFrequency(new Float(-1.0));
			}
			
			if (languageTokenRank.containsKey(mToken)){
				Integer inverseRank = languageTokenRank.get(mToken);
				//mTokenAnnotation.setLanguageTokenRank(inverseRank);
			}
			else {
				//the token is an hapax
				//mTokenAnnotation.setLanguageTokenRank(new Integer(-1));
			}

		}

	}

}