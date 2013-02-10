package net.danielwind.effcaching.recipe7.domain;

import org.apache.log4j.Logger;

public final class Person {
	
	private static final Logger log = Logger.getLogger(Person.class);
	
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String state;
	
	public Person(String firstName, String lastName, String email, String city, String state) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		
		log.info("Creating a Person instance " + this.toString());
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		return sb.toString();
	}
}