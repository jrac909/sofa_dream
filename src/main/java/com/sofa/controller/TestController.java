package com.sofa.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sofa.common.ResponseDTO;
import com.sofa.model.User;
import com.sofa.service.UserService;

@RestController
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/test")
	public ResponseDTO test(){
		ResponseDTO responseDTO = new ResponseDTO();
		User user = new User();
		user = userService.getUserById(1);
		responseDTO.setData(user);
		responseDTO.setMsg("成功");
		responseDTO.setStatus(1);
		System.out.println(responseDTO);
		return responseDTO;
	}
}
