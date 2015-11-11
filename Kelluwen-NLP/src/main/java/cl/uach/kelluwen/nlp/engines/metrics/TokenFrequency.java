package cl.uach.kelluwen.nlp.engines.metrics;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
			String mToken = mTokenAnnotation.getLemma().toLowerCase();
			//check if the token is in the hashmap
			if (tokenFrequencyMap.containsKey(mToken)){
				tokenFrequencyMap.put(mToken, tokenFrequencyMap.get(mToken)+1);
			}
			else {
				tokenFrequencyMap.put(mToken, 1);
			}
			cpt_token=cpt_token+1;
		}
		
		//second step sort the hashmap according to the value of each entry
		HashMap<String,Integer> tokenFrequencyMapSorted = triAvecValeur(tokenFrequencyMap);
		HashMap<String,Integer> tokensRank = new HashMap<String,Integer>();
		Iterator<Entry<String, Integer>> itTokenSorted= tokenFrequencyMapSorted.entrySet().iterator();
		int rank=1;
		int nb_wordsAtThisRank=0;
		int current_freq=0;
		while (itTokenSorted.hasNext()){
			Entry<String,Integer> entry = itTokenSorted.next();
			if (current_freq==0){
				current_freq=entry.getValue();
				nb_wordsAtThisRank=nb_wordsAtThisRank+1;
			}
			else {
				if (current_freq==entry.getValue()){
					nb_wordsAtThisRank=nb_wordsAtThisRank+1;
				}
				else if (current_freq>entry.getValue()){
					rank=rank+nb_wordsAtThisRank;
					nb_wordsAtThisRank=1;
				}
				else {
					System.out.println("pb TokenFrequency, this case should not happen");
				}
			}
			tokensRank.put(entry.getKey(), rank);
		}
		
		
		// third step : Browse for alltokens to annotate frequency and rank
		idxToken = jcas.getAnnotationIndex(Token.type);
		itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token mTokenAnnotation = (Token) itToken.next();
			String mToken = mTokenAnnotation.getLemma().toLowerCase();
			Integer tokenFrequency = tokenFrequencyMap.get(mToken);
			Float result = new Float (tokenFrequency)/new Float(cpt_token);
			DecimalFormat df = new DecimalFormat("#.############");
			mTokenAnnotation.setTextTokenFrequency(new Float(df.format(result).replace(",", ".")));
			
			Integer tokenRank = tokensRank.get(mToken);
			mTokenAnnotation.setTextTokenRank(tokenRank);
		}
	}
	
	public HashMap<String, Integer> triAvecValeur( HashMap<String, Integer> map ){
		   List<Map.Entry<String, Integer>> list =
		        new LinkedList<Map.Entry<String, Integer>>( map.entrySet() );
		   Collections.sort( list, new Comparator<Map.Entry<String, Integer>>(){
		      public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ){
		    	  return (o2.getValue()).compareTo( o1.getValue());
		      }
		   });

		   HashMap<String, Integer> map_apres = new LinkedHashMap<String, Integer>();
		   for(Map.Entry<String, Integer> entry : list)
		     map_apres.put( entry.getKey(), entry.getValue() );
		   return map_apres;
		}
}