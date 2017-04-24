package net.ray.web.ees.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import net.ray.web.ees.db.eo.Person;

public class CookieUtil {
	public static Person getCurrentUser(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if ("currentUser".equals(name)) {
				userId = value;
				break;
			}
		}
		Person currentUser = LocalCache.getCurrentMap().get(userId);
		return currentUser;
	}
	
	public static String getCurrentUserId(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		String userId = null;
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if ("currentUser".equals(name)) {
				userId = value;
				break;
			}
		}
		return userId;
	}
}
