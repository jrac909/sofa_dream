package com.sofa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		System.out.println("请求到这里了...");
		ResponseDTO responseDTO = new ResponseDTO();
		User user = userService.getUserById(1);
		
		responseDTO.setData(user);
		responseDTO.setMsg("成功");
		responseDTO.setStatus(0);
		
		return responseDTO;
	}
}
