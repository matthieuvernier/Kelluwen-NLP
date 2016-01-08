package cl.uach.kelluwen.nlp.io.elastic;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.json.simple.JSONObject;

import cl.uach.kelluwen.nlp.types.Article;
import cl.uach.kelluwen.nlp.types.Token;
import cl.uach.kelluwen.nlp.types.Topic;
import cl.uach.kelluwen.nlp.types.Tweet;
import cl.uach.kelluwen.nlp.types.location.City;
import cl.uach.kelluwen.nlp.types.location.Country;

import static org.elasticsearch.node.NodeBuilder.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExportDocumentAnalyzed2Elastic extends JCasAnnotator_ImplBase {

	private Client client;
	private Node node;
	private IndexResponse response;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		// Parent initialization
		super.initialize(aContext);

		node = nodeBuilder()
				.settings(Settings.builder()
						.put("path.home", "/home/mvernier/DEVELOPPEMENT/elasticsearch-2.0.0")).node();
		client = node.client();
	}

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		/**ORDER KEYWORDS ACCORDING TO TF.IDF**/
		ArrayList<Float> keywordsRelevancy = new ArrayList<Float>();
		ArrayList<String> keywordsToken = new ArrayList<String>();
		ArrayList<String> orderedRelevantKeywords = new ArrayList<String>();
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		Iterator<Token> itToken = idxToken.iterator();
		while (itToken.hasNext()){
			Token token = itToken.next();
			String lemma = token.getLemma();
			Float tfIdf = token.getTextMetric().getTFIDF();
			boolean added=false;
			for (int i=0;i<orderedRelevantKeywords.size();i++){
				String existingLemma = orderedRelevantKeywords.get(i);
				Float existingTfIdf = keywordsRelevancy.get(i);
				if (!lemma.equals(existingLemma)){
					if (existingTfIdf<tfIdf){
						orderedRelevantKeywords.add(i, lemma);
						keywordsRelevancy.add(i,tfIdf);
						keywordsToken.add(i,token.getCoveredText().toLowerCase());
						added=true;
						i=orderedRelevantKeywords.size();
					}
				}
				else {
					added=true;
					i=orderedRelevantKeywords.size();
				}
			}
			if (!added){
				orderedRelevantKeywords.add(orderedRelevantKeywords.size(), lemma);
				keywordsRelevancy.add(keywordsRelevancy.size(),tfIdf);
				keywordsToken.add(keywordsToken.size(),token.getCoveredText().toLowerCase());
			}
		}

		/**PREPARE CITIES AND COUNTRIES LISTS **/
		AnnotationIndex<City> idxCity = jcas.getAnnotationIndex(City.type);
		AnnotationIndex<Country> idxCountry = jcas.getAnnotationIndex(Country.type);
		Iterator<City> itCity = idxCity.iterator();
		Iterator<Country> itCountry = idxCountry.iterator();

		/**CREATE THE JSON REPRESENTATION FOR THIS DOCUMENT*/
		AnnotationIndex<Topic> idxTopic = jcas.getAnnotationIndex(Topic.type);
		AnnotationIndex<Tweet> idxTweet = jcas.getAnnotationIndex(Tweet.type);
		AnnotationIndex<Article> idxArticle = jcas.getAnnotationIndex(Article.type);

		if (idxArticle.iterator().hasNext()){
			Article article = idxArticle.iterator().next();
			if (!article.getErrorDuringScraping()){
				if (idxTweet.iterator().hasNext()){
					Tweet tweet = idxTweet.iterator().next();

					if (idxTopic.iterator().hasNext()){
						if(itCountry.hasNext()){

							Topic topic = idxTopic.iterator().next();

					/*V1		String json ="{" +
									"\"date\":\""+tweet.getDate()+"\"," +
									"\"screen_name\":\""+tweet.getScreen_name()+"\"," +
									"\"num_followers\":\""+new Integer(tweet.getNum_followers()).toString()+"\"," +
									"\"tweet_text\":\""+JSONObject.escape(tweet.getCoveredText())+"\"," +
									"\"article_text\":\""+JSONObject.escape(article.getCoveredText())+"\","+
									"\"title\":\""+JSONObject.escape(article.getTitle())+"\","+
									"\"url\":\""+JSONObject.escape(article.getUrl())+"\","+
									"\"topic\":\""+JSONObject.escape(topic.getCategory())+"\"," +
									"\"location\":{\"countries\":[";

							String countries="";
							boolean first=true;
							while (itCountry.hasNext()){
								Country country = itCountry.next();
								String countryName = country.getNormalizedName();
								double longitude = country.getLongitude();
								double latitude = country.getLatitude();
								if (!first){countries=countries+",";}
								countries=countries+"{\"countryname\":\""+countryName+
										"\", \"location\":\""+
										latitude+","+longitude+"\"}";
								first=false;
							}

							json = json + countries + "],\"cities\":[";

							String cities="";
							first=true;
							while (itCity.hasNext()){
								City city = itCity.next();
								String cityName = city.getNormalizedName();
								double longitude = city.getLongitude();
								double latitude = city.getLatitude();
								if (!first){cities=cities+",";}
								cities=cities+"{\"cityname\":\""+cityName+
										"\", \"location\":\""+
										latitude+","+longitude+"\"}";
								first=false;
							}	
							json = json + cities + "]},\"keywords\":[";

							String keywords="";
							first=true;
							int NB_KEYWORDS_LIMIT=0;
							for (int i=0;i<orderedRelevantKeywords.size()&&NB_KEYWORDS_LIMIT<10;i++){
								if (!first){keywords=keywords+",";}
								keywords=keywords+"{\"keyword\":\""+orderedRelevantKeywords.get(i)+"\", \"relevancy\":"+keywordsRelevancy.get(i)+"}";

								first=false;
								NB_KEYWORDS_LIMIT=NB_KEYWORDS_LIMIT+1;
							}
							json = json + keywords + "]}";

							System.out.println(json);*/
							
							
							String json ="{" +
									"\"date\":\""+tweet.getDate()+"\"," +
									"\"screen_name\":\""+tweet.getScreen_name()+"\"," +
									"\"num_followers\":\""+new Integer(tweet.getNum_followers()).toString()+"\"," +
									"\"tweet_text\":\""+JSONObject.escape(tweet.getCoveredText())+"\"," +
									"\"article_text\":\""+JSONObject.escape(article.getCoveredText())+"\","+
									"\"title\":\""+JSONObject.escape(article.getTitle())+"\","+
									"\"url\":\""+JSONObject.escape(article.getUrl())+"\","+
									"\"topic\":\""+JSONObject.escape(topic.getCategory())+"\","; 

							if (itCountry.hasNext()){
								Country country = itCountry.next();
								String countryName = country.getNormalizedName();
								double longitude = country.getLongitude();
								double latitude = country.getLatitude();
								json = json+"\"countryname\":\""+countryName+"\",\"countrylocation\":\""+latitude+","+longitude+"\",";
							}
							
							if (itCity.hasNext()){
								City city = itCity.next();
								String cityName = city.getNormalizedName();
								double longitude = city.getLongitude();
								double latitude = city.getLatitude();
								json = json+"\"cityname\":\""+cityName+"\",\"citylocation\":\""+latitude+","+longitude+"\",";
							}
							

							String keywords="\"keywords\":[";
							boolean first=true;
							int NB_KEYWORDS_LIMIT=0;
							for (int i=0;i<orderedRelevantKeywords.size()&&NB_KEYWORDS_LIMIT<10;i++){
								if (!first){keywords=keywords+",";}
								keywords=keywords+"{\"keyword\":\""+orderedRelevantKeywords.get(i)+"\", \"relevancy\":"+keywordsRelevancy.get(i)+"}";

								first=false;
								NB_KEYWORDS_LIMIT=NB_KEYWORDS_LIMIT+1;
							}
							json = json + keywords + "]}";

							response = client.prepareIndex("documents_analyzed", "articles")
									.setSource(json)
									.get();
						}
					}
				}
			}
		}
	}

	@Override
	public void collectionProcessComplete()
			throws AnalysisEngineProcessException {
		node.close();
	}
}
