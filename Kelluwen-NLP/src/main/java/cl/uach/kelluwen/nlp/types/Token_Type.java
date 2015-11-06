
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
 * Updated by JCasGen Fri Nov 06 17:24:47 CLT 2015
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
  final Feature casFeat_tokenFrequency;
  /** @generated */
  final int     casFeatCode_tokenFrequency;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getTokenFrequency(int addr) {
        if (featOkTst && casFeat_tokenFrequency == null)
      jcas.throwFeatMissing("tokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_tokenFrequency);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTokenFrequency(int addr, float v) {
        if (featOkTst && casFeat_tokenFrequency == null)
      jcas.throwFeatMissing("tokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_tokenFrequency, v);}
    
  
 
  /** @generated */
  final Feature casFeat_inverseTokenFrequency;
  /** @generated */
  final int     casFeatCode_inverseTokenFrequency;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getInverseTokenFrequency(int addr) {
        if (featOkTst && casFeat_inverseTokenFrequency == null)
      jcas.throwFeatMissing("inverseTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_inverseTokenFrequency);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setInverseTokenFrequency(int addr, float v) {
        if (featOkTst && casFeat_inverseTokenFrequency == null)
      jcas.throwFeatMissing("inverseTokenFrequency", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_inverseTokenFrequency, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TfItf;
  /** @generated */
  final int     casFeatCode_TfItf;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getTfItf(int addr) {
        if (featOkTst && casFeat_TfItf == null)
      jcas.throwFeatMissing("TfItf", "cl.uach.kelluwen.nlp.types.Token");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_TfItf);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTfItf(int addr, float v) {
        if (featOkTst && casFeat_TfItf == null)
      jcas.throwFeatMissing("TfItf", "cl.uach.kelluwen.nlp.types.Token");
    ll_cas.ll_setFloatValue(addr, casFeatCode_TfItf, v);}
    
  



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

 
    casFeat_tokenFrequency = jcas.getRequiredFeatureDE(casType, "tokenFrequency", "uima.cas.Float", featOkTst);
    casFeatCode_tokenFrequency  = (null == casFeat_tokenFrequency) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_tokenFrequency).getCode();

 
    casFeat_inverseTokenFrequency = jcas.getRequiredFeatureDE(casType, "inverseTokenFrequency", "uima.cas.Float", featOkTst);
    casFeatCode_inverseTokenFrequency  = (null == casFeat_inverseTokenFrequency) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_inverseTokenFrequency).getCode();

 
    casFeat_TfItf = jcas.getRequiredFeatureDE(casType, "TfItf", "uima.cas.Float", featOkTst);
    casFeatCode_TfItf  = (null == casFeat_TfItf) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TfItf).getCode();

  }
}



    