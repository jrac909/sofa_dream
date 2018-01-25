package com.sofa.service;

import org.springframework.stereotype.Service;

import com.sofa.model.User;

public interface UserService {
	public User getUserById(Integer id);
	
	public int addUser(User user);
}
