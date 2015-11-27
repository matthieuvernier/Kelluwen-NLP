
/* First created by JCasGen Thu Nov 26 18:11:50 CLT 2015 */
package cl.uach.kelluwen.nlp.location;

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
 * Updated by JCasGen Thu Nov 26 18:12:46 CLT 2015
 * @generated */
public class Country_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Country_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Country_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Country(addr, Country_Type.this);
  			   Country_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Country(addr, Country_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Country.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cl.uach.kelluwen.nlp.location.Country");
 
  /** @generated */
  final Feature casFeat_latitude;
  /** @generated */
  final int     casFeatCode_latitude;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getLatitude(int addr) {
        if (featOkTst && casFeat_latitude == null)
      jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.location.Country");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_latitude);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLatitude(int addr, double v) {
        if (featOkTst && casFeat_latitude == null)
      jcas.throwFeatMissing("latitude", "cl.uach.kelluwen.nlp.location.Country");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_latitude, v);}
    
  
 
  /** @generated */
  final Feature casFeat_longitude;
  /** @generated */
  final int     casFeatCode_longitude;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getLongitude(int addr) {
        if (featOkTst && casFeat_longitude == null)
      jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.location.Country");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_longitude);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLongitude(int addr, double v) {
        if (featOkTst && casFeat_longitude == null)
      jcas.throwFeatMissing("longitude", "cl.uach.kelluwen.nlp.location.Country");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_longitude, v);}
    
  
 
  /** @generated */
  final Feature casFeat_normalizedName;
  /** @generated */
  final int     casFeatCode_normalizedName;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getNormalizedName(int addr) {
        if (featOkTst && casFeat_normalizedName == null)
      jcas.throwFeatMissing("normalizedName", "cl.uach.kelluwen.nlp.location.Country");
    return ll_cas.ll_getStringValue(addr, casFeatCode_normalizedName);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNormalizedName(int addr, String v) {
        if (featOkTst && casFeat_normalizedName == null)
      jcas.throwFeatMissing("normalizedName", "cl.uach.kelluwen.nlp.location.Country");
    ll_cas.ll_setStringValue(addr, casFeatCode_normalizedName, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public Country_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_latitude = jcas.getRequiredFeatureDE(casType, "latitude", "uima.cas.Double", featOkTst);
    casFeatCode_latitude  = (null == casFeat_latitude) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_latitude).getCode();

 
    casFeat_longitude = jcas.getRequiredFeatureDE(casType, "longitude", "uima.cas.Double", featOkTst);
    casFeatCode_longitude  = (null == casFeat_longitude) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_longitude).getCode();

 
    casFeat_normalizedName = jcas.getRequiredFeatureDE(casType, "normalizedName", "uima.cas.String", featOkTst);
    casFeatCode_normalizedName  = (null == casFeat_normalizedName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_normalizedName).getCode();

  }
}



    