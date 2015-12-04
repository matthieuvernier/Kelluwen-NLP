

/* First created by JCasGen Thu Nov 26 18:37:15 CLT 2015 */
package cl.uach.kelluwen.nlp.types.location;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Nov 30 19:08:37 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/io/XmiCollectionReader.xml
 * @generated */
public class Country extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Country.class);
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
  protected Country() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Country(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Country(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Country(JCas jcas, int begin, int end) {
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

  /** getter for latitude - gets 
   * @generated
   * @return value of the feature 
   */
  public double getLatitude() {
    if (Country_Type.featOkTst && ((Country_Type)jcasType).casFeat_latitude == null)
      jcasType.jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.location.Country");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Country_Type)jcasType).casFeatCode_latitude);}
    
  /** setter for latitude - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLatitude(double v) {
    if (Country_Type.featOkTst && ((Country_Type)jcasType).casFeat_latitude == null)
      jcasType.jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.types.location.Country");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Country_Type)jcasType).casFeatCode_latitude, v);}    
   
    
  //*--------------*
  //* Feature: longitude

  /** getter for longitude - gets 
   * @generated
   * @return value of the feature 
   */
  public double getLongitude() {
    if (Country_Type.featOkTst && ((Country_Type)jcasType).casFeat_longitude == null)
      jcasType.jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.location.Country");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Country_Type)jcasType).casFeatCode_longitude);}
    
  /** setter for longitude - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLongitude(double v) {
    if (Country_Type.featOkTst && ((Country_Type)jcasType).casFeat_longitude == null)
      jcasType.jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.types.location.Country");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Country_Type)jcasType).casFeatCode_longitude, v);}    
   
    
  //*--------------*
  //* Feature: normalizedName

  /** getter for normalizedName - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNormalizedName() {
    if (Country_Type.featOkTst && ((Country_Type)jcasType).casFeat_normalizedName == null)
      jcasType.jcas.throwFeatMissing("normalizedName", "cl.uach.kelluwen.nlp.types.location.Country");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Country_Type)jcasType).casFeatCode_normalizedName);}
    
  /** setter for normalizedName - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNormalizedName(String v) {
    if (Country_Type.featOkTst && ((Country_Type)jcasType).casFeat_normalizedName == null)
      jcasType.jcas.throwFeatMissing("normalizedName", "cl.uach.kelluwen.nlp.types.location.Country");
    jcasType.ll_cas.ll_setStringValue(addr, ((Country_Type)jcasType).casFeatCode_normalizedName, v);}    
  }

    