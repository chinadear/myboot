package com.bootplus.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}

	public static String getTimeStampMS() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}

	public static String getDateTime(Date date) {
		if(date==null){
			return "";
		}
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	public static String getCurYear() {
		return new SimpleDateFormat("yyyy").format(new Date());
	}
	public static String getCurMonth() {
		return new SimpleDateFormat("MM").format(new Date());	
	}
	public static String getCurDay() {
		return new SimpleDateFormat("dd").format(new Date());
	}
	public static String getDate(Date date){
		if(date==null){
			return "";
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static String objectToDate(Object object){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(object==null){
			return "";
		}
		
		if( object instanceof Date){
			return sf.format(object);

		}else {
		    //考虑是String类型
		    try{
		    	return sf.format(sf.parse(object.toString()));        
		    }catch(Exception e){
		       e.printStackTrace();
		    }
		    
		}
		return "";
	}
	
	public static String getDateAndWeek(Date date){
		return new SimpleDateFormat("yyyy-MM-dd(E)").format(date);
	}
	
	
	public static String getDateWith(Date date){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	}
	
	
	public static String getDateTimeAndWeek(Date date){
		return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss(E)").format(date);
	}
/*	
	public static String getDateTime(Date date){
		if(date!=null){
			return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);
		}
		return "";
	}*/
	
	
	public static String getNow(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	

	public static Date toDate(String date) {
		return toDate(date,null);
	}
	
	public static Date toDateTime(String date) {
		return toDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	public static Date toDate(String date, String pattern) {
		if (("" + date).equals("")) {
			return null;
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date newDate = new Date();
		try {
			newDate = sdf.parse(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return newDate;
	}
	


	public static String toString(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		String dateString = "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			dateString = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dateString;
	}

	public static String toString(Long time, String pattern) {
		if (time.longValue() > 0L) {
			if (time.toString().length() == 10) {
				time = Long.valueOf(time.longValue() * 1000L);
			}
			Date date = new Date(time.longValue());
			String str = toString(date, pattern);
			return str;
		}
		return "";
	}

	public static String[] getLastMonth() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(1);
		int month = cal.get(2) + 1;

		cal.set(5, 1);

		cal.add(5, -1);

		int day = cal.get(5);

		String months = "";
		String days = "";
		if (month > 1) {
			month--;
		} else {
			year--;
			month = 12;
		}
		if (String.valueOf(month).length() <= 1) {
			months = "0" + month;
		} else {
			months = String.valueOf(month);
		}
		if (String.valueOf(day).length() <= 1) {
			days = "0" + day;
		} else {
			days = String.valueOf(day);
		}
		String firstDay = "" + year + "-" + months + "-01";
		String lastDay = "" + year + "-" + months + "-" + days;

		String[] lastMonth = new String[2];
		lastMonth[0] = firstDay;
		lastMonth[1] = lastDay;

		return lastMonth;
	}

	public static String[] getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(1);
		int month = cal.get(2) + 1;

		int notMonth = cal.get(2) + 2;

		cal.set(5, 1);

		cal.add(5, -1);

		String months = "";
		String nextMonths = "";
		if (String.valueOf(month).length() <= 1) {
			months = "0" + month;
		} else {
			months = String.valueOf(month);
		}
		if (String.valueOf(notMonth).length() <= 1) {
			nextMonths = "0" + notMonth;
		} else {
			nextMonths = String.valueOf(notMonth);
		}
		String firstDay = "" + year + "-" + months + "-01";
		String lastDay = "" + year + "-" + nextMonths + "-01";
		String[] currentMonth = new String[2];
		currentMonth[0] = firstDay;
		currentMonth[1] = lastDay;

		return currentMonth;
	}

	public static int getDateline() {
		return (int) (System.currentTimeMillis() / 1000L);
	}

	public static long getDatelineLong() {
		return System.currentTimeMillis() / 1000L;
	}

	public static int getDateline(String date) {
		return (int) (toDate(date, "yyyy-MM-dd").getTime() / 1000L);
	}

	public static int getDateline(String date, String pattern) {
		return (int) (toDate(date, pattern).getTime() / 1000L);
	}

	public static long getDatelineLong(String date) {
		return toDate(date, "yyyy-MM-dd").getTime() / 1000L;
	}

	public static void main(String[] args) {
		System.out.println(); 
	}
}
