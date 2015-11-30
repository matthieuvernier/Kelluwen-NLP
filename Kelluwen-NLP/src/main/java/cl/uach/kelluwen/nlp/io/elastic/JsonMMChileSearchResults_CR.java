package cl.uach.kelluwen.nlp.io.elastic;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cl.uach.kelluwen.nlp.types.Article;
import cl.uach.kelluwen.nlp.types.Tweet;

public class JsonMMChileSearchResults_CR extends CollectionReader_ImplBase {

	/**
	 * Name of configuration parameter that must be set to the path of the CSV file.
	 */
	public static final String PARAM_INPUTFILE = "InputFile";
	private File corpus;
	private int mCurrentIndex;
	private JsonNode tweetsArray;

	private int nb_no_urls;
	private int nb_download_fails;

	/**
	 * @see org.apache.uima.collection.CollectionReader_ImplBase#initialize()
	 */
	public void initialize() throws ResourceInitializationException {

		mCurrentIndex = 0;
		nb_no_urls=0;
		nb_download_fails=0;

		// this is the key object to convert JSON to Java
		ObjectMapper mapper = new ObjectMapper();

		try {
			corpus= new File(((String) getConfigParameterValue(PARAM_INPUTFILE)).trim());
			JsonNode node = mapper.readValue(corpus, JsonNode.class);
			tweetsArray = node.get("hits").get("hits");

		} catch (JsonGenerationException ex) {
			ex.printStackTrace();
		} catch (JsonMappingException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}


	}

	public void getNext(CAS aCAS) throws IOException, CollectionException {
		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new CollectionException(e);
		}

		/*Parse Json Tweet*/
		JsonNode tweetNode = tweetsArray.get(mCurrentIndex);
		JsonNode tweetSourceNode = tweetNode.get("_source");
		JsonNode numFollowersNode = tweetSourceNode.get("num_followers");
		JsonNode fechaNode = tweetSourceNode.get("fecha");
		JsonNode articleUrlNode = tweetSourceNode.get("article_url");
		JsonNode tweetTextNode = tweetSourceNode.get("tweet_text");
		JsonNode screenNameNode = tweetSourceNode.get("screen_name");
		
		String documentText=tweetTextNode.asText();
		
		/*Date format conversion*/
		final String TWITTER="EEE MMM dd HH:mm:ss ZZZZZ yyyy";
		SimpleDateFormat sf = new SimpleDateFormat(TWITTER, Locale.US);
		sf.setLenient(true);
		Date date = new Date();
		try {
			date = sf.parse(fechaNode.asText());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateTxt = dateFormat.format(date);
		//System.out.println("dateTxt:"+dateTxt);
		

		Tweet tweetAnnotation = new Tweet(jcas);
		tweetAnnotation.setNum_followers(numFollowersNode.asInt());
		tweetAnnotation.setDate(dateTxt);
		tweetAnnotation.setArticle_url(articleUrlNode.asText());
		tweetAnnotation.setScreen_name(screenNameNode.asText());
		tweetAnnotation.setBegin(0);
		tweetAnnotation.setEnd(documentText.length());
		tweetAnnotation.addToIndexes();
		
		Article articleAnnotation = new Article(jcas);
		articleAnnotation.setUrl(articleUrlNode.asText());
		articleAnnotation.setErrorDuringScraping(true);
	
		String documentText2=documentText+"\n";
		articleAnnotation.setBegin(documentText.length());
		articleAnnotation.setEnd(documentText2.length());
		articleAnnotation.addToIndexes();
		
		try {
			Document doc = Jsoup.connect(articleUrlNode.asText()).get();
			documentText2=documentText2+"\n"+doc.title()+"\n"+doc.select("p").text();
			articleAnnotation.setErrorDuringScraping(false);
			articleAnnotation.setEnd(documentText2.length());
			articleAnnotation.setTitle(doc.title());
		}
		catch (HttpStatusException e){
			System.out.println(e);
			nb_download_fails=nb_download_fails+1;
		}
		catch (SocketTimeoutException e){
			System.out.println(e);

			nb_download_fails=nb_download_fails+1;
		}
		catch (org.jsoup.UnsupportedMimeTypeException e){
			System.out.println(e);
			nb_download_fails=nb_download_fails+1;
		}


		jcas.setDocumentText(documentText2);

		mCurrentIndex=mCurrentIndex+1;
	}


	public Progress[] getProgress() {
		return new Progress[] { new ProgressImpl(mCurrentIndex, tweetsArray.size(), Progress.ENTITIES) };
	}

	/**
	 * @see org.apache.uima.collection.CollectionReader#hasNext()
	 */
	public boolean hasNext() {
		return mCurrentIndex<tweetsArray.size();
	}

	public void close() throws IOException {
		System.out.println("no urls = "+nb_no_urls);
		System.out.println("download failures = "+nb_download_fails);
	}

}
