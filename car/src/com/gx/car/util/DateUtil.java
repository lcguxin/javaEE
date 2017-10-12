package com.gx.car.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {


	/**
	 * 日期验证
	 * @param obj
	 * @return
	 */
	public static Date checkDate(String dateStr){
		if(dateStr==null)
			return null;
		if("".equals(dateStr))
			return null;
		try {
			Date date=new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}
	/**
	 * 把某�?��时间，转换成�?���?��的时�?
	 * @param dateString
	 * @return
	 */
	public static Date StrToDayStartDate(String dateString){
		if(dateString==null || "".equals(dateString)){
			return null;
		}
		try {
			String date=DateUtil.formatDate(DateUtil.parseDate(dateString), "yyyy-MM-dd");
			date=date+" 00:00:00";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return dateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 把某�?��时间，转换成�?���?��的时�?
	 * @param dateString
	 * @return
	 */
	public static String StrToDayStartStr(String dateString){
		if(dateString==null || "".equals(dateString)){
			return null;
		}
		try {
			String date=DateUtil.formatDate(DateUtil.parseDate(dateString), "yyyy-MM-dd");
			date=date+" 00:00:00";
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 把某�?��时间，转换成�?��结束的时�?
	 * @param dateString
	 * @return
	 */
	public static Date StrToDayEndDate(String dateString){
		if(dateString==null || "".equals(dateString)){
			return null;
		}
		try {
			String date=DateUtil.formatDate(DateUtil.parseDate(dateString), "yyyy-MM-dd");
			date=date+" 23:59:59";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			return dateFormat.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 把某�?��时间，转换成�?��结束的时�?
	 * @param dateString
	 * @return
	 */
	public static String StrToDayEndStr(String dateString){
		if(dateString==null || "".equals(dateString)){
			return null;
		}
		try {
			String date=DateUtil.formatDate(DateUtil.parseDate(dateString), "yyyy-MM-dd");
			date=date+" 23:59:59";
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	public static String dateToStr(Date date) {
		if(date != null)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// Date dBeginDate;
			String dateStr = dateFormat.format(date);
			return dateStr;
		}
		return null;
	}
	
	public static String customDateToStr(Date date,String pattern) {
		if(date != null)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			// Date dBeginDate;
			String dateStr = dateFormat.format(date);
			return dateStr;
		}
		return null;
	}

	public static Date getStandardDate(String source, String pattern) {
		if (source == null || source.trim().length() == 0)
			return null;
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		;
		try {
			return sf.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 	日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static java.util.Date addDate(java.util.Date date, int day) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}
	
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}
	
	public static String getDateStr()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		// Date dBeginDate;
		String dateStr = dateFormat.format(date);
		return dateStr;
	}
	
	public static String getTimeStr()
	{
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("hhmmss");
		// Date dBeginDate;
		String dateStr = dateFormat.format(date);
		return dateStr;
	}
	
	public static Date getSysDate(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
	
	/**
	 * 获取当月第一天的日期
	 */
	public static Date getFirstDateOfMonth(){
		Calendar ca = Calendar.getInstance();
		ca.setTime(getSysDate());  //   someDate   为你要获取的那个月的时间   
		ca.set(Calendar.DAY_OF_MONTH,1);
		return ca.getTime();
//		ca.add(Calendar.MONTH,1);
//		ca.add(Calendar.DAY_OF_MONTH,-1);
//	    Date lastDate = ca.getTime();
	}
	
	public static Date preMonthFirstDay(){
   	 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return StrToDayStartDate(sdf.format(cal.getTime()));
	}
	
	public static Date stringToDate(String str_date){
        if(str_date==null||str_date.equals("")){
        	System.out.println("转换的日期字符串为空!");
            return null;
        }
   	 	SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
   	 	Date dt = null;
   	 	try{
   	 		dt = form.parse(str_date);
   	 	}
   	 	catch(ParseException e){		
   	 		System.out.println("unparseable using " + form);	
   	 	}
   	 	return dt;
	}
	
	/**
	 * 
	 * (根据当前时间点为参照�?
	 * 得到任何日期时间,比如去年的今天的时�?，上个月今天的时间�?下个月当天时�?
	 * @param field    Calendar.Year = 1; MONTH = 2; WEEK_OF_YEAR = 3;WEEK_OF_MONTH = 4;DAY_OF_MONTH = 5;DAY_OF_YEAR = 6
	 * @param amount : int 
	 * @return Date 
	
	 * 
	 * For instance:
	 * 得到昨天的日�?
	 * getAnyDateBy（Calendar.DAY_OF_MONTH,-1�?
	 * 得到下个月日�?
	 * getAnyDateBy（Calendar.MONTH,+1�?
	 * 
	 */
	public static Date getAnyDateBy(int field,int amount){
		//默认格式
		Calendar c = Calendar.getInstance();
		c.add(field, amount);
		return c.getTime();
	}
	
	/**
	 * 根据日期得到日期的年�?
	 * @param date
	 * @return int
	 */
	public static int getYearTimeOfDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	/**
	 * 根据日期得到月份
	 * @param date
	 * @return

	 */
	public static int getMonthTimeOfDate(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH);
	}
	
	
	/**
	 * 
	 * 格式化日期类为yyyy-MM-dd格式日期�?
	 * liu_xs
	 * @param datetime
	 *            �?��转化的日�?
	 * @return 转化后的日期
	 */
	public static Date parseDate(Date datetime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		if (datetime == null) {
			return null;
		} else {
			try {
				return formatter.parse(formatter.format(datetime));
			} catch (ParseException e) {
				return null;
			}
		}
	}
	
	/**
	 * 
	 * 2012-8-7  得到当前时间的格式化字符�?
	 * 
	 * @param type
	 *            日期格式
	 * @return 指定日期格式的当前时间的字符�?
	 */
	public static String getFormatDate(String type) {
		return (formatDate(now(), type));
	}

	/**
	 * 
	 * 2012-8-7  得到当前时间的格式化字符�?
	 * 
	 * @return yyyy-MM-dd HH:mm:ss格式的当前时间的字符�?
	 */
	public static String getDefaultDate() {
		return (formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 
	 * 2012-8-7  得到当前时间的格式化字符�?
	 * 
	 * @return yyyy-MM-dd格式的当前时间的字符�?
	 */
	public static String getFormatDate() {
		return (formatDate(now(), "yyyy-MM-dd"));
	}

	/**
	 * 
	 * 2012-8-7  得到当前时间的格式化字符�?
	 * 
	 * @return yyyyMM格式的当前时间的字符�?
	 */
	public static String getFormatDate1() {
		return (formatDate(now(), "yyyyMM"));
	}

	/**
	 * 
	 * 2012-8-7  根据传入的日期类型格式化日期
	 * 
	 * @param date
	 *            �?��格式化的日期
	 * @param pattern
	 *            日期格式
	 * @return 格式化后的日期字符串
	 */
	public static String formatDate(Date date, String pattern) {
		if (date == null)
			return "";
		if (pattern == null)
			pattern = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return (sdf.format(date));
	}

	/**
	 * 
	 * 2012-8-7  根据传入的日期类型格式化日期字符�?
	 * 
	 * @param dateStr
	 *            �?��格式化的日期字符�?
	 * @param pattern
	 *            日期格式
	 * @return 格式化后的日�?
	 */
	public static Date formatDate(String dateStr, String pattern) {
		if (pattern == null || "".equals(pattern)) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date d = null;
		try {
			if (dateStr == null) {
				d = null;
			} else {
				d = sdf.parse(dateStr);
			}
		} catch (ParseException e) {
			return null;
		}
		return d;
	}

	/**
	 * 
	 * 2012-8-7  将传入的日期格式化为yyyy-MM-dd HH:mm:ss格式字符�?
	 * 
	 * @param date
	 *            �?��格式化的日期
	 * @return 格式化后的日期字符串
	 */
	public static String formatDateTime(Date date) {
		return (formatDate(date, "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 
	 * 2012-8-7  将当前日期格式化为yyyy-MM-dd HH:mm:ss格式字符�?
	 * 
	 * @return 格式化后的日期字符串
	 */
	public static String formatDateTime() {
		return (formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 
	 * 2012-8-7  返回当前日期
	 * 
	 * @return 当前日期
	 */
	public static Date now() {
		return (new Date());
	}

	/**
	 * 
	 * 2012-8-7  将字符串转换成日期类(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param datetime
	 *            �?��转化的日期字符串
	 * @return 转化后的日期
	 */
	public static Date parseDateTime(String datetime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if ((datetime == null) || (datetime.equals(""))) {
			return null;
		} else {
			try {
				return formatter.parse(datetime);
			} catch (ParseException e) {
				return parseDate(datetime);
			}
		}
	}

	/**
	 * 
	 * 2012-8-7  将字符串转换成日期类(yyyy-MM-dd)
	 * 
	 * @param date
	 *            �?��转化的日期字符串
	 * @return 转化后的日期
	 */
	public static Date parseDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		if ((date == null) || (date.equals(""))) {
			return null;
		} else {
			try {
				return formatter.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 
	 * 2012-8-7  将字符串转换成日期类(yyyyMMdd)
	 * 
	 * @param date
	 *            �?��转化的日期字符串
	 * @return 转化后的日期
	 */
	public static Date parseDate2(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		if ((date == null) || (date.equals(""))) {
			return null;
		} else {
			try {
				return formatter.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 
	 * 2012-8-7  格式化日期类
	 * 
	 * @param datetime
	 *            �?��格式化的日期
	 * @param str
	 *            日期格式
	 * @return 转化后的日期
	 */
	public static Date parseDate(Date datetime, String str) {
		if (str == null || "".equals(str)) {
			str = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat formatter = new SimpleDateFormat(str);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		if (datetime == null) {
			return null;
		} else {
			try {
				return formatter.parse(formatter.format(datetime));
			} catch (ParseException e) {
				return null;
			}
		}
	}

	/**
	 * 
	 * 2012-8-7  将传入的对象转成日期字符串（对象为空不转换）
	 * 
	 * @param o
	 *            �?��转化的对�?
	 * @return 转化后的日期字符
	 */
	public static String formatDate(Object o) {
		if (o == null)
			return "";
		if (o.getClass() == String.class)
			return formatDate((String) o);
		else if (o.getClass() == Date.class)
			return formatDate((Date) o);
		else if (o.getClass() == Timestamp.class) {
			return formatDate(new Date(((Timestamp) o).getTime()));
		} else
			return o.toString();
	}

	/**
	 * 
	 * 2012-8-7  给时间加上或减去指定毫秒，秒，分，时，天、月或年等，返回变动后的时间
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param field
	 *            时间域，有Calendar.MILLISECOND,Calendar.SECOND,Calendar.MINUTE,<br>
	 *            Calendar.HOUR,Calendar.DATE, Calendar.MONTH,Calendar.YEAR
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return 变动后的时间
	 */
	public static Date add(Date date, int field, int amount) {
		if (date == null) {
			date = new Date();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, amount);

		return cal.getTime();
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上微秒的时间结�?
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addMilliSecond(Date date, int amount) {
		return add(date, Calendar.MILLISECOND, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上秒的时间结果
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addSecond(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上分钟的时间结�?
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addMiunte(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上小时的时间结�?
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addHour(Date date, int amount) {
		return add(date, Calendar.HOUR, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上天的时间结果
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addDay(Date date, int amount) {
		return add(date, Calendar.DATE, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上月的时间结果
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addMonth(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回�?��时间加上年的时间结果
	 * 
	 * @param date
	 *            要加减前的时间，如果不传，则为当前日�?
	 * @param amount
	 *            按指定时间域加减的时间数量，正数为加，负数为�?
	 * @return
	 */
	public static Date addYear(Date date, int amount) {
		return add(date, Calendar.YEAR, amount);
	}

	/**
	 * 
	 * 2012-8-7  返回格式化为yyyy-MM-dd HH:mm:ss的字符串的当前日�?
	 * 
	 * @return 格式化后的日�?
	 */
	public static Date getDateTime() {
		return parseDateTime(formatDate(now(), "yyyy-MM-dd HH:mm:ss"));
	}

	/**
	 * 
	 * 2012-8-7  返回格式化的字符串转化成的日期类
	 * 
	 * @param d
	 *            �?��转化的日�?
	 * @param pattern
	 *            日期格式
	 * @return 格式化后的日�?
	 */
	public static Date getDateTime(Date d, String pattern) {
		if (pattern == null) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		return parseDateTime(formatDate(d, pattern));
	}

	/**
	 * 
	 * 2012-8-7  格式化特定格式的日期
	 * 
	 * @param Date
	 *            "20090214" or "20091225134520"
	 * @return "2009-02-14" or "2009-12-25 13:45:20"
	 */
	public static String formatDate2(String Date) {
		if ((null != Date) && (!(Date.equals(""))) && (Date.length() == 8)
				&& !isNaN(Date)) {
			Date = Date.substring(0, 4) + "-" + Date.substring(4, 6) + "-"
					+ Date.substring(6, 8);
		} else if ((null != Date) && (!(Date.equals("")))
				&& (Date.length() == 14) && !isNaN(Date)) {
			Date = Date.substring(0, 4) + "-" + Date.substring(4, 6) + "-"
					+ Date.substring(6, 8) + " " + Date.substring(8, 10) + ":"
					+ Date.substring(10, 12) + ":" + Date.substring(12, 14);
		}
		return Date;
	}

	/**
	 * 
	 * 2012-8-7  判断�?��入的字符串是否是数字，不是：true；是：false
	 * 
	 * @param num
	 *            �?��判断的字符串
	 * @return 是否是数�?
	 */
	public static boolean isNaN(String num) {
		String number = "1234567890";
		for (int i = 0; i < num.length(); i++) {
			if (number.indexOf(num.charAt(i)) == -1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * 2012-8-7  返回dateString指定部分的�?，如果是week则返回周的第几天
	 * 
	 * @param dateString
	 *            日期字符�?
	 * @param part
	 *            指明�?��返回的是日期哪个部分的�?
	 * @return 指定部分的�?
	 */
	public static String getPart(String dateString, String part) {
		// yyyy-MM-dd HH:mm:ss
		String result = "";
		String[] parts = dateString.split("-| |:");
		if (parts.length >= 0 && part.equalsIgnoreCase("year")) {
			result = parts[0];
		}
		if (parts.length >= 1 && part.equalsIgnoreCase("month")) {
			result = parts[1];
		}
		if (part.equalsIgnoreCase("week")) {
			try {
				Calendar c = Calendar.getInstance();
				c.setTime(DateUtil.parseDate(dateString));
				result = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
			} catch (Exception e) {
				return "0";
			}
		}
		if (parts.length >= 2 && part.equalsIgnoreCase("day")) {
			result = parts[2];
		}
		if (parts.length >= 3 && part.equalsIgnoreCase("Hour")) {
			result = parts[3];
		}
		if (parts.length >= 4 && part.equalsIgnoreCase("minute")) {
			result = parts[4];
		}
		if (parts.length >= 5 && part.equalsIgnoreCase("second")) {
			result = parts[5];
		}
		return result;
	}

	/**
	 * 
	 * 2012-8-7  将yyyy-MM-dd hh:mm:ss转换成yyyymmddhhmmss格式
	 * 
	 * @param dateString
	 *            �?��转化的日期字�?
	 * @return 转化后的日期字符
	 */
	public static String formateToNumber(String dateString) {
		String result = null;
		if (dateString == null || dateString.trim().equals("")) {
			result = "";
		} else {
			result = dateString.replaceAll("[- :]", "");
		}
		return result;
	}

	/**
	 * 
	 * 2012-8-7  验证yyyyMMddHHmmss型字符串是否为合法的时间
	 * 
	 * @param time
	 *            �?��验证的日期字�?
	 * @return 验证结果
	 */
	public static boolean isTrueTime(String time) {

		boolean b = true;

		// 判断是否全为数字
		if (isNaN(time))
			return false;

		// 根据位数做不同的验证
		int length = time.length();
		if (length == 12) {// 不包含秒
			b = isTrueTimeExceptSecond(time);
		} else if (length == 14) {
			boolean bSecond = true;
			int second = Integer.parseInt(time.substring(12, 14));// 获取�?
			if (second < 0 || second > 59) {// 秒超出范�?
				bSecond = false;
			}
			b = isTrueTimeExceptSecond(time) && bSecond;
		} else {
			b = false;
		}
		return b;
	}

	/**
	 * 
	 * 2012-8-7  验证yyyyMMddHHmm型字符串是否为合法的时间
	 * 
	 * @param time
	 *            �?��验证的日期字�?
	 * @return 验证结果
	 */
	private static boolean isTrueTimeExceptSecond(String time) {

		// 年月�?�?�?
		int year = Integer.parseInt(time.substring(0, 4));
		int month = Integer.parseInt(time.substring(4, 6));
		int day = Integer.parseInt(time.substring(6, 8));
		int hour = Integer.parseInt(time.substring(8, 10));
		int minute = Integer.parseInt(time.substring(10, 12));

		if (month < 1 || month > 12 || day < 1 || day > 31) {// 月份和日期超出范�?
			return false;
		}

		if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {// 时分超出范围
			return false;
		}

		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {// 闰年
			return checkDay(true, month, day);
		} else {
			return checkDay(false, month, day);
		}

	}

	/**
	 * 
	 * 2012-8-7  验证小月天数是否超出范围
	 * 
	 * @param isLeapYear
	 *            是否为闰�?
	 * @param month
	 *            月份
	 * @param day
	 *            日期
	 * @return
	 */
	private static boolean checkDay(boolean isLeapYear, int month, int day) {
		boolean b = true;
		int count = 28;
		if (isLeapYear == true) {
			count = 29;
		}
		switch (month) {
		case 2:
			if (day > count) {
				b = false;
			}
			break;
		case 4:
			if (day > 30) {
				b = false;
			}
			break;
		case 6:
			if (day > 30) {
				b = false;
			}
			break;
		case 9:
			if (day > 30) {
				b = false;
			}
			break;
		case 11:
			if (day > 30) {
				b = false;
			}
			break;
		default:
			break;
		}
		return b;
	}
}
