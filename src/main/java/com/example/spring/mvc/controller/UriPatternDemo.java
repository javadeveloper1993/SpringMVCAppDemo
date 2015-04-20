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
@RequestMapping("/uriPattern")
public class UriPatternDemo {
	private static final Logger logger = Logger.getLogger(UriPatternDemo.class);

	@RequestMapping(value = "/p1/{ownerId}/p2/{petId}", method = RequestMethod.GET)
	public ModelAndView displayUri(@PathVariable String ownerId,
			@PathVariable String petId) {
		logger.info(" >>> :" + ownerId + " >>> :" + petId);
		String name = " >>> " + ownerId + " >>> " + petId;
		return new ModelAndView("Hello", "message", name);
	}

	@RequestMapping(value = "${path}", method = RequestMethod.GET)
	private ModelAndView propertyPlaceHolder() {
		return new ModelAndView("Hello", "message",
				"In Property Place Holder Demo.");
	}

	// Matrix Variable Demo
	@RequestMapping(value = "/matrix/{id}", method = RequestMethod.GET)
	public ModelAndView matrix1(@PathVariable String id, @MatrixVariable int q) {
		logger.info("Matrix Value  :: " + q);
		return new ModelAndView("Hello", "message", q);
	}

	@RequestMapping(value = "/matrix1/p1/{ownerId}/p2/{petId}", method = RequestMethod.GET)
	public ModelAndView matrix2(
			@MatrixVariable(value = "q", pathVar = "ownerId") int q1,
			@MatrixVariable(value = "q", pathVar = "petId") int q2) {
		String value = "Q1 ::" + q1 + " >>> Q2 :: " + q2;
		logger.info("Matrix Value 1:: " + value);
		return new ModelAndView("Hello", "message", value);
	}
}
