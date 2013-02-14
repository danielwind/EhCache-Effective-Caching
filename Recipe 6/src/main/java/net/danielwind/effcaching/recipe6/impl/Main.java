package net.danielwind.effcaching.recipe6.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.danielwind.effcaching.recipe6.cache.CacheDelegate;
import net.danielwind.effcaching.recipe6.domain.Employee;
import net.danielwind.effcaching.recipe6.domain.EmployeeList;
import net.danielwind.effcaching.recipe6.utils.XMLUtil;

import org.apache.log4j.Logger;

public final class Main {

	private static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws JAXBException {
		
		log.info("------ Starting Program --------");
		
		//load employees.xml and unmarshal it using JAXB
		File file = XMLUtil.loadXML();
		JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		EmployeeList employeeList = (EmployeeList) unmarshaller.unmarshal(file);
		List<Employee> list = employeeList.getEmployees();  
		Iterator<Employee> employeeItr = list.iterator();
		
		while(employeeItr.hasNext()){
			Employee employee = (Employee) employeeItr.next();
			log.info("loading employee: [" + employee.toString() + "]");
		}
		
		//Initialize Cache Delegate
		CacheDelegate cache = new CacheDelegate();
		cache.loadInCache(list);
		
		log.info("***********************************");
		log.info("* Starting EhCache Search Queries *");
		log.info("***********************************");
		
		//Initiate Search Query Operations
		log.info("The overall salary average is: " + cache.getSalaryAverage());
		
		
		log.info("The total of employees in Engineering Dept. is: " + cache.getTotalEmployeesByDepartment("Engineering"));
		
		
		log.info("Searching Employee By Social Sercurity Number: [" + cache.searchEmployeeBySocialNumber("078-07-1121") + "]");
		
		
		log.info("********************************************************");
		log.info("Retrieve all Employees with salary greater than 95,000: ");
		List<Employee> emps = cache.searchBySalaryGreaterThan(95000);
		
		for(Employee employee : emps) {
			log.info(employee.toString());
		}
		log.info("---------------------------------------------------------");
	}
}
