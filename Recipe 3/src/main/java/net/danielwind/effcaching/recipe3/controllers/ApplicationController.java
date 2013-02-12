package net.danielwind.effcaching.recipe3.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.danielwind.effcaching.recipe3.domain.Employee;
import net.danielwind.effcaching.recipe3.services.impl.ApplicationServiceImpl;
import net.danielwind.effcaching.recipe3.utils.JsonConverter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public final class ApplicationController {
	
	@Autowired
	private ApplicationServiceImpl applicationService;
	
	private static final Logger log = Logger.getLogger(ApplicationController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/list/employees")
	@ResponseStatus(HttpStatus.OK)
	public void invokeEmployeeList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		log.info("--- Invoking controller method: invokeEmployeeList() ---");
		
		List<Employee> employees = applicationService.findAllEmployees();
		
		log.debug("--- The number of employees found is: " + employees.size());
		
		String json = JsonConverter.toJson(employees);
		PrintWriter out = response.getWriter();
		out.println((employees != null) ? json : "{}");
	}

}
