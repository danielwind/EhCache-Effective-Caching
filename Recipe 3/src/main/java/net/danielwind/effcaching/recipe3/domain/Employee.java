package net.danielwind.effcaching.recipe3.domain;

public final class Employee {

	private long id;
	private long salary;
	
	private String role;
	private String firstName;
	private String lastName;
	private String department;
	
	
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
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public long getSalary() {
		return salary;
	}
	
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		sb.append("ID: " + this.id);
		sb.append(",");
		sb.append("First Name: " + this.firstName);
		sb.append(",");
		sb.append("Last Name: " + this.lastName);
		sb.append(",");
		sb.append("Department: " + this.department);
		sb.append(",");
		sb.append("Role: " + this.role);
		sb.append(",");
		sb.append("Salary: " + this.salary);
		sb.append("]");
		
		return sb.toString();
	}
}