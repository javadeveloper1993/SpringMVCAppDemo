package com.example.spring.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Maulik
 * 
 */


/**
 * @Question 1> How To Redirect Same Request
 *           2> How To Forward Same Request
 *
 */
@Controller
public class RedirectForwardViewController {

	private static final Logger logger = Logger
			.getLogger(RedirectForwardViewController.class);

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	private ModelAndView redirectDemo() {
		logger.info("In Redirect View Controller...!!!");

		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName("redirect:/pages/jsp/redirect.jsp");

		return new ModelAndView("redirect:/pages/jsp/redirect.jsp");
		// return "redirect:/redirect";
		// return "redirect:/hello/Patel/Maulik";
	}

	@RequestMapping(value = "/forward", method = RequestMethod.GET)
	private String forwardDemo() {
		logger.info("In Forward View Controller...!!!");
		return "forward:/pages/jsp/redirect.jsp";
	}

}
