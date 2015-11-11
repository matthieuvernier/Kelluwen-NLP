

/* First created by JCasGen Fri Nov 06 13:24:00 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** Annotation covering simples tokens (simples words)
 * Updated by JCasGen Wed Nov 11 10:30:04 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/types/TypeSystem-Kelluwen-NLP.xml
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
  //* Feature: textTokenFrequency

  /** getter for textTokenFrequency - gets give the frequency of this token in the current text
   * @generated
   * @return value of the feature 
   */
  public float getTextTokenFrequency() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_textTokenFrequency == null)
      jcasType.jcas.throwFeatMissing("textTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Token_Type)jcasType).casFeatCode_textTokenFrequency);}
    
  /** setter for textTokenFrequency - sets give the frequency of this token in the current text 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTextTokenFrequency(float v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_textTokenFrequency == null)
      jcasType.jcas.throwFeatMissing("textTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Token_Type)jcasType).casFeatCode_textTokenFrequency, v);}    
   
    
  //*--------------*
  //* Feature: languageTokenFrequency

  /** getter for languageTokenFrequency - gets gives the frequency of this token in the language
   * @generated
   * @return value of the feature 
   */
  public float getLanguageTokenFrequency() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_languageTokenFrequency == null)
      jcasType.jcas.throwFeatMissing("languageTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Token_Type)jcasType).casFeatCode_languageTokenFrequency);}
    
  /** setter for languageTokenFrequency - sets gives the frequency of this token in the language 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLanguageTokenFrequency(float v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_languageTokenFrequency == null)
      jcasType.jcas.throwFeatMissing("languageTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Token_Type)jcasType).casFeatCode_languageTokenFrequency, v);}    
   
    
  //*--------------*
  //* Feature: puntajeRelevancia

  /** getter for puntajeRelevancia - gets TF * ITF score
   * @generated
   * @return value of the feature 
   */
  public float getPuntajeRelevancia() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_puntajeRelevancia == null)
      jcasType.jcas.throwFeatMissing("puntajeRelevancia", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Token_Type)jcasType).casFeatCode_puntajeRelevancia);}
    
  /** setter for puntajeRelevancia - sets TF * ITF score 
   * @generated
   * @param v value to set into the feature 
   */
  public void setPuntajeRelevancia(float v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_puntajeRelevancia == null)
      jcasType.jcas.throwFeatMissing("puntajeRelevancia", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Token_Type)jcasType).casFeatCode_puntajeRelevancia, v);}    
   
    
  //*--------------*
  //* Feature: textTokenRank

  /** getter for textTokenRank - gets Rank of this token in the text according to it frequency
   * @generated
   * @return value of the feature 
   */
  public int getTextTokenRank() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_textTokenRank == null)
      jcasType.jcas.throwFeatMissing("textTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Token_Type)jcasType).casFeatCode_textTokenRank);}
    
  /** setter for textTokenRank - sets Rank of this token in the text according to it frequency 
   * @generated
   * @param v value to set into the feature 
   */
  public void setTextTokenRank(int v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_textTokenRank == null)
      jcasType.jcas.throwFeatMissing("textTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setIntValue(addr, ((Token_Type)jcasType).casFeatCode_textTokenRank, v);}    
   
    
  //*--------------*
  //* Feature: languageTokenRank

  /** getter for languageTokenRank - gets Rank of this token according to it frequency in the language
   * @generated
   * @return value of the feature 
   */
  public int getLanguageTokenRank() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_languageTokenRank == null)
      jcasType.jcas.throwFeatMissing("languageTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Token_Type)jcasType).casFeatCode_languageTokenRank);}
    
  /** setter for languageTokenRank - sets Rank of this token according to it frequency in the language 
   * @generated
   * @param v value to set into the feature 
   */
  public void setLanguageTokenRank(int v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_languageTokenRank == null)
      jcasType.jcas.throwFeatMissing("languageTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setIntValue(addr, ((Token_Type)jcasType).casFeatCode_languageTokenRank, v);}    
   
    
  //*--------------*
  //* Feature: frequencyGap

  /** getter for frequencyGap - gets Frequency gap between text frequency and language frequency
   * @generated
   * @return value of the feature 
   */
  public float getFrequencyGap() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_frequencyGap == null)
      jcasType.jcas.throwFeatMissing("frequencyGap", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((Token_Type)jcasType).casFeatCode_frequencyGap);}
    
  /** setter for frequencyGap - sets Frequency gap between text frequency and language frequency 
   * @generated
   * @param v value to set into the feature 
   */
  public void setFrequencyGap(float v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_frequencyGap == null)
      jcasType.jcas.throwFeatMissing("frequencyGap", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setFloatValue(addr, ((Token_Type)jcasType).casFeatCode_frequencyGap, v);}    
   
    
  //*--------------*
  //* Feature: rankGap

  /** getter for rankGap - gets rank gap between rank in the text and rank in the language
   * @generated
   * @return value of the feature 
   */
  public int getRankGap() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_rankGap == null)
      jcasType.jcas.throwFeatMissing("rankGap", "cl.uach.kelluwen.nlp.types.Token");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Token_Type)jcasType).casFeatCode_rankGap);}
    
  /** setter for rankGap - sets rank gap between rank in the text and rank in the language 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRankGap(int v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_rankGap == null)
      jcasType.jcas.throwFeatMissing("rankGap", "cl.uach.kelluwen.nlp.types.Token");
    jcasType.ll_cas.ll_setIntValue(addr, ((Token_Type)jcasType).casFeatCode_rankGap, v);}    
  }

    