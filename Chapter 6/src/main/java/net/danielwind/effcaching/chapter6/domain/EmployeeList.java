package net.danielwind.effcaching.chapter6.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employeeList")
public final class EmployeeList {
	
	@XmlElement(name="employee")
	private List<Employee> employeeList;
	
	public List<Employee> getEmployees() {
		return employeeList;
	}

	public void setEmployees(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
