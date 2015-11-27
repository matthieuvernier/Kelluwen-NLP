package cl.uach.kelluwen.nlp.engines.geolocation;

import java.util.ArrayList;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.text.AnnotationIndex;
import org.apache.uima.jcas.JCas;

import cl.uach.kelluwen.nlp.types.location.City;
import cl.uach.kelluwen.nlp.types.location.Country;
import cl.uach.kelluwen.nlp.types.location.Region;
import cl.uach.kelluwen.nlp.types.geonames.GeoClue;

public class CountriesAndCitiesSimpleSpotter extends JCasAnnotator_ImplBase {

	private ArrayList<String> countryCodeList;

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		countryCodeList=new ArrayList<String>();

		//Browse all Geoname annotations --> annotate Country and region
		AnnotationIndex<GeoClue> idxGeoclue = jcas.getAnnotationIndex(GeoClue.type);
		FSIterator<GeoClue> idxGeoclueIt = idxGeoclue.iterator();
		while (idxGeoclueIt.hasNext()) {
			GeoClue geoClueAnnotation = idxGeoclueIt.next();
			/*check if this GeoClue is a country (feature_class A and feature_code PCLI or ADM1)*/
			if (geoClueAnnotation.getFeature_code().equals("PCLI")){
				Country countryAnnotation = new Country(jcas);
				countryAnnotation.setBegin(geoClueAnnotation.getBegin());
				countryAnnotation.setEnd(geoClueAnnotation.getEnd());
				try {
					Double latitude = new Double(geoClueAnnotation.getLatitude());
					Double longitude = new Double(geoClueAnnotation.getLongitude());
					countryCodeList.add(geoClueAnnotation.getCountry_code());
					countryAnnotation.setLatitude(latitude);
					countryAnnotation.setLongitude(longitude);
					countryAnnotation.setNormalizedName(geoClueAnnotation.getCountry_code());
					countryAnnotation.addToIndexes();
				}
				catch (Exception e){
					System.out.println(e);
				}
			}
			if (geoClueAnnotation.getFeature_code().equals("ADM1")){
				Region regionAnnotation = new Region(jcas);
				regionAnnotation.setBegin(geoClueAnnotation.getBegin());
				regionAnnotation.setEnd(geoClueAnnotation.getEnd());
				try {
					Double latitude = new Double(geoClueAnnotation.getLatitude());
					Double longitude = new Double(geoClueAnnotation.getLongitude());
					countryCodeList.add(geoClueAnnotation.getCountry_code());
					regionAnnotation.setLatitude(latitude);
					regionAnnotation.setLongitude(longitude);
					regionAnnotation.setNormalizedCountryName(geoClueAnnotation.getCountry_code());
					regionAnnotation.setNormalizedName(geoClueAnnotation.getAsciiname());
					regionAnnotation.addToIndexes();
				}
				catch (Exception e){
					System.out.println(e);
				}			
			}
		}

		//Browse all Geoname annotations --> annotate cities (those who have a country in a region in the text 
		AnnotationIndex<GeoClue> idxGeoclue2 = jcas.getAnnotationIndex(GeoClue.type);
		FSIterator<GeoClue> idxGeoclueIt2 = idxGeoclue2.iterator();
		while (idxGeoclueIt2.hasNext()) {
			GeoClue geoClueAnnotation = idxGeoclueIt2.next();
			String countryCode = geoClueAnnotation.getCountry_code();
			if (geoClueAnnotation.getFeature_code().equals("PPL")||geoClueAnnotation.getFeature_code().equals("PPLA")||geoClueAnnotation.getFeature_code().equals("PPLA2")){
				if(countryCodeList.contains(countryCode)){
					City cityAnnotation = new City(jcas);
					cityAnnotation.setBegin(geoClueAnnotation.getBegin());
					cityAnnotation.setEnd(geoClueAnnotation.getEnd());
					try {
						Double latitude = new Double(geoClueAnnotation.getLatitude());
						Double longitude = new Double(geoClueAnnotation.getLongitude());
						countryCodeList.add(geoClueAnnotation.getCountry_code());
						cityAnnotation.setLatitude(latitude);
						cityAnnotation.setLongitude(longitude);
						cityAnnotation.setNormalizedCountryName(geoClueAnnotation.getCountry_code());
						cityAnnotation.setNormalizedName(geoClueAnnotation.getAsciiname());
						cityAnnotation.addToIndexes();
					}
					catch (Exception e){
						System.out.println(e);
					}
				}
			}

		}

	}

}
