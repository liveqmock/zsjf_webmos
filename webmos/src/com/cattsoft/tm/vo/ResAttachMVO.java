package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;


public class ResAttachMVO extends GenericVO{

	private static final long serialVersionUID = 1L;
	private byte[] bytes;
	private String desc = null;
	private String imageId = null;
	private String deviceId = null;
	
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
}
