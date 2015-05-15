package com.example.spring.mvc.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.example.spring.mvc.model.User;
import com.example.spring.mvc.mongodb.service.UserService;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public View createPerson(@ModelAttribute User user, ModelMap model) {
		userService.addUser(user);
		return new RedirectView("userView");
	}

}
