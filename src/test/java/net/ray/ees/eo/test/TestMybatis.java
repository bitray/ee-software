package net.ray.ees.eo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import junit.framework.TestCase;
import net.ray.web.ees.eo.User;
import net.ray.web.ees.eo.UserH2;

public class TestMybatis extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}


	public void testMybatis(){
		
		String resource = "mybatis.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlsession=sqlSessionFactory.openSession();
		User user=sqlsession.selectOne("net.ray.web.ees.eo.User.findById", 1);
		System.out.println(user.getPersonName());
		
		String resourceh2 = "mybatish2.xml";
		InputStream inputStream2=null;
		try {
			inputStream2 = Resources.getResourceAsStream(resourceh2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory2 = new SqlSessionFactoryBuilder().build(inputStream2);
		SqlSession sqlsession2=sqlSessionFactory2.openSession();
		UserH2 userh2=sqlsession2.selectOne("net.ray.web.ees.eo.UserH2.findById", 1);
		System.out.println(userh2.getName());
	}
}
