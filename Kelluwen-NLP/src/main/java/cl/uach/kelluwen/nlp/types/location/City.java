

/* First created by JCasGen Thu Nov 12 12:40:58 CLT 2015 */
package cl.uach.kelluwen.nlp.types.location;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Cities in the world
 * Updated by JCasGen Wed Nov 18 11:35:47 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/types/TypeSystem-Kelluwen-Database.xml
 * @generated */
public class City extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(City.class);
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
  protected City() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public City(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public City(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public City(JCas jcas, int begin, int end) {
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
  //* Feature: latitude

  /** getter for latitude - gets North-South
   * @generated
   * @return value of the feature 
   */
  public double getLatitude() {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_latitude == null)
      jcasType.jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.location.City");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((City_Type)jcasType).casFeatCode_latitude);}
    
  /** setter for latitude - sets North-South 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLatitude(double v) {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_latitude == null)
      jcasType.jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.location.City");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((City_Type)jcasType).casFeatCode_latitude, v);}    
   
    
  //*--------------*
  //* Feature: longitude

  /** getter for longitude - gets West-East
   * @generated
   * @return value of the feature 
   */
  public double getLongitude() {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_longitude == null)
      jcasType.jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.location.City");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((City_Type)jcasType).casFeatCode_longitude);}
    
  /** setter for longitude - sets West-East 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLongitude(double v) {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_longitude == null)
      jcasType.jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.location.City");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((City_Type)jcasType).casFeatCode_longitude, v);}    
   
    
  //*--------------*
  //* Feature: country

  /** getter for country - gets 
   * @generated
   * @return value of the feature 
   */
  public String getCountry() {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_country == null)
      jcasType.jcas.throwFeatMissing("country", "cl.uach.kelluwen.nlp.types.location.City");
    return jcasType.ll_cas.ll_getStringValue(addr, ((City_Type)jcasType).casFeatCode_country);}
    
  /** setter for country - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setCountry(String v) {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_country == null)
      jcasType.jcas.throwFeatMissing("country", "cl.uach.kelluwen.nlp.types.location.City");
    jcasType.ll_cas.ll_setStringValue(addr, ((City_Type)jcasType).casFeatCode_country, v);}    
   
    
  //*--------------*
  //* Feature: normalizedName

  /** getter for normalizedName - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNormalizedName() {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_normalizedName == null)
      jcasType.jcas.throwFeatMissing("normalizedName", "cl.uach.kelluwen.nlp.types.location.City");
    return jcasType.ll_cas.ll_getStringValue(addr, ((City_Type)jcasType).casFeatCode_normalizedName);}
    
  /** setter for normalizedName - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNormalizedName(String v) {
    if (City_Type.featOkTst && ((City_Type)jcasType).casFeat_normalizedName == null)
      jcasType.jcas.throwFeatMissing("normalizedName", "cl.uach.kelluwen.nlp.types.location.City");
    jcasType.ll_cas.ll_setStringValue(addr, ((City_Type)jcasType).casFeatCode_normalizedName, v);}    
  }

    