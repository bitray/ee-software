package net.ray.web.ees.dao;

import java.util.List;

import net.ray.web.ees.eo.UserH2;

public interface UserH2DAO {
	public List<UserH2> getAllUsers();
	public boolean insertUserH2(UserH2 userH2);
}
