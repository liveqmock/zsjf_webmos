package com.cattsoft.tm.vo;

public class MosSurveyMVO extends MosSurveySVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7345829727228049441L;

	private byte[] signatureBytes;

	public byte[] getSignatureBytes() {
		return signatureBytes;
	}

	public void setSignatureBytes(byte[] signatureBytes) {
		this.signatureBytes = signatureBytes;
	}
}
