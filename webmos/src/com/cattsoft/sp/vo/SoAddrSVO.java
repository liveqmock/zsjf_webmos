package com.cattsoft.sp.vo;

import java.io.*;
import com.cattsoft.pub.vo.GenericVO;
import java.util.*;
import java.sql.Clob;
import java.sql.Blob;

/**
 * SoAddrSVO
 * 
 * @author £º°×Ð¡ÁÁ¡£
 * @version 1.1 2007-9-23
 *          <p>
 *          Company: ´óÌÆÈí¼þ
 *          </p>
 */
public class SoAddrSVO extends GenericVO {
	private static final long serialVersionUID = -8023365870017741968L;

	private String actType = null;

	private String addrId = null;

	private String addrInfo = null;

	private String areaId = null;

	private String azFlag = null;

	private String branchId = null;

	private String buildingId = null;

	private String buildingName = null;

	private String changedFlag = null;

	private String deviceId = null;

	private String districtId = null;

	private String districtName = null;

	private String exchId = null;

	private String localNetId = null;

	private String maintAreaId = null;

	private String msAreaId = null;

	private String msAreaName = null;

	private String msStaffId = null;

	private String msStaffName = null;

	private String mtAreaName = null;

	private String mtStaffId = null;

	private String mtStaffName = null;

	private String noFlag = null;

	private String postCode = null;

	private String projectId = null;

	private String refAccNbr = null;

	private String servDeptId = null;

	private String situated = null;

	private String soAddrId = null;

	private String soNbr = null;

	private String sts = null;

	private Date stsDate = null;

	private String twoExchFlag = null;

	private String woAction = null;

	private int flagActType = 0;

	private int flagAddrId = 0;

	private int flagAddrInfo = 0;

	private int flagAreaId = 0;

	private int flagAzFlag = 0;

	private int flagBranchId = 0;

	private int flagBuildingId = 0;

	private int flagBuildingName = 0;

	private int flagChangedFlag = 0;

	private int flagDeviceId = 0;

	private int flagDistrictId = 0;

	private int flagDistrictName = 0;

	private int flagExchId = 0;

	private int flagLocalNetId = 0;

	private int flagMaintAreaId = 0;

	private int flagMsAreaId = 0;

	private int flagMsAreaName = 0;

	private int flagMsStaffId = 0;

	private int flagMsStaffName = 0;

	private int flagMtAreaName = 0;

	private int flagMtStaffId = 0;

	private int flagMtStaffName = 0;

	private int flagNoFlag = 0;

	private int flagPostCode = 0;

	private int flagProjectId = 0;

	private int flagRefAccNbr = 0;

	private int flagServDeptId = 0;

	private int flagSituated = 0;

	private int flagSoAddrId = 0;

	private int flagSoNbr = 0;

	private int flagSts = 0;

	private int flagStsDate = 0;

	private int flagTwoExchFlag = 0;

	private int flagWoAction = 0;

	public String getActType() {
		return actType;
	}

	public void setActType(String newValue) {
		this.actType = newValue;
		flagActType = 1;
	}

	public int getFlagActType() {
		return flagActType;
	}

	public String getAddrId() {
		return addrId;
	}

	public void setAddrId(String newValue) {
		this.addrId = newValue;
		flagAddrId = 1;
	}

	public int getFlagAddrId() {
		return flagAddrId;
	}

	public String getAddrInfo() {
		return addrInfo;
	}

	public void setAddrInfo(String newValue) {
		this.addrInfo = newValue;
		flagAddrInfo = 1;
	}

	public int getFlagAddrInfo() {
		return flagAddrInfo;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String newValue) {
		this.areaId = newValue;
		flagAreaId = 1;
	}

	public int getFlagAreaId() {
		return flagAreaId;
	}

	public String getAzFlag() {
		return azFlag;
	}

	public void setAzFlag(String newValue) {
		this.azFlag = newValue;
		flagAzFlag = 1;
	}

	public int getFlagAzFlag() {
		return flagAzFlag;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String newValue) {
		this.branchId = newValue;
		flagBranchId = 1;
	}

	public int getFlagBranchId() {
		return flagBranchId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String newValue) {
		this.buildingId = newValue;
		flagBuildingId = 1;
	}

	public int getFlagBuildingId() {
		return flagBuildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String newValue) {
		this.buildingName = newValue;
		flagBuildingName = 1;
	}

	public int getFlagBuildingName() {
		return flagBuildingName;
	}

	public String getChangedFlag() {
		return changedFlag;
	}

	public void setChangedFlag(String newValue) {
		this.changedFlag = newValue;
		flagChangedFlag = 1;
	}

	public int getFlagChangedFlag() {
		return flagChangedFlag;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String newValue) {
		this.deviceId = newValue;
		flagDeviceId = 1;
	}

	public int getFlagDeviceId() {
		return flagDeviceId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String newValue) {
		this.districtId = newValue;
		flagDistrictId = 1;
	}

	public int getFlagDistrictId() {
		return flagDistrictId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String newValue) {
		this.districtName = newValue;
		flagDistrictName = 1;
	}

	public int getFlagDistrictName() {
		return flagDistrictName;
	}

	public String getExchId() {
		return exchId;
	}

	public void setExchId(String newValue) {
		this.exchId = newValue;
		flagExchId = 1;
	}

	public int getFlagExchId() {
		return flagExchId;
	}

	public String getLocalNetId() {
		return localNetId;
	}

	public void setLocalNetId(String newValue) {
		this.localNetId = newValue;
		flagLocalNetId = 1;
	}

	public int getFlagLocalNetId() {
		return flagLocalNetId;
	}

	public String getMaintAreaId() {
		return maintAreaId;
	}

	public void setMaintAreaId(String newValue) {
		this.maintAreaId = newValue;
		flagMaintAreaId = 1;
	}

	public int getFlagMaintAreaId() {
		return flagMaintAreaId;
	}

	public String getMsAreaId() {
		return msAreaId;
	}

	public void setMsAreaId(String newValue) {
		this.msAreaId = newValue;
		flagMsAreaId = 1;
	}

	public int getFlagMsAreaId() {
		return flagMsAreaId;
	}

	public String getMsAreaName() {
		return msAreaName;
	}

	public void setMsAreaName(String newValue) {
		this.msAreaName = newValue;
		flagMsAreaName = 1;
	}

	public int getFlagMsAreaName() {
		return flagMsAreaName;
	}

	public String getMsStaffId() {
		return msStaffId;
	}

	public void setMsStaffId(String newValue) {
		this.msStaffId = newValue;
		flagMsStaffId = 1;
	}

	public int getFlagMsStaffId() {
		return flagMsStaffId;
	}

	public String getMsStaffName() {
		return msStaffName;
	}

	public void setMsStaffName(String newValue) {
		this.msStaffName = newValue;
		flagMsStaffName = 1;
	}

	public int getFlagMsStaffName() {
		return flagMsStaffName;
	}

	public String getMtAreaName() {
		return mtAreaName;
	}

	public void setMtAreaName(String newValue) {
		this.mtAreaName = newValue;
		flagMtAreaName = 1;
	}

	public int getFlagMtAreaName() {
		return flagMtAreaName;
	}

	public String getMtStaffId() {
		return mtStaffId;
	}

	public void setMtStaffId(String newValue) {
		this.mtStaffId = newValue;
		flagMtStaffId = 1;
	}

	public int getFlagMtStaffId() {
		return flagMtStaffId;
	}

	public String getMtStaffName() {
		return mtStaffName;
	}

	public void setMtStaffName(String newValue) {
		this.mtStaffName = newValue;
		flagMtStaffName = 1;
	}

	public int getFlagMtStaffName() {
		return flagMtStaffName;
	}

	public String getNoFlag() {
		return noFlag;
	}

	public void setNoFlag(String newValue) {
		this.noFlag = newValue;
		flagNoFlag = 1;
	}

	public int getFlagNoFlag() {
		return flagNoFlag;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String newValue) {
		this.postCode = newValue;
		flagPostCode = 1;
	}

	public int getFlagPostCode() {
		return flagPostCode;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String newValue) {
		this.projectId = newValue;
		flagProjectId = 1;
	}

	public int getFlagProjectId() {
		return flagProjectId;
	}

	public String getRefAccNbr() {
		return refAccNbr;
	}

	public void setRefAccNbr(String newValue) {
		this.refAccNbr = newValue;
		flagRefAccNbr = 1;
	}

	public int getFlagRefAccNbr() {
		return flagRefAccNbr;
	}

	public String getServDeptId() {
		return servDeptId;
	}

	public void setServDeptId(String newValue) {
		this.servDeptId = newValue;
		flagServDeptId = 1;
	}

	public int getFlagServDeptId() {
		return flagServDeptId;
	}

	public String getSituated() {
		return situated;
	}

	public void setSituated(String newValue) {
		this.situated = newValue;
		flagSituated = 1;
	}

	public int getFlagSituated() {
		return flagSituated;
	}

	public String getSoAddrId() {
		return soAddrId;
	}

	public void setSoAddrId(String newValue) {
		this.soAddrId = newValue;
		flagSoAddrId = 1;
	}

	public int getFlagSoAddrId() {
		return flagSoAddrId;
	}

	public String getSoNbr() {
		return soNbr;
	}

	public void setSoNbr(String newValue) {
		this.soNbr = newValue;
		flagSoNbr = 1;
	}

	public int getFlagSoNbr() {
		return flagSoNbr;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String newValue) {
		this.sts = newValue;
		flagSts = 1;
	}

	public int getFlagSts() {
		return flagSts;
	}

	public Date getStsDate() {
		return stsDate;
	}

	public void setStsDate(Date newValue) {
		this.stsDate = newValue;
		flagStsDate = 1;
	}

	public int getFlagStsDate() {
		return flagStsDate;
	}

	public String getTwoExchFlag() {
		return twoExchFlag;
	}

	public void setTwoExchFlag(String newValue) {
		this.twoExchFlag = newValue;
		flagTwoExchFlag = 1;
	}

	public int getFlagTwoExchFlag() {
		return flagTwoExchFlag;
	}

	public String getWoAction() {
		return woAction;
	}

	public void setWoAction(String newValue) {
		this.woAction = newValue;
		flagWoAction = 1;
	}

	public int getFlagWoAction() {
		return flagWoAction;
	}

	public void clearFlagActType() {
		flagActType = 0;
	}

	public void clearFlagAddrId() {
		flagAddrId = 0;
	}

	public void clearFlagAddrInfo() {
		flagAddrInfo = 0;
	}

	public void clearFlagAreaId() {
		flagAreaId = 0;
	}

	public void clearFlagAzFlag() {
		flagAzFlag = 0;
	}

	public void clearFlagBranchId() {
		flagBranchId = 0;
	}

	public void clearFlagBuildingId() {
		flagBuildingId = 0;
	}

	public void clearFlagBuildingName() {
		flagBuildingName = 0;
	}

	public void clearFlagChangedFlag() {
		flagChangedFlag = 0;
	}

	public void clearFlagDeviceId() {
		flagDeviceId = 0;
	}

	public void clearFlagDistrictId() {
		flagDistrictId = 0;
	}

	public void clearFlagDistrictName() {
		flagDistrictName = 0;
	}

	public void clearFlagExchId() {
		flagExchId = 0;
	}

	public void clearFlagLocalNetId() {
		flagLocalNetId = 0;
	}

	public void clearFlagMaintAreaId() {
		flagMaintAreaId = 0;
	}

	public void clearFlagMsAreaId() {
		flagMsAreaId = 0;
	}

	public void clearFlagMsAreaName() {
		flagMsAreaName = 0;
	}

	public void clearFlagMsStaffId() {
		flagMsStaffId = 0;
	}

	public void clearFlagMsStaffName() {
		flagMsStaffName = 0;
	}

	public void clearFlagMtAreaName() {
		flagMtAreaName = 0;
	}

	public void clearFlagMtStaffId() {
		flagMtStaffId = 0;
	}

	public void clearFlagMtStaffName() {
		flagMtStaffName = 0;
	}

	public void clearFlagNoFlag() {
		flagNoFlag = 0;
	}

	public void clearFlagPostCode() {
		flagPostCode = 0;
	}

	public void clearFlagProjectId() {
		flagProjectId = 0;
	}

	public void clearFlagRefAccNbr() {
		flagRefAccNbr = 0;
	}

	public void clearFlagServDeptId() {
		flagServDeptId = 0;
	}

	public void clearFlagSituated() {
		flagSituated = 0;
	}

	public void clearFlagSoAddrId() {
		flagSoAddrId = 0;
	}

	public void clearFlagSoNbr() {
		flagSoNbr = 0;
	}

	public void clearFlagSts() {
		flagSts = 0;
	}

	public void clearFlagStsDate() {
		flagStsDate = 0;
	}

	public void clearFlagTwoExchFlag() {
		flagTwoExchFlag = 0;
	}

	public void clearFlagWoAction() {
		flagWoAction = 0;
	}

	public void clearAll() {
		flagActType = 0;
		flagAddrId = 0;
		flagAddrInfo = 0;
		flagAreaId = 0;
		flagAzFlag = 0;
		flagBranchId = 0;
		flagBuildingId = 0;
		flagBuildingName = 0;
		flagChangedFlag = 0;
		flagDeviceId = 0;
		flagDistrictId = 0;
		flagDistrictName = 0;
		flagExchId = 0;
		flagLocalNetId = 0;
		flagMaintAreaId = 0;
		flagMsAreaId = 0;
		flagMsAreaName = 0;
		flagMsStaffId = 0;
		flagMsStaffName = 0;
		flagMtAreaName = 0;
		flagMtStaffId = 0;
		flagMtStaffName = 0;
		flagNoFlag = 0;
		flagPostCode = 0;
		flagProjectId = 0;
		flagRefAccNbr = 0;
		flagServDeptId = 0;
		flagSituated = 0;
		flagSoAddrId = 0;
		flagSoNbr = 0;
		flagSts = 0;
		flagStsDate = 0;
		flagTwoExchFlag = 0;
		flagWoAction = 0;

	}
}
