package net.ray.web.ees.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ray.web.ees.bo.UserBO;
import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserH2;

@Controller
@RequestMapping("/test")
public class TestController {
	 
	@Resource(name="userBO")
	public UserBO userBO;
	
	@RequestMapping("/t1")
	public String testResponse(HttpServletRequest request){
		String name=userBO.getUserNameById(2);
		request.setAttribute("userName", name);
		return "index";
	}
	
	@RequestMapping("/ajax")
	@ResponseBody
	public String testAjax(HttpServletRequest request,Integer id){
		String name=userBO.getUserNameById(id);
		return name;
	}
	
	@RequestMapping("/t2")
	public String easyUiTest(HttpServletRequest request){
		List<User> users=userBO.getAllUsers();
		request.setAttribute("list", users);
		return "grid";
	}
	
	@RequestMapping("/t3")
	public String testH2(HttpServletRequest request){
		List<UserH2> users=userBO.getAllH2Users();
		request.setAttribute("list", users);
		System.out.println(users.get(0).getName());
		return "testAdd";
	}
	
	@RequestMapping("/ajaxAdd")
	@ResponseBody
	public String ajaxAdd(HttpServletRequest request){
		String test=userBO.addUsers();
		return test;
	}
	
	@RequestMapping("/login")
	public String loginInit(){
		return "login";
	}
	
	@RequestMapping("/loginResult")
	@ResponseBody
	public String loginResult(String personName,String password){
		User user=new User();
		user.setLoginName(personName);
		user.setPassword(password);
		User returnUser=userBO.getUser(user);
		return returnUser!=null?"1":"2";
	}
}
