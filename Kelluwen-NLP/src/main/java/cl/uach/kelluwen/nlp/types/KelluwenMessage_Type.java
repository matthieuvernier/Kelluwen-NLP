
/* First created by JCasGen Fri Nov 13 12:43:35 CLT 2015 */
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

/** a message in the kelluwen platform
 * Updated by JCasGen Wed Nov 18 11:35:47 CLT 2015
 * @generated */
public class KelluwenMessage_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (KelluwenMessage_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = KelluwenMessage_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new KelluwenMessage(addr, KelluwenMessage_Type.this);
  			   KelluwenMessage_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new KelluwenMessage(addr, KelluwenMessage_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = KelluwenMessage.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("cl.uach.kelluwen.nlp.types.KelluwenMessage");
 
  /** @generated */
  final Feature casFeat_messageType;
  /** @generated */
  final int     casFeatCode_messageType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getMessageType(int addr) {
        if (featOkTst && casFeat_messageType == null)
      jcas.throwFeatMissing("messageType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_messageType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setMessageType(int addr, int v) {
        if (featOkTst && casFeat_messageType == null)
      jcas.throwFeatMissing("messageType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_messageType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_idMessage;
  /** @generated */
  final int     casFeatCode_idMessage;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIdMessage(int addr) {
        if (featOkTst && casFeat_idMessage == null)
      jcas.throwFeatMissing("idMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_idMessage);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIdMessage(int addr, int v) {
        if (featOkTst && casFeat_idMessage == null)
      jcas.throwFeatMissing("idMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_idMessage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_idSuperMessage;
  /** @generated */
  final int     casFeatCode_idSuperMessage;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIdSuperMessage(int addr) {
        if (featOkTst && casFeat_idSuperMessage == null)
      jcas.throwFeatMissing("idSuperMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_idSuperMessage);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIdSuperMessage(int addr, int v) {
        if (featOkTst && casFeat_idSuperMessage == null)
      jcas.throwFeatMissing("idSuperMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_idSuperMessage, v);}
    
  
 
  /** @generated */
  final Feature casFeat_idUser;
  /** @generated */
  final int     casFeatCode_idUser;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIdUser(int addr) {
        if (featOkTst && casFeat_idUser == null)
      jcas.throwFeatMissing("idUser", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_idUser);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIdUser(int addr, int v) {
        if (featOkTst && casFeat_idUser == null)
      jcas.throwFeatMissing("idUser", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_idUser, v);}
    
  
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
  /** @generated */
  final Feature casFeat_userType;
  /** @generated */
  final int     casFeatCode_userType;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getUserType(int addr) {
        if (featOkTst && casFeat_userType == null)
      jcas.throwFeatMissing("userType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_userType);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setUserType(int addr, int v) {
        if (featOkTst && casFeat_userType == null)
      jcas.throwFeatMissing("userType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_userType, v);}
    
  
 
  /** @generated */
  final Feature casFeat_idExercicePattern;
  /** @generated */
  final int     casFeatCode_idExercicePattern;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIdExercicePattern(int addr) {
        if (featOkTst && casFeat_idExercicePattern == null)
      jcas.throwFeatMissing("idExercicePattern", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_idExercicePattern);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIdExercicePattern(int addr, int v) {
        if (featOkTst && casFeat_idExercicePattern == null)
      jcas.throwFeatMissing("idExercicePattern", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_idExercicePattern, v);}
    
  
 
  /** @generated */
  final Feature casFeat_idExperience;
  /** @generated */
  final int     casFeatCode_idExperience;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getIdExperience(int addr) {
        if (featOkTst && casFeat_idExperience == null)
      jcas.throwFeatMissing("idExperience", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_idExperience);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setIdExperience(int addr, int v) {
        if (featOkTst && casFeat_idExperience == null)
      jcas.throwFeatMissing("idExperience", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_idExperience, v);}
    
  
 
  /** @generated */
  final Feature casFeat_year;
  /** @generated */
  final int     casFeatCode_year;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getYear(int addr) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_year);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setYear(int addr, int v) {
        if (featOkTst && casFeat_year == null)
      jcas.throwFeatMissing("year", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_year, v);}
    
  
 
  /** @generated */
  final Feature casFeat_semester;
  /** @generated */
  final int     casFeatCode_semester;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getSemester(int addr) {
        if (featOkTst && casFeat_semester == null)
      jcas.throwFeatMissing("semester", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getStringValue(addr, casFeatCode_semester);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSemester(int addr, String v) {
        if (featOkTst && casFeat_semester == null)
      jcas.throwFeatMissing("semester", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setStringValue(addr, casFeatCode_semester, v);}
    
  
 
  /** @generated */
  final Feature casFeat_numberOfStudents;
  /** @generated */
  final int     casFeatCode_numberOfStudents;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getNumberOfStudents(int addr) {
        if (featOkTst && casFeat_numberOfStudents == null)
      jcas.throwFeatMissing("numberOfStudents", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getIntValue(addr, casFeatCode_numberOfStudents);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setNumberOfStudents(int addr, int v) {
        if (featOkTst && casFeat_numberOfStudents == null)
      jcas.throwFeatMissing("numberOfStudents", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setIntValue(addr, casFeatCode_numberOfStudents, v);}
    
  
 
  /** @generated */
  final Feature casFeat_filtered;
  /** @generated */
  final int     casFeatCode_filtered;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public boolean getFiltered(int addr) {
        if (featOkTst && casFeat_filtered == null)
      jcas.throwFeatMissing("filtered", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_filtered);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFiltered(int addr, boolean v) {
        if (featOkTst && casFeat_filtered == null)
      jcas.throwFeatMissing("filtered", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_filtered, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public KelluwenMessage_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_messageType = jcas.getRequiredFeatureDE(casType, "messageType", "uima.cas.Integer", featOkTst);
    casFeatCode_messageType  = (null == casFeat_messageType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_messageType).getCode();

 
    casFeat_idMessage = jcas.getRequiredFeatureDE(casType, "idMessage", "uima.cas.Integer", featOkTst);
    casFeatCode_idMessage  = (null == casFeat_idMessage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_idMessage).getCode();

 
    casFeat_idSuperMessage = jcas.getRequiredFeatureDE(casType, "idSuperMessage", "uima.cas.Integer", featOkTst);
    casFeatCode_idSuperMessage  = (null == casFeat_idSuperMessage) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_idSuperMessage).getCode();

 
    casFeat_idUser = jcas.getRequiredFeatureDE(casType, "idUser", "uima.cas.Integer", featOkTst);
    casFeatCode_idUser  = (null == casFeat_idUser) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_idUser).getCode();

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_userType = jcas.getRequiredFeatureDE(casType, "userType", "uima.cas.Integer", featOkTst);
    casFeatCode_userType  = (null == casFeat_userType) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_userType).getCode();

 
    casFeat_idExercicePattern = jcas.getRequiredFeatureDE(casType, "idExercicePattern", "uima.cas.Integer", featOkTst);
    casFeatCode_idExercicePattern  = (null == casFeat_idExercicePattern) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_idExercicePattern).getCode();

 
    casFeat_idExperience = jcas.getRequiredFeatureDE(casType, "idExperience", "uima.cas.Integer", featOkTst);
    casFeatCode_idExperience  = (null == casFeat_idExperience) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_idExperience).getCode();

 
    casFeat_year = jcas.getRequiredFeatureDE(casType, "year", "uima.cas.Integer", featOkTst);
    casFeatCode_year  = (null == casFeat_year) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_year).getCode();

 
    casFeat_semester = jcas.getRequiredFeatureDE(casType, "semester", "uima.cas.String", featOkTst);
    casFeatCode_semester  = (null == casFeat_semester) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_semester).getCode();

 
    casFeat_numberOfStudents = jcas.getRequiredFeatureDE(casType, "numberOfStudents", "uima.cas.Integer", featOkTst);
    casFeatCode_numberOfStudents  = (null == casFeat_numberOfStudents) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_numberOfStudents).getCode();

 
    casFeat_filtered = jcas.getRequiredFeatureDE(casType, "filtered", "uima.cas.Boolean", featOkTst);
    casFeatCode_filtered  = (null == casFeat_filtered) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_filtered).getCode();

  }
}



    