package com.example.spring.mvc.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.mvc.model.User;

public interface UserDao extends MongoRepository<User, String> {

}
