package com.cappack8.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cappack8.exception.UserException;
import com.cappack8.model.User;
import com.cappack8.repository.UserRepository;
import com.cappack8.service.IUserService;

@Service
public class UserDao implements IUserService{

	@Autowired
	UserRepository urepos;
	@Override
	public User addUser(User user) throws UserException {
		if(urepos.existsById(user.getUserId())) {
			throw new UserException("This User is avalilable");
		}
		return urepos.save(user);
	}

	@Override
	public int removeUser(int userId) {
		if(urepos.existsById(userId)) {
			urepos.deleteById(userId);
			return 1;
		}
		else {
			return 0;
		}
		
	}

}