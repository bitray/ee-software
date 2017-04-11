package net.ray.web.ees.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ray.web.ees.bo.MallBO;
import net.ray.web.ees.bo.TradeDailyBO;
import net.ray.web.ees.bo.TradeMonthlyBO;
import net.ray.web.ees.bo.TradeYearlyBO;
import net.ray.web.ees.bo.UserBO;
import net.ray.web.ees.db.eo.MallBase;
import net.ray.web.ees.db.eo.Person;
import net.ray.web.ees.db.eo.TradeDailyAchievement;
import net.ray.web.ees.db.eo.TradeMonthlyAchievement;
import net.ray.web.ees.db.eo.TradeYearAchievement;
import net.ray.web.ees.util.DateUtil;
import net.ray.web.ees.util.LocalCache;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource(name="userBO")
	public UserBO userBO;
	@Resource
	public MallBO mallBO;
	@Resource
	public TradeDailyBO tradeDailyBO;
	@Resource
	public TradeMonthlyBO tradeMonthlyBO;
	@Resource
	public TradeYearlyBO tradeYearlyBO;
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
			
			List<TradeDailyAchievement> achievements=tradeDailyBO.getDailyTradeYesterday(Boolean.FALSE);
			List<TradeDailyAchievement> mallAchievements=tradeDailyBO.getDailyTradeYesterday(Boolean.TRUE);
			int yesterdayCustomers=0;
			float yesterdaySales=0f;
			for(TradeDailyAchievement mallAchievement:mallAchievements){
				yesterdayCustomers+=mallAchievement.getCustomerVolume();
				yesterdaySales+=mallAchievement.getSalesAmount();
			}
			request.setAttribute("achievements", achievements);
			request.setAttribute("yesterdayCustomers", yesterdayCustomers);
			request.setAttribute("yesterdaySales", yesterdaySales);
			
			TradeMonthlyAchievement params=new TradeMonthlyAchievement();
			params.setTradeId(11);
			params.setSaleMonth(new Date());
			List<TradeMonthlyAchievement> monthlyAchievements=tradeMonthlyBO.getMonthlyAchievementBycondition(params);
			int monthCustomers=0;
			float monthSales=0f;
			for(TradeMonthlyAchievement monthlyTrade:monthlyAchievements){
				monthCustomers+=monthlyTrade.getCustomerVolume();
				monthSales+=monthlyTrade.getSalesAmount();
			}
			request.setAttribute("monthCustomers", monthCustomers);
			request.setAttribute("monthSales", monthSales);

			TradeYearAchievement param=new TradeYearAchievement();
			param.setTradeId(11);
			param.setSaleYear(DateUtil.getCurrentYear());
			int yearCustomers=0;
			float yearSales=0f;
			List<TradeYearAchievement> yearAchievements=tradeYearlyBO.getTradeYearAchievementsByCondition(param);
			for(TradeYearAchievement yearAchievement:yearAchievements){
				yearCustomers+=yearAchievement.getCustomerVolume();
				yearSales+=yearAchievement.getSalesAmount();
			}
			request.setAttribute("yearCustomers", yearCustomers);
			request.setAttribute("yearSales", yearSales);
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
	
	
	@RequestMapping("/customer_volume")
	@ResponseBody
	public List<TradeDailyAchievement> getCustomerVolume(){
		List<TradeDailyAchievement> achievements=tradeDailyBO.getDailyTradeByIdForCurrentWeek(11);
		return achievements;
	}
	
	@RequestMapping("/data_enter")
	public String pageEnterInit(HttpServletRequest request){
		return "page_enter";
	}
}
