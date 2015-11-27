package cl.uach.kelluwen.nlp.engines.metrics;

import static com.mongodb.client.model.Filters.eq;

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

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cl.uach.kelluwen.nlp.types.TextMetric;
import cl.uach.kelluwen.nlp.types.Token;

public class SpanishTextMetricAnalysis extends JCasAnnotator_ImplBase {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collectionSpanishWords;
	private long allWordsFrequency=1000000000;
	
	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		mongoClient = new MongoClient("localhost" , 27017);
		database = mongoClient.getDatabase("words_frequencies");
		//collectionCities = database.getCollection("cities");
		collectionSpanishWords = database.getCollection("spanish");
		
		FindIterable<Document> iterable = collectionSpanishWords.find(eq("spanish_name", "_ALL_"));
		Document doc = iterable.first();		
		if (doc!=null){
			allWordsFrequency=((Number)doc.get("Total_occurences")).longValue();
			System.out.println(((Number)doc.get("Total_occurences")).longValue());
		}
	}
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		//System.out.println("process metrics");
		/** TOKEN FREQUENCY IN TEXT */
		
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

		//System.out.println("step2");
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
		
		
		// third step : Browse for alltokens to annotate frequency, rank and language frequency
		idxToken = jcas.getAnnotationIndex(Token.type);
		itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			//System.out.println("token");
			Token mTokenAnnotation = (Token) itToken.next();
			String mToken = mTokenAnnotation.getLemma().toLowerCase();
			Integer tokenFrequency = tokenFrequencyMap.get(mToken);
			Float result = new Float (tokenFrequency)/new Float(cpt_token);
			DecimalFormat df = new DecimalFormat("#.############");
			//mTokenAnnotation.setTextTokenFrequency(new Float(df.format(result).replace(",", ".")));
			
			Integer tokenRank = tokensRank.get(mToken);
			//mTokenAnnotation.setTextTokenRank(tokenRank);
			
			/** TOKEN FREQUENCY IN LANGUAGE */
			
			FindIterable<Document> iterable = collectionSpanishWords.find(eq("Lemma", mTokenAnnotation.getLemma()));
			Document doc = iterable.first();
			long wordFrequency = 0;
			Float tokenFrequencyInLanguage = (float) 0.0;
			if (doc!=null){
				wordFrequency=((Number)doc.get("Total_occurences")).longValue();
				tokenFrequencyInLanguage = new Float(wordFrequency)/new Float(allWordsFrequency);
			}
			
			/** TFIDF */
			
			/**ANNOTATION*/
			TextMetric metricAnnotation = new TextMetric(jcas);
			metricAnnotation.setBegin(mTokenAnnotation.getBegin());
			metricAnnotation.setEnd(mTokenAnnotation.getEnd());
			metricAnnotation.addToIndexes();
			mTokenAnnotation.setTextMetric(metricAnnotation);
			metricAnnotation.setAnnotation(mTokenAnnotation);
			metricAnnotation.setFrequencyInText(new Float(df.format(result).replace(",", ".")));
			metricAnnotation.setFrequencyInLanguage(new Float(df.format(tokenFrequencyInLanguage).replace(",", ".")));
			
			if (tokenFrequencyInLanguage!=0){
				Float tfidf = new Float(df.format(result/tokenFrequencyInLanguage).replace(",", "."));
				metricAnnotation.setTFIDF(new Float(df.format(result/tokenFrequencyInLanguage).replace(",", ".")));
				
		//	System.out.println(mTokenAnnotation.getLemma()+":"+tfidf);
			}
			else {metricAnnotation.setTFIDF(new Float(0.0));};
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
