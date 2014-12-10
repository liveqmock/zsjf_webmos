package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;
/**
 * 终端
 * @author xueweiwei
 *
 */
public class ScanTermailSVO extends GenericVO{

	private String macAddress;//设备条形码
    private String StaffId;//用户id
    private String localNetId;//本地网
    private String areaId;//服务区
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getStaffId() {
		return StaffId;
	}
	public void setStaffId(String staffId) {
		StaffId = staffId;
	}
	public String getLocalNetId() {
		return localNetId;
	}
	public void setLocalNetId(String localNetId) {
		this.localNetId = localNetId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
}
