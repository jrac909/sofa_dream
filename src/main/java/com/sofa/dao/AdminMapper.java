package com.sofa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sofa.model.Admin;
import com.sofa.model.Log;

public interface AdminMapper {
	/**
	 * 方法功能说明：  插入新的管理员
	 * 创建：2018年1月25日 by Judy   
	 * @param admin 管理员
	 * @return int    
	 */
	public int insertNewAdmin(Admin admin);
	/**
	 * 方法功能说明：  根据管理员id删除管理员对象
	 * 创建：2018年1月25日 by Judy   
	 * @param id 管理员id
	 * @return int    
	 */
	public int deleteAdminById(int id);
	
	/**
	 * 方法功能说明：  根据管理员id更新管理员信息
	 * 创建：2018年1月25日 by Judy   
	 * @param admin 管理员
	 * @return int    
	 */
	public int updateAdminById(Admin admin);
	
	/**
	 * 方法功能说明： 取出所有的管理员 
	 * 创建：2018年1月25日 by Judy   
	 * @return List<Admin>    
	 */
	public List<Admin> queryAllAdmin();
	/**
	 * 方法功能说明： 根据管理员id分页查看其日志 
	 * 创建：2018年1月25日 by Judy   
	 * @param andminId 管理员id
	 * @return Log    
	 */
	public List<Log> queryLogByAdminId(int andminId,int start,int size);
	/**
	 * 方法功能说明：  分页查询管理员
	 * 创建：2018年1月25日 by Judy   
	 * @param start 页码
	 * @param size 每页展示的条数
	 * @return List<Admin>    
	 */
	public List<Admin> queryAdminByPage(int start,int size);
	/**
	 * 方法功能说明： 查询数据库中总条数
	 * 创建：2018年1月25日 by Judy   
	 * @return int    
	 */
	public int queryTotalNum();
	/**
	 * 方法功能说明：  获得日志的总条数
	 * 创建：2018年1月25日 by Judy
	 * @param adminId 管理员id  
	 * @return int    
	 */
	public int queryLogNum(int adminId);
	/**
	 * 方法功能说明：  模糊查询管理员
	 * 创建：2018年1月26日 by Judy   
	 * @param adminName 管理员名字
	 * @param number 管理员电话的
	 * @param role 管理员角色
	 * @return List<Admin>    
	 */
	public List<Admin> queryByImperfect(@Param("adminName") String adminName,@Param("number") String number,@Param("role") int role);
}
