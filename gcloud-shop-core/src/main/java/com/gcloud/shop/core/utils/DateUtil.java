package com.gcloud.shop.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ChenJin
 * @version V1.0
 * @Title: AreaServiceImpl
 * @Package com.gcloud.api
 * @Description: 地址Service
 * @date 2016/6/1 13:53
 */
public class DateUtil {
	
	public static java.sql.Date parseSqlDate(Date date) {
		if (date != null)
			return new java.sql.Date(date.getTime());
		else
			return null;
	}

	/**
	 * 格式化输出日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		String str="yyyy-MM-dd HH:mm:ss";
		if(format!=null&&!format.equals("")) str=format;
		try {
			if (date != null) {
				java.text.DateFormat df = new SimpleDateFormat(str);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static String format(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 返回年份
	 * 
	 * @param date
	 *            日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 返回月份
	 * 
	 * @param date
	 *            日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH) + 1;
	}

	/**
	 * 返回日份
	 * 
	 * @param date
	 *            日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 返回分钟
	 * @param date
	 * 日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 返回字符型时间
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型时间
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}


	/**
	 * 日期相加
	 * 
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
		return c.getTime();
	}

	/**
	 * 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回date - date1 相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}
	
	/**
	 * 日期相减
	 * 
	 * @param date
	 *            日期
	 * @param date1
	 *            日期
	 * @return 返回date - date1 相减后的日期
	 */
	public static int diffDate(String date, String date1) {
		if(date == null || date1 == null) return 0;
		return (int) ((getMillis(getDate(date)) - getMillis(getDate(date1))) / (24 * 3600 * 1000));
	}
	
	/**
	 * 判断日期是否比现在靠后
	 * @param date
	 * @return
	 */
	public static boolean isbefortoday(Date date){
		boolean ok=true;
		if(getMillis(date)-getMillis(new Date())>60000){
			ok=false;
		}
		return ok;
	}
	
	
	
	/**
	 * 返回日期与今天相差的天数 today-datestr
	 * @param datestr
	 * @return
	 */
	public static int diffDate(String datestr){
		
		return (int) ((getMillis(new Date()) - getMillis(getDate(datestr))) / (24 * 3600 * 1000));
	}
	
	public static boolean isSameDay(Date date, Date date1) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date);
		c2.setTime(date1);
		int c1_day = c1.get(Calendar.DAY_OF_YEAR);
		int c1_y = c1.get(Calendar.YEAR);

		int c2_day = c2.get(Calendar.DAY_OF_YEAR);
		int c2_y = c2.get(Calendar.YEAR);
		
		if(c1_day == c2_day && c1_y == c2_y) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public static Date getDate(String datestr) {
		String format="";
			if(datestr.length()<=10) {
				format="yyyy-MM-dd";
			}else {
				format="yyyy-MM-dd HH:mm:ss";
			}
		SimpleDateFormat sd=new SimpleDateFormat(format);
		try {
			Date d = sd.parse(datestr);
			return d;
		} catch (ParseException e) {
			return null;
		}
		
	}
	

	public static Date getDate(String datestr, String format) {
		
		SimpleDateFormat sd=new SimpleDateFormat(format);
		try {
			Date d = sd.parse(datestr);
			return d;
		} catch (ParseException e) {
			return null;
		}
		
	}
	
	/**
	 * 返回星期几
	 * @author HJ
	 */
	public static String getWeek(Date date) {
		if(date==null)return "";
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return new SimpleDateFormat("EEEE").format(c.getTime());
	} 
	/**
	 * 返回相 加/减 的日期
	 * @author HJ
	 */
	public static String diffDate(Date date, int day, String stly){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setTimeInMillis(c.getTimeInMillis() + ((long) day) * 24 * 3600 * 1000);

		return format(c.getTime(),stly);
	}

	
	public static String diffDate(String date, int day, String stly){
		Calendar c = Calendar.getInstance();
		c.setTime(getDate(date, stly));
		c.setTimeInMillis(c.getTimeInMillis() + ((long) day) * 24 * 3600 * 1000);
		return format(c.getTime(), stly);
	}


	
}
