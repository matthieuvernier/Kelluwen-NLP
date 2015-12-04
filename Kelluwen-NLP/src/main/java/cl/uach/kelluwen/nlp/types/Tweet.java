

/* First created by JCasGen Mon Nov 23 15:48:45 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Nov 30 19:08:37 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/io/XmiCollectionReader.xml
 * @generated */
public class Tweet extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Tweet.class);
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
  protected Tweet() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Tweet(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Tweet(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Tweet(JCas jcas, int begin, int end) {
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
  //* Feature: num_followers

  /** getter for num_followers - gets 
   * @generated
   * @return value of the feature 
   */
  public int getNum_followers() {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_num_followers == null)
      jcasType.jcas.throwFeatMissing("num_followers", "cl.uach.kelluwen.nlp.types.Tweet");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Tweet_Type)jcasType).casFeatCode_num_followers);}
    
  /** setter for num_followers - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNum_followers(int v) {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_num_followers == null)
      jcasType.jcas.throwFeatMissing("num_followers", "cl.uach.kelluwen.nlp.types.Tweet");
    jcasType.ll_cas.ll_setIntValue(addr, ((Tweet_Type)jcasType).casFeatCode_num_followers, v);}    
   
    
  //*--------------*
  //* Feature: date

  /** getter for date - gets 
   * @generated
   * @return value of the feature 
   */
  public String getDate() {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_date == null)
      jcasType.jcas.throwFeatMissing("date", "cl.uach.kelluwen.nlp.types.Tweet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Tweet_Type)jcasType).casFeatCode_date);}
    
  /** setter for date - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDate(String v) {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_date == null)
      jcasType.jcas.throwFeatMissing("date", "cl.uach.kelluwen.nlp.types.Tweet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Tweet_Type)jcasType).casFeatCode_date, v);}    
   
    
  //*--------------*
  //* Feature: article_url

  /** getter for article_url - gets 
   * @generated
   * @return value of the feature 
   */
  public String getArticle_url() {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_article_url == null)
      jcasType.jcas.throwFeatMissing("article_url", "cl.uach.kelluwen.nlp.types.Tweet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Tweet_Type)jcasType).casFeatCode_article_url);}
    
  /** setter for article_url - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setArticle_url(String v) {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_article_url == null)
      jcasType.jcas.throwFeatMissing("article_url", "cl.uach.kelluwen.nlp.types.Tweet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Tweet_Type)jcasType).casFeatCode_article_url, v);}    
   
    
  //*--------------*
  //* Feature: screen_name

  /** getter for screen_name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getScreen_name() {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_screen_name == null)
      jcasType.jcas.throwFeatMissing("screen_name", "cl.uach.kelluwen.nlp.types.Tweet");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Tweet_Type)jcasType).casFeatCode_screen_name);}
    
  /** setter for screen_name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setScreen_name(String v) {
    if (Tweet_Type.featOkTst && ((Tweet_Type)jcasType).casFeat_screen_name == null)
      jcasType.jcas.throwFeatMissing("screen_name", "cl.uach.kelluwen.nlp.types.Tweet");
    jcasType.ll_cas.ll_setStringValue(addr, ((Tweet_Type)jcasType).casFeatCode_screen_name, v);}    
  }

    