package com.sofa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sofa.dao.AdminMapper;
import com.sofa.model.Admin;
import com.sofa.model.Log;
import com.sofa.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminMapper adminDao;
	
	@Override
	public int insertNewAdmin(Admin admin) {
		return adminDao.insertNewAdmin(admin);
	}

	@Override
	public List<Admin> queryAllAdmin() {
		return adminDao.queryAllAdmin();
	}

	@Override
	public int deleteAdminById(int id) {
		return adminDao.deleteAdminById(id);
	}

	@Override
	public int updateAdminById(Admin admin) {
		return adminDao.updateAdminById(admin);
	}

	@Override
	public List<Log> queryLogByAdminId(int adminId) {
		return adminDao.queryLogByAdminId(adminId);
	}

	@Override
	public List<Admin> queryAdminByPage(int start, int size) {
		return adminDao.queryAdminByPage(start, size);
	}

	@Override
	public int queryTotalNum() {
		return adminDao.queryTotalNum();
	}

}
