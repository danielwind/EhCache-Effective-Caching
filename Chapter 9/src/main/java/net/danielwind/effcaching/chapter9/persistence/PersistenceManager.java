package net.danielwind.effcaching.chapter9.persistence;

import java.util.List;

import net.danielwind.effcaching.chapter9.domain.Employee;
import net.danielwind.effcaching.chapter9.utils.ApplicationUtil;

import org.springframework.cache.annotation.Cacheable;

public final class PersistenceManager {

	public PersistenceManager() {
		
	}
	
	@Cacheable("employeeCache")
	public List<Employee> getEmployees() {
		return ApplicationUtil.retrieveList();
	}

}
