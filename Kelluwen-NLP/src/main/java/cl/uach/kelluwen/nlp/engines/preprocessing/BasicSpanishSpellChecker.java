package cl.uach.kelluwen.nlp.engines.preprocessing;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;

import cl.uach.kelluwen.nlp.types.Token;

public class BasicSpanishSpellChecker extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// Browse for all those token annotations...
				AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
				FSIterator<Token> itToken      = idxToken.iterator();
				while (itToken.hasNext()) {
					Token mToken = (Token) itToken.next();
					String lemma = mToken.getLemma();
					lemma = lemma.replaceAll("(a){2,}","a");
					lemma = lemma.replaceAll("(e){2,}","e");
					lemma = lemma.replaceAll("(i){2,}","i");
					lemma = lemma.replaceAll("(o){2,}","o");
					lemma = lemma.replaceAll("(u){2,}","u");					

					lemma = lemma.replaceAll("(b){2,}","b");
					lemma = lemma.replaceAll("(c){3,}","cc");
					lemma = lemma.replaceAll("(d){2,}","d");
					lemma = lemma.replaceAll("(f){2,}","f");
					lemma = lemma.replaceAll("(g){2,}","g");
					lemma = lemma.replaceAll("(h){2,}","h");
					lemma = lemma.replaceAll("(j){2,}","j");
					lemma = lemma.replaceAll("(k){2,}","k");
					lemma = lemma.replaceAll("(l){3,}","ll");
					lemma = lemma.replaceAll("(m){3,}","m");
					lemma = lemma.replaceAll("(n){2,}","n");
					lemma = lemma.replaceAll("(ñ){2,}","ñ");
					lemma = lemma.replaceAll("(p){2,}","p");
					lemma = lemma.replaceAll("(q){2,}","q");
					lemma = lemma.replaceAll("(r){3,}","r");
					lemma = lemma.replaceAll("(s){2,}","s");
					lemma = lemma.replaceAll("(t){2,}","t");
					lemma = lemma.replaceAll("(v){2,}","v");
					lemma = lemma.replaceAll("(w){2,}","w");
					lemma = lemma.replaceAll("(x){2,}","x");
					lemma = lemma.replaceAll("(y){2,}","y");
					lemma = lemma.replaceAll("(z){2,}","z");
					
				
					mToken.setLemma(lemma);
					
				}

	}

}
