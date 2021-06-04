package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/** 毫秒 */
	public final static long MS = 1;
	/** 每秒钟的毫秒数 */
	public final static long SECOND_MS = MS * 1000;
	/** 每分钟的毫秒数 */
	public final static long MINUTE_MS = SECOND_MS * 60;
	/** 每小时的毫秒数 */
	public final static long HOUR_MS = MINUTE_MS * 60;
	/** 每天的毫秒数 */
	public final static long DAY_MS = HOUR_MS * 24;
	/** 标准日期格式 */
	public final static String NORM_DATE_PATTERN = "yyyyMMdd";
	/** 标准时间格式 */
	public final static String NORM_TIME_PATTERN = "HH:mm:ss";
	/** 标准日期时间格式 */
	public final static String NORM_DATETIME_PATTERN = "yyyyMMddHHmmss";
    
	
	/** 标准日期（不含时间）格式化器 */
	private final static SimpleDateFormat NORM_DATE_FORMAT = new SimpleDateFormat(NORM_DATE_PATTERN);
	/** 标准时间格式化器 */
	private final static SimpleDateFormat NORM_TIME_FORMAT = new SimpleDateFormat(NORM_TIME_PATTERN);
	/** 标准日期时间格式化器 */
	private final static SimpleDateFormat NORM_DATETIME_FORMAT = new SimpleDateFormat(NORM_DATETIME_PATTERN);
	
	/**
	 * 当前时间，格式 yyyyMMddHHmmss
	 * @return 当前时间的标准形式字符串
	 */
	public static String now() {
		return formatDateTime(new Date());
	}
	
	/**
	 * 当前日期，格式 yyyyMMdd
	 * @return 当前日期的标准形式字符串
	 */
	public static String today() {
		return formatDate(new Date());
	}
	
	// ------------------------------------ Format start ----------------------------------------------
	/**
	 * 根据特定格式格式化日期
	 * @param date 被格式化的日期
	 * @param format 格式
	 * @return 格式化后的字符串
	 */
	public static String format(Date date, String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * 格式 yyyyMMddHHmmss
	 * @param date 被格式化的日期
	 * @return 格式化后的日期
	 */
	public static String formatDateTime(Date date) {
		return NORM_DATETIME_FORMAT.format(date);
	}
	
	/**
	 * 格式 yyyyMMdd
	 * @param date 被格式化的日期
	 * @return 格式化后的字符串
	 */
	public static String formatDate(Date date) {
		return NORM_DATE_FORMAT.format(date);
	}
	// ------------------------------------ Format end ----------------------------------------------
	
	// ------------------------------------ Parse start ----------------------------------------------
	/**
	 * 将特定格式的日期转换为Date对象
	 * @param dateString 特定格式的日期
	 * @param format 格式，例如yyyyMMdd
	 * @return 日期对象
	 */
	public static Date parse(String dateString, String format){
		try {
			return (new SimpleDateFormat(format)).parse(dateString);
		} catch (ParseException e) {
//			log.error("Parse " + dateString + " with format " + format + " error!", e);
		}
		return null;
	}
	
	/**
	 * 格式yyyyMMddHHmmss
	 * @param dateString 标准形式的时间字符串
	 * @return 日期对象
	 */
	public static Date parseDateTime(String dateString){
		try {
			return NORM_DATETIME_FORMAT.parse(dateString);
		} catch (ParseException e) {
//			log.error("Parse " + dateString + " with format " + NORM_DATETIME_FORMAT.toPattern() + " error!", e);
		}
		return null;
	}
	
	/**
	 * 格式yyyyMMdd
	 * @param dateString 标准形式的日期字符串
	 * @return 日期对象
	 */
	public static Date parseDate(String dateString){
		try {
			NORM_DATE_FORMAT.setLenient(false);
			return NORM_DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
//			log.error("Parse " + dateString + " with format " + NORM_DATE_PATTERN + " error!", e);
		}
		return null;
	}
	
	/**
	 * 格式HH:mm:ss
	 * @param timeString 标准形式的日期字符串
	 * @return 日期对象
	 */
	public static Date parseTime(String timeString){
		try {
			return NORM_TIME_FORMAT.parse(timeString);
		} catch (ParseException e) {
//			log.error("Parse " + timeString + " with format " + NORM_TIME_PATTERN + " error!", e);
		}
		return null;
	}
	
	/**
	 * 格式：<br>
	 * 1、yyyyMMddHHmmss<br>
	 * 2、yyyyMMdd<br>
	 * 3、HH:mm:ss>
	 * @param dateStr 日期字符串
	 * @return 日期
	 */
	public static Date parse(String dateStr) {
		int length = dateStr.length();
		try {
			if(length == DateUtil.NORM_DATETIME_PATTERN.length()) {
				return parseDateTime(dateStr);
			}else if(length == DateUtil.NORM_DATE_PATTERN.length()) {
				return parseDate(dateStr);
			}else if(length == DateUtil.NORM_TIME_PATTERN.length()){
				return parseTime(dateStr);
			}
		}catch(Exception e) {
//			log.error("Parse " + dateStr + " with format normal error!", e);
		}
		return null;
	}
	// ------------------------------------ Parse end ----------------------------------------------
	
	// ------------------------------------ Offset start ----------------------------------------------
	
	/**
	 * 昨天
	 * @return 昨天
	 */
	public static Date yesterday() {
		return offsiteDate(new Date(), Calendar.DAY_OF_YEAR, -1);
	}
	
	/**
	 * 明天
	 * @return 明天
	 */
	public static Date tomorrow() {
		return offsiteDate(new Date(), Calendar.DAY_OF_YEAR, 1);
	}
	
	/**
	 * 上周
	 * @return 上周
	 */
	public static Date lastWeek() {
		return offsiteDate(new Date(), Calendar.WEEK_OF_YEAR, -1);
	}
	
	/**
	 * 上个月
	 * @return 上个月
	 */
	public static Date lastMouth() {
		return offsiteDate(new Date(), Calendar.MONTH, -1);
	}
	
	/**
	 * 获取指定日期偏移指定时间后的时间
	 * @param date 基准日期
	 * @param calendarField 偏移的粒度大小（小时、天、月等）使用Calendar中的常数
	 * @param offsite 偏移量，正数为向后偏移，负数为向前偏移
	 * @return 偏移后的日期
	 */
	public static Date offsiteDate(Date date, int calendarField, int offsite){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(calendarField, offsite);
		return cal.getTime();
	}
	// ------------------------------------ Offset end ----------------------------------------------
	
	/**
	 * 判断两个日期相差的时长<br/>
	 * 返回 minuend - subtrahend 的差
	 * @param subtrahend 减数日期
	 * @param minuend 被减数日期
	 * @param diffField 相差的选项：相差的天、小时
	 * @return 日期差
	 */
	public static long diff(Date subtrahend, Date minuend, long diffField){ 
	  long diff = minuend.getTime() - subtrahend.getTime();
	  return diff/diffField; 
	}
	
	/**
	 * 计时，常用于记录某段代码的执行时间，单位：纳秒
	 * @param preTime 之前记录的时间
	 * @return 时间差，纳秒
	 */
	public static long spendNt(long preTime) {
		return System.nanoTime() - preTime;
	}
	
	/**
	 * 计时，常用于记录某段代码的执行时间，单位：毫秒
	 * @param preTime 之前记录的时间
	 * @return 时间差，毫秒
	 */
	public static long spendMs(long preTime) {
		return System.currentTimeMillis() - preTime;
	}

	public static void main(String[] args) {
		Date date = DateUtil.parseDate("20191232");
		System.out.println(date);
	}
}