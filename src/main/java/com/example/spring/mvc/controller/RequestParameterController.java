package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/rqparameter")
public class RequestParameterController {

	private static final Logger logger = Logger
			.getLogger(RequestParameterController.class);

	@RequestMapping("/null")
	public ModelAndView requestParameterNull(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "age", required = false) String age) {
		logger.info("@Request Paramter Value : " + name + " : " + age);
		String message = "@Request  Parameter Value : " + name + "  " + age;
		return new ModelAndView("Hello", "message", message);
	}

	@RequestMapping("/notnull")
	public ModelAndView requestParameterNotNull(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "age") String age) {
		logger.info("@Request Paramter Value : " + name + " : " + age);
		String message = "@Request  Parameter Value : " + name + "  " + age;
		return new ModelAndView("Hello", "message", message);
	}
}
