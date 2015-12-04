package cl.uach.kelluwen.nlp.io.elastic;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import cl.uach.kelluwen.nlp.types.Article;
import cl.uach.kelluwen.nlp.types.Tweet;

public class ElasticSearchQuery_CR extends CollectionReader_ImplBase {

	public static final String PARAM_FROMDATE = "fromDate";
	public static final String PARAM_TODATE = "toDate";
	
	private Client client;
	private Node node;
	private SearchResponse response;
	private int mCurrentIndex;
	private int numberOfHits;
	private SearchHit[] hitsArray;
	private int hitsArrayCursor;

	/**
	 * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
	 */
	public void initialize() throws ResourceInitializationException {
		String dateFromString = (String) getConfigParameterValue(PARAM_FROMDATE);
		String dateToString = (String) getConfigParameterValue(PARAM_TODATE);
		
		node = nodeBuilder()
				.settings(Settings.builder()
						.put("path.home", "/home/mvernier/DEVELOPPEMENT/elasticsearch-2.0.0")).node();
		client = node.client();
		
		RangeQueryBuilder query = QueryBuilders.rangeQuery("date").to(dateToString).from(dateFromString);
		response = client.prepareSearch("documents20000")
		        .setTypes("articles")
		        .setSearchType(SearchType.SCAN)
		        .setScroll(new TimeValue(60000))
		        .setQuery(query)                 // Query
		      //  .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
		        .setSize(100)
		        .execute()
		        .actionGet();
		
		response = client.prepareSearchScroll(response.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
		hitsArray = response.getHits().getHits();
		hitsArrayCursor=0;
		
		numberOfHits = (int) response.getHits().getTotalHits();
		//System.out.println(response.toString());
		mCurrentIndex=0;
		
	}

	public void getNext(CAS aCAS) throws IOException, CollectionException {
		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new CollectionException(e);
		}
		Tweet tweetAnnotation = new Tweet(jcas);
		Article articleAnnotation = new Article(jcas);
		
		String tweetTxt = "";
		String articleTxt = "";
		
		SearchHit hit = hitsArray[hitsArrayCursor];
		Map<String,Object> source = hit.getSource();
		for (String name : source.keySet()){
			if (name.equals("date")){
				tweetAnnotation.setDate(source.get(name).toString());
			}
			else if (name.equals("screen_name")){
				tweetAnnotation.setScreen_name(source.get(name).toString());
			}
			else if (name.equals("num_followers")){
				tweetAnnotation.setNum_followers(new Integer(source.get(name).toString()));
			}
			else if (name.equals("tweet_text")){
				tweetTxt=source.get(name).toString();
			}
			else if (name.equals("article_text")){
				articleTxt=source.get(name).toString();
			}
			else if (name.equals("title")){
				articleAnnotation.setTitle(source.get(name).toString());
			}
			else if (name.equals("url")){
				articleAnnotation.setUrl(source.get(name).toString());
			}
		}
		jcas.setDocumentText(tweetTxt+"\n"+articleTxt);
		tweetAnnotation.setBegin(0);
		tweetAnnotation.setEnd(tweetTxt.length());
		articleAnnotation.setBegin(tweetTxt.length()+1);
		articleAnnotation.setEnd(tweetTxt.length()+1+articleTxt.length());
		tweetAnnotation.addToIndexes();articleAnnotation.addToIndexes();
		
		hitsArrayCursor=hitsArrayCursor+1;
		mCurrentIndex=mCurrentIndex+1;
	}

	public Progress[] getProgress() {
		return new Progress[] { new ProgressImpl(mCurrentIndex, numberOfHits, Progress.ENTITIES) };
	}


	public boolean hasNext() {
		if (hitsArray.length==0){
			return false;
		}
		else if (hitsArray.length == hitsArrayCursor){
	    	response = client.prepareSearchScroll(response.getScrollId()).setScroll(new TimeValue(600000)).execute().actionGet();
	    	hitsArray = response.getHits().getHits();
	    	hitsArrayCursor=0;
		}
		if (hitsArray.length==0){
			return false;
		}
		else																																																																																																																																																																																																																																																																																																																																																																																																																																				 return true;
	}

	public void close() throws IOException {
		//node.close();
	}

}
