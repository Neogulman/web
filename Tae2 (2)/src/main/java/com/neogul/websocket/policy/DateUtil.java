package com.neogul.websocket.policy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 현재 날짜 
	 */
	public static String fnToDay(String format){
		Date now = new Date();
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(now);
	}
	
	/**
	 * 특정일 날짜
	 */
	public static String fnDayReturn(String frm, int dcnt){
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		
		cal.add(Calendar.DATE, dcnt);
		
		SimpleDateFormat vans = new SimpleDateFormat(frm);
		String day = vans.format(cal.getTime());
		return day;
	}
	
	/**
	 * 날짜 차이 계산
	 */
	public static long fnDifference(int year, int month, int date, int hours, int minutes, int seconds){
		Calendar now = Calendar.getInstance();
		Calendar set= Calendar.getInstance();
		DateFormat df = DateFormat.getInstance();

		set.set(year, month-1, date, hours, minutes, seconds);
		
		//System.out.println(set.getTime()+" : "+now.getTime());
		//System.out.println(df.format(now.getTime()));
		//System.out.println(df.format(set.getTime()));
		long time = set.getTime().getTime() - now.getTime().getTime();
		return time;
	}
}
