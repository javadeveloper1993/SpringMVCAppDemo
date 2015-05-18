package com.example.spring.mvc.mongodb.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/userWeb")
public class UserWebController {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String userRegistrationPage() {
		return "user/userRegistration";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String userLoginPage() {
		return "user/userView";
	}

}
