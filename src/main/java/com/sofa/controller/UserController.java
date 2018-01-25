package com.sofa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.sofa.common.ResponseDTO;
import com.sofa.model.User;
import com.sofa.service.UserService;

/**
 * 
 * @Description: 用户控制器
 * @author: wanghaixue
 * @CreateDate: 2018年1月25日 下午1:34:23
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 根据 id 获取某一用户的信息
	 * @return
	 */
	@RequestMapping(value="/get")
	public ResponseDTO get(Integer id){
		ResponseDTO responseDTO = new ResponseDTO();
		User user = userService.getUserById(id);
		
		responseDTO.setData(user);
		responseDTO.setMsg("成功");
		responseDTO.setStatus(0);
		
		return responseDTO;
	}
	/**
	 * 管理员创建用户
	 * @return
	 */
	@RequestMapping(value="/add")
	public ResponseDTO add(@ModelAttribute()User user){
		ResponseDTO responseDTO = new ResponseDTO();
		int flag = userService.addUser(user);
		if (flag != 0){
			responseDTO.setStatus(0);
		} else {
			responseDTO.setStatus(1);
		}
		return responseDTO;	
	}
	
	/**
	 * 管理员删除指定 id用户
	 * @return
	 */
	@RequestMapping(value="/del")
	public ResponseDTO del(Integer id){
		ResponseDTO responseDTO = new ResponseDTO();
		int flag = userService.delUser(id);
		if (flag != 0){
			responseDTO.setStatus(0);
		} else {
			responseDTO.setStatus(1);
		}
		responseDTO.setMsg("成功");
		responseDTO.setData("成功");
		return responseDTO;
	}
	
	/**
	 * 批量删除指定 id 的用户
	 * @return
	 */
	@RequestMapping(value="/batchDel")
	public ResponseDTO batchDel(@RequestParam(value="ids[]") Integer[] ids){
		ResponseDTO responseDTO = new ResponseDTO();
		int flag = userService.batchDelUser(ids);
		
		if (flag != 0){
			responseDTO.setStatus(0);
		} else {
			responseDTO.setStatus(1);
		}
		
		responseDTO.setMsg("成功");
		responseDTO.setData("批量删除成功");
		
		return responseDTO;
	}
}
