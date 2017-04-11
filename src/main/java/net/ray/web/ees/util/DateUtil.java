package net.ray.web.ees.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	public static Date[] getCurrentWeek(){
		Date[] duration=new Date[2];
		Calendar currentDate = new GregorianCalendar();   
		currentDate.setFirstDayOfWeek(Calendar.MONDAY);  
		currentDate.set(Calendar.HOUR_OF_DAY, 0);  
		currentDate.set(Calendar.MINUTE, 0);  
		currentDate.set(Calendar.SECOND, 0);  
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		duration[0]=currentDate.getTime();
		currentDate.set(Calendar.HOUR_OF_DAY, 23);  
		currentDate.set(Calendar.MINUTE, 59);  
		currentDate.set(Calendar.SECOND, 59);  
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		duration[1]=currentDate.getTime();
		return duration;
	}
	
	public static Date getYesterday(){
		Date yesterday=new Date();
		Calendar currentDate=Calendar.getInstance();
		currentDate.setTime(yesterday);
		currentDate.set(Calendar.HOUR_OF_DAY, 0);  
		currentDate.set(Calendar.MINUTE, 0);  
		currentDate.set(Calendar.SECOND, 0);  
		currentDate.add(Calendar.DAY_OF_YEAR, -1);
		return currentDate.getTime();
	}
	
	public static String getCurrentYear(){
		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("yyyy");
		String yearStr=dateFormat.format(date);
		return yearStr;
	}
	
	public static void main(String[] args) {
		Date[] duration=DateUtil.getCurrentWeek();
		System.out.println(duration[0]);
		System.out.println(duration[1]);
		Date yesterday=DateUtil.getYesterday();
		System.out.println(yesterday);
		
		System.out.println(DateUtil.getCurrentYear());
	}
}
