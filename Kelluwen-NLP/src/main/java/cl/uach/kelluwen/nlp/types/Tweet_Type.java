
/* First created by JCasGen Mon Nov 23 15:48:45 CLT 2015 */
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

/** 
 * Updated by JCasGen Thu Nov 26 18:37:18 CLT 2015
 * @generated */
public class Tweet_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Tweet_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Tweet_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Tweet(addr, Tweet_Type.this);
  			   Tweet_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Tweet(addr, Tweet_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Tweet.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cl.uach.kelluwen.nlp.types.Tweet");
 
  /** @generated */
  final Feature casFeat_num_followers;
  /** @generated */
  final int     casFeatCode_num_followers;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNum_followers(int addr) {
        if (featOkTst && casFeat_num_followers == null)
      jcas.throwFeatMissing("num_followers", "cl.uach.kelluwen.nlp.types.Tweet");
    return ll_cas.ll_getIntValue(addr, casFeatCode_num_followers);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNum_followers(int addr, int v) {
        if (featOkTst && casFeat_num_followers == null)
      jcas.throwFeatMissing("num_followers", "cl.uach.kelluwen.nlp.types.Tweet");
    ll_cas.ll_setIntValue(addr, casFeatCode_num_followers, v);}
    
  
 
  /** @generated */
  final Feature casFeat_date;
  /** @generated */
  final int     casFeatCode_date;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDate(int addr) {
        if (featOkTst && casFeat_date == null)
      jcas.throwFeatMissing("date", "cl.uach.kelluwen.nlp.types.Tweet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_date);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDate(int addr, String v) {
        if (featOkTst && casFeat_date == null)
      jcas.throwFeatMissing("date", "cl.uach.kelluwen.nlp.types.Tweet");
    ll_cas.ll_setStringValue(addr, casFeatCode_date, v);}
    
  
 
  /** @generated */
  final Feature casFeat_article_url;
  /** @generated */
  final int     casFeatCode_article_url;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getArticle_url(int addr) {
        if (featOkTst && casFeat_article_url == null)
      jcas.throwFeatMissing("article_url", "cl.uach.kelluwen.nlp.types.Tweet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_article_url);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setArticle_url(int addr, String v) {
        if (featOkTst && casFeat_article_url == null)
      jcas.throwFeatMissing("article_url", "cl.uach.kelluwen.nlp.types.Tweet");
    ll_cas.ll_setStringValue(addr, casFeatCode_article_url, v);}
    
  
 
  /** @generated */
  final Feature casFeat_screen_name;
  /** @generated */
  final int     casFeatCode_screen_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getScreen_name(int addr) {
        if (featOkTst && casFeat_screen_name == null)
      jcas.throwFeatMissing("screen_name", "cl.uach.kelluwen.nlp.types.Tweet");
    return ll_cas.ll_getStringValue(addr, casFeatCode_screen_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setScreen_name(int addr, String v) {
        if (featOkTst && casFeat_screen_name == null)
      jcas.throwFeatMissing("screen_name", "cl.uach.kelluwen.nlp.types.Tweet");
    ll_cas.ll_setStringValue(addr, casFeatCode_screen_name, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Tweet_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_num_followers = jcas.getRequiredFeatureDE(casType, "num_followers", "uima.cas.Integer", featOkTst);
    casFeatCode_num_followers  = (null == casFeat_num_followers) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_num_followers).getCode();

 
    casFeat_date = jcas.getRequiredFeatureDE(casType, "date", "uima.cas.String", featOkTst);
    casFeatCode_date  = (null == casFeat_date) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_date).getCode();

 
    casFeat_article_url = jcas.getRequiredFeatureDE(casType, "article_url", "uima.cas.String", featOkTst);
    casFeatCode_article_url  = (null == casFeat_article_url) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_article_url).getCode();

 
    casFeat_screen_name = jcas.getRequiredFeatureDE(casType, "screen_name", "uima.cas.String", featOkTst);
    casFeatCode_screen_name  = (null == casFeat_screen_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_screen_name).getCode();

  }
}



    