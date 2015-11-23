package cl.uach.kelluwen.nlp.engines.preprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import cl.uach.kelluwen.nlp.types.Token;

public class StopWords extends JCasAnnotator_ImplBase {

	/** Parameter for the lexicon path */
	private final static String PARAM_LEXICON = "Filename";
	private String theLexiconFile;
	private ArrayList<String> theLexicon;
	
	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		// Obtain the path to the lexicon of stop-words
		theLexiconFile     = (String) context.getConfigParameterValue(PARAM_LEXICON);

		//Parse the lexicon file : add each entry/line in the lexicon (an arraylist)
		Scanner sc;
		theLexicon = new ArrayList<String>();
		try {
			sc = new Scanner(new File(theLexiconFile ));
		} catch (FileNotFoundException e) {
			throw new ResourceInitializationException();
		}
		while (sc.hasNextLine())
		{
		    String s = sc.nextLine();
		    theLexicon.add(s);
		}
		sc.close();
		
	}

	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {
		
		// Browse for all those token annotations...
		AnnotationIndex<Token> idxToken = cas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token mToken = (Token) itToken.next();
			//Test if the current token is in the stop words list
			if (theLexicon.contains(mToken.getCoveredText().toLowerCase())){
			// in that case, the value of the "stop-word" attribute is true
				mToken.setStopWord(true);
			}
			else {
				// in the other case, this token is not a stop-word
				mToken.setStopWord(false);
			}
			
		}
	}

}
