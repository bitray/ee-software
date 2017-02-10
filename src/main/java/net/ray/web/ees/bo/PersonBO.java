package net.ray.web.ees.bo;

import net.ray.web.ees.db.eo.Person;

public interface PersonBO {
	public Person getUser(Person person);
	public boolean isUserExisted(String userName);
}
