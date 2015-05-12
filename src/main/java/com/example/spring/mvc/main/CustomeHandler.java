package com.example.spring.mvc.main;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("customeHandler")
public class CustomeHandler {

	private static final Logger logger = Logger.getLogger(CustomeHandler.class);

	@RequestMapping(method = RequestMethod.GET)
	public String customeHandler() {
		logger.info(">>> In CustomeHandler Method...!!!");
		return "index";
	}

}
