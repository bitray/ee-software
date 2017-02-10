package net.ray.web.ees.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ray.web.ees.dao.BaseDAO;
import net.ray.web.ees.dao.UserAuthorityDAO;
import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserAuthority;
@Repository("userAuthority")
public class UserAuthorityDAOImpl extends BaseDAO implements UserAuthorityDAO {

	@Override
	public List<UserAuthority> getUserAuthoritiesByUser(User user) {
		return this.getSqlSession().selectList("net.ray.web.ees.eo.UserAuthority.findByParams",user);
	}

}
