

/* First created by JCasGen Mon Nov 30 15:55:23 CLT 2015 */
package cl.uach.kelluwen.nlp.types.evaluation;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Nov 30 19:08:37 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/io/XmiCollectionReader.xml
 * @generated */
public class Reference extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Reference.class);
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
  protected Reference() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Reference(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Reference(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Reference(JCas jcas, int begin, int end) {
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
  //* Feature: topic

  /** getter for topic - gets 
   * @generated
   * @return value of the feature 
   */
  public String getTopic() {
    if (Reference_Type.featOkTst && ((Reference_Type)jcasType).casFeat_topic == null)
      jcasType.jcas.throwFeatMissing("topic", "cl.uach.kelluwen.nlp.types.evaluation.Reference");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Reference_Type)jcasType).casFeatCode_topic);}
    
  /** setter for topic - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTopic(String v) {
    if (Reference_Type.featOkTst && ((Reference_Type)jcasType).casFeat_topic == null)
      jcasType.jcas.throwFeatMissing("topic", "cl.uach.kelluwen.nlp.types.evaluation.Reference");
    jcasType.ll_cas.ll_setStringValue(addr, ((Reference_Type)jcasType).casFeatCode_topic, v);}    
  }

    