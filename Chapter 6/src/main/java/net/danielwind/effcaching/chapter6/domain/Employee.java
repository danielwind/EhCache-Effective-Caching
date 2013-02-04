package net.danielwind.effcaching.chapter6.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public final class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private String socialNumber;
	private CompanyProfile profile;
	
	public Employee() {
		
	}

	public String getFirstName() {
		return firstName;
	}
	
	@XmlElement
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	@XmlElement
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSocialNumber() {
		return socialNumber;
	}

	@XmlElement
	public void setSocialNumber(String socialNumber) {
		this.socialNumber = socialNumber;
	}

	public CompanyProfile getProfile() {
		return profile;
	}
	
	@XmlElement
	public void setProfile(CompanyProfile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("First Name: " + this.firstName + ", ");
		sb.append("Last Name: " + this.lastName + ", ");
		sb.append("Social Number: " + this.socialNumber + ", ");
		sb.append("Department: " + this.profile.getDepartment() + ", ");
		sb.append("Role: " + this.profile.getRole() + ", ");
		sb.append("Salary Income: " + this.profile.getSalary());
		
		return sb.toString();
	}
}
