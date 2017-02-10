package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserH2;

public interface UserBO {
	public String getUserNameById(Integer id);
	public List<User> getAllUsers();
	public List<UserH2> getAllH2Users();
	public String addUsers();
	public User getUser(User user);
	public boolean isUserExisted(String userName);
}
