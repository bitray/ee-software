package net.ray.web.ees.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDAOH2 extends SqlSessionDaoSupport{
//	@Resource(name="sqlSessionFactoryh2")
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactoryh) {
		super.setSqlSessionFactory(sqlSessionFactoryh);
	}

}
