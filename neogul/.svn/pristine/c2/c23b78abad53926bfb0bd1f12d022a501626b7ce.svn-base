package com.joheul.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {
	
	/**
	 * 현재 날짜
	 */
	public static String fnToDay(String format){
		Date now = new Date();
		SimpleDateFormat vans = new SimpleDateFormat(format);
		String today = vans.format(now);
		return today;
	}
	
	/**
	 * 현재 Month에 해당하는 파티션이름을 리턴
	 */
	public static String fnMonToPartion(){
		int month;
		String partition = "";
		Calendar cal = Calendar.getInstance();
		month = cal.get(Calendar.MONTH) + 1;
		
		partition = "p" + (month % 12);
		
		System.out.println("partition:" + partition + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return partition;
		
	}
	
	/**
	 * 인자로 주어진  Month에 해당하는 파티션이름을 리턴
	 */
	public static String fnMonToPartion(String date){
		int month= -1;
		String partition = "p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11";

		Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

		Matcher matcher = pattern.matcher(date);
		if (matcher.find()) {
			month = Integer.parseInt(matcher.group(2));
		}

		if (month != -1) {
			partition = "p" + (month % 12);
		}

		System.out.println("partition:" + partition + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return partition;
		
	}
	
	public static String fnMonthMaxDay(){
		Calendar cal = Calendar.getInstance();
		
		String year=String.valueOf(cal.get(Calendar.YEAR));
		String month=String.valueOf(cal.get(Calendar.MONTH)+1);
		String day=String.valueOf(cal.getMaximum(Calendar.DAY_OF_MONTH));

		String date=year+"-"+month+"-"+day;
		
		return date;
		
	};
	
	public static String fnMonthDateTime(int gap){
		String today = null;
		  
		  
		  Date date = new Date();
		  
		  
		  // 포맷변경 ( 년월일 시분초)
		  SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  
		  // Java 시간 더하기		  
		  Calendar cal = Calendar.getInstance();		  
		  cal.setTime(date);
		  // 10분 더하기
		  cal.add(Calendar.MINUTE, gap);
		  
		  today = sdformat.format(cal.getTime());  
		  
		return today;
		
	};
	
	/**
	 * 인자로 주어진 날짜 범위에 해당 하는 파티션 문자열을 리턴(ex, "p0,p1")
	 */
	public static String fnPartionRange(String start, String end) {
		int s_year = 0, e_year = 0, s_month = 0, e_month = 0, range=0;
		String partition = "";

		Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");

		Matcher matcher = pattern.matcher(start);
		if (matcher.find()) {
			s_year = Integer.parseInt(matcher.group(1));
			s_month = Integer.parseInt(matcher.group(2));
		}

		matcher = pattern.matcher(end);
		if (matcher.find()) {
			e_year = Integer.parseInt(matcher.group(1));
			e_month = Integer.parseInt(matcher.group(2));
		}

		range = (e_year * 12 + e_month) - (s_year * 12 + s_month) + 1;
		
		if(range >= 12 || s_year == 0 || e_year == 0 || s_month == 0 || e_month == 0)
		{
			partition = "p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11"; // All Partitions
			return partition;
		}
		
		
		while(range != 0){
			
			partition = partition + "p" + (s_month%12) + ",";
			s_month++;
			range--;
		}
		partition = partition.substring(0, partition.length() - 1); // 마지막 ','를  제거하기 위함
		
		System.out.println("partitionss:" + partition + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return partition;

	}
	
	/**
	 * 하루전 / 하루후 날짜
	 */
	public static String fnGapDay(String format, int day){
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		
		cal.add(Calendar.DATE, day);
		
		SimpleDateFormat vans = new SimpleDateFormat(format);
		String week = vans.format(cal.getTime());
		return week;
	}
	
	/**
	 * 한달전 / 한달후 날짜
	 */
	public static String fnMonthReturn(int year, int month, int date, String frm, int mcnt){
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, date);
		cal.add(Calendar.MONTH, mcnt);
		
		Date currentTime = cal.getTime();
		SimpleDateFormat vans = new SimpleDateFormat(frm);
		String day = vans.format(currentTime);
		return day;
	}
	
	/**
	 * 특정 날짜 요일 정보
	 */	
	public static String fnWeekStr(String date, String type) throws Exception {
		LanguageKr langu = new LanguageKr();
		String week = "";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(type) ;
	    Date nDate = dateFormat.parse(date) ;
	     
	    Calendar cal = Calendar.getInstance() ;
	    cal.setTime(nDate);
	     
	    int num = cal.get(Calendar.DAY_OF_WEEK) ;
	    
	    switch(num){
	    	case 1:
	        	week = langu.controller_view_57;
	        	break;
	        case 2:
	        	week = langu.controller_view_58;
	        	break;
	        case 3:
	        	week = langu.controller_view_59;
	        	break;
	        case 4:
	        	week = langu.controller_view_60;
	        	break;
	        case 5:
	        	week = langu.controller_view_61;
	        	break;
	        case 6:
	        	week = langu.controller_view_62;
	        	break;
	        case 7:
	        	week = langu.controller_view_63;
	        	break;
	    }
	    
	    return week;
	}
	
	/**
	 * 특정 날짜 요일 정보
	 */	
	public static int fnWeek(String date, String type) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(type) ;
	    Date nDate = dateFormat.parse(date) ;
	     
	    Calendar cal = Calendar.getInstance() ;
	    cal.setTime(nDate);
	     
	    int num = cal.get(Calendar.DAY_OF_WEEK) ;
	    return num;
	}
	
	 /**
	  * <p>GregorianCalendar 객체를 반환함.
	  * 
	  * @param yyyymmdd 날짜 인수
	  * @return GregorianCalendar
	  * @see java.util.Calendar 
	  * @see java.util.GregorianCalendar
	  * <p><pre>
	  *  - 사용 예
	  * Calendar cal = DateUtil.getGregorianCalendar(DateUtil.getCurrentYyyymmdd())
	  * </pre>
      */
	public static GregorianCalendar getGregorianCalendar(String yyyymmdd) {
	
	     int yyyy = Integer.parseInt(yyyymmdd.substring(0, 4));
	     int mm = Integer.parseInt(yyyymmdd.substring(4, 6));
	     int dd = Integer.parseInt(yyyymmdd.substring(6));
	
	     GregorianCalendar calendar = new GregorianCalendar(yyyy, mm - 1, dd, 0, 0, 0);
	
	     return calendar;
	
	}
	
	/** 
     * <p>두 날짜간의 날짜수를 반환(윤년을 감안함)
     * 
	 * @param startDate 시작 날짜
	 * @param endDate 끝 날짜
	 * @return 날수
     * @see java.util.GregorianCalendar 
     * <p><pre>
     *  - 사용 예
     * long date = DateUtil.getDifferDays("20080101","20080202")
     * </pre>
     */ 
	public static long getDifferDays(String startDate, String endDate) {

	    GregorianCalendar StartDate = getGregorianCalendar(startDate);
	    GregorianCalendar EndDate = getGregorianCalendar(endDate);
	    long difer = (EndDate.getTime().getTime() - StartDate.getTime().getTime()) / 86400000;
	    return difer;

    }
}