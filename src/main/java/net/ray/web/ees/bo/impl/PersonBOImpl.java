package net.ray.web.ees.bo.impl;

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


}
