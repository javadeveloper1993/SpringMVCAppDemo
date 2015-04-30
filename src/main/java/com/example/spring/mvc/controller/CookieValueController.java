package com.example.spring.mvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Maulik Patel
 * 
 */
@Controller
@RequestMapping("/cookie")
public class CookieValueController {

	private static final Logger logger = Logger
			.getLogger(CookieValueController.class);

	@RequestMapping(value = "/getCookie", method = RequestMethod.GET)
	public void cookieValue(
			@CookieValue(value = "myCookie", defaultValue = "testCookie") String cookie) {
		logger.info(" >> Cookie :: " + cookie);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void addcookieValue(HttpServletResponse httpServletResponse) {
		String cookieName = "myCookie", cookieValue = "123456";
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(10);
		httpServletResponse.addCookie(cookie);
		logger.info(" Cookie With name : " + cookieName + " Value : "
				+ cookieValue + " is Added...!!!");
	}

}
