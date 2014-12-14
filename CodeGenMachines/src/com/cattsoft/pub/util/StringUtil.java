package com.cattsoft.pub.util;

import org.apache.log4j.Logger;

public class StringUtil {
	private static final Logger log = Logger.getLogger(StringUtil.class);

	/**
	 * 删除str指定的后缀
	 * 
	 * @param str
	 * @param suffix
	 * @return
	 */
	public static String removeSuffix(String str, String suffix) throws UtilException {
		if (null == str)
			return null;
		if ("".equals(str.trim()))
			return "";

		if (null == suffix || "".equals(suffix))
			return str;

		if (str.endsWith(suffix)) {
			return str.substring(0, str.length() - suffix.length());
		}

		throw new UtilException(str + " 没有按指定字符串" + suffix + "结尾");
	}

	/**
	 * 是否是空的（包括null、""、空格）
	 * 
	 * @param str
	 * @return
	 * @throws UtilException
	 */
	public static boolean isBlank(String str) {
		if (null == str)
			return true;
		if ("".equals(str.trim()))
			return true;

		return false;
	}

	/**
	 * 将对象转成String
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString().trim();
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String getString(String str) {
		if (null == str)
			return "";
		return str;

	}

	/**
	 * 计算两个数字字符串的和
	 * 
	 * @param augend
	 * @param addend
	 * @return
	 * @throws UtilException
	 */
	public static String getSum(String augend, String second, String addend) {
		if (augend == null)
			augend = "0";
		if (second == null)
			second = "0";
		if (addend == null)
			addend = "0";
		int sum = Integer.parseInt(augend) + Integer.parseInt(second) + Integer.parseInt(addend);
		return new Integer(sum).toString();
	}

	public static void main(String[] args) throws UtilException {
		String str = "kkjlj l.class";

		LogUtil.debug(log, StringUtil.removeSuffix(str, ".class"));
	}

	public static String change(String str, int n, boolean isLeft) {
		if (str == null || str.length() >= n)
			return str;
		String s = "";
		for (int i = str.length(); i < n; i++)
			s += "0";
		if (isLeft)
			return s + str;
		else
			return str + s;
	}
    public static String getInString(String str){
    	if(str==null)
    		return null;
    	StringBuffer sb=new StringBuffer("");
    	String s[]=str.split(",");
    	if(s!=null&&s.length>0){
    		for(int i=0;i<s.length;i++){
    			if(i!=0)
    				sb.append(",");
    			sb.append("'").append(s[i]).append("'");
    		}
    	}
    	return sb.toString();
    }
}
