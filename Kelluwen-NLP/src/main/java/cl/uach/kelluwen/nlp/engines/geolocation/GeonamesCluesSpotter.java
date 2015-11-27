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
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import cl.uach.kelluwen.nlp.types.Token;
import cl.uach.kelluwen.nlp.types.geonames.GeoClue;
import cl.uach.kelluwen.nlp.types.location.City;

public class GeonamesCluesSpotter extends JCasAnnotator_ImplBase {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collectionA_Country;
	private MongoCollection<Document> collectionH_Stream;
	private MongoCollection<Document> collectionL_Park;
	private MongoCollection<Document> collectionP_City;
	private MongoCollection<Document> collectionR_Road;
	private MongoCollection<Document> collectionS_Spot;
	private MongoCollection<Document> collectionT_Mountain;
	private MongoCollection<Document> collectionU_Undersea;
	private MongoCollection<Document> collectionV_Forest;

	private int cpt_query=0;

	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		mongoClient = new MongoClient("localhost" , 27017);
		database = mongoClient.getDatabase("geonames");

		collectionA_Country= database.getCollection("A_Country");
		collectionH_Stream= database.getCollection("H_Stream");
		collectionL_Park= database.getCollection("L_Park");
		collectionP_City= database.getCollection("P_City");
		collectionR_Road= database.getCollection("R_Road");
		collectionS_Spot= database.getCollection("S_Spot");
		collectionT_Mountain= database.getCollection("T_Mountain");
		collectionU_Undersea= database.getCollection("U_Undersea");
		collectionV_Forest= database.getCollection("V_Forest");
	}


	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		//ArrayList to store all tokens and manipulate them more easily for this task (especially to manage various window sizes)
		ArrayList<Token> tokenList = new ArrayList<Token>();

		// Browse all the tokens 
		AnnotationIndex<Token> idxToken = jcas.getAnnotationIndex(Token.type);
		FSIterator<Token> itToken      = idxToken.iterator();
		while (itToken.hasNext()) {
			tokenList.add( (Token) itToken.next());
		}

		/*Iterate tokens with a windows size=5*/
		if (tokenList.size()>=5){
			int window5Begin=0;
			int window5End=4;
			while (window5End<tokenList.size()){
				String window5Value = "";
				for (int i=0;i<5;i++){
					if (i==0){window5Value = tokenList.get(window5Begin+i).getCoveredText();}
					else {window5Value = window5Value + " " + tokenList.get(window5Begin+i).getCoveredText();}
				}
				/*Test if this window5Value is in Geonames*/
				annotateWithGeoname(window5Value,tokenList.get(window5Begin).getBegin(),tokenList.get(window5End).getEnd(),jcas);
				/*Move the window*/
				window5Begin=window5Begin+1;
				window5End=window5End+1;
			}
		}
		/*Iterate tokens with a windows size4*/
		if (tokenList.size()>=4){
			int window4Begin=0;
			int window4End=3;
			while (window4End<tokenList.size()){
				String window4Value = "";
				for (int i=0;i<4;i++){
					if (i==0){window4Value = tokenList.get(window4Begin+i).getCoveredText();}
					else {window4Value = window4Value + " " + tokenList.get(window4Begin+i).getCoveredText();}
				}
				/*Test if this window4Value is in Geonames*/
				annotateWithGeoname(window4Value,tokenList.get(window4Begin).getBegin(),tokenList.get(window4End).getEnd(),jcas);
				/*Move the window*/
				window4Begin=window4Begin+1;
				window4End=window4End+1;
			}
		}
		/*Iterate tokens with a windows size 3*/
		if (tokenList.size()>=3){
			int window3Begin=0;
			int window3End=2;
			while (window3End<tokenList.size()){
				String window3Value = "";
				for (int i=0;i<3;i++){
					if (i==0){window3Value = tokenList.get(window3Begin+i).getCoveredText();}
					else {window3Value = window3Value + " " + tokenList.get(window3Begin+i).getCoveredText();}
				}
				/*Test if this window3Value is in Geonames*/
				annotateWithGeoname(window3Value,tokenList.get(window3Begin).getBegin(),tokenList.get(window3End).getEnd(),jcas);
				/*Move the window*/
				window3Begin=window3Begin+1;
				window3End=window3End+1;
			}
		}
		/*Iterate tokens with a windows size 2*/
		if (tokenList.size()>=2){
			int window2Begin=0;
			int window2End=1;
			while (window2End<tokenList.size()){
				String window2Value = "";
				for (int i=0;i<2;i++){
					if (i==0){window2Value = tokenList.get(window2Begin+i).getCoveredText();}
					else {window2Value = window2Value + " " + tokenList.get(window2Begin+i).getCoveredText();}
				}
				/*Test if this window2Value is in Geonames*/
				annotateWithGeoname(window2Value,tokenList.get(window2Begin).getBegin(),tokenList.get(window2End).getEnd(),jcas);
				/*Move the window*/
				window2Begin=window2Begin+1;
				window2End=window2End+1;
			}
		}
		/*Iterate tokens*/
		if (tokenList.size()>=1){
			int token=0;
			while (token<tokenList.size()){
				String tokenValue = tokenList.get(token).getCoveredText();
				/*Test if this token is in Geonames*/
				annotateWithGeoname(tokenValue,tokenList.get(token).getBegin(),tokenList.get(token).getEnd(),jcas);
				token=token+1;
			}
		}

	}

	private void annotateWithGeoname(String query, int begin, int end, JCas jcas){
		//System.out.println("query 1");
		MongoCursor<Document> cursor = collectionA_Country.find(eq("spanishname", query)).iterator();
		cpt_query=cpt_query+1;
		try {
			while (cursor.hasNext()){
				Document doc = cursor.next();

				if (doc!=null){
					//ADD ANNOTATION
					GeoClue geoClueAnnotation = new GeoClue(jcas);
					geoClueAnnotation.setBegin(begin);
					geoClueAnnotation.setEnd(end);
					geoClueAnnotation.addToIndexes();
					//geoClueAnnotation.setGeonameid(doc.getInteger("geonameid"));
					geoClueAnnotation.setName(doc.get("name").toString());
					geoClueAnnotation.setAsciiname(doc.get("asciiname").toString());
					geoClueAnnotation.setSpanishname(doc.get("spanishname").toString());
					geoClueAnnotation.setLatitude(doc.get("latitude").toString());
					geoClueAnnotation.setLongitude(doc.get("longitude").toString());
					geoClueAnnotation.setFeature_class(doc.get("feature_class").toString());
					geoClueAnnotation.setFeature_code(doc.get("feature_code").toString());
					geoClueAnnotation.setCountry_code(doc.get("country_code").toString());
					geoClueAnnotation.setCountry_name(doc.get("country_name").toString());
					//System.out.println("city: "+query);
				}
			}
		} finally {cursor.close();}
		//System.out.println("query 2");
		MongoCursor<Document> cursor2 = collectionP_City.find(eq("spanishname", query)).iterator();
		cpt_query=cpt_query+1;
		try {
			while (cursor2.hasNext()){
				Document doc = cursor2.next();

				if (doc!=null){
					//ADD ANNOTATION
					GeoClue geoClueAnnotation = new GeoClue(jcas);
					geoClueAnnotation.setBegin(begin);
					geoClueAnnotation.setEnd(end);
					geoClueAnnotation.addToIndexes();
					//geoClueAnnotation.setGeonameid(doc.getLong("geonameid"));
					geoClueAnnotation.setName(doc.get("name").toString());
					geoClueAnnotation.setAsciiname(doc.get("asciiname").toString());
					geoClueAnnotation.setSpanishname(doc.get("spanishname").toString());
					geoClueAnnotation.setLatitude(doc.get("latitude").toString());
					geoClueAnnotation.setLongitude(doc.get("longitude").toString());
					geoClueAnnotation.setFeature_class(doc.get("feature_class").toString());
					geoClueAnnotation.setFeature_code(doc.get("feature_code").toString());
					geoClueAnnotation.setCountry_code(doc.get("country_code").toString());
					geoClueAnnotation.setCountry_name(doc.get("country_name").toString());
					//	System.out.println("city: "+query);
				}
			}
		} finally {cursor2.close();}
	}

	@Override
	public void collectionProcessComplete()
			throws AnalysisEngineProcessException {
		mongoClient.close();
		System.out.println("nb mongo queries by geonamesCluesSpotter :"+cpt_query);
	}

}
