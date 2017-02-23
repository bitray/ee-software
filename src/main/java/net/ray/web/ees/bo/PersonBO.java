package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.Person;

public interface PersonBO {
	public Person getUser(Person person);
	public boolean isUserExisted(String userName);
	public List<Person> getUsers();
	public boolean insertUser(Person person);
	public boolean deleteUserById(Integer userId);
	public boolean updateUser(Person person);
}
