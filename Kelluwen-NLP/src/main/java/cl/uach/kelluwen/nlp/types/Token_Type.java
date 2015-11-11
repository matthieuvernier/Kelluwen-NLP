
/* First created by JCasGen Fri Nov 06 13:24:00 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

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

/** Annotation covering simples tokens (simples words)
 * Updated by JCasGen Wed Nov 11 10:30:04 CLT 2015
 * @generated */
public class Token_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Token_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Token_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Token(addr, Token_Type.this);
  			   Token_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Token(addr, Token_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Token.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cl.uach.kelluwen.nlp.types.Token");



  /** @generated */
  final Feature casFeat_lemma;
  /** @generated */
  final int     casFeatCode_lemma;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLemma(int addr) {
        if (featOkTst && casFeat_lemma == null)
      jcas.throwFeatMissing("lemma", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_lemma);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLemma(int addr, String v) {
        if (featOkTst && casFeat_lemma == null)
      jcas.throwFeatMissing("lemma", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_lemma, v);}
    
  
 
  /** @generated */
  final Feature casFeat_pos;
  /** @generated */
  final int     casFeatCode_pos;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPos(int addr) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_pos);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPos(int addr, String v) {
        if (featOkTst && casFeat_pos == null)
      jcas.throwFeatMissing("pos", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_pos, v);}
    
  
 
  /** @generated */
  final Feature casFeat_posTreeTagger;
  /** @generated */
  final int     casFeatCode_posTreeTagger;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getPosTreeTagger(int addr) {
        if (featOkTst && casFeat_posTreeTagger == null)
      jcas.throwFeatMissing("posTreeTagger", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getStringValue(addr, casFeatCode_posTreeTagger);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPosTreeTagger(int addr, String v) {
        if (featOkTst && casFeat_posTreeTagger == null)
      jcas.throwFeatMissing("posTreeTagger", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setStringValue(addr, casFeatCode_posTreeTagger, v);}
    
  
 
  /** @generated */
  final Feature casFeat_textTokenFrequency;
  /** @generated */
  final int     casFeatCode_textTokenFrequency;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getTextTokenFrequency(int addr) {
        if (featOkTst && casFeat_textTokenFrequency == null)
      jcas.throwFeatMissing("textTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_textTokenFrequency);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTextTokenFrequency(int addr, float v) {
        if (featOkTst && casFeat_textTokenFrequency == null)
      jcas.throwFeatMissing("textTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_textTokenFrequency, v);}
    
  
 
  /** @generated */
  final Feature casFeat_languageTokenFrequency;
  /** @generated */
  final int     casFeatCode_languageTokenFrequency;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getLanguageTokenFrequency(int addr) {
        if (featOkTst && casFeat_languageTokenFrequency == null)
      jcas.throwFeatMissing("languageTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_languageTokenFrequency);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLanguageTokenFrequency(int addr, float v) {
        if (featOkTst && casFeat_languageTokenFrequency == null)
      jcas.throwFeatMissing("languageTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_languageTokenFrequency, v);}
    
  
 
  /** @generated */
  final Feature casFeat_puntajeRelevancia;
  /** @generated */
  final int     casFeatCode_puntajeRelevancia;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getPuntajeRelevancia(int addr) {
        if (featOkTst && casFeat_puntajeRelevancia == null)
      jcas.throwFeatMissing("puntajeRelevancia", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_puntajeRelevancia);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPuntajeRelevancia(int addr, float v) {
        if (featOkTst && casFeat_puntajeRelevancia == null)
      jcas.throwFeatMissing("puntajeRelevancia", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_puntajeRelevancia, v);}
    
  
 
  /** @generated */
  final Feature casFeat_textTokenRank;
  /** @generated */
  final int     casFeatCode_textTokenRank;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getTextTokenRank(int addr) {
        if (featOkTst && casFeat_textTokenRank == null)
      jcas.throwFeatMissing("textTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getIntValue(addr, casFeatCode_textTokenRank);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTextTokenRank(int addr, int v) {
        if (featOkTst && casFeat_textTokenRank == null)
      jcas.throwFeatMissing("textTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setIntValue(addr, casFeatCode_textTokenRank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_languageTokenRank;
  /** @generated */
  final int     casFeatCode_languageTokenRank;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getLanguageTokenRank(int addr) {
        if (featOkTst && casFeat_languageTokenRank == null)
      jcas.throwFeatMissing("languageTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getIntValue(addr, casFeatCode_languageTokenRank);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLanguageTokenRank(int addr, int v) {
        if (featOkTst && casFeat_languageTokenRank == null)
      jcas.throwFeatMissing("languageTokenRank", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setIntValue(addr, casFeatCode_languageTokenRank, v);}
    
  
 
  /** @generated */
  final Feature casFeat_frequencyGap;
  /** @generated */
  final int     casFeatCode_frequencyGap;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getFrequencyGap(int addr) {
        if (featOkTst && casFeat_frequencyGap == null)
      jcas.throwFeatMissing("frequencyGap", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_frequencyGap);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFrequencyGap(int addr, float v) {
        if (featOkTst && casFeat_frequencyGap == null)
      jcas.throwFeatMissing("frequencyGap", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_frequencyGap, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rankGap;
  /** @generated */
  final int     casFeatCode_rankGap;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getRankGap(int addr) {
        if (featOkTst && casFeat_rankGap == null)
      jcas.throwFeatMissing("rankGap", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getIntValue(addr, casFeatCode_rankGap);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRankGap(int addr, int v) {
        if (featOkTst && casFeat_rankGap == null)
      jcas.throwFeatMissing("rankGap", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setIntValue(addr, casFeatCode_rankGap, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Token_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_lemma = jcas.getRequiredFeatureDE(casType, "lemma", "uima.cas.String", featOkTst);
    casFeatCode_lemma  = (null == casFeat_lemma) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_lemma).getCode();

 
    casFeat_pos = jcas.getRequiredFeatureDE(casType, "pos", "uima.cas.String", featOkTst);
    casFeatCode_pos  = (null == casFeat_pos) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_pos).getCode();

 
    casFeat_posTreeTagger = jcas.getRequiredFeatureDE(casType, "posTreeTagger", "uima.cas.String", featOkTst);
    casFeatCode_posTreeTagger  = (null == casFeat_posTreeTagger) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_posTreeTagger).getCode();

 
    casFeat_textTokenFrequency = jcas.getRequiredFeatureDE(casType, "textTokenFrequency", "uima.cas.Float", featOkTst);
    casFeatCode_textTokenFrequency  = (null == casFeat_textTokenFrequency) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_textTokenFrequency).getCode();

 
    casFeat_languageTokenFrequency = jcas.getRequiredFeatureDE(casType, "languageTokenFrequency", "uima.cas.Float", featOkTst);
    casFeatCode_languageTokenFrequency  = (null == casFeat_languageTokenFrequency) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_languageTokenFrequency).getCode();

 
    casFeat_puntajeRelevancia = jcas.getRequiredFeatureDE(casType, "puntajeRelevancia", "uima.cas.Float", featOkTst);
    casFeatCode_puntajeRelevancia  = (null == casFeat_puntajeRelevancia) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_puntajeRelevancia).getCode();

 
    casFeat_textTokenRank = jcas.getRequiredFeatureDE(casType, "textTokenRank", "uima.cas.Integer", featOkTst);
    casFeatCode_textTokenRank  = (null == casFeat_textTokenRank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_textTokenRank).getCode();

 
    casFeat_languageTokenRank = jcas.getRequiredFeatureDE(casType, "languageTokenRank", "uima.cas.Integer", featOkTst);
    casFeatCode_languageTokenRank  = (null == casFeat_languageTokenRank) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_languageTokenRank).getCode();

 
    casFeat_frequencyGap = jcas.getRequiredFeatureDE(casType, "frequencyGap", "uima.cas.Float", featOkTst);
    casFeatCode_frequencyGap  = (null == casFeat_frequencyGap) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_frequencyGap).getCode();

 
    casFeat_rankGap = jcas.getRequiredFeatureDE(casType, "rankGap", "uima.cas.Integer", featOkTst);
    casFeatCode_rankGap  = (null == casFeat_rankGap) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rankGap).getCode();

  }
}



    