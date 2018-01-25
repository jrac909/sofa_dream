package com.sofa.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofa.common.ResponseDTO;
import com.sofa.model.Admin;
import com.sofa.model.Log;
import com.sofa.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/buildNewAdmin")
	public ResponseDTO buildNewAdmin(Admin admin) {
		ResponseDTO res = new ResponseDTO();
//		admin.setAdminName("tt");
//		admin.setNumber("122332");
//		admin.setPassword("123456");
//		admin.setPhoto("121321");
//		admin.setRole(1);
		admin.setCreateTime(new Date().toString());
		//需要做密码加密 暂时还没做
		int result = 0;
		result = adminService.insertNewAdmin(admin);
		
		if(result == 0) {
			res.setMsg("添加失败");
			res.setStatus(0);
		}else {
			res.setMsg("添加成功");
			res.setStatus(1);
		}
		
		res.setData(result);
		System.out.println("添加成功\t"+result);
		return res;
	}
	
	@RequestMapping("/getAllAdmin")
	public ResponseDTO getAllAdmin() {
		ResponseDTO res = new ResponseDTO();
		List<Admin> alist = adminService.queryAllAdmin();
		res.setData(alist);
		res.setMsg("获取成功");
		res.setStatus(1);
		
		return res;
	}
	
	@RequestMapping("/deleteAdmin")
	public ResponseDTO deleteAdmin(int id) {
		ResponseDTO res = new ResponseDTO();
		id=4;
		int result = 0;
		result =  adminService.deleteAdminById(id);
		res.setData(result);
		res.setMsg("删除成功");
		res.setStatus(1);
		
		return res;
		
	}
	@RequestMapping("/updateAdmin")
	public ResponseDTO updateAdmin(Admin admin) {
		ResponseDTO res = new ResponseDTO();
		admin.setId(5);
		admin.setUpdateTime(new Date().toString());
		
		int result = 0;
		result =  adminService.updateAdminById(admin);
		res.setData(result);
		res.setMsg("更新成功");
		res.setStatus(1);
		return res;
	}
	@RequestMapping("/getLog")
	public ResponseDTO getLog(int adminId) {
		ResponseDTO res = new ResponseDTO();
		adminId=2;
		List<Log> log = adminService.queryLogByAdminId(adminId);
		
		res.setData(log);
		res.setMsg("获取成功");
		res.setStatus(1);
		
		return res;
	}
	@RequestMapping("/getPageAdmin")
	public ResponseDTO getPageAdmin(int page,int size) {
		ResponseDTO res = new ResponseDTO();
		int sizeTotal = adminService.queryTotalNum();
		System.out.println(sizeTotal);
		List<Admin> aList = null;
		// mybatis里面limit start,size 指从start位置开始取size个数据  start从0开始
		int start=(page-1)*size;
		int end=page*size;
		if(start < sizeTotal) { 
			if(end > sizeTotal) {
				end = sizeTotal;
				size = sizeTotal-start;
			}
			aList = adminService.queryAdminByPage(start, size);
		}
		res.setData(aList);
		res.setMsg("获取成功");
		res.setStatus(1);
		return res;
	}
	
	
}
