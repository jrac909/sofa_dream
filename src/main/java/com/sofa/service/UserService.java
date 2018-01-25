package com.sofa.service;

import org.springframework.stereotype.Service;

import com.sofa.model.User;

public interface UserService {
	public User getUserById(Integer id);
	
	public int addUser(User user);
	
	public int delUser(Integer id);
	
	public int batchDelUser(Integer[] ids);
}
