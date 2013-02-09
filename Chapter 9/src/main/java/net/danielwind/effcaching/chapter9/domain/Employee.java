package net.danielwind.effcaching.chapter9.domain;

public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private Double salary;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("Employee ID: " + this.id);
		sb.append(",");
		sb.append("First Name: " + this.firstName);
		sb.append(",");
		sb.append("Last Name: " + this.lastName);
		sb.append(",");
		sb.append("Email: " + this.email);
		sb.append(",");
		sb.append("Department: " + this.department);
		sb.append(",");
		sb.append("Salary: " + this.salary);
		sb.append("]");
		
		return sb.toString();
	}
}
