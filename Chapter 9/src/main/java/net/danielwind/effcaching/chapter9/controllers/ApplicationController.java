package net.danielwind.effcaching.chapter9.controllers;

import net.danielwind.effcaching.chapter9.repository.ApplicationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

	@Autowired
	private ApplicationRepository repository;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	
}
