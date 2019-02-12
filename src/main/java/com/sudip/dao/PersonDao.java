package com.sudip.dao;

import java.util.List;

import com.sudip.bean.Person;

public interface PersonDao {

	public void addPerson(Person person);
	public void editPerson(Person person, int id);
	public void deletePerson(int id);
	public Person showPerson(int id);
	public List<Person> showAll();

}
