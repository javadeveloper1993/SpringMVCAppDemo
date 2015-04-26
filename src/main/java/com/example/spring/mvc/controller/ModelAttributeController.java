package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.mvc.model.Person;

/**
 * @author Maulik
 * 
 */

@Controller
@RequestMapping(value = "/modelAttribute")
public class ModelAttributeController {
	private static final Logger logger = Logger
			.getLogger(ModelAttributeController.class);

	@ModelAttribute(value = "person")
	private Person getPerson() {
		Person person = new Person();
		person.setId("001");
		person.setName("Patel Maulik J");
		person.setAge(15);
		logger.info("Model Attribute Method Initilize For Person ...!!!");
		return person;
	}

	@RequestMapping(value = "/getPersonInfo", method = RequestMethod.GET)
	@ResponseBody
	private Person getPersonInfo(@ModelAttribute("person") Person person) {
		logger.info("Model Attribute Handler Method Before Executed...!!!" + person);
		person.setId("002");
		person.setName("Patel Parth");
		person.setAge(20);
		logger.info("Model Attribute Handler Method After Executed...!!!" + person);
		return person;
	}

}
