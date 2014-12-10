package com.cattsoft.sp.vo;
 

import com.cattsoft.pub.vo.GenericVO;

import java.util.*; 
 /**
   * SoHandleSVO
   * @author £º°×Ð¡ÁÁ¡£
   * @version 1.0  2007-5-14
   * <p>Company: ´óÌÆÈí¼þ</p>
  */
public class SoHandleSVO extends GenericVO {
/**
	 * 
	 */
	private static final long serialVersionUID = 8649468747194018870L;
private String areaId = null;
private String failReasonId = null;
private Date handleDate = null;
private String handleTypeId = null;
private String info = null;
private String localNetId = null;
private String reasonInfo = null;
private String soHandleId = null;
private String soNbr = null;
private String staffId = null;
private String workAreaId = null;
private int flagAreaId = 0;
private int flagFailReasonId = 0;
private int flagHandleDate = 0;
private int flagHandleTypeId = 0;
private int flagInfo = 0;
private int flagLocalNetId = 0;
private int flagReasonInfo = 0;
private int flagSoHandleId = 0;
private int flagSoNbr = 0;
private int flagStaffId = 0;
private int flagWorkAreaId = 0;
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
public Date getHandleDate(){ 
 return handleDate;
}
public void setHandleDate(Date newValue){  
 this.handleDate = newValue;
  flagHandleDate = 1;
}
public int getFlagHandleDate(){ 
 return flagHandleDate;
}
public String getHandleTypeId(){
 return handleTypeId;
}
public void setHandleTypeId(String newValue){ 
 this.handleTypeId = newValue;
  flagHandleTypeId = 1;
}
public int getFlagHandleTypeId(){ 
 return flagHandleTypeId;
}
public String getInfo(){
 return info;
}
public void setInfo(String newValue){ 
 this.info = newValue;
  flagInfo = 1;
}
public int getFlagInfo(){ 
 return flagInfo;
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
public String getReasonInfo(){
 return reasonInfo;
}
public void setReasonInfo(String newValue){ 
 this.reasonInfo = newValue;
  flagReasonInfo = 1;
}
public int getFlagReasonInfo(){ 
 return flagReasonInfo;
}
public String getSoHandleId(){
 return soHandleId;
}
public void setSoHandleId(String newValue){ 
 this.soHandleId = newValue;
  flagSoHandleId = 1;
}
public int getFlagSoHandleId(){ 
 return flagSoHandleId;
}
public String getSoNbr(){
 return soNbr;
}
public void setSoNbr(String newValue){ 
 this.soNbr = newValue;
  flagSoNbr = 1;
}
public int getFlagSoNbr(){ 
 return flagSoNbr;
}
public String getStaffId(){
 return staffId;
}
public void setStaffId(String newValue){ 
 this.staffId = newValue;
  flagStaffId = 1;
}
public int getFlagStaffId(){ 
 return flagStaffId;
}
public String getWorkAreaId(){
 return workAreaId;
}
public void setWorkAreaId(String newValue){ 
 this.workAreaId = newValue;
  flagWorkAreaId = 1;
}
public int getFlagWorkAreaId(){ 
 return flagWorkAreaId;
}
public void clearFlagAreaId(){
 flagAreaId = 0 ;
}
public void clearFlagFailReasonId(){
 flagFailReasonId = 0 ;
}
public void clearFlagHandleDate(){
 flagHandleDate = 0 ;
}
public void clearFlagHandleTypeId(){
 flagHandleTypeId = 0 ;
}
public void clearFlagInfo(){
 flagInfo = 0 ;
}
public void clearFlagLocalNetId(){
 flagLocalNetId = 0 ;
}
public void clearFlagReasonInfo(){
 flagReasonInfo = 0 ;
}
public void clearFlagSoHandleId(){
 flagSoHandleId = 0 ;
}
public void clearFlagSoNbr(){
 flagSoNbr = 0 ;
}
public void clearFlagStaffId(){
 flagStaffId = 0 ;
}
public void clearFlagWorkAreaId(){
 flagWorkAreaId = 0 ;
}
public void clearAll(){ flagAreaId = 0;
 flagFailReasonId = 0;
 flagHandleDate = 0;
 flagHandleTypeId = 0;
 flagInfo = 0;
 flagLocalNetId = 0;
 flagReasonInfo = 0;
 flagSoHandleId = 0;
 flagSoNbr = 0;
 flagStaffId = 0;
 flagWorkAreaId = 0;

}
}
