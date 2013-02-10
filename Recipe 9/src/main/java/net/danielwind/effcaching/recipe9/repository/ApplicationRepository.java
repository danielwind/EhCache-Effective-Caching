package net.danielwind.effcaching.recipe9.repository;

import java.util.List;

import net.danielwind.effcaching.recipe9.domain.Employee;
import net.danielwind.effcaching.recipe9.persistence.PersistenceManager;

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
