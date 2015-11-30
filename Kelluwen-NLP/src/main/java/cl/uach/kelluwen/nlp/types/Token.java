

/* First created by JCasGen Fri Nov 06 13:24:00 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Annotation covering simples tokens (simples words)
 * Updated by JCasGen Sun Nov 29 19:05:34 CLT 2015
 * XML source: /home/matthieu/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/types/TypeSystem-Kelluwen-Database.xml
 * @generated */
public class Token extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
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
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Token(JCas jcas, int begin, int end) {
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
  //* Feature: lemma

  /** getter for lemma - gets token's lemma
   * @generated
   * @return value of the feature 
   */
  public String getLemma() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_lemma);}
    
  /** setter for lemma - sets token's lemma 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLemma(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_lemma == null)
      jcasType.jcas.throwFeatMissing("lemma", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_lemma, v);}    
   
    
  //*--------------*
  //* Feature: pos

  /** getter for pos - gets normalized grammatical category
   * @generated
   * @return value of the feature 
   */
  public String getPos() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_pos);}
    
  /** setter for pos - sets normalized grammatical category 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPos(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_pos == null)
      jcasType.jcas.throwFeatMissing("pos", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_pos, v);}    
   
    
  //*--------------*
  //* Feature: posTreeTagger

  /** getter for posTreeTagger - gets grammatical category according to the external tool : TreeTagger (not normalized !)
   * @generated
   * @return value of the feature 
   */
  public String getPosTreeTagger() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_posTreeTagger == null)
      jcasType.jcas.throwFeatMissing("posTreeTagger", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_posTreeTagger);}
    
  /** setter for posTreeTagger - sets grammatical category according to the external tool : TreeTagger (not normalized !) 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPosTreeTagger(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_posTreeTagger == null)
      jcasType.jcas.throwFeatMissing("posTreeTagger", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_posTreeTagger, v);}    
   
    
  //*--------------*
  //* Feature: stopWord

  /** getter for stopWord - gets 
   * @generated
   * @return value of the feature 
   */
  public boolean getStopWord() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_stopWord == null)
      jcasType.jcas.throwFeatMissing("stopWord", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_stopWord);}
    
  /** setter for stopWord - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setStopWord(boolean v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_stopWord == null)
      jcasType.jcas.throwFeatMissing("stopWord", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Token_Type)jcasType).casFeatCode_stopWord, v);}    
   
    
  //*--------------*
  //* Feature: textMetric

  /** getter for textMetric - gets 
   * @generated
   * @return value of the feature 
   */
  public TextMetric getTextMetric() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_textMetric == null)
      jcasType.jcas.throwFeatMissing("textMetric", "cl.uach.kelluwen.nlp.types.Token");
    return (TextMetric)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Token_Type)jcasType).casFeatCode_textMetric)));}
    
  /** setter for textMetric - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setTextMetric(TextMetric v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_textMetric == null)
      jcasType.jcas.throwFeatMissing("textMetric", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setRefValue(addr, ((Token_Type)jcasType).casFeatCode_textMetric, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    