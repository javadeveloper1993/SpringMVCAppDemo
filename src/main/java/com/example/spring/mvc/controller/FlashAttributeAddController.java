package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring.mvc.model.Person;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/flash")
public class FlashAttributeAddController {

	private static final Logger logger = Logger
			.getLogger(FlashAttributeAddController.class);

	@RequestMapping(value="/add",method=RequestMethod.GET)
	private String addFlashAttribute(RedirectAttributes redirectAttributes) {
		logger.info("In Add Flash Attribure Controller");
		redirectAttributes.addFlashAttribute("flash", "Flash Attribute");
		Person person = new Person();
		person.setId("p001");
		person.setAge(15);
		person.setName("Patel Maulik");
		redirectAttributes.addFlashAttribute("person",person);
		return "redirect:/flashGet";
	}

}
