package net.danielwind.effcaching.recipe9.services.impl;

import java.util.List;

import net.danielwind.effcaching.recipe9.dao.EmployeeDao;
import net.danielwind.effcaching.recipe9.domain.Employee;
import net.danielwind.effcaching.recipe9.services.ApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.findAll();
	}

}
