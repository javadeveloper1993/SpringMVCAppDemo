package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.spring.mvc.model.Person;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/negotiation")
public class ContentNegotiationViewResolverController {

	private static final Logger logger = Logger
			.getLogger(ContentNegotiationViewResolverController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String nogotiationDemo(ModelMap modelMap) {
		Person person = new Person();
		person.setId("p001");
		person.setAge(15);
		person.setName("Patel Maulik");
		modelMap.addAttribute("person", person);
		logger.info("In Content Negotiation View Resolver Demo");
		return "Home";
	}

}
