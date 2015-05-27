package com.example.spring.mvc.mongodb.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String createUser(@RequestBody User user) {
		userService.addUser(user);
		return "user/userView";
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public List<User> getUser(@RequestBody User user) {
		return userService.getUser(user);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return "userWeb/view";
	}
	
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	@ResponseBody
	public User getFindByIdUser(@RequestBody User user) {
		return userService.getUserById(user);
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@ResponseBody
	public String removeUser(@RequestBody User user) {
		userService.removeUser(user);
		return "userWeb/view";
	}

}
