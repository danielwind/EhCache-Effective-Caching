package net.danielwind.effcaching.recipe6.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.danielwind.effcaching.recipe6.utils.EnumAdapter;
import net.danielwind.effcaching.recipe6.utils.Role;

public final class CompanyProfile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Role role;
	private int salary;
	private String department;
	
	public CompanyProfile() {
		
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}
	
	@XmlJavaTypeAdapter(EnumAdapter.class)
	public void setRole(Role role) {
		this.role = role;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "";
	}
}
