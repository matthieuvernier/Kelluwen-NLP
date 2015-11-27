package cl.uach.kelluwen.io.elastic;

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
import cl.uach.kelluwen.nlp.types.Tweet;

import static org.elasticsearch.node.NodeBuilder.*;

public class ExportDocument2Elastic extends JCasAnnotator_ImplBase {

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
		AnnotationIndex<Tweet> idxTweet = jcas.getAnnotationIndex(Tweet.type);
		AnnotationIndex<Article> idxArticle = jcas.getAnnotationIndex(Article.type);

		if (idxArticle.iterator().hasNext()){
			Article article = idxArticle.iterator().next();
			if (!article.getErrorDuringScraping()){
				if (idxTweet.iterator().hasNext()){
					Tweet tweet = idxTweet.iterator().next();
					String json ="{" +
							"\"date\":\""+tweet.getDate()+"\"," +
							"\"screen_name\":\""+tweet.getScreen_name()+"\"," +
							"\"num_followers\":\""+new Integer(tweet.getNum_followers()).toString()+"\"," +
							"\"tweet_text\":\""+JSONObject.escape(tweet.getCoveredText())+"\"," +
							"\"article_text\":\""+JSONObject.escape(article.getCoveredText())+"\","+
							"\"title\":\""+JSONObject.escape(article.getTitle())+"\","+
							"\"url\":\""+JSONObject.escape(article.getUrl())+"\""+
							"}";
					response = client.prepareIndex("documents20000", "articles")
							.setSource(json)
							.get();
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
