package com.sofa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sofa.model.User;
import com.sofa.util.PageBean;

public interface UserService {
	public User getUserById(Integer id);
	
	public int addUser(User user);
	
	public int delUser(Integer id);
	
	public int batchDelUser(Integer[] ids);
	
	public int updateUser(User user);
	
	public List<User> queryUsers(User user);
	
	public PageBean<User> getCurrentUser(Integer currentPage, Integer pageSize);
}
