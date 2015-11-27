

/* First created by JCasGen Thu Nov 26 11:24:23 CLT 2015 */
package cl.uach.kelluwen.nlp.types.geonames;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Clue identificated with Geonames
 * Updated by JCasGen Thu Nov 26 13:34:38 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/types/TypeSystem-Kelluwen-Geonames.xml
 * @generated */
public class GeoClue extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeoClue.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeoClue() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GeoClue(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GeoClue(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public GeoClue(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: geonameid

  /** getter for geonameid - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGeonameid() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_geonameid == null)
      jcasType.jcas.throwFeatMissing("geonameid", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_geonameid);}
    
  /** setter for geonameid - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeonameid(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_geonameid == null)
      jcasType.jcas.throwFeatMissing("geonameid", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_geonameid, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: asciiname

  /** getter for asciiname - gets 
   * @generated
   * @return value of the feature 
   */
  public String getAsciiname() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_asciiname == null)
      jcasType.jcas.throwFeatMissing("asciiname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_asciiname);}
    
  /** setter for asciiname - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAsciiname(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_asciiname == null)
      jcasType.jcas.throwFeatMissing("asciiname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_asciiname, v);}    
   
    
  //*--------------*
  //* Feature: spanishname

  /** getter for spanishname - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSpanishname() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_spanishname == null)
      jcasType.jcas.throwFeatMissing("spanishname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_spanishname);}
    
  /** setter for spanishname - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSpanishname(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_spanishname == null)
      jcasType.jcas.throwFeatMissing("spanishname", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_spanishname, v);}    
   
    
  //*--------------*
  //* Feature: latitude

  /** getter for latitude - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLatitude() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_latitude == null)
      jcasType.jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_latitude);}
    
  /** setter for latitude - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLatitude(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_latitude == null)
      jcasType.jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_latitude, v);}    
   
    
  //*--------------*
  //* Feature: longitude

  /** getter for longitude - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLongitude() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_longitude == null)
      jcasType.jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_longitude);}
    
  /** setter for longitude - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLongitude(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_longitude == null)
      jcasType.jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_longitude, v);}    
   
    
  //*--------------*
  //* Feature: feature_class

  /** getter for feature_class - gets 
   * @generated
   * @return value of the feature 
   */
  public String getFeature_class() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_feature_class == null)
      jcasType.jcas.throwFeatMissing("feature_class", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_feature_class);}
    
  /** setter for feature_class - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFeature_class(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_feature_class == null)
      jcasType.jcas.throwFeatMissing("feature_class", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_feature_class, v);}    
   
    
  //*--------------*
  //* Feature: feature_code

  /** getter for feature_code - gets 
   * @generated
   * @return value of the feature 
   */
  public String getFeature_code() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_feature_code == null)
      jcasType.jcas.throwFeatMissing("feature_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_feature_code);}
    
  /** setter for feature_code - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFeature_code(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_feature_code == null)
      jcasType.jcas.throwFeatMissing("feature_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_feature_code, v);}    
   
    
  //*--------------*
  //* Feature: country_code

  /** getter for country_code - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCountry_code() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_country_code == null)
      jcasType.jcas.throwFeatMissing("country_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_country_code);}
    
  /** setter for country_code - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountry_code(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_country_code == null)
      jcasType.jcas.throwFeatMissing("country_code", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_country_code, v);}    
   
    
  //*--------------*
  //* Feature: country_name

  /** getter for country_name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCountry_name() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_country_name == null)
      jcasType.jcas.throwFeatMissing("country_name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_country_name);}
    
  /** setter for country_name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountry_name(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_country_name == null)
      jcasType.jcas.throwFeatMissing("country_name", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_country_name, v);}    
   
    
  //*--------------*
  //* Feature: cc2

  /** getter for cc2 - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCc2() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_cc2 == null)
      jcasType.jcas.throwFeatMissing("cc2", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_cc2);}
    
  /** setter for cc2 - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCc2(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_cc2 == null)
      jcasType.jcas.throwFeatMissing("cc2", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_cc2, v);}    
   
    
  //*--------------*
  //* Feature: population

  /** getter for population - gets 
   * @generated
   * @return value of the feature 
   */
  public String getPopulation() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_population == null)
      jcasType.jcas.throwFeatMissing("population", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_population);}
    
  /** setter for population - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPopulation(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_population == null)
      jcasType.jcas.throwFeatMissing("population", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_population, v);}    
   
    
  //*--------------*
  //* Feature: elevation

  /** getter for elevation - gets 
   * @generated
   * @return value of the feature 
   */
  public String getElevation() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_elevation == null)
      jcasType.jcas.throwFeatMissing("elevation", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_elevation);}
    
  /** setter for elevation - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setElevation(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_elevation == null)
      jcasType.jcas.throwFeatMissing("elevation", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_elevation, v);}    
   
    
  //*--------------*
  //* Feature: timezone

  /** getter for timezone - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTimezone() {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_timezone == null)
      jcasType.jcas.throwFeatMissing("timezone", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_timezone);}
    
  /** setter for timezone - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTimezone(String v) {
    if (GeoClue_Type.featOkTst && ((GeoClue_Type)jcasType).casFeat_timezone == null)
      jcasType.jcas.throwFeatMissing("timezone", "cl.uach.kelluwen.nlp.types.geonames.GeoClue");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeoClue_Type)jcasType).casFeatCode_timezone, v);}    
  }

    