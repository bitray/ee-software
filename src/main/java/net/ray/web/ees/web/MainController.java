package net.ray.web.ees.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ray.web.ees.bo.UserBO;

@Controller
@RequestMapping("/main")
public class MainController {
	@Resource(name="userBO")
	public UserBO userBO;
	
	@RequestMapping("/init")
	public String mainInit(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
		for(Cookie cookie : cookies){
		    cookie.getName();// get the cookie name
		    cookie.getValue(); // get the cookie value
		    System.out.println(cookie.getName());
		    System.out.println(cookie.getValue());
		}
		return "welcome";
	}
	
	@RequestMapping("/data_enter")
	public String pageEnterInit(HttpServletRequest request){
		return "page_enter";
	}
}
