package com.cattsoft.sp.vo;
import java.io.*;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;
 /**
   * SoSVO
   * @author ：白小亮。
   * @version 1.1  2007-9-23
   * <p>Company: 大唐软件</p>
  */
public class SoSVO extends GenericVO {
/**
	 * 
	 */
	private static final long serialVersionUID = 628839962333871801L;
private String acctNbr = null;
private Date alarmDate = null;
private Date applDate = null;
private String arcDealCount = null;
private String arcMsg = null;
private String areaId = null;
private String billType = null;
private String bookFlag = null;
private String businessId = null;
private String chgServSpecId = null;
private String collabSts = null;
private Date complDate = null;
private String contactInfo = null;
private String contactName = null;
private String contactResult = null;
private String coNbr = null;
private Date createDate = null;
private String csoNbr = null;
private String cutoverId = null;
private String dealFlag = null;
private String devContactInfo = null;
private String devDeptId = null;
private String devPartyName = null;
private String devPartyRoleId = null;
private String devPartyRoleTypeId = null;
private String extSoNbr = null;
private String extWoNbr = null;
private String failReasonId = null;
private String fromProdId = null;
private String fromServInstId = null;
private String groupFlag = null;
private String hastenFlag = null;
private String localNetId = null;
private String msPlanName = null;
private String msPlanTargetId = null;
private String msTaskId = null;
private String msTaskName = null;
private String msTaskPrjId = null;
private String msTaskPrjName = null;
private String noFlag = null;
private String nSoNbr = null;
private String oldSoNbr = null;
private String oriSoNbr = null;
private String overtimeId = null;
private String partyRoleId = null;
private String partyRoleTypeId = null;
private String payManName = null;
private String payManTeleNbr = null;
private String paySts = null;
private Date preAlarmDate = null;
private String priority = null;
private String processId = null;
private String procInstId = null;
private String prodId = null;
private String realTimeFlag = null;
private String reasonId = null;
private String reasonInfo = null;
private String relaExtWoNbr = null;
private String relaSoNbr = null;
private String remarks = null;
private Date reqCompDate = null;
private String resSystem = null;
private String servDeptId = null;
private String servInstId = null;
private String soBatchId = null;
private String soCat = null;
private Date soLockDate = null;
private String soLockSts = null;
private String soMeth = null;
private String soNbr = null;
private String soSeq = null;
private String soStaffId = null;
private String soStaffName = null;
private String soSts = null;
private Date soStsDate = null;
private String soTemplateId = null;
private String soType = null;
private String soWorkAreaId = null;
private String soWorkAreaName = null;
private String specialFlag = null;
private String sts = null;
private Date stsDate = null;
private String tempFlag = null;
private String tradeId = null;
private String tradeName = null;
private int flagAcctNbr = 0;
private int flagAlarmDate = 0;
private int flagApplDate = 0;
private int flagArcDealCount = 0;
private int flagArcMsg = 0;
private int flagAreaId = 0;
private int flagBillType = 0;
private int flagBookFlag = 0;
private int flagBusinessId = 0;
private int flagChgServSpecId = 0;
private int flagCollabSts = 0;
private int flagComplDate = 0;
private int flagContactInfo = 0;
private int flagContactName = 0;
private int flagContactResult = 0;
private int flagCoNbr = 0;
private int flagCreateDate = 0;
private int flagCsoNbr = 0;
private int flagCutoverId = 0;
private int flagDealFlag = 0;
private int flagDevContactInfo = 0;
private int flagDevDeptId = 0;
private int flagDevPartyName = 0;
private int flagDevPartyRoleId = 0;
private int flagDevPartyRoleTypeId = 0;
private int flagExtSoNbr = 0;
private int flagExtWoNbr = 0;
private int flagFailReasonId = 0;
private int flagFromProdId = 0;
private int flagFromServInstId = 0;
private int flagGroupFlag = 0;
private int flagHastenFlag = 0;
private int flagLocalNetId = 0;
private int flagMsPlanName = 0;
private int flagMsPlanTargetId = 0;
private int flagMsTaskId = 0;
private int flagMsTaskName = 0;
private int flagMsTaskPrjId = 0;
private int flagMsTaskPrjName = 0;
private int flagNoFlag = 0;
private int flagNSoNbr = 0;
private int flagOldSoNbr = 0;
private int flagOriSoNbr = 0;
private int flagOvertimeId = 0;
private int flagPartyRoleId = 0;
private int flagPartyRoleTypeId = 0;
private int flagPayManName = 0;
private int flagPayManTeleNbr = 0;
private int flagPaySts = 0;
private int flagPreAlarmDate = 0;
private int flagPriority = 0;
private int flagProcessId = 0;
private int flagProcInstId = 0;
private int flagProdId = 0;
private int flagRealTimeFlag = 0;
private int flagReasonId = 0;
private int flagReasonInfo = 0;
private int flagRelaExtWoNbr = 0;
private int flagRelaSoNbr = 0;
private int flagRemarks = 0;
private int flagReqCompDate = 0;
private int flagResSystem = 0;
private int flagServDeptId = 0;
private int flagServInstId = 0;
private int flagSoBatchId = 0;
private int flagSoCat = 0;
private int flagSoLockDate = 0;
private int flagSoLockSts = 0;
private int flagSoMeth = 0;
private int flagSoNbr = 0;
private int flagSoSeq = 0;
private int flagSoStaffId = 0;
private int flagSoStaffName = 0;
private int flagSoSts = 0;
private int flagSoStsDate = 0;
private int flagSoTemplateId = 0;
private int flagSoType = 0;
private int flagSoWorkAreaId = 0;
private int flagSoWorkAreaName = 0;
private int flagSpecialFlag = 0;
private int flagSts = 0;
private int flagStsDate = 0;
private int flagTempFlag = 0;
private int flagTradeId = 0;
private int flagTradeName = 0;

private String chbApplDate = "1"; // 申请日期标识

private Date fromApplDate; // 起始申请日期

private Date toApplDate; // 终止申请日期

public String getChbApplDate() {
	return chbApplDate;
}

public void setChbApplDate(String chbApplDate) {
	this.chbApplDate = chbApplDate;
}

public void setFromApplDate(String fromApplDate) throws AppException, SysException {
	try {
	    this.fromApplDate = DateUtil.str2DateTime(fromApplDate);
	} catch (AppException e) {
		throw new AppException("520002", "日期转换异常："+e.getMessage());	
	} catch (SysException e) {
		throw new SysException("1000001","日期转换异常："+e.getMessage(),e); 
	}
    }

    public void setFromApplDate(Date fromApplDate) {
	this.fromApplDate = fromApplDate;
    }

    /**
     * @return the fromApplDate
     */
    public String getFromApplDate() {
	return DateUtil.dateTime2Str(this.fromApplDate);
    }

    public Date getFromApplDated() {
	return this.fromApplDate;
    }
    
    public void setToApplDate(String toApplDate) {
    	try {
    	    this.toApplDate = DateUtil.str2DateTime(toApplDate);
    	} catch (AppException e) {
    	    e.printStackTrace();
    	} catch (SysException e) {
    	    e.printStackTrace();
    	}
        }

        public void setToApplDate(Date toApplDate) {
    	this.toApplDate = toApplDate;
        }

        public String getToApplDate() {
    	return DateUtil.dateTime2Str(this.toApplDate);
        }

        public Date getToApplDated() {
    	return this.toApplDate;
        }
    
    
    
public String getAcctNbr(){
 return acctNbr;
}
public void setAcctNbr(String newValue){ 
 this.acctNbr = newValue;
  flagAcctNbr = 1;
}
public int getFlagAcctNbr(){ 
 return flagAcctNbr;
}
public Date getAlarmDate(){ 
 return alarmDate;
}
public void setAlarmDate(Date newValue){  
 this.alarmDate = newValue;
  flagAlarmDate = 1;
}
public int getFlagAlarmDate(){ 
 return flagAlarmDate;
}
public Date getApplDate(){ 
 return applDate;
}
public void setApplDate(Date newValue){  
 this.applDate = newValue;
  flagApplDate = 1;
}
public int getFlagApplDate(){ 
 return flagApplDate;
}
public String getArcDealCount(){
 return arcDealCount;
}
public void setArcDealCount(String newValue){ 
 this.arcDealCount = newValue;
  flagArcDealCount = 1;
}
public int getFlagArcDealCount(){ 
 return flagArcDealCount;
}
public String getArcMsg(){
 return arcMsg;
}
public void setArcMsg(String newValue){ 
 this.arcMsg = newValue;
  flagArcMsg = 1;
}
public int getFlagArcMsg(){ 
 return flagArcMsg;
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
public String getBillType(){
 return billType;
}
public void setBillType(String newValue){ 
 this.billType = newValue;
  flagBillType = 1;
}
public int getFlagBillType(){ 
 return flagBillType;
}
public String getBookFlag(){
 return bookFlag;
}
public void setBookFlag(String newValue){ 
 this.bookFlag = newValue;
  flagBookFlag = 1;
}
public int getFlagBookFlag(){ 
 return flagBookFlag;
}
public String getBusinessId(){
 return businessId;
}
public void setBusinessId(String newValue){ 
 this.businessId = newValue;
  flagBusinessId = 1;
}
public int getFlagBusinessId(){ 
 return flagBusinessId;
}
public String getChgServSpecId(){
 return chgServSpecId;
}
public void setChgServSpecId(String newValue){ 
 this.chgServSpecId = newValue;
  flagChgServSpecId = 1;
}
public int getFlagChgServSpecId(){ 
 return flagChgServSpecId;
}
public String getCollabSts(){
 return collabSts;
}
public void setCollabSts(String newValue){ 
 this.collabSts = newValue;
  flagCollabSts = 1;
}
public int getFlagCollabSts(){ 
 return flagCollabSts;
}
public Date getComplDate(){ 
 return complDate;
}
public void setComplDate(Date newValue){  
 this.complDate = newValue;
  flagComplDate = 1;
}
public int getFlagComplDate(){ 
 return flagComplDate;
}
public String getContactInfo(){
 return contactInfo;
}
public void setContactInfo(String newValue){ 
 this.contactInfo = newValue;
  flagContactInfo = 1;
}
public int getFlagContactInfo(){ 
 return flagContactInfo;
}
public String getContactName(){
 return contactName;
}
public void setContactName(String newValue){ 
 this.contactName = newValue;
  flagContactName = 1;
}
public int getFlagContactName(){ 
 return flagContactName;
}
public String getContactResult(){
 return contactResult;
}
public void setContactResult(String newValue){ 
 this.contactResult = newValue;
  flagContactResult = 1;
}
public int getFlagContactResult(){ 
 return flagContactResult;
}
public String getCoNbr(){
 return coNbr;
}
public void setCoNbr(String newValue){ 
 this.coNbr = newValue;
  flagCoNbr = 1;
}
public int getFlagCoNbr(){ 
 return flagCoNbr;
}
public Date getCreateDate(){ 
 return createDate;
}
public void setCreateDate(Date newValue){  
 this.createDate = newValue;
  flagCreateDate = 1;
}
public int getFlagCreateDate(){ 
 return flagCreateDate;
}
public String getCsoNbr(){
 return csoNbr;
}
public void setCsoNbr(String newValue){ 
 this.csoNbr = newValue;
  flagCsoNbr = 1;
}
public int getFlagCsoNbr(){ 
 return flagCsoNbr;
}
public String getCutoverId(){
 return cutoverId;
}
public void setCutoverId(String newValue){ 
 this.cutoverId = newValue;
  flagCutoverId = 1;
}
public int getFlagCutoverId(){ 
 return flagCutoverId;
}
public String getDealFlag(){
 return dealFlag;
}
public void setDealFlag(String newValue){ 
 this.dealFlag = newValue;
  flagDealFlag = 1;
}
public int getFlagDealFlag(){ 
 return flagDealFlag;
}
public String getDevContactInfo(){
 return devContactInfo;
}
public void setDevContactInfo(String newValue){ 
 this.devContactInfo = newValue;
  flagDevContactInfo = 1;
}
public int getFlagDevContactInfo(){ 
 return flagDevContactInfo;
}
public String getDevDeptId(){
 return devDeptId;
}
public void setDevDeptId(String newValue){ 
 this.devDeptId = newValue;
  flagDevDeptId = 1;
}
public int getFlagDevDeptId(){ 
 return flagDevDeptId;
}
public String getDevPartyName(){
 return devPartyName;
}
public void setDevPartyName(String newValue){ 
 this.devPartyName = newValue;
  flagDevPartyName = 1;
}
public int getFlagDevPartyName(){ 
 return flagDevPartyName;
}
public String getDevPartyRoleId(){
 return devPartyRoleId;
}
public void setDevPartyRoleId(String newValue){ 
 this.devPartyRoleId = newValue;
  flagDevPartyRoleId = 1;
}
public int getFlagDevPartyRoleId(){ 
 return flagDevPartyRoleId;
}
public String getDevPartyRoleTypeId(){
 return devPartyRoleTypeId;
}
public void setDevPartyRoleTypeId(String newValue){ 
 this.devPartyRoleTypeId = newValue;
  flagDevPartyRoleTypeId = 1;
}
public int getFlagDevPartyRoleTypeId(){ 
 return flagDevPartyRoleTypeId;
}
public String getExtSoNbr(){
 return extSoNbr;
}
public void setExtSoNbr(String newValue){ 
 this.extSoNbr = newValue;
  flagExtSoNbr = 1;
}
public int getFlagExtSoNbr(){ 
 return flagExtSoNbr;
}
public String getExtWoNbr(){
 return extWoNbr;
}
public void setExtWoNbr(String newValue){ 
 this.extWoNbr = newValue;
  flagExtWoNbr = 1;
}
public int getFlagExtWoNbr(){ 
 return flagExtWoNbr;
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
public String getFromProdId(){
 return fromProdId;
}
public void setFromProdId(String newValue){ 
 this.fromProdId = newValue;
  flagFromProdId = 1;
}
public int getFlagFromProdId(){ 
 return flagFromProdId;
}
public String getFromServInstId(){
 return fromServInstId;
}
public void setFromServInstId(String newValue){ 
 this.fromServInstId = newValue;
  flagFromServInstId = 1;
}
public int getFlagFromServInstId(){ 
 return flagFromServInstId;
}
public String getGroupFlag(){
 return groupFlag;
}
public void setGroupFlag(String newValue){ 
 this.groupFlag = newValue;
  flagGroupFlag = 1;
}
public int getFlagGroupFlag(){ 
 return flagGroupFlag;
}
public String getHastenFlag(){
 return hastenFlag;
}
public void setHastenFlag(String newValue){ 
 this.hastenFlag = newValue;
  flagHastenFlag = 1;
}
public int getFlagHastenFlag(){ 
 return flagHastenFlag;
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
public String getMsPlanName(){
 return msPlanName;
}
public void setMsPlanName(String newValue){ 
 this.msPlanName = newValue;
  flagMsPlanName = 1;
}
public int getFlagMsPlanName(){ 
 return flagMsPlanName;
}
public String getMsPlanTargetId(){
 return msPlanTargetId;
}
public void setMsPlanTargetId(String newValue){ 
 this.msPlanTargetId = newValue;
  flagMsPlanTargetId = 1;
}
public int getFlagMsPlanTargetId(){ 
 return flagMsPlanTargetId;
}
public String getMsTaskId(){
 return msTaskId;
}
public void setMsTaskId(String newValue){ 
 this.msTaskId = newValue;
  flagMsTaskId = 1;
}
public int getFlagMsTaskId(){ 
 return flagMsTaskId;
}
public String getMsTaskName(){
 return msTaskName;
}
public void setMsTaskName(String newValue){ 
 this.msTaskName = newValue;
  flagMsTaskName = 1;
}
public int getFlagMsTaskName(){ 
 return flagMsTaskName;
}
public String getMsTaskPrjId(){
 return msTaskPrjId;
}
public void setMsTaskPrjId(String newValue){ 
 this.msTaskPrjId = newValue;
  flagMsTaskPrjId = 1;
}
public int getFlagMsTaskPrjId(){ 
 return flagMsTaskPrjId;
}
public String getMsTaskPrjName(){
 return msTaskPrjName;
}
public void setMsTaskPrjName(String newValue){ 
 this.msTaskPrjName = newValue;
  flagMsTaskPrjName = 1;
}
public int getFlagMsTaskPrjName(){ 
 return flagMsTaskPrjName;
}
public String getNoFlag(){
 return noFlag;
}
public void setNoFlag(String newValue){ 
 this.noFlag = newValue;
  flagNoFlag = 1;
}
public int getFlagNoFlag(){ 
 return flagNoFlag;
}
public String getNSoNbr(){
 return nSoNbr;
}
public void setNSoNbr(String newValue){ 
 this.nSoNbr = newValue;
  flagNSoNbr = 1;
}
public int getFlagNSoNbr(){ 
 return flagNSoNbr;
}
public String getOldSoNbr(){
 return oldSoNbr;
}
public void setOldSoNbr(String newValue){ 
 this.oldSoNbr = newValue;
  flagOldSoNbr = 1;
}
public int getFlagOldSoNbr(){ 
 return flagOldSoNbr;
}
public String getOriSoNbr(){
 return oriSoNbr;
}
public void setOriSoNbr(String newValue){ 
 this.oriSoNbr = newValue;
  flagOriSoNbr = 1;
}
public int getFlagOriSoNbr(){ 
 return flagOriSoNbr;
}
public String getOvertimeId(){
 return overtimeId;
}
public void setOvertimeId(String newValue){ 
 this.overtimeId = newValue;
  flagOvertimeId = 1;
}
public int getFlagOvertimeId(){ 
 return flagOvertimeId;
}
public String getPartyRoleId(){
 return partyRoleId;
}
public void setPartyRoleId(String newValue){ 
 this.partyRoleId = newValue;
  flagPartyRoleId = 1;
}
public int getFlagPartyRoleId(){ 
 return flagPartyRoleId;
}
public String getPartyRoleTypeId(){
 return partyRoleTypeId;
}
public void setPartyRoleTypeId(String newValue){ 
 this.partyRoleTypeId = newValue;
  flagPartyRoleTypeId = 1;
}
public int getFlagPartyRoleTypeId(){ 
 return flagPartyRoleTypeId;
}
public String getPayManName(){
 return payManName;
}
public void setPayManName(String newValue){ 
 this.payManName = newValue;
  flagPayManName = 1;
}
public int getFlagPayManName(){ 
 return flagPayManName;
}
public String getPayManTeleNbr(){
 return payManTeleNbr;
}
public void setPayManTeleNbr(String newValue){ 
 this.payManTeleNbr = newValue;
  flagPayManTeleNbr = 1;
}
public int getFlagPayManTeleNbr(){ 
 return flagPayManTeleNbr;
}
public String getPaySts(){
 return paySts;
}
public void setPaySts(String newValue){ 
 this.paySts = newValue;
  flagPaySts = 1;
}
public int getFlagPaySts(){ 
 return flagPaySts;
}
public Date getPreAlarmDate(){ 
 return preAlarmDate;
}
public void setPreAlarmDate(Date newValue){  
 this.preAlarmDate = newValue;
  flagPreAlarmDate = 1;
}
public int getFlagPreAlarmDate(){ 
 return flagPreAlarmDate;
}
public String getPriority(){
 return priority;
}
public void setPriority(String newValue){ 
 this.priority = newValue;
  flagPriority = 1;
}
public int getFlagPriority(){ 
 return flagPriority;
}
public String getProcessId(){
 return processId;
}
public void setProcessId(String newValue){ 
 this.processId = newValue;
  flagProcessId = 1;
}
public int getFlagProcessId(){ 
 return flagProcessId;
}
public String getProcInstId(){
 return procInstId;
}
public void setProcInstId(String newValue){ 
 this.procInstId = newValue;
  flagProcInstId = 1;
}
public int getFlagProcInstId(){ 
 return flagProcInstId;
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
public String getRealTimeFlag(){
 return realTimeFlag;
}
public void setRealTimeFlag(String newValue){ 
 this.realTimeFlag = newValue;
  flagRealTimeFlag = 1;
}
public int getFlagRealTimeFlag(){ 
 return flagRealTimeFlag;
}
public String getReasonId(){
 return reasonId;
}
public void setReasonId(String newValue){ 
 this.reasonId = newValue;
  flagReasonId = 1;
}
public int getFlagReasonId(){ 
 return flagReasonId;
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
public String getRelaExtWoNbr(){
 return relaExtWoNbr;
}
public void setRelaExtWoNbr(String newValue){ 
 this.relaExtWoNbr = newValue;
  flagRelaExtWoNbr = 1;
}
public int getFlagRelaExtWoNbr(){ 
 return flagRelaExtWoNbr;
}
public String getRelaSoNbr(){
 return relaSoNbr;
}
public void setRelaSoNbr(String newValue){ 
 this.relaSoNbr = newValue;
  flagRelaSoNbr = 1;
}
public int getFlagRelaSoNbr(){ 
 return flagRelaSoNbr;
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
public Date getReqCompDate(){ 
 return reqCompDate;
}
public void setReqCompDate(Date newValue){  
 this.reqCompDate = newValue;
  flagReqCompDate = 1;
}
public int getFlagReqCompDate(){ 
 return flagReqCompDate;
}
public String getResSystem(){
 return resSystem;
}
public void setResSystem(String newValue){ 
 this.resSystem = newValue;
  flagResSystem = 1;
}
public int getFlagResSystem(){ 
 return flagResSystem;
}
public String getServDeptId(){
 return servDeptId;
}
public void setServDeptId(String newValue){ 
 this.servDeptId = newValue;
  flagServDeptId = 1;
}
public int getFlagServDeptId(){ 
 return flagServDeptId;
}
public String getServInstId(){
 return servInstId;
}
public void setServInstId(String newValue){ 
 this.servInstId = newValue;
  flagServInstId = 1;
}
public int getFlagServInstId(){ 
 return flagServInstId;
}
public String getSoBatchId(){
 return soBatchId;
}
public void setSoBatchId(String newValue){ 
 this.soBatchId = newValue;
  flagSoBatchId = 1;
}
public int getFlagSoBatchId(){ 
 return flagSoBatchId;
}
public String getSoCat(){
 return soCat;
}
public void setSoCat(String newValue){ 
 this.soCat = newValue;
  flagSoCat = 1;
}
public int getFlagSoCat(){ 
 return flagSoCat;
}
public Date getSoLockDate(){ 
 return soLockDate;
}
public void setSoLockDate(Date newValue){  
 this.soLockDate = newValue;
  flagSoLockDate = 1;
}
public int getFlagSoLockDate(){ 
 return flagSoLockDate;
}
public String getSoLockSts(){
 return soLockSts;
}
public void setSoLockSts(String newValue){ 
 this.soLockSts = newValue;
  flagSoLockSts = 1;
}
public int getFlagSoLockSts(){ 
 return flagSoLockSts;
}
public String getSoMeth(){
 return soMeth;
}
public void setSoMeth(String newValue){ 
 this.soMeth = newValue;
  flagSoMeth = 1;
}
public int getFlagSoMeth(){ 
 return flagSoMeth;
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
public String getSoSeq(){
 return soSeq;
}
public void setSoSeq(String newValue){ 
 this.soSeq = newValue;
  flagSoSeq = 1;
}
public int getFlagSoSeq(){ 
 return flagSoSeq;
}
public String getSoStaffId(){
 return soStaffId;
}
public void setSoStaffId(String newValue){ 
 this.soStaffId = newValue;
  flagSoStaffId = 1;
}
public int getFlagSoStaffId(){ 
 return flagSoStaffId;
}
public String getSoStaffName(){
 return soStaffName;
}
public void setSoStaffName(String newValue){ 
 this.soStaffName = newValue;
  flagSoStaffName = 1;
}
public int getFlagSoStaffName(){ 
 return flagSoStaffName;
}
public String getSoSts(){
 return soSts;
}
public void setSoSts(String newValue){ 
 this.soSts = newValue;
  flagSoSts = 1;
}
public int getFlagSoSts(){ 
 return flagSoSts;
}
public Date getSoStsDate(){ 
 return soStsDate;
}
public void setSoStsDate(Date newValue){  
 this.soStsDate = newValue;
  flagSoStsDate = 1;
}
public int getFlagSoStsDate(){ 
 return flagSoStsDate;
}
public String getSoTemplateId(){
 return soTemplateId;
}
public void setSoTemplateId(String newValue){ 
 this.soTemplateId = newValue;
  flagSoTemplateId = 1;
}
public int getFlagSoTemplateId(){ 
 return flagSoTemplateId;
}
public String getSoType(){
 return soType;
}
public void setSoType(String newValue){ 
 this.soType = newValue;
  flagSoType = 1;
}
public int getFlagSoType(){ 
 return flagSoType;
}
public String getSoWorkAreaId(){
 return soWorkAreaId;
}
public void setSoWorkAreaId(String newValue){ 
 this.soWorkAreaId = newValue;
  flagSoWorkAreaId = 1;
}
public int getFlagSoWorkAreaId(){ 
 return flagSoWorkAreaId;
}
public String getSoWorkAreaName(){
 return soWorkAreaName;
}
public void setSoWorkAreaName(String newValue){ 
 this.soWorkAreaName = newValue;
  flagSoWorkAreaName = 1;
}
public int getFlagSoWorkAreaName(){ 
 return flagSoWorkAreaName;
}
public String getSpecialFlag(){
 return specialFlag;
}
public void setSpecialFlag(String newValue){ 
 this.specialFlag = newValue;
  flagSpecialFlag = 1;
}
public int getFlagSpecialFlag(){ 
 return flagSpecialFlag;
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
public String getTempFlag(){
 return tempFlag;
}
public void setTempFlag(String newValue){ 
 this.tempFlag = newValue;
  flagTempFlag = 1;
}
public int getFlagTempFlag(){ 
 return flagTempFlag;
}
public String getTradeId(){
 return tradeId;
}
public void setTradeId(String newValue){ 
 this.tradeId = newValue;
  flagTradeId = 1;
}
public int getFlagTradeId(){ 
 return flagTradeId;
}
public String getTradeName(){
 return tradeName;
}
public void setTradeName(String newValue){ 
 this.tradeName = newValue;
  flagTradeName = 1;
}
public int getFlagTradeName(){ 
 return flagTradeName;
}
public void clearFlagAcctNbr(){
 flagAcctNbr = 0 ;
}
public void clearFlagAlarmDate(){
 flagAlarmDate = 0 ;
}
public void clearFlagApplDate(){
 flagApplDate = 0 ;
}
public void clearFlagArcDealCount(){
 flagArcDealCount = 0 ;
}
public void clearFlagArcMsg(){
 flagArcMsg = 0 ;
}
public void clearFlagAreaId(){
 flagAreaId = 0 ;
}
public void clearFlagBillType(){
 flagBillType = 0 ;
}
public void clearFlagBookFlag(){
 flagBookFlag = 0 ;
}
public void clearFlagBusinessId(){
 flagBusinessId = 0 ;
}
public void clearFlagChgServSpecId(){
 flagChgServSpecId = 0 ;
}
public void clearFlagCollabSts(){
 flagCollabSts = 0 ;
}
public void clearFlagComplDate(){
 flagComplDate = 0 ;
}
public void clearFlagContactInfo(){
 flagContactInfo = 0 ;
}
public void clearFlagContactName(){
 flagContactName = 0 ;
}
public void clearFlagContactResult(){
 flagContactResult = 0 ;
}
public void clearFlagCoNbr(){
 flagCoNbr = 0 ;
}
public void clearFlagCreateDate(){
 flagCreateDate = 0 ;
}
public void clearFlagCsoNbr(){
 flagCsoNbr = 0 ;
}
public void clearFlagCutoverId(){
 flagCutoverId = 0 ;
}
public void clearFlagDealFlag(){
 flagDealFlag = 0 ;
}
public void clearFlagDevContactInfo(){
 flagDevContactInfo = 0 ;
}
public void clearFlagDevDeptId(){
 flagDevDeptId = 0 ;
}
public void clearFlagDevPartyName(){
 flagDevPartyName = 0 ;
}
public void clearFlagDevPartyRoleId(){
 flagDevPartyRoleId = 0 ;
}
public void clearFlagDevPartyRoleTypeId(){
 flagDevPartyRoleTypeId = 0 ;
}
public void clearFlagExtSoNbr(){
 flagExtSoNbr = 0 ;
}
public void clearFlagExtWoNbr(){
 flagExtWoNbr = 0 ;
}
public void clearFlagFailReasonId(){
 flagFailReasonId = 0 ;
}
public void clearFlagFromProdId(){
 flagFromProdId = 0 ;
}
public void clearFlagFromServInstId(){
 flagFromServInstId = 0 ;
}
public void clearFlagGroupFlag(){
 flagGroupFlag = 0 ;
}
public void clearFlagHastenFlag(){
 flagHastenFlag = 0 ;
}
public void clearFlagLocalNetId(){
 flagLocalNetId = 0 ;
}
public void clearFlagMsPlanName(){
 flagMsPlanName = 0 ;
}
public void clearFlagMsPlanTargetId(){
 flagMsPlanTargetId = 0 ;
}
public void clearFlagMsTaskId(){
 flagMsTaskId = 0 ;
}
public void clearFlagMsTaskName(){
 flagMsTaskName = 0 ;
}
public void clearFlagMsTaskPrjId(){
 flagMsTaskPrjId = 0 ;
}
public void clearFlagMsTaskPrjName(){
 flagMsTaskPrjName = 0 ;
}
public void clearFlagNoFlag(){
 flagNoFlag = 0 ;
}
public void clearFlagNSoNbr(){
 flagNSoNbr = 0 ;
}
public void clearFlagOldSoNbr(){
 flagOldSoNbr = 0 ;
}
public void clearFlagOriSoNbr(){
 flagOriSoNbr = 0 ;
}
public void clearFlagOvertimeId(){
 flagOvertimeId = 0 ;
}
public void clearFlagPartyRoleId(){
 flagPartyRoleId = 0 ;
}
public void clearFlagPartyRoleTypeId(){
 flagPartyRoleTypeId = 0 ;
}
public void clearFlagPayManName(){
 flagPayManName = 0 ;
}
public void clearFlagPayManTeleNbr(){
 flagPayManTeleNbr = 0 ;
}
public void clearFlagPaySts(){
 flagPaySts = 0 ;
}
public void clearFlagPreAlarmDate(){
 flagPreAlarmDate = 0 ;
}
public void clearFlagPriority(){
 flagPriority = 0 ;
}
public void clearFlagProcessId(){
 flagProcessId = 0 ;
}
public void clearFlagProcInstId(){
 flagProcInstId = 0 ;
}
public void clearFlagProdId(){
 flagProdId = 0 ;
}
public void clearFlagRealTimeFlag(){
 flagRealTimeFlag = 0 ;
}
public void clearFlagReasonId(){
 flagReasonId = 0 ;
}
public void clearFlagReasonInfo(){
 flagReasonInfo = 0 ;
}
public void clearFlagRelaExtWoNbr(){
 flagRelaExtWoNbr = 0 ;
}
public void clearFlagRelaSoNbr(){
 flagRelaSoNbr = 0 ;
}
public void clearFlagRemarks(){
 flagRemarks = 0 ;
}
public void clearFlagReqCompDate(){
 flagReqCompDate = 0 ;
}
public void clearFlagResSystem(){
 flagResSystem = 0 ;
}
public void clearFlagServDeptId(){
 flagServDeptId = 0 ;
}
public void clearFlagServInstId(){
 flagServInstId = 0 ;
}
public void clearFlagSoBatchId(){
 flagSoBatchId = 0 ;
}
public void clearFlagSoCat(){
 flagSoCat = 0 ;
}
public void clearFlagSoLockDate(){
 flagSoLockDate = 0 ;
}
public void clearFlagSoLockSts(){
 flagSoLockSts = 0 ;
}
public void clearFlagSoMeth(){
 flagSoMeth = 0 ;
}
public void clearFlagSoNbr(){
 flagSoNbr = 0 ;
}
public void clearFlagSoSeq(){
 flagSoSeq = 0 ;
}
public void clearFlagSoStaffId(){
 flagSoStaffId = 0 ;
}
public void clearFlagSoStaffName(){
 flagSoStaffName = 0 ;
}
public void clearFlagSoSts(){
 flagSoSts = 0 ;
}
public void clearFlagSoStsDate(){
 flagSoStsDate = 0 ;
}
public void clearFlagSoTemplateId(){
 flagSoTemplateId = 0 ;
}
public void clearFlagSoType(){
 flagSoType = 0 ;
}
public void clearFlagSoWorkAreaId(){
 flagSoWorkAreaId = 0 ;
}
public void clearFlagSoWorkAreaName(){
 flagSoWorkAreaName = 0 ;
}
public void clearFlagSpecialFlag(){
 flagSpecialFlag = 0 ;
}
public void clearFlagSts(){
 flagSts = 0 ;
}
public void clearFlagStsDate(){
 flagStsDate = 0 ;
}
public void clearFlagTempFlag(){
 flagTempFlag = 0 ;
}
public void clearFlagTradeId(){
 flagTradeId = 0 ;
}
public void clearFlagTradeName(){
 flagTradeName = 0 ;
}
public void clearAll(){ flagAcctNbr = 0;
 flagAlarmDate = 0;
 flagApplDate = 0;
 flagArcDealCount = 0;
 flagArcMsg = 0;
 flagAreaId = 0;
 flagBillType = 0;
 flagBookFlag = 0;
 flagBusinessId = 0;
 flagChgServSpecId = 0;
 flagCollabSts = 0;
 flagComplDate = 0;
 flagContactInfo = 0;
 flagContactName = 0;
 flagContactResult = 0;
 flagCoNbr = 0;
 flagCreateDate = 0;
 flagCsoNbr = 0;
 flagCutoverId = 0;
 flagDealFlag = 0;
 flagDevContactInfo = 0;
 flagDevDeptId = 0;
 flagDevPartyName = 0;
 flagDevPartyRoleId = 0;
 flagDevPartyRoleTypeId = 0;
 flagExtSoNbr = 0;
 flagExtWoNbr = 0;
 flagFailReasonId = 0;
 flagFromProdId = 0;
 flagFromServInstId = 0;
 flagGroupFlag = 0;
 flagHastenFlag = 0;
 flagLocalNetId = 0;
 flagMsPlanName = 0;
 flagMsPlanTargetId = 0;
 flagMsTaskId = 0;
 flagMsTaskName = 0;
 flagMsTaskPrjId = 0;
 flagMsTaskPrjName = 0;
 flagNoFlag = 0;
 flagNSoNbr = 0;
 flagOldSoNbr = 0;
 flagOriSoNbr = 0;
 flagOvertimeId = 0;
 flagPartyRoleId = 0;
 flagPartyRoleTypeId = 0;
 flagPayManName = 0;
 flagPayManTeleNbr = 0;
 flagPaySts = 0;
 flagPreAlarmDate = 0;
 flagPriority = 0;
 flagProcessId = 0;
 flagProcInstId = 0;
 flagProdId = 0;
 flagRealTimeFlag = 0;
 flagReasonId = 0;
 flagReasonInfo = 0;
 flagRelaExtWoNbr = 0;
 flagRelaSoNbr = 0;
 flagRemarks = 0;
 flagReqCompDate = 0;
 flagResSystem = 0;
 flagServDeptId = 0;
 flagServInstId = 0;
 flagSoBatchId = 0;
 flagSoCat = 0;
 flagSoLockDate = 0;
 flagSoLockSts = 0;
 flagSoMeth = 0;
 flagSoNbr = 0;
 flagSoSeq = 0;
 flagSoStaffId = 0;
 flagSoStaffName = 0;
 flagSoSts = 0;
 flagSoStsDate = 0;
 flagSoTemplateId = 0;
 flagSoType = 0;
 flagSoWorkAreaId = 0;
 flagSoWorkAreaName = 0;
 flagSpecialFlag = 0;
 flagSts = 0;
 flagStsDate = 0;
 flagTempFlag = 0;
 flagTradeId = 0;
 flagTradeName = 0;

}
}
