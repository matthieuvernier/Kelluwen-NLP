package cl.uach.kelluwen.nlp.io.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;

import cl.uach.kelluwen.nlp.types.KelluwenMessage;
import cl.uach.kelluwen.nlp.types.Token;
import cl.uach.kelluwen.nlp.types.Topic;

public class ExportJordanExperimentation1 extends JCasAnnotator_ImplBase {

	private HashMap<String,Integer> lemmasMap=new HashMap<String,Integer>();
	private HashMap<String,Integer> topicsMap=new HashMap<String,Integer>();
	private ArrayList<Entry<String,String>> messagesList=new ArrayList<Entry<String,String>>();
	private ArrayList<String> csvLines=new ArrayList<String>();

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token tokenAnnotation = (Token) itToken.next();
			//Filter stop words
			if (!tokenAnnotation.getStopWord()){
				String lemma = tokenAnnotation.getLemma();

				if (tokenAnnotation.getCoveredText().startsWith("http://")){
					if (tokenAnnotation.getCoveredText().contains("youtube")){
						lemma="youtube";
					}
					else lemma="http";
				}
				if (!lemmasMap.containsKey(lemma)){
					lemmasMap.put(lemma, 1);
				}
				else {lemmasMap.put(lemma, lemmasMap.get(lemma)+1);}
			}
		}
		//TOPIC
		AnnotationIndex<Topic> idxTopic = jcas.getAnnotationIndex(Topic.type);
		FSIterator<Topic> itTopic      = idxTopic.iterator();
		String topic="";
		if (itTopic.hasNext()) {
			Topic topicAnnotation = (Topic) itTopic.next();
			topic = topicAnnotation.getCategory();
			if (!topicsMap.containsKey(topic)){
				topicsMap.put(topic, 1);
			}
			else {topicsMap.put(topic, topicsMap.get(topic)+1);}
		}
		//MESSAGE
		AnnotationIndex<KelluwenMessage> idxMessage = jcas.getAnnotationIndex(KelluwenMessage.type);
		FSIterator<KelluwenMessage> itKelluwenMessage      = idxMessage.iterator();
		if (itKelluwenMessage.hasNext()) {
			KelluwenMessage kelluwenMessageAnnotation = (KelluwenMessage) itKelluwenMessage.next();
			String messageId = new Integer(kelluwenMessageAnnotation.getIdMessage()).toString();
			Entry<String,String> entry= new AbstractMap.SimpleEntry<String, String>(messageId, topic);
			messagesList.add(entry);
		}

		//CSVLINES
		String csvLine="";

		AnnotationIndex<KelluwenMessage> idxKelluwenMessage = jcas.getAnnotationIndex(KelluwenMessage.type);
		FSIterator<KelluwenMessage> itKelluwenMessage2 = idxKelluwenMessage.iterator();
		if (itKelluwenMessage2.hasNext()) {
			KelluwenMessage mKelluwenMessage = (KelluwenMessage) itKelluwenMessage2.next();
			Integer col1=mKelluwenMessage.getMessageType();
			Integer col2=mKelluwenMessage.getIdMessage();
			Integer col3=mKelluwenMessage.getIdSuperMessage();
			Integer col4=mKelluwenMessage.getIdUser();
			String col5=mKelluwenMessage.getName();
			Integer col6=mKelluwenMessage.getUserType();
			Integer col7=mKelluwenMessage.getIdExercicePattern();
			Integer col8 = mKelluwenMessage.getIdExperience();
			Integer col9=mKelluwenMessage.getYear();
			String col10=mKelluwenMessage.getSemester();
			Integer col11=mKelluwenMessage.getNumberOfStudents();
			String col12 = mKelluwenMessage.getCoveredText().replace("\n", "").replace(";", ",").replace("\"","");

			csvLine="\""+col1+"\""+";"+"\""+col2+"\""+";"+"\""+col3+"\""+";"+"\""+col4+"\""+";"+"\""+col5+"\""+";"+"\""+col6+"\""+";"+"\""+col7+"\""+";"+
					"\""+col8+"\""+";"+"\""+col9+"\""+";"+"\""+col10+"\""+";"+"\""+col11+"\""+";"+"\""+col12+"\""+";"+"\""+topic+"\"";			
		
			csvLines.add(csvLine);
		}


	}

	@Override
	public void collectionProcessComplete()
			throws AnalysisEngineProcessException {
		try {
			try {
				ArrayList<Entry<String, Integer>> lemmasList = (ArrayList<Entry<String, Integer>>) entriesSortedByValues(lemmasMap);
				ArrayList<Entry<String, Integer>> topicsList = (ArrayList<Entry<String, Integer>>) entriesSortedByValues(topicsMap);

				BufferedWriter out
				= new BufferedWriter(new FileWriter("/home/matthieu/lemmasList.csv"));

				for (int i=0;i<lemmasList.size();i++){
					out.write(lemmasList.get(i).getKey()+";"+lemmasList.get(i).getValue()+"\n");
				}
				out.close();

				BufferedWriter out2
				= new BufferedWriter(new FileWriter("/home/matthieu/topicsList.csv"));

				for (int i=0;i<topicsList.size();i++){
					out2.write(topicsList.get(i).getKey()+";"+topicsList.get(i).getValue()+"\n");
				}
				out2.close();

				BufferedWriter out3
				= new BufferedWriter(new FileWriter("/home/matthieu/TopicClasification-KelluwenMessages.csv"));

				for (int i=0;i<messagesList.size();i++){
					out3.write(messagesList.get(i).getKey()+";"+messagesList.get(i).getValue()+"\n");
				}
				out3.close();


				BufferedWriter out4
				= new BufferedWriter(new FileWriter("/home/matthieu/AnnotatedMessages_Jordan.csv"));
				for (int i=0;i<csvLines.size();i++){
					out4.write(csvLines.get(i)+"\n");
				}

				out.close();


			} catch (IOException e) {
				throw new AnalysisEngineProcessException(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static <K,V extends Comparable<? super V>>
	List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

		Collections.sort(sortedEntries, 
				new Comparator<Entry<K,V>>() {
			@Override
			public int compare(Entry<K,V> e1, Entry<K,V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		}
				);

		return sortedEntries;
	}
}
