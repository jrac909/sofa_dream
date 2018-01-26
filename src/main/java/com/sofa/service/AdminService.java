package com.sofa.service;

import java.util.List;

import com.sofa.model.Admin;
import com.sofa.model.Log;

public interface AdminService {
	public int insertNewAdmin(Admin admin);
	public List<Admin> queryAllAdmin();
	public int deleteAdminById(int id);
	public int updateAdminById(Admin admin);
	public List<Log> queryLogByAdminId(int adminId,int start,int size);
	public List<Admin> queryAdminByPage(int start,int size);
	public int queryTotalNum();
	public int queryLogNum(int adminId);
	public List<Admin> queryByImperfect(String adminName,String number,int role);
}
