package com.sudip.service;

import java.util.List;

import com.sudip.bean.Person;

public interface PersonService {

	public void addPeople(Person person);
	public void editPerson(Person person, int id);
	public void deletePerson(int id);
	public Person showPerson(int id);
	public List<Person> showAll();
}
