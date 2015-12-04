

/* First created by JCasGen Wed Nov 25 15:14:48 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** metrics for text analysis : frecuency, language frecuency, rank, etc.
 * Updated by JCasGen Mon Nov 30 19:08:37 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/io/XmiCollectionReader.xml
 * @generated */
public class TextMetric extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TextMetric.class);
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
  protected TextMetric() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TextMetric(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TextMetric(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TextMetric(JCas jcas, int begin, int end) {
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
  //* Feature: frequencyInText

  /** getter for frequencyInText - gets 
   * @generated
   * @return value of the feature 
   */
  public float getFrequencyInText() {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_frequencyInText == null)
      jcasType.jcas.throwFeatMissing("frequencyInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_frequencyInText);}
    
  /** setter for frequencyInText - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFrequencyInText(float v) {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_frequencyInText == null)
      jcasType.jcas.throwFeatMissing("frequencyInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    jcasType.ll_cas.ll_setFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_frequencyInText, v);}    
   
    
  //*--------------*
  //* Feature: frequencyInLanguage

  /** getter for frequencyInLanguage - gets 
   * @generated
   * @return value of the feature 
   */
  public float getFrequencyInLanguage() {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_frequencyInLanguage == null)
      jcasType.jcas.throwFeatMissing("frequencyInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_frequencyInLanguage);}
    
  /** setter for frequencyInLanguage - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFrequencyInLanguage(float v) {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_frequencyInLanguage == null)
      jcasType.jcas.throwFeatMissing("frequencyInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    jcasType.ll_cas.ll_setFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_frequencyInLanguage, v);}    
   
    
  //*--------------*
  //* Feature: rankInText

  /** getter for rankInText - gets 
   * @generated
   * @return value of the feature 
   */
  public float getRankInText() {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_rankInText == null)
      jcasType.jcas.throwFeatMissing("rankInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_rankInText);}
    
  /** setter for rankInText - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRankInText(float v) {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_rankInText == null)
      jcasType.jcas.throwFeatMissing("rankInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    jcasType.ll_cas.ll_setFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_rankInText, v);}    
   
    
  //*--------------*
  //* Feature: rankInLanguage

  /** getter for rankInLanguage - gets 
   * @generated
   * @return value of the feature 
   */
  public float getRankInLanguage() {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_rankInLanguage == null)
      jcasType.jcas.throwFeatMissing("rankInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_rankInLanguage);}
    
  /** setter for rankInLanguage - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRankInLanguage(float v) {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_rankInLanguage == null)
      jcasType.jcas.throwFeatMissing("rankInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    jcasType.ll_cas.ll_setFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_rankInLanguage, v);}    
   
    
  //*--------------*
  //* Feature: TFIDF

  /** getter for TFIDF - gets 
   * @generated
   * @return value of the feature 
   */
  public float getTFIDF() {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_TFIDF == null)
      jcasType.jcas.throwFeatMissing("TFIDF", "cl.uach.kelluwen.nlp.types.TextMetric");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_TFIDF);}
    
  /** setter for TFIDF - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTFIDF(float v) {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_TFIDF == null)
      jcasType.jcas.throwFeatMissing("TFIDF", "cl.uach.kelluwen.nlp.types.TextMetric");
    jcasType.ll_cas.ll_setFloatValue(addr, ((TextMetric_Type)jcasType).casFeatCode_TFIDF, v);}    
   
    
  //*--------------*
  //* Feature: annotation

  /** getter for annotation - gets 
   * @generated
   * @return value of the feature 
   */
  public Annotation getAnnotation() {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_annotation == null)
      jcasType.jcas.throwFeatMissing("annotation", "cl.uach.kelluwen.nlp.types.TextMetric");
    return (Annotation)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TextMetric_Type)jcasType).casFeatCode_annotation)));}
    
  /** setter for annotation - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnnotation(Annotation v) {
    if (TextMetric_Type.featOkTst && ((TextMetric_Type)jcasType).casFeat_annotation == null)
      jcasType.jcas.throwFeatMissing("annotation", "cl.uach.kelluwen.nlp.types.TextMetric");
    jcasType.ll_cas.ll_setRefValue(addr, ((TextMetric_Type)jcasType).casFeatCode_annotation, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    