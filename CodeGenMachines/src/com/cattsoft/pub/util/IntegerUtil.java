package com.cattsoft.pub.util;

public class IntegerUtil {
	
	
	public static int convert(long value){
		String strLong = Long.toString(value);
		return Integer.parseInt(strLong);
	}

}
