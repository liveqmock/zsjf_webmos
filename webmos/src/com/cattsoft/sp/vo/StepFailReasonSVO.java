package com.cattsoft.sp.vo;
import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;
 /**
   * StepFailReasonSVO
   * @author £º°×Ð¡ÁÁ¡£
   * @version 1.1  2007-9-23
   * <p>Company: ´óÌÆÈí¼þ</p>
  */
public class StepFailReasonSVO extends GenericVO {
/**
	 * 
	 */
	private static final long serialVersionUID = -7311795680965910538L;
private String actionId = null;
private String areaId = null;
private String auditFlag = null;
private String failDoFlag = null;
private String failReasonId = null;
private String localNetId = null;
private String prodId = null;
private String remarks = null;
private String resReleaseFlag = null;
private String stepId = null;
private String stepReasonId = null;
private String sts = null;
private Date stsDate = null;
private int flagActionId = 0;
private int flagAreaId = 0;
private int flagAuditFlag = 0;
private int flagFailDoFlag = 0;
private int flagFailReasonId = 0;
private int flagLocalNetId = 0;
private int flagProdId = 0;
private int flagRemarks = 0;
private int flagResReleaseFlag = 0;
private int flagStepId = 0;
private int flagStepReasonId = 0;
private int flagSts = 0;
private int flagStsDate = 0;
public String getActionId(){
 return actionId;
}
public void setActionId(String newValue){ 
 this.actionId = newValue;
  flagActionId = 1;
}
public int getFlagActionId(){ 
 return flagActionId;
}
public String getAreaId(){
 return areaId;
}
public void setAreaId(String newValue){ 
 this.areaId = newValue;
  flagAreaId = 1;
}
public int getFlagAreaId(){ 
 return flagAreaId;
}
public String getAuditFlag(){
 return auditFlag;
}
public void setAuditFlag(String newValue){ 
 this.auditFlag = newValue;
  flagAuditFlag = 1;
}
public int getFlagAuditFlag(){ 
 return flagAuditFlag;
}
public String getFailDoFlag(){
 return failDoFlag;
}
public void setFailDoFlag(String newValue){ 
 this.failDoFlag = newValue;
  flagFailDoFlag = 1;
}
public int getFlagFailDoFlag(){ 
 return flagFailDoFlag;
}
public String getFailReasonId(){
 return failReasonId;
}
public void setFailReasonId(String newValue){ 
 this.failReasonId = newValue;
  flagFailReasonId = 1;
}
public int getFlagFailReasonId(){ 
 return flagFailReasonId;
}
public String getLocalNetId(){
 return localNetId;
}
public void setLocalNetId(String newValue){ 
 this.localNetId = newValue;
  flagLocalNetId = 1;
}
public int getFlagLocalNetId(){ 
 return flagLocalNetId;
}
public String getProdId(){
 return prodId;
}
public void setProdId(String newValue){ 
 this.prodId = newValue;
  flagProdId = 1;
}
public int getFlagProdId(){ 
 return flagProdId;
}
public String getRemarks(){
 return remarks;
}
public void setRemarks(String newValue){ 
 this.remarks = newValue;
  flagRemarks = 1;
}
public int getFlagRemarks(){ 
 return flagRemarks;
}
public String getResReleaseFlag(){
 return resReleaseFlag;
}
public void setResReleaseFlag(String newValue){ 
 this.resReleaseFlag = newValue;
  flagResReleaseFlag = 1;
}
public int getFlagResReleaseFlag(){ 
 return flagResReleaseFlag;
}
public String getStepId(){
 return stepId;
}
public void setStepId(String newValue){ 
 this.stepId = newValue;
  flagStepId = 1;
}
public int getFlagStepId(){ 
 return flagStepId;
}
public String getStepReasonId(){
 return stepReasonId;
}
public void setStepReasonId(String newValue){ 
 this.stepReasonId = newValue;
  flagStepReasonId = 1;
}
public int getFlagStepReasonId(){ 
 return flagStepReasonId;
}
public String getSts(){
 return sts;
}
public void setSts(String newValue){ 
 this.sts = newValue;
  flagSts = 1;
}
public int getFlagSts(){ 
 return flagSts;
}
public Date getStsDate(){ 
 return stsDate;
}
public void setStsDate(Date newValue){  
 this.stsDate = newValue;
  flagStsDate = 1;
}
public int getFlagStsDate(){ 
 return flagStsDate;
}
public void clearFlagActionId(){
 flagActionId = 0 ;
}
public void clearFlagAreaId(){
 flagAreaId = 0 ;
}
public void clearFlagAuditFlag(){
 flagAuditFlag = 0 ;
}
public void clearFlagFailDoFlag(){
 flagFailDoFlag = 0 ;
}
public void clearFlagFailReasonId(){
 flagFailReasonId = 0 ;
}
public void clearFlagLocalNetId(){
 flagLocalNetId = 0 ;
}
public void clearFlagProdId(){
 flagProdId = 0 ;
}
public void clearFlagRemarks(){
 flagRemarks = 0 ;
}
public void clearFlagResReleaseFlag(){
 flagResReleaseFlag = 0 ;
}
public void clearFlagStepId(){
 flagStepId = 0 ;
}
public void clearFlagStepReasonId(){
 flagStepReasonId = 0 ;
}
public void clearFlagSts(){
 flagSts = 0 ;
}
public void clearFlagStsDate(){
 flagStsDate = 0 ;
}
public void clearAll(){ flagActionId = 0;
 flagAreaId = 0;
 flagAuditFlag = 0;
 flagFailDoFlag = 0;
 flagFailReasonId = 0;
 flagLocalNetId = 0;
 flagProdId = 0;
 flagRemarks = 0;
 flagResReleaseFlag = 0;
 flagStepId = 0;
 flagStepReasonId = 0;
 flagSts = 0;
 flagStsDate = 0;

}
}
