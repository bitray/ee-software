package net.ray.web.ees.dao;

import java.util.List;

import net.ray.web.ees.eo.User;

public interface UserDAO {
	public User getUserById(Integer id);
	public List<User> getAllUsers();
	public boolean insertUser(User user);
	public User getUser(User user);
}
