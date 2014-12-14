package com.cattsoft.pub.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;

import com.cattsoft.pub.util.LogUtil;

public class AppException extends GenericException {

	public AppException() {

	}

	public AppException(String errId, String errOwnMsg) {
		this.errId = errId;
		this.errMsg += ":" + errOwnMsg;
		this.writeAppException();
	}

	private void writeAppException() {
		Logger log = Logger.getLogger(AppException.class);
		LogUtil.debug(log, "应用错误号：" + this.errId);
		LogUtil.debug(log, "应用错误信息：" + this.errMsg);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream p = new PrintStream(os);
		this.printStackTrace(p);
		if (log.isDebugEnabled())
			log.debug(os.toString());

	}
}
