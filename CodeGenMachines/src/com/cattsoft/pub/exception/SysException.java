package com.cattsoft.pub.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;



public class SysException extends GenericException {

	/**
	 * SysException�ĸ��ٵ�����Ϣ��һ����������ͷ�������
	 */
	private String trace = "";

	public SysException() {
	}

	public SysException(String errId, String errOwnMsg, Exception oriEx) {

		super(oriEx);
		this.errId = errId;
		this.errMsg += ":" + errOwnMsg;
		this.errMsgOri = oriEx.getMessage();
		this.errOri = oriEx;
		this.writeSysException();
	}

	public SysException(String errId, Exception oriEx) {
		super(oriEx);
		this.errId = errId;
		this.errMsgOri = oriEx.getMessage();
		this.errOri = oriEx;
		this.writeSysException();
	}

	/**
	 * ��Ӹ�����Ϣ��ֻ�в�׽��SysException��ʱ��ŵ��øú�����
	 * 
	 * @param msg
	 *            String ������Ϣ
	 */
	public void appendMsg(String msg) {
		trace += msg;
	}

	/**
	 * ���ظ�����Ϣ
	 * 
	 * @return String
	 */
	public String getTrace() {
		return trace;
	}

	/**
	 * ��ӡԭ��������Ϣ
	 */
	public void printDebug() {
		// //System.out.println("errId:"+this.errId);
		// //System.out.println("errMsg:"+this.errMsg);
		// //System.out.println("trace:"+this.trace);
		// //System.out.println("errMsgOri:"+this.errMsgOri);
		this.errOri.printStackTrace();
	}

	private void writeSysException() {
		Logger log = Logger.getLogger(SysException.class);
		if (log.isDebugEnabled()) {
			log.debug("writeSysException begin");
		}
		if (log.isDebugEnabled()) {
			log.debug("id:" + this.errId);
			log.debug("msg:" + this.errMsg);
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		this.errOri.printStackTrace(p);
		if (log.isDebugEnabled())
			log.debug(os.toString());

	}

}
