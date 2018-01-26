package com.sofa.dao;

import java.util.List;

import com.sofa.model.User;

/**
 * 
 * @Description: 用户 Dao 接口
 * @author: wanghaixue
 * @CreateDate: 2018年1月25日 下午1:47:23
 */
public interface UserMapper {
	/**
	 * 根据用户 id 获取该用户记录
	 * @param id
	 * @return 用户信息
	 */
	public User getUserById(Integer id);
	
	/**
	 * 插入一条用户记录
	 * @param user
	 * @return 改变记录的条数
	 */
	public int insertUser(User user);
	
	/**
	 * 删除一条用户记录
	 * @param id
	 * @return 操作记录条数
	 */
	public int delUser(Integer id);
	
	/**
	 * 根据 id 批量删除用户记录
	 * @param ids id数组
	 * @return
	 */
	public int batchDelUser(Integer[] ids);
	
	/**
	 * 根据 id 修改用户信息
	 * @param id
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 根据条件查找用户
	 * @param user
	 * @return
	 */
	public List<User> queryUsers(User user);
	
	/**
	 * 查询用户总记录数
	 * @return
	 */
	public int getUserNum();
	
	public List<User> getCurrentUser(Integer currentPage, Integer pageSize);
}
