package com.sofa.dao;

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
}
