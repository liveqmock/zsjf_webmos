package com.cattsoft.pub;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * Title: 服务开通系统<br>
 * Description: <br>
 * Date: 2007-9-22 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class LogConfig {
	private static final Logger log = Logger.getLogger(LogConfig.class);

	public static void init() {
		
		Properties config = new Properties();
		InputStream is = null;
		try {
			is = LogConfig.class.getClassLoader().getResourceAsStream("log4j.properties");			
			config.load(is);
		} catch (IOException e) {
			throw new RuntimeException("failed to read log4j configuration file");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		PropertyConfigurator.configure(config);
		log.debug("can log");
	}

}
