package com.cattsoft.sp.vo;

import org.apache.struts.upload.FormFile;

public class SoAttachMVO extends SoAttachSVO {

	private static final long serialVersionUID = -3340933750560973590L;

	private FormFile file;
	
	private byte[] bytes;

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}
}
