package com.sudip.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sudip.bean.Person;

@Repository
@Qualifier("personDao")
public class PersonDaoImpl implements PersonDao {
	

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addPerson(Person person) {
		jdbcTemplate.update("insert into person(id,lastName,firstName,age) values(?,?,?,?)", person.getId(), person.getLastName(), person.getFirstName(), person.getAge());
		System.out.println("Successfully inserted one person");
	}

	public void editPerson(Person person, int id) {
		jdbcTemplate.update("update person set lastName=?,firstName=?,age=? where id = ?",person.getLastName(),person.getFirstName(),person.getAge(),id );
		System.out.println("Successfully edited one person details");
	}

	public void deletePerson(int id) {

		jdbcTemplate.update("delete from person where id = ?", id);
		System.out.println("Successfully deleted one person");
	}

	public Person showPerson(int id) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Person person = (Person)jdbcTemplate.queryForObject("select * from person where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Person.class));
		return person;
	}

	public List<Person> showAll() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Person> persons = jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper(Person.class));
		return persons;
	}

}
