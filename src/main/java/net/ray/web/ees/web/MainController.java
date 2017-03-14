package net.ray.web.ees.web;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ray.web.ees.bo.MallBO;
import net.ray.web.ees.bo.UserBO;
import net.ray.web.ees.db.eo.MallBase;
import net.ray.web.ees.db.eo.Person;
import net.ray.web.ees.util.LocalCache;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource(name="userBO")
	public UserBO userBO;
	@Resource
	public MallBO mallBO;
	
	@RequestMapping("/init")
	public String mainInit(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
		String userId=null;
		for(Cookie cookie : cookies){
		    String name=cookie.getName();// get the cookie name
		    String value=cookie.getValue(); // get the cookie value
		    if("currentUser".equals(name)){
		    	userId=value;
		    	break;
		    }
		}
		if(userId!=null){
			Person currentUser=LocalCache.getCurrentMap().get(userId);
			request.setAttribute("currentUser", currentUser);
			request.setAttribute("currentDate", new Date());
			
			MallBase mallBase=mallBO.getMallById(currentUser.getMallId());
			request.setAttribute("mall", mallBase);
			int days=countDaysBetweenTwoDate(mallBase.getProOpenDate(),new Date());
			request.setAttribute("openDays", days);
//			String timeString=getDurationBetweenTwoDate(mallBase.getProOpenDate(),new Date());
//			System.out.println(timeString);
		}
		return "welcome";
	}
	
	private int countDaysBetweenTwoDate(Date fromDate, Date toDate){
		int days=0;
		long d1=fromDate.getTime();
		long d2=toDate.getTime();
		days=(int)((d2-d1)/(1000*60*60*24));
		return days;
	}
	
	private String getDurationBetweenTwoDate(Date fromDate, Date toDate){
		String timeString=null;
		int[] result=new int[3];
		Calendar fromCalendar=Calendar.getInstance();
		fromCalendar.setTime(fromDate);
		Calendar toCalendar=Calendar.getInstance();
		toCalendar.setTime(toDate);
		result[0]=toCalendar.get(Calendar.YEAR)-fromCalendar.get(Calendar.YEAR);
		result[1]=toCalendar.get(Calendar.MONTH)-fromCalendar.get(Calendar.MONTH);
		result[2]=toCalendar.get(Calendar.DAY_OF_MONTH)-fromCalendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(fromDate);
		timeString=result[0]+"年，"+result[1]+"月，"+result[2]+"天";
		return timeString;
	}
	
	@RequestMapping("/data_enter")
	public String pageEnterInit(HttpServletRequest request){
		return "page_enter";
	}
}
