package com.cappack8.service;

import com.cappack8.exception.UserException;
import com.cappack8.model.User;

public interface IUserService {

	public User addUser(User user) throws UserException;
	public int removeUser(int userId);
}