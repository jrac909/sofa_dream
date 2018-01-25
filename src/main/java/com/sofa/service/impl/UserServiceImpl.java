package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofa.dao.UserMapper;
import com.sofa.model.User;
import com.sofa.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public int addUser(User user) {
		return userMapper.insertUser(user);
	}

	@Override
	public int delUser(Integer id) {
		return userMapper.delUser(id);
	}

	@Override
	public int batchDelUser(Integer[] ids) {
		return userMapper.batchDelUser(ids);
	}

	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public List<User> queryUsers(User user) {
		return userMapper.queryUsers(user);
	}

}
