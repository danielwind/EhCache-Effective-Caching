package net.danielwind.effcaching.chapter9.repository;

import java.util.List;

import net.danielwind.effcaching.chapter9.domain.Employee;
import net.danielwind.effcaching.chapter9.persistence.PersistenceManager;

import org.springframework.stereotype.Repository;

@Repository
public class ApplicationRepository {
	
	private PersistenceManager manager;
	
	/**
	 * Finds all stored employees 
	 * @return List of Employees
	 */
	public List<Employee> findAll() {
		return manager.getEmployees();
	}
}
