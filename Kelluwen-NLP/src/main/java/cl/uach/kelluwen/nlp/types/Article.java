

/* First created by JCasGen Mon Nov 23 15:48:45 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Nov 26 18:37:18 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/types/TypeSystem-Kelluwen-DataViz.xml
 * @generated */
public class Article extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Article.class);
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
  protected Article() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Article(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Article(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Article(JCas jcas, int begin, int end) {
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
  //* Feature: url

  /** getter for url - gets 
   * @generated
   * @return value of the feature 
   */
  public String getUrl() {
    if (Article_Type.featOkTst && ((Article_Type)jcasType).casFeat_url == null)
      jcasType.jcas.throwFeatMissing("url", "cl.uach.kelluwen.nlp.types.Article");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Article_Type)jcasType).casFeatCode_url);}
    
  /** setter for url - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setUrl(String v) {
    if (Article_Type.featOkTst && ((Article_Type)jcasType).casFeat_url == null)
      jcasType.jcas.throwFeatMissing("url", "cl.uach.kelluwen.nlp.types.Article");
    jcasType.ll_cas.ll_setStringValue(addr, ((Article_Type)jcasType).casFeatCode_url, v);}    
   
    
  //*--------------*
  //* Feature: errorDuringScraping

  /** getter for errorDuringScraping - gets 
   * @generated
   * @return value of the feature 
   */
  public boolean getErrorDuringScraping() {
    if (Article_Type.featOkTst && ((Article_Type)jcasType).casFeat_errorDuringScraping == null)
      jcasType.jcas.throwFeatMissing("errorDuringScraping", "cl.uach.kelluwen.nlp.types.Article");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Article_Type)jcasType).casFeatCode_errorDuringScraping);}
    
  /** setter for errorDuringScraping - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setErrorDuringScraping(boolean v) {
    if (Article_Type.featOkTst && ((Article_Type)jcasType).casFeat_errorDuringScraping == null)
      jcasType.jcas.throwFeatMissing("errorDuringScraping", "cl.uach.kelluwen.nlp.types.Article");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Article_Type)jcasType).casFeatCode_errorDuringScraping, v);}    
   
    
  //*--------------*
  //* Feature: title

  /** getter for title - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTitle() {
    if (Article_Type.featOkTst && ((Article_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "cl.uach.kelluwen.nlp.types.Article");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Article_Type)jcasType).casFeatCode_title);}
    
  /** setter for title - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTitle(String v) {
    if (Article_Type.featOkTst && ((Article_Type)jcasType).casFeat_title == null)
      jcasType.jcas.throwFeatMissing("title", "cl.uach.kelluwen.nlp.types.Article");
    jcasType.ll_cas.ll_setStringValue(addr, ((Article_Type)jcasType).casFeatCode_title, v);}    
  }

    