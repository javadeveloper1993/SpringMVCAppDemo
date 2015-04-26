package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.mvc.model.Person;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/rqbody")
public class RequestResponceBodyParameterController {

	private Person person;

	private static final Logger logger = Logger
			.getLogger(RequestResponceBodyParameterController.class);

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	@ResponseBody
	public Person addPerson(@RequestBody Person person) {
		logger.info(person);
		this.person=person;
		return person;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Person getPerson() {
		logger.info("In Get Person >>> " + person );
		return person;
	}
}
