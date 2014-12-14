package com.cattsoft.pub.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;

/**
 * 
 * Title: 服务开通系统<br>
 * Description: <br>
 * Date: 2007-6-18 <br>
 * Copyright (c) 2007 CATTSoft<br>
 * 
 * @author liaoyh
 */
public class DateUtil {
	public static SimpleDateFormat datetimef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static SimpleDateFormat datef = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 按指定的格式将日期对象转换为字符串
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String to_char(Date date, String format) {
		if (date == null)
			return null;
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	/**
	 * 按指定格式将字符串转换为日期对象
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws SysException
	 * 
	 */
	public static Date to_date(String dateStr, String format) throws SysException {
		if (StringUtils.isEmpty(dateStr))
			return null;
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			throw new SysException("", "系统转换日期字符串时出错！", e);
		}
	}

	/**
	 * 得到大于传入天数的日期
	 * 
	 * @param date
	 * @param num
	 * @return java.util.Date
	 * @throws AppException
	 */
	public static Date addDays(Date date, int num) throws AppException {
		if (null == date)
			throw new AppException("", "缺少参数！");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(GregorianCalendar.DAY_OF_MONTH, num);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的起始时间，如：2007-6-6 00:00:00
	 * 
	 * @param date
	 * @return
	 * @throws AppException
	 */
	public static Date getStartDateTime(Date date) throws AppException {
		if (null == date)
			throw new AppException("", "缺少参数！");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 日期（精确到秒）转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTime2Str(Date date) {
		String str = "";
		if (null != date) {
			str = DateUtil.to_char(date, "yyyy-MM-dd HH:mm:ss");
		}
		return str;
	}

	/**
	 * 日期（精确到日）转字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Str(Date date) {
		String str = "";
		if (null != date) {
			str = DateUtil.to_char(date, "yyyy-MM-dd");
		}
		return str;
	}

	/**
	 * 字符串转日期（精确到秒）
	 * 
	 * @param str
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Date str2DateTime(String str) throws AppException, SysException {
		Date date = null;
		if (!StringUtil.isBlank(str)) {
			date = DateUtil.to_date(str, "yyyy-MM-dd HH:mm:ss");
		}
		return date;

	}

	/**
	 * 字符串转日期（精确到日）
	 * 
	 * @param str
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public static Date str2Date(String str) throws AppException, SysException {
		Date date = null;
		if (!StringUtil.isBlank(str)) {
			date = DateUtil.to_date(str, "yyyy-MM-dd");
		}
		return date;

	}

	/**
	 * 获取一个永久时间
	 * 
	 * @return
	 * @throws SysException
	 */
	public static Date getForeverDate() throws SysException {
		return to_date("2049-12-31 00:00:00", "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获得数据库当前时间
	 * 
	 * @return
	 */
	public static Date getDBDate() {
		return SysDate.getCurrentDate();

	}
	
	/**
	 * 获得数据库当前时间字符串
	 * 
	 * @return
	 */
	public static String getDBDateTimeStr() {
		return DateUtil.dateTime2Str(SysDate.getCurrentDate());

	}

	/**
	 * 根据日期返回星期
	 * 
	 * @param date
	 * @return
	 */
	public static String date2Week(Date date) {
		if (date == null)
			return null;
		return new SimpleDateFormat("E").format(date);
	}
}
