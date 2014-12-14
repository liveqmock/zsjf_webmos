package com.cattsoft.pub.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Address 
{
	
	private static final Logger log = Logger.getLogger(Address.class);

	public static Properties getAddress() {
		
		Properties config = new Properties();
		InputStream is = null;
		try {
			is = Address.class.getClassLoader().getResourceAsStream("address.properties");
			config.load(is);
		} catch (IOException e) {
			throw new RuntimeException("failed to read address.properties configuration file");
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		log.debug("return address config");
		return config;
	}
}
