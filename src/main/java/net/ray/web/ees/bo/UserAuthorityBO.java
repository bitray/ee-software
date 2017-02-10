package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.eo.Menu;
import net.ray.web.ees.eo.User;

public interface UserAuthorityBO {
	public List<Menu> getMenuByUser(User user);
}
