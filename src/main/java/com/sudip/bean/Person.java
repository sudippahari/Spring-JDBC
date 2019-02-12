package com.sudip.bean;


//bean class
public class Person {

	private int id;
	private String lastName;
	private String FirstName;
	private int age;

	public Person() {
	}

	public Person(int id, String lastName, String firstName, int age) {
		super();
		this.id = id;
		this.lastName = lastName;
		FirstName = firstName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", lastName=" + lastName + ", FirstName=" + FirstName + ", age=" + age + "]";
	}

}
