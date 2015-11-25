
/* First created by JCasGen Wed Nov 25 15:14:48 CLT 2015 */
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

/** metrics for text analysis : frecuency, language frecuency, rank, etc.
 * Updated by JCasGen Wed Nov 25 15:14:48 CLT 2015
 * @generated */
public class TextMetric_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (TextMetric_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = TextMetric_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new TextMetric(addr, TextMetric_Type.this);
  			   TextMetric_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new TextMetric(addr, TextMetric_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = TextMetric.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cl.uach.kelluwen.nlp.types.TextMetric");
 
  /** @generated */
  final Feature casFeat_frequencyInText;
  /** @generated */
  final int     casFeatCode_frequencyInText;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getFrequencyInText(int addr) {
        if (featOkTst && casFeat_frequencyInText == null)
      jcas.throwFeatMissing("frequencyInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_frequencyInText);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFrequencyInText(int addr, float v) {
        if (featOkTst && casFeat_frequencyInText == null)
      jcas.throwFeatMissing("frequencyInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    ll_cas.ll_setFloatValue(addr, casFeatCode_frequencyInText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_frequencyInLanguage;
  /** @generated */
  final int     casFeatCode_frequencyInLanguage;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getFrequencyInLanguage(int addr) {
        if (featOkTst && casFeat_frequencyInLanguage == null)
      jcas.throwFeatMissing("frequencyInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_frequencyInLanguage);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFrequencyInLanguage(int addr, float v) {
        if (featOkTst && casFeat_frequencyInLanguage == null)
      jcas.throwFeatMissing("frequencyInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    ll_cas.ll_setFloatValue(addr, casFeatCode_frequencyInLanguage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rankInText;
  /** @generated */
  final int     casFeatCode_rankInText;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getRankInText(int addr) {
        if (featOkTst && casFeat_rankInText == null)
      jcas.throwFeatMissing("rankInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_rankInText);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRankInText(int addr, float v) {
        if (featOkTst && casFeat_rankInText == null)
      jcas.throwFeatMissing("rankInText", "cl.uach.kelluwen.nlp.types.TextMetric");
    ll_cas.ll_setFloatValue(addr, casFeatCode_rankInText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_rankInLanguage;
  /** @generated */
  final int     casFeatCode_rankInLanguage;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getRankInLanguage(int addr) {
        if (featOkTst && casFeat_rankInLanguage == null)
      jcas.throwFeatMissing("rankInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_rankInLanguage);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRankInLanguage(int addr, float v) {
        if (featOkTst && casFeat_rankInLanguage == null)
      jcas.throwFeatMissing("rankInLanguage", "cl.uach.kelluwen.nlp.types.TextMetric");
    ll_cas.ll_setFloatValue(addr, casFeatCode_rankInLanguage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_TFIDF;
  /** @generated */
  final int     casFeatCode_TFIDF;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getTFIDF(int addr) {
        if (featOkTst && casFeat_TFIDF == null)
      jcas.throwFeatMissing("TFIDF", "cl.uach.kelluwen.nlp.types.TextMetric");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_TFIDF);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setTFIDF(int addr, float v) {
        if (featOkTst && casFeat_TFIDF == null)
      jcas.throwFeatMissing("TFIDF", "cl.uach.kelluwen.nlp.types.TextMetric");
    ll_cas.ll_setFloatValue(addr, casFeatCode_TFIDF, v);}
    
  
 
  /** @generated */
  final Feature casFeat_annotation;
  /** @generated */
  final int     casFeatCode_annotation;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnnotation(int addr) {
        if (featOkTst && casFeat_annotation == null)
      jcas.throwFeatMissing("annotation", "cl.uach.kelluwen.nlp.types.TextMetric");
    return ll_cas.ll_getRefValue(addr, casFeatCode_annotation);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnnotation(int addr, int v) {
        if (featOkTst && casFeat_annotation == null)
      jcas.throwFeatMissing("annotation", "cl.uach.kelluwen.nlp.types.TextMetric");
    ll_cas.ll_setRefValue(addr, casFeatCode_annotation, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public TextMetric_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_frequencyInText = jcas.getRequiredFeatureDE(casType, "frequencyInText", "uima.cas.Float", featOkTst);
    casFeatCode_frequencyInText  = (null == casFeat_frequencyInText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_frequencyInText).getCode();

 
    casFeat_frequencyInLanguage = jcas.getRequiredFeatureDE(casType, "frequencyInLanguage", "uima.cas.Float", featOkTst);
    casFeatCode_frequencyInLanguage  = (null == casFeat_frequencyInLanguage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_frequencyInLanguage).getCode();

 
    casFeat_rankInText = jcas.getRequiredFeatureDE(casType, "rankInText", "uima.cas.Float", featOkTst);
    casFeatCode_rankInText  = (null == casFeat_rankInText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rankInText).getCode();

 
    casFeat_rankInLanguage = jcas.getRequiredFeatureDE(casType, "rankInLanguage", "uima.cas.Float", featOkTst);
    casFeatCode_rankInLanguage  = (null == casFeat_rankInLanguage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_rankInLanguage).getCode();

 
    casFeat_TFIDF = jcas.getRequiredFeatureDE(casType, "TFIDF", "uima.cas.Float", featOkTst);
    casFeatCode_TFIDF  = (null == casFeat_TFIDF) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_TFIDF).getCode();

 
    casFeat_annotation = jcas.getRequiredFeatureDE(casType, "annotation", "uima.tcas.Annotation", featOkTst);
    casFeatCode_annotation  = (null == casFeat_annotation) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_annotation).getCode();

  }
}



    