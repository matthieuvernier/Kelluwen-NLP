
/* First created by JCasGen Thu Nov 26 11:24:23 CLT 2015 */
package cl.uach.kelluwen.nlp.types.geonames;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** Clue identificated with Geonames
 * Updated by JCasGen Thu Nov 26 13:34:38 CLT 2015
 * @generated */
public class GeoClue_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeoClue_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeoClue_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeoClue(addr, GeoClue_Type.this);
  			   GeoClue_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeoClue(addr, GeoClue_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeoClue.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cl.uach.kelluwen.nlp.types.geonames.GeoClue");
 
  /** @generated */
  final Feature casFeat_geonameid;
  /** @generated */
  final int     casFeatCode_geonameid;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGeonameid(int addr) {
        if (featOkTst && casFeat_geonameid == null)
      jcas.throwFeatMissing("geonameid", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geonameid);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeonameid(int addr, String v) {
        if (featOkTst && casFeat_geonameid == null)
      jcas.throwFeatMissing("geonameid", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_geonameid, v);}
    
  
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_asciiname;
  /** @generated */
  final int     casFeatCode_asciiname;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getAsciiname(int addr) {
        if (featOkTst && casFeat_asciiname == null)
      jcas.throwFeatMissing("asciiname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_asciiname);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAsciiname(int addr, String v) {
        if (featOkTst && casFeat_asciiname == null)
      jcas.throwFeatMissing("asciiname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_asciiname, v);}
    
  
 
  /** @generated */
  final Feature casFeat_spanishname;
  /** @generated */
  final int     casFeatCode_spanishname;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSpanishname(int addr) {
        if (featOkTst && casFeat_spanishname == null)
      jcas.throwFeatMissing("spanishname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_spanishname);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSpanishname(int addr, String v) {
        if (featOkTst && casFeat_spanishname == null)
      jcas.throwFeatMissing("spanishname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_spanishname, v);}
    
  
 
  /** @generated */
  final Feature casFeat_latitude;
  /** @generated */
  final int     casFeatCode_latitude;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLatitude(int addr) {
        if (featOkTst && casFeat_latitude == null)
      jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_latitude);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLatitude(int addr, String v) {
        if (featOkTst && casFeat_latitude == null)
      jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_latitude, v);}
    
  
 
  /** @generated */
  final Feature casFeat_longitude;
  /** @generated */
  final int     casFeatCode_longitude;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLongitude(int addr) {
        if (featOkTst && casFeat_longitude == null)
      jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_longitude);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLongitude(int addr, String v) {
        if (featOkTst && casFeat_longitude == null)
      jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_longitude, v);}
    
  
 
  /** @generated */
  final Feature casFeat_feature_class;
  /** @generated */
  final int     casFeatCode_feature_class;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFeature_class(int addr) {
        if (featOkTst && casFeat_feature_class == null)
      jcas.throwFeatMissing("feature_class", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_feature_class);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFeature_class(int addr, String v) {
        if (featOkTst && casFeat_feature_class == null)
      jcas.throwFeatMissing("feature_class", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_feature_class, v);}
    
  
 
  /** @generated */
  final Feature casFeat_feature_code;
  /** @generated */
  final int     casFeatCode_feature_code;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getFeature_code(int addr) {
        if (featOkTst && casFeat_feature_code == null)
      jcas.throwFeatMissing("feature_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_feature_code);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFeature_code(int addr, String v) {
        if (featOkTst && casFeat_feature_code == null)
      jcas.throwFeatMissing("feature_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_feature_code, v);}
    
  
 
  /** @generated */
  final Feature casFeat_country_code;
  /** @generated */
  final int     casFeatCode_country_code;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCountry_code(int addr) {
        if (featOkTst && casFeat_country_code == null)
      jcas.throwFeatMissing("country_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_country_code);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountry_code(int addr, String v) {
        if (featOkTst && casFeat_country_code == null)
      jcas.throwFeatMissing("country_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_country_code, v);}
    
  
 
  /** @generated */
  final Feature casFeat_country_name;
  /** @generated */
  final int     casFeatCode_country_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCountry_name(int addr) {
        if (featOkTst && casFeat_country_name == null)
      jcas.throwFeatMissing("country_name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_country_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCountry_name(int addr, String v) {
        if (featOkTst && casFeat_country_name == null)
      jcas.throwFeatMissing("country_name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_country_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_cc2;
  /** @generated */
  final int     casFeatCode_cc2;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getCc2(int addr) {
        if (featOkTst && casFeat_cc2 == null)
      jcas.throwFeatMissing("cc2", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_cc2);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setCc2(int addr, String v) {
        if (featOkTst && casFeat_cc2 == null)
      jcas.throwFeatMissing("cc2", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_cc2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_population;
  /** @generated */
  final int     casFeatCode_population;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPopulation(int addr) {
        if (featOkTst && casFeat_population == null)
      jcas.throwFeatMissing("population", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_population);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPopulation(int addr, String v) {
        if (featOkTst && casFeat_population == null)
      jcas.throwFeatMissing("population", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_population, v);}
    
  
 
  /** @generated */
  final Feature casFeat_elevation;
  /** @generated */
  final int     casFeatCode_elevation;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getElevation(int addr) {
        if (featOkTst && casFeat_elevation == null)
      jcas.throwFeatMissing("elevation", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_elevation);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setElevation(int addr, String v) {
        if (featOkTst && casFeat_elevation == null)
      jcas.throwFeatMissing("elevation", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_elevation, v);}
    
  
 
  /** @generated */
  final Feature casFeat_timezone;
  /** @generated */
  final int     casFeatCode_timezone;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getTimezone(int addr) {
        if (featOkTst && casFeat_timezone == null)
      jcas.throwFeatMissing("timezone", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return ll_cas.ll_getStringValue(addr, casFeatCode_timezone);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTimezone(int addr, String v) {
        if (featOkTst && casFeat_timezone == null)
      jcas.throwFeatMissing("timezone", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    ll_cas.ll_setStringValue(addr, casFeatCode_timezone, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GeoClue_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_geonameid = jcas.getRequiredFeatureDE(casType, "geonameid", "uima.cas.String", featOkTst);
    casFeatCode_geonameid  = (null == casFeat_geonameid) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geonameid).getCode();

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_asciiname = jcas.getRequiredFeatureDE(casType, "asciiname", "uima.cas.String", featOkTst);
    casFeatCode_asciiname  = (null == casFeat_asciiname) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_asciiname).getCode();

 
    casFeat_spanishname = jcas.getRequiredFeatureDE(casType, "spanishname", "uima.cas.String", featOkTst);
    casFeatCode_spanishname  = (null == casFeat_spanishname) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_spanishname).getCode();

 
    casFeat_latitude = jcas.getRequiredFeatureDE(casType, "latitude", "uima.cas.String", featOkTst);
    casFeatCode_latitude  = (null == casFeat_latitude) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_latitude).getCode();

 
    casFeat_longitude = jcas.getRequiredFeatureDE(casType, "longitude", "uima.cas.String", featOkTst);
    casFeatCode_longitude  = (null == casFeat_longitude) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_longitude).getCode();

 
    casFeat_feature_class = jcas.getRequiredFeatureDE(casType, "feature_class", "uima.cas.String", featOkTst);
    casFeatCode_feature_class  = (null == casFeat_feature_class) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_feature_class).getCode();

 
    casFeat_feature_code = jcas.getRequiredFeatureDE(casType, "feature_code", "uima.cas.String", featOkTst);
    casFeatCode_feature_code  = (null == casFeat_feature_code) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_feature_code).getCode();

 
    casFeat_country_code = jcas.getRequiredFeatureDE(casType, "country_code", "uima.cas.String", featOkTst);
    casFeatCode_country_code  = (null == casFeat_country_code) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_country_code).getCode();

 
    casFeat_country_name = jcas.getRequiredFeatureDE(casType, "country_name", "uima.cas.String", featOkTst);
    casFeatCode_country_name  = (null == casFeat_country_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_country_name).getCode();

 
    casFeat_cc2 = jcas.getRequiredFeatureDE(casType, "cc2", "uima.cas.String", featOkTst);
    casFeatCode_cc2  = (null == casFeat_cc2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_cc2).getCode();

 
    casFeat_population = jcas.getRequiredFeatureDE(casType, "population", "uima.cas.String", featOkTst);
    casFeatCode_population  = (null == casFeat_population) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_population).getCode();

 
    casFeat_elevation = jcas.getRequiredFeatureDE(casType, "elevation", "uima.cas.String", featOkTst);
    casFeatCode_elevation  = (null == casFeat_elevation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_elevation).getCode();

 
    casFeat_timezone = jcas.getRequiredFeatureDE(casType, "timezone", "uima.cas.String", featOkTst);
    casFeatCode_timezone  = (null == casFeat_timezone) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_timezone).getCode();

  }
}



    