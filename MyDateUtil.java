package com.sicdt.sicsign.auth.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class MyDateUtil {

	public static SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 
	 * <br>
	 * 描 述: 返回当前日期 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		Date currentDate = null;
		long current = System.currentTimeMillis();// 当前时间毫秒数
		try {
			currentDate = formatTime.parse(formatTime.format(current));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return currentDate;
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回当前日期的字符串 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		long current = System.currentTimeMillis();// 当前时间毫秒数
		return formatTime.format(current);
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回今天零点零分零秒 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static Date getCurrentDateZero() {
		Date currentDateZero = null;
		long current = System.currentTimeMillis();// 当前时间毫秒数
		long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();// 今天零点零分零秒的毫秒数
		try {
			currentDateZero = formatTime.parse(formatTime.format(zero));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return currentDateZero;
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回今天零点零分零秒字符串 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static String getCurrentDateZeroString() {

		long current = System.currentTimeMillis();// 当前时间毫秒数
		long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();// 今天零点零分零秒的毫秒数

		return formatTime.format(zero);
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回昨天的当前时间 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static Date getYesterdayCurrentDate() {
		Date yesterdayDate = null;
		long yesterday = System.currentTimeMillis() - 24 * 60 * 60 * 1000;// 昨天的这一时间的毫秒数
		try {
			yesterdayDate = formatTime.parse(formatTime.format(yesterday));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return yesterdayDate;
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回昨天的当前时间字符串 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static String getYesterdayCurrentDateString() {
		long yesterday = System.currentTimeMillis() - 24 * 60 * 60 * 1000;// 昨天的这一时间的毫秒数
		return formatTime.format(yesterday);
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回去年的当前时间 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static Date getYesteryearCurrentDate() {

		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		// calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.add(Calendar.YEAR, -1);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回去年的当前时间 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @return
	 */
	public static String getYesteryearCurrentDateString() {

		Calendar calendar = Calendar.getInstance();
		Date date = new Date(System.currentTimeMillis());
		calendar.setTime(date);
		// calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.add(Calendar.YEAR, -1);
		date = calendar.getTime();
		return formatTime.format(date);
	}

	/**
	 * 
	 * <br>
	 * 描 述: 返回两个日期之间的日期差 <br>
	 * 作 者: xwj <br>
	 * 历 史: (版本) 作者 时间 注释
	 * 
	 * @param startDate
	 * @param endDate
	 * @param format：
	 *            "y-M-d-H-m-s" 例，返回 “0-11-28-0-0-0” 
	 *            "y-M-d" 例，返回 “0-11-28”
	 *            "y年M月d日" 例，返回 “0年11月28日” 
	 *            "y年M月d日 H时m分s秒" 例，返回 “0年11月28日0时0分0秒” 
	 *            "d日" 例，返回 “362日” 
	 *            "M月" 例，返回 “11月”
	 *            
	 * @return
	 */
	public static String betweenDays(Date startDate, Date endDate, String format) {
		if (null == startDate || null == endDate || StringUtils.isEmpty(format)) {
			return null;
		}
		if (null == startDate || null == endDate) {
			return null;
		}
		// 开始时间大于结束时间
		if(endDate.compareTo(startDate) < 0){
			Date temp = startDate;
			startDate = endDate;
			endDate = temp;
		}
		return DurationFormatUtils.formatPeriod(startDate.getTime(), endDate.getTime(), format);
	}
	
	
	public static String betweenDays2(Date startDate, Date endDate) {
		if (null == startDate || null == endDate) {
			return null;
		}
		// 开始时间大于结束时间
		if(endDate.compareTo(startDate) < 0){
			Date temp = startDate;
			startDate = endDate;
			endDate = temp;
		}		
		
		Calendar cs = Calendar.getInstance();
		cs.setTime(startDate);
		//获取起始年
		int years = cs.get(Calendar.YEAR);
		//获取起始月份，0表示1月份
		int months = cs.get(Calendar.MONTH) + 1;
		//获取起始天数
		int days = cs.get(Calendar.DAY_OF_MONTH);
		
		Calendar ce = Calendar.getInstance();
		ce.setTime(endDate);
		//获取终止年
		int yeare = ce.get(Calendar.YEAR);
		//获取终止月份，0表示1月份
		int monthe = ce.get(Calendar.MONTH) + 1;
		//获取终止天数
		int daye = ce.get(Calendar.DAY_OF_MONTH);
		
		int y = yeare - years;
		int m = monthe - months;
		int d = daye - days;
		// 其中月份小于起始月份的话，年减一，月份计算今年月份到上一年起始月份之间的差；
		// 否则，计算今年月份到今年起始月份的差
		if(monthe < months){
			y--;
			m = 12 - months + monthe;
		}
		// 日期小于起始日期的话，月份减一，日期计算昨天到上一个月起始日期之间的差；
		// 否则，计算昨天到本月起始日期的差；
		if(daye < days){
			m--;
			if(m < 0){
				m = 11;
				y--;
			}
			// 获取上月最大天数
			ce.add(Calendar.MONTH, -1);
			int last = ce.getActualMaximum(Calendar.DAY_OF_MONTH);
			d = last - days + daye;
		}		
		return y + "年" + m + "月" + d + "日";
	}
	
}
