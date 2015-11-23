

/* First created by JCasGen Fri Nov 13 12:43:35 CLT 2015 */
package cl.uach.kelluwen.nlp.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** a message in the kelluwen platform
 * Updated by JCasGen Wed Nov 18 11:35:47 CLT 2015
 * XML source: /home/mvernier/git/Kelluwen-NLP/Kelluwen-NLP/src/main/resources/cl/uach/kelluwen/nlp/types/TypeSystem-Kelluwen-Database.xml
 * @generated */
public class KelluwenMessage extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(KelluwenMessage.class);
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
  protected KelluwenMessage() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public KelluwenMessage(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public KelluwenMessage(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public KelluwenMessage(JCas jcas, int begin, int end) {
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
  //* Feature: messageType

  /** getter for messageType - gets new message=0
reply=1
   * @generated
   * @return value of the feature 
   */
  public int getMessageType() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_messageType == null)
      jcasType.jcas.throwFeatMissing("messageType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_messageType);}
    
  /** setter for messageType - sets new message=0
reply=1 
   * @generated
   * @param v value to set into the feature 
   */
  public void setMessageType(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_messageType == null)
      jcasType.jcas.throwFeatMissing("messageType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_messageType, v);}    
   
    
  //*--------------*
  //* Feature: idMessage

  /** getter for idMessage - gets id of this message in the kelluwen platform
   * @generated
   * @return value of the feature 
   */
  public int getIdMessage() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idMessage == null)
      jcasType.jcas.throwFeatMissing("idMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idMessage);}
    
  /** setter for idMessage - sets id of this message in the kelluwen platform 
   * @generated
   * @param v value to set into the feature 
   */
  public void setIdMessage(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idMessage == null)
      jcasType.jcas.throwFeatMissing("idMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idMessage, v);}    
   
    
  //*--------------*
  //* Feature: idSuperMessage

  /** getter for idSuperMessage - gets Id of the "super" message in the hierarchy if the current message is a reply.
If the current message is a new message, value = -1.
   * @generated
   * @return value of the feature 
   */
  public int getIdSuperMessage() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idSuperMessage == null)
      jcasType.jcas.throwFeatMissing("idSuperMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idSuperMessage);}
    
  /** setter for idSuperMessage - sets Id of the "super" message in the hierarchy if the current message is a reply.
If the current message is a new message, value = -1. 
   * @generated
   * @param v value to set into the feature 
   */
  public void setIdSuperMessage(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idSuperMessage == null)
      jcasType.jcas.throwFeatMissing("idSuperMessage", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idSuperMessage, v);}    
   
    
  //*--------------*
  //* Feature: idUser

  /** getter for idUser - gets id of the message author
   * @generated
   * @return value of the feature 
   */
  public int getIdUser() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idUser == null)
      jcasType.jcas.throwFeatMissing("idUser", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idUser);}
    
  /** setter for idUser - sets id of the message author 
   * @generated
   * @param v value to set into the feature 
   */
  public void setIdUser(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idUser == null)
      jcasType.jcas.throwFeatMissing("idUser", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idUser, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets name of the author
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets name of the author 
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setStringValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: userType

  /** getter for userType - gets prof=1
alumno=2
associate=3
   * @generated
   * @return value of the feature 
   */
  public int getUserType() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_userType == null)
      jcasType.jcas.throwFeatMissing("userType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_userType);}
    
  /** setter for userType - sets prof=1
alumno=2
associate=3 
   * @generated
   * @param v value to set into the feature 
   */
  public void setUserType(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_userType == null)
      jcasType.jcas.throwFeatMissing("userType", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_userType, v);}    
   
    
  //*--------------*
  //* Feature: idExercicePattern

  /** getter for idExercicePattern - gets if of the exercice concerned by this message
   * @generated
   * @return value of the feature 
   */
  public int getIdExercicePattern() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idExercicePattern == null)
      jcasType.jcas.throwFeatMissing("idExercicePattern", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idExercicePattern);}
    
  /** setter for idExercicePattern - sets if of the exercice concerned by this message 
   * @generated
   * @param v value to set into the feature 
   */
  public void setIdExercicePattern(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idExercicePattern == null)
      jcasType.jcas.throwFeatMissing("idExercicePattern", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idExercicePattern, v);}    
   
    
  //*--------------*
  //* Feature: idExperience

  /** getter for idExperience - gets id of the real experience related to this message
   * @generated
   * @return value of the feature 
   */
  public int getIdExperience() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idExperience == null)
      jcasType.jcas.throwFeatMissing("idExperience", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idExperience);}
    
  /** setter for idExperience - sets id of the real experience related to this message 
   * @generated
   * @param v value to set into the feature 
   */
  public void setIdExperience(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_idExperience == null)
      jcasType.jcas.throwFeatMissing("idExperience", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_idExperience, v);}    
   
    
  //*--------------*
  //* Feature: year

  /** getter for year - gets date (year) of this message
   * @generated
   * @return value of the feature 
   */
  public int getYear() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_year == null)
      jcasType.jcas.throwFeatMissing("year", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_year);}
    
  /** setter for year - sets date (year) of this message 
   * @generated
   * @param v value to set into the feature 
   */
  public void setYear(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_year == null)
      jcasType.jcas.throwFeatMissing("year", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_year, v);}    
   
    
  //*--------------*
  //* Feature: semester

  /** getter for semester - gets 1° semestre or 2 ° semestre
   * @generated
   * @return value of the feature 
   */
  public String getSemester() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_semester == null)
      jcasType.jcas.throwFeatMissing("semester", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getStringValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_semester);}
    
  /** setter for semester - sets 1° semestre or 2 ° semestre 
   * @generated
   * @param v value to set into the feature 
   */
  public void setSemester(String v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_semester == null)
      jcasType.jcas.throwFeatMissing("semester", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setStringValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_semester, v);}    
   
    
  //*--------------*
  //* Feature: numberOfStudents

  /** getter for numberOfStudents - gets numberOfStudents concerned by this experience
   * @generated
   * @return value of the feature 
   */
  public int getNumberOfStudents() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_numberOfStudents == null)
      jcasType.jcas.throwFeatMissing("numberOfStudents", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_numberOfStudents);}
    
  /** setter for numberOfStudents - sets numberOfStudents concerned by this experience 
   * @generated
   * @param v value to set into the feature 
   */
  public void setNumberOfStudents(int v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_numberOfStudents == null)
      jcasType.jcas.throwFeatMissing("numberOfStudents", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setIntValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_numberOfStudents, v);}    
   
    
  //*--------------*
  //* Feature: filtered

  /** getter for filtered - gets 
   * @generated
   * @return value of the feature 
   */
  public boolean getFiltered() {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_filtered == null)
      jcasType.jcas.throwFeatMissing("filtered", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_filtered);}
    
  /** setter for filtered - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFiltered(boolean v) {
    if (KelluwenMessage_Type.featOkTst && ((KelluwenMessage_Type)jcasType).casFeat_filtered == null)
      jcasType.jcas.throwFeatMissing("filtered", "cl.uach.kelluwen.nlp.types.KelluwenMessage");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((KelluwenMessage_Type)jcasType).casFeatCode_filtered, v);}    
  }

    