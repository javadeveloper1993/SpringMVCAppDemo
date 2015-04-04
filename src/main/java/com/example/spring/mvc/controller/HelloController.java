package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	private static final Logger logger = Logger
			.getLogger(HelloController.class);

	@RequestMapping("/{firstName}/{middleName}")
	public ModelAndView helloWorld(@PathVariable("firstName") String firstName,
			@PathVariable("middleName") String middleName) {
		logger.info("In Hello World Example : " + firstName + " " + middleName);
		String message = "Welcome To Spring MVC : " + firstName + " "
				+ middleName;
		return new ModelAndView("Hello", "message", message);
	}

	@RequestMapping(value = "/matrixDemo/{id}", method = RequestMethod.GET)
	public ModelAndView matrixDemo(@MatrixVariable int q,
			@PathVariable String id) {
		logger.info("In Matrix Example : " + q);
		String message = "Welcome To Spring MVC Matrix : " + id;
		return new ModelAndView("Hello", "message", message);

	}

}
