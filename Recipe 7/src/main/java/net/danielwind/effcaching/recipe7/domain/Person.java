package net.danielwind.effcaching.recipe7.domain;

import java.io.Serializable;

public final class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String citizenship;
	private String socialSecurity;
	
	/**
	 * Default Constructor (required)
	 */
	public Person() {
		
	}
	
	/**
	 * Overloaded Constructor
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param citizenship
	 * @param socialSecurity
	 */
	public Person(String firstName, String lastName, String email, String citizenship, String socialSecurity) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.citizenship = citizenship;
		this.socialSecurity = socialSecurity;
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
	
	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append("firstName: " + this.firstName);
		sb.append(",");
		sb.append("lastName: " + this.lastName);
		sb.append(",");
		sb.append("email: " + this.email);
		sb.append(",");
		sb.append("citizenship: " + this.citizenship);
		sb.append(",");
		sb.append("socialSecurity: " + this.socialSecurity);
		sb.append("]");
		
		return sb.toString();
	}
}