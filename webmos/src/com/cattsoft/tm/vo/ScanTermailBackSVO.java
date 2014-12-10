package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;
/**
 * 领取/退回终端服务端返回的结果
 * @author xueweiwei
 *
 */
public class ScanTermailBackSVO extends GenericVO{

	private String macAddress;//终端条码
	private String Flag;//入库成功与否标识
	private String remark;//备注
	
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}
	public String getFlag() {
		return Flag;
	}
	public void setFlag(String flag) {
		Flag = flag;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
