package cl.uach.kelluwen.nlp.engines.metrics;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;

import cl.uach.kelluwen.nlp.types.Token;

/**
 * @author Kelluwen
 * Complete the Token annotation with token frenquency in the current JCas.
 *
 */

public class TokenFrequency extends JCasAnnotator_ImplBase {
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// HashMap used to count token frequencies in the jcas
		HashMap<String,Integer> tokenFrequencyMap = new HashMap<String,Integer>();
		// first step : Browse for alltokens to count frequency
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		//Store the number of tokens in the document
		int cpt_token=0;
		while (itToken.hasNext()) {
			Token mTokenAnnotation = (Token) itToken.next();
			String mToken = mTokenAnnotation.getCoveredText().toLowerCase();
			//check if the token is in the hashmap
			if (tokenFrequencyMap.containsKey(mToken)){
				tokenFrequencyMap.put(mToken, tokenFrequencyMap.get(mToken)+1);
			}
			else {
				tokenFrequencyMap.put(mToken, 1);
			}
			cpt_token=cpt_token+1;
		}
		
		// second step : Browse for alltokens to annotate frequency
		idxToken = jcas.getAnnotationIndex(Token.type);
		itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token mTokenAnnotation = (Token) itToken.next();
			String mToken = mTokenAnnotation.getCoveredText().toLowerCase();
			Integer tokenFrequency = tokenFrequencyMap.get(mToken);
			Float result = new Float (tokenFrequency)/new Float(cpt_token);
			DecimalFormat df = new DecimalFormat("#.############");
			mTokenAnnotation.setTokenFrequency(new Float(df.format(result).replace(",", ".")));
		}
	}

}
