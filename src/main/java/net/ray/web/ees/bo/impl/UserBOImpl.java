package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ray.web.ees.bo.UserBO;
import net.ray.web.ees.dao.UserDAO;
import net.ray.web.ees.dao.UserH2DAO;
import net.ray.web.ees.db.dao.PersonMapper;
import net.ray.web.ees.db.eo.Person;
import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserH2;

@Service("userBO")
public class UserBOImpl implements UserBO {

	@Resource(name = "userd")
	private UserDAO userDao;
//	@Resource(name = "user_h2")
	private UserH2DAO h2Dao;
	@Resource
	private PersonMapper personMapper;
	
	@Override
	public String getUserNameById(Integer id) {
		User user = userDao.getUserById(id);
		return user.getPersonName();
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<UserH2> getAllH2Users() {
		return h2Dao.getAllUsers();
	}

	@Override
	@Transactional(rollbackFor=RuntimeException.class)
	public String addUsers() {
		User user = new User();
		user.setPersonName("tt1");
		user.setPassword("tt1");
		user.setPersonNumber("1092");
		UserH2 userH2 = new UserH2();
		userH2.setId(5);
		userH2.setName("te5");
		boolean b1 = userDao.insertUser(user);
		boolean b2 = h2Dao.insertUserH2(userH2);
		return String.valueOf(b1 & b2);
	}

	@Override
	public User getUser(User user) {
		return userDao.getUser(user);
	}

	@Override
	public boolean isUserExisted(String userName) {
		User parameter = new User();
		parameter.setLoginName(userName);
		User user=userDao.getUser(parameter);
		return user!=null;
	}

}
