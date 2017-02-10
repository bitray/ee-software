package net.ray.web.ees.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.ray.web.ees.dao.BaseDAO;
import net.ray.web.ees.dao.UserDAO;
import net.ray.web.ees.db.dao.PersonMapper;
import net.ray.web.ees.db.eo.Person;
import net.ray.web.ees.eo.User;

@Repository("userd")
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public User getUserById(Integer id) {
		return this.getSqlSession().selectOne("net.ray.web.ees.eo.User.findById", id);
	}

	@Override
	public List<User> getAllUsers() {
		return this.getSqlSession().selectList("net.ray.web.ees.eo.User.findByParams");
	}

	@Override
	public boolean insertUser(User user) {
		int i=this.getSqlSession().insert("net.ray.web.ees.eo.User.insertUser", user);
		return i>0;
	}

	@Override
	public User getUser(User user) {
		return this.getSqlSession().selectOne("net.ray.web.ees.eo.User.findByParams", user);
	}
	
}
