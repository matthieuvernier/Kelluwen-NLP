package cl.uach.kelluwen.nlp.engines.metrics;

import java.text.DecimalFormat;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;

import cl.uach.kelluwen.nlp.types.Token;

/**
 * @author Kelluwen
 * Calculate the TF.IDF score for each token of a given document
 *
 */
public class TokenRelevancyScoring extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// Browse all the tokens and annotate its inverse frequency
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token mTokenAnnotation = (Token) itToken.next();
			Float tf = mTokenAnnotation.getTextTokenFrequency();
			Float itf = mTokenAnnotation.getLanguageTokenFrequency();
			Float tfitf = tf/itf;
			DecimalFormat df = new DecimalFormat("#.####################");
			mTokenAnnotation.setPuntajeRelevancia(new Float(df.format(tfitf).replace(",", ".")));
			
			/*mTokenAnnotation.setRankGap(mTokenAnnotation.getTextTokenRank()-mTokenAnnotation.getLanguageTokenRank());
			mTokenAnnotation.setFrequencyGap(mTokenAnnotation.getLanguageTokenFrequency()-mTokenAnnotation.getTextTokenFrequency());
			*/
		}

	}

}
