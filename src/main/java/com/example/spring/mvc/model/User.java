package com.example.spring.mvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Maulik
 * 
 */
@Document(collection = "user")
public class User {

	@Id
	private String id;
	private String userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int age;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", age=" + age + "]";
	}

}
