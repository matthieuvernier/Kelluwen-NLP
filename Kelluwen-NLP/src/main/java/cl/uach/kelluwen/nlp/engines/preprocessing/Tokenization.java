package cl.uach.kelluwen.nlp.engines.preprocessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import cl.uach.kelluwen.nlp.types.Token;

public class Tokenization extends JCasAnnotator_ImplBase {

	static final String TOKENREGEXP ="("
			+ "([\\wáéíóúüÁÉÍÓÚÜñÑ@]{1,})"
			+ "("
			+ "([.\\/():;-|]{0,3})"
			+ "([\\wáéíóúüÁÉÍÓÚÜñÑ@]{1,})"
			+ "){0,}"
			+ ")+";
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		//Get document text
		String docText = jcas.getDocumentText();
		//Compile the regexp patterns for tokens
		Pattern patternTokens = Pattern.compile(TOKENREGEXP);
		
		//Create a Matcher object on the current text
		Matcher matcherTokens = patternTokens.matcher(docText);
		
		//Search for tokens in the current text 
		while (matcherTokens.find()){
			// found one - create annotation
			Token annotation = new Token(jcas);
			//	Precise the position in the text
			annotation.setBegin(matcherTokens.start());
			annotation.setEnd(matcherTokens.end());
			// Add the annotation to the JCas index
			annotation.addToIndexes();
		}
	}

}
