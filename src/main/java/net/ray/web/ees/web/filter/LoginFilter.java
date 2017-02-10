package net.ray.web.ees.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp =(HttpServletResponse) response;
		String path = req.getRequestURI();
		System.out.println(path);
		Cookie[] cookies = req.getCookies();//这样便可以获取一个cookie数组
		for(Cookie cookie : cookies){
		    String name=cookie.getName();// get the cookie name
		    String value=cookie.getValue(); // get the cookie value
		    System.out.println(cookie.getName());
		    System.out.println(cookie.getValue());
		    if("loginInfo".equals(name)&&"loginSuccess".equals(value)){
		    	chain.doFilter(request, response);
		    }else{
		    	resp.sendRedirect("/login/t1");
		    }
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
