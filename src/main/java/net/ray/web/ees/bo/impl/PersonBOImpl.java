package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.PersonBO;
import net.ray.web.ees.db.dao.PersonMapper;
import net.ray.web.ees.db.eo.Person;
@Service("personBO")
public class PersonBOImpl implements PersonBO {

	@Resource
	private PersonMapper personMapper;
	
	@Override
	public Person getUser(Person person) {
		return personMapper.findByParams(person);
	}

	@Override
	public boolean isUserExisted(String userName) {
		Person parameter=new Person();
		parameter.setLoginName(userName);
		Person person=personMapper.findByParams(parameter);
		return person!=null;
	}

	@Override
	public List<Person> getUsers() {
		return personMapper.getAllUsers();
	}

	@Override
	public boolean insertUser(Person person) {
		int count=0;
		try{
			count=personMapper.insertSelective(person);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		int count=0;
		try{
			count=personMapper.deleteByPrimaryKey(userId);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return count>0;
	}

	@Override
	public boolean updateUser(Person person) {
		int count=0;
		try{
			count=personMapper.updateByPrimaryKeySelective(person);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return count>0;
	}


}
