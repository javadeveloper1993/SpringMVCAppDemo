package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maulik
 * 
 */
@Controller
public class HelloController {

	private static final Logger logger = Logger
			.getLogger(HelloController.class);

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		logger.info("In Print Welcome");
		String message = "HELLO SPRING MVC";
		return new ModelAndView("Hello", "message", message);
	}
}
