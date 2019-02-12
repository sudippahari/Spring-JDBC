package com.sudip.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sudip.bean.Person;
import com.sudip.configuration.ApplicationConfig;
import com.sudip.service.PersonService;

public class App {

	public static void main(String[] args) {

	
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		PersonService ps = (PersonService) context.getBean("personService");
		Person sudip = new Person(1, "Pahari", "Sudip", 27);
		Person rashmi = new Person(2, "Sharma", "Rashmi", 27);
		Person gaine = new Person(3, "Gaine", "Gaine", 30);

		ps.deletePerson(1);
		ps.deletePerson(2);
		ps.deletePerson(3);
		
		System.out.println("Adding persons........");
		ps.addPeople(sudip);
		ps.addPeople(rashmi);
		ps.addPeople(gaine);
		

		System.out.println("Fetching person");
		System.out.println(ps.showPerson(3));

		System.out.println("Updating person");
		gaine.setAge(28);
		gaine.setLastName("LOLBAHADUR");
		ps.editPerson(gaine, 3);

		System.out.println("Fetching person");
		System.out.println(ps.showPerson(3));
		
		System.out.println("Deleting person");
		ps.deletePerson(3);

		System.out.println("Fetching all persons");
		List<Person> persons = ps.showAll();
		for (Person p : persons) {
			System.out.println(p);
		}
	
	}

}
