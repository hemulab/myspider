package com.ksyche.tools.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateHelper {
	private static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static String DATE_PATTERN = "yyyy-MM-dd";
	/**
	 * 格式化日期为字符串
	 * 
	 * @param date
	 *            目标日期
	 * @param partten
	 *            模式
	 * @return
	 */
	public static String format(Date date, String... partten) {
		SimpleDateFormat sdf = null;
		if(date==null){
			return null;
		}
		if (partten != null && partten.length > 0) {
			sdf = new SimpleDateFormat(partten[0]);
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return sdf.format(date);
	}

	/**
	 * 将格式化的日期字符串解析为Date类型
	 * 
	 * @param source
	 *            格式化的日期字符串
	 * @param partten
	 *            模式
	 * @return
	 * @throws Exception
	 */
	public static Date parse(String source, String... partten) throws Exception {
		if(source==null || "".equals(source)){
			return null;
		}
		SimpleDateFormat sdf = null;
		if (partten != null && partten.length > 0) {
			sdf = new SimpleDateFormat(partten[0]);
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		return sdf.parse(source);
	}
	
	
	/**
	 * 格式化http头gmt时间
	 * @param date
	 * @return
	 */
	public static String formatHttpDateGMT(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);  
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date);
	}

	/**
	 * 
	 * @param now
	 * @param days
	 * @return
	 */
	public static Date addDays(Date now, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * 
	 * @param now
	 * @param years
	 * @return
	 */
	public static Date addYears(Date now, int years) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.YEAR, years);
		return cal.getTime();
	}
	
	/**
	 * 两个日期相减得到天数(d1 - d2)
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int subDate(Date d1, Date d2) {
		return (int) ((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
	}
	
	/**
	 * 获得指定日期是一年中的哪个季度
	 * @param d
	 * @return
	 */
	public static int getQuqrterOfYear(int month) {
		if(month <= 3) {
			return 1;
		} else if(month <= 6) {
			return 2;
		} else if(month <= 9) {
			return 3;
		} else if(month <= 12) {
			return 4;
		}
		
		return -1;
	}
	
	public static boolean isHourBetween(int start,int end){
		Calendar calendar = Calendar.getInstance();
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		return h>=start&&h<end;
	}
	
	public static boolean timeIsHourBetween(Date date,int start,int end){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int h = calendar.get(Calendar.HOUR_OF_DAY);
		return h>=start&&h<end;
	}
	/**
	 * 把一个Data 转化成 yyyyMMdd的整数形式
	 * @param date
	 * @return
	 */
	public static int Date2Int(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String format = df.format(date);
		return Integer.valueOf(format);
	}

	/**
	 * 把距当前日期 n 天的时间转换成 yyyyMMdd的整数形式
	 * @param n  的n天
	 * @return
	 */
	public static int Date2int(int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, n);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");  
	    String format = simpleDateFormat.format(calendar.getTime());
	    return Integer.valueOf(format);
		
	}
	
	/***
	 * 获取一天的结束时间
	 * 23:59:59
	 * */
	public static Date getDateEnd(Date date) throws Exception{
		if(date != null){
			return parse(format(date, DATE_PATTERN)+" 23:59:59",DATE_TIME_PATTERN);
		}
		return date;
	}
	
	/***
	 * 获取一天的结束时间
	 * 00:00:00
	 * */
	public static Date getDateStart(Date date) throws Exception{
		if(date != null){
			return parse(format(date, DATE_PATTERN)+" 00:00:00",DATE_TIME_PATTERN);
		}
		return date;
	}
}
