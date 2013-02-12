package net.danielwind.effcaching.recipe3.services.impl;

import java.util.List;

import net.danielwind.effcaching.recipe3.dao.EmployeeDao;
import net.danielwind.effcaching.recipe3.domain.Employee;
import net.danielwind.effcaching.recipe3.services.ApplicationService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private EmployeeDao employeeDao;
	
	private static final Logger log = Logger.getLogger(ApplicationServiceImpl.class);
	
	/**
	 * @{inheritDoc}
	 */
	public List<Employee> findAllEmployees() {
		log.info("--- Accessing Service Layer: ApplicationService.findAllEmployees() ---");
		return employeeDao.findAll();
	}
}
