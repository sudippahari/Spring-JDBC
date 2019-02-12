package com.sudip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudip.bean.Person;
import com.sudip.dao.PersonDao;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	public void addPeople(Person person) {
		personDao.addPerson(person);

	}

	public void editPerson(Person person, int id) {
		personDao.editPerson(person,id);

	}

	public void deletePerson(int id) {
		personDao.deletePerson(id);

	}

	public Person showPerson(int id) {
		return personDao.showPerson(id);
		
	}

	public List<Person> showAll() {
		return personDao.showAll();
	}

}
