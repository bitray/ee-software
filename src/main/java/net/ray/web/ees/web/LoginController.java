package net.ray.web.ees.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ray.web.ees.bo.FloorBO;
import net.ray.web.ees.bo.PersonBO;
import net.ray.web.ees.bo.UserBO;
import net.ray.web.ees.db.eo.Floors;
import net.ray.web.ees.db.eo.Person;
import net.ray.web.ees.eo.User;
import net.ray.web.ees.util.LocalCache;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource(name="personBO")
	public PersonBO personBO;
	
	@Resource(name="floorBO")
	private FloorBO floorBO;
	
	@RequestMapping("/t1")
	public String lgoinInit(HttpServletRequest request){
		return "login";
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	/**
	 * result:1是成功，2是失败，3是user不存在
	 * @param personName
	 * @param password
	 * @return
	 */
	public String login(String personName,String password,HttpServletRequest request,HttpServletResponse response){
		boolean isUserExisted=personBO.isUserExisted(personName);
		String isSuccess="";
		if(isUserExisted){
			Person user=new Person();
			user.setLoginName(personName);
			user.setPassword(password);
			Person returnUser=personBO.getUser(user);
			isSuccess=returnUser!=null?"1":"2";
			if(returnUser!=null){
				Cookie cookie = new Cookie("loginInfo","loginSuccess");
				cookie.setPath("/");
				response.addCookie(cookie);
				
				List<Floors> floors=floorBO.getFloors();
				LocalCache.setFloors(floors);
			}
		}else{
			isSuccess="3";
		}
		return isSuccess;
	}
}
