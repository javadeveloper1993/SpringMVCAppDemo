package com.example.spring.mvc.mongodb.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.spring.mvc.model.User;
import com.example.spring.mvc.mongodb.service.UserService;

/**
 * @author Maulik
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createUser(@ModelAttribute User user, Model model) {
		userService.addUser(user);
		model.addAttribute("userId", user.getUserId());
		return "user/userView";
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public User getUser(@RequestBody User user) {
		return userService.getUser(user);
	}

}
