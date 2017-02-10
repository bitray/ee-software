package net.ray.web.ees.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import net.ray.web.ees.dao.BaseDAOH2;
import net.ray.web.ees.dao.UserH2DAO;
import net.ray.web.ees.eo.UserH2;

//@Repository("user_h2")
public class UserH2DAOImpl extends SqlSessionDaoSupport implements UserH2DAO {

	@Override
	public List<UserH2> getAllUsers() {
		return this.getSqlSession().selectList("net.ray.web.ees.eo.UserH2.findByParams");
	}

	@Override
	public boolean insertUserH2(UserH2 userH2) {
		int i=this.getSqlSession().insert("net.ray.web.ees.eo.UserH2.insertUser", userH2);
		if(i>0){
			throw new RuntimeException("test");
		}
		return i>0;
	}

}
