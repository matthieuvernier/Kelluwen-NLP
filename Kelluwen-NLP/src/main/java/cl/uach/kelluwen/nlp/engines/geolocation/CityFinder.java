package cl.uach.kelluwen.nlp.engines.geolocation;

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
import static com.mongodb.client.model.Filters.eq;

import cl.uach.kelluwen.nlp.types.Token;
import cl.uach.kelluwen.nlp.types.location.City;

public class CityFinder extends JCasAnnotator_ImplBase {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collectionCountries;
	
	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		mongoClient = new MongoClient("localhost" , 27017);
		database = mongoClient.getDatabase("geolocation");
		//collectionCities = database.getCollection("cities");
		collectionCountries = database.getCollection("countries");
	}


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		// Browse all the tokens and annotate its inverse frequency
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			Token mTokenAnnotation = (Token) itToken.next();
			
			//System.out.println(mTokenAnnotation.getCoveredText());
			FindIterable<Document> iterable = collectionCountries.find(eq("spanish_name", mTokenAnnotation.getCoveredText()));
			Document doc = iterable.first();
			
			if (doc!=null){
				//ADD ANNOTATION
				City city = new City(jcas);
				city.setBegin(mTokenAnnotation.getBegin());
				city.setEnd(mTokenAnnotation.getEnd());
				city.setLatitude(((Number) doc.get("latitude")).doubleValue());
				city.setLongitude(((Number) doc.get("longitude")).doubleValue());
				city.setCountry((String)doc.get("countryName"));
				city.setNormalizedName((String)doc.get("ascii_name"));
				city.addToIndexes(jcas);
			}

		}

	}
	
	@Override
	public void collectionProcessComplete()
			throws AnalysisEngineProcessException {
		mongoClient.close();
	}

}
