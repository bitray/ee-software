package net.ray.web.ees.dao;

import java.util.List;

import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserAuthority;

public interface UserAuthorityDAO {
	public List<UserAuthority> getUserAuthoritiesByUser(User user);
}
