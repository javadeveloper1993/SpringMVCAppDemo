package com.example.spring.mvc.mongodb.repository;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.spring.mvc.model.User;

/**
 * @author Maulik
 * 
 */
@Repository
public class UserService {

	private static final Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addUser(User user) {
		if (!mongoTemplate.collectionExists(User.class)) {
			mongoTemplate.createCollection(User.class);
		}
		mongoTemplate.insert(user);
		logger.info("User Added Sucessfully...!!!");
	}

}
