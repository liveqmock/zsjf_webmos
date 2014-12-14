package com.cattsoft.pub.util;

import org.apache.log4j.Logger;

public class LogUtil {
	
	/**
	 * ��־debug������װ
	 * @param log
	 * @param msg
	 */
	public static void debug(Logger log,String msg){
		if (log.isDebugEnabled()) {
			log.debug(msg);
		}
	}
	
	
	/**
	 * ��־info������װ
	 * @param log
	 * @param msg
	 */
	public static void info(Logger log,String msg){
		if (log.isInfoEnabled()) {
			log.debug(msg);
		}
	}
	
	/**
	 * ��־error������װ
	 * @param log
	 * @param msg
	 */
	public static void error(Logger log,String msg){
		log.error(msg);
	}

}
