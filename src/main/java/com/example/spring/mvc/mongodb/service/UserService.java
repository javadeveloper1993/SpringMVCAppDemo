package com.example.spring.mvc.mongodb.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.spring.mvc.model.User;
import com.mongodb.WriteResult;

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
		logger.info("user :: " + user);
		mongoTemplate.insert(user);
		logger.info("User Added Sucessfully...!!!");
	}

	public List<User> getUser(User user) {
		List<User> users = new ArrayList<>();
		if (user.getUserId() == null) {
			users = mongoTemplate.findAll(User.class);
		} else {
			users = mongoTemplate.find(new Query(Criteria.where("userId").is(user.getUserId())),
					User.class);
		}
		return users;
	}

	public WriteResult removeUser(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(user.getId()));
		return mongoTemplate.remove(query, User.class);
	}

	public User getUserById(User user) {
		return mongoTemplate.findById(user.getId(), User.class);
	}

}
