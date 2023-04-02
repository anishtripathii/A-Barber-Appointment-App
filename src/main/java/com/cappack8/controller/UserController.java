package com.cappack8.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cappack8.dao.UserDao;
import com.cappack8.exception.UserException;
import com.cappack8.model.User;

@RestController
public class UserController {

	@Autowired
	UserDao udao;
	
	@PostMapping(path="/createUser")
	public User createUser(@RequestBody User user) throws UserException
	{
		return udao.addUser(user);
	}
	@GetMapping(path="/deleteUserById/{userId}")
	public int deleteUserById(@PathVariable Integer userId) {
		return udao.removeUser(userId);
	}
	
}