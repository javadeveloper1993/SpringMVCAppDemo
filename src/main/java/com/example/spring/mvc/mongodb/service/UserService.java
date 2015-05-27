package com.example.spring.mvc.mongodb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
		mongoTemplate.save(user);
		logger.info("User Added Sucessfully...!!!" + user);
	}

	public List<User> getUser(User user) {
		Query query = new Query();
		if (user.getUserId() != null) {
			query.addCriteria(Criteria.where("userId").is(user.getUserId()));
		}
		return mongoTemplate.find(query, User.class);
	}

	public WriteResult removeUser(User user) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(user.getId()));
		return mongoTemplate.remove(query, User.class);
	}

	public User getUserById(User user) {
		return mongoTemplate.findById(user.getId(), User.class);
	}

	public void updateUser(User user) {
		Update update = new Update();
		update.set("userId", user.getUserId());
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastName());
		update.set("userName", user.getUserName());
		update.set("password", user.getPassword());
		update.set("age", user.getAge());
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(user.getId()));
		mongoTemplate.updateFirst(query, update, User.class);
		logger.info("User Update Sucessfully...!!!");
	}

}