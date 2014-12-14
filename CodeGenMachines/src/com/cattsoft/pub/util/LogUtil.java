package com.cattsoft.pub.util;

import org.apache.log4j.Logger;

public class LogUtil {
	
	/**
	 * 日志debug操作封装
	 * @param log
	 * @param msg
	 */
	public static void debug(Logger log,String msg){
		if (log.isDebugEnabled()) {
			log.debug(msg);
		}
	}
	
	
	/**
	 * 日志info操作封装
	 * @param log
	 * @param msg
	 */
	public static void info(Logger log,String msg){
		if (log.isInfoEnabled()) {
			log.debug(msg);
		}
	}
	
	/**
	 * 日志error操作封装
	 * @param log
	 * @param msg
	 */
	public static void error(Logger log,String msg){
		log.error(msg);
	}

}
