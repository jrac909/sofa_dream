package com.sofa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.sofa.common.ResponseDTO;
import com.sofa.model.User;
import com.sofa.service.UserService;
import com.sofa.util.PageBean;

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
	
	/**
	 * 修改用户信息
	 * @return
	 */
	@RequestMapping(value="/update")
	public ResponseDTO update(@ModelAttribute()User user){
		ResponseDTO responseDTO = new ResponseDTO();
		user.setUpdate_date("修改后时间");
		int flag = userService.updateUser(user);
		
		if (flag != 0){
			responseDTO.setStatus(0);
		} else {
			responseDTO.setStatus(1);
		}
		
		responseDTO.setMsg("成功");
		responseDTO.setData("修改用户成功");
		return responseDTO;
	}
	/**
	 * 根据条件查询用户
	 * @return
	 */
	@RequestMapping(value="/query")
	public ResponseDTO query(@ModelAttribute()User user){
		// String username, String email, Integer role, Integer vip, Integer status
		ResponseDTO responseDTO = new ResponseDTO();
		List<User> userList = userService.queryUsers(user);
		
		/**如果查询为空, 把查询信息返回*/
		if (userList == null){
			userList = new ArrayList<>();
			userList.add(user);
			responseDTO.setStatus(1);
		} else{
			responseDTO.setStatus(0);
		}
		responseDTO.setData(userList);
		responseDTO.setMsg("执行条件查询完成");
		return responseDTO;
	}
	/**
	 * 获取所有用户
	 * @return
	 */
	@RequestMapping(value="/getAll")
	public ResponseDTO getUsers(Integer currentPage, Integer pageSize){
		ResponseDTO responseDTO = new ResponseDTO();
		PageBean<User> pageBean = userService.getCurrentUser(currentPage, pageSize);
		responseDTO.setData(pageBean);
		responseDTO.setMsg("分页查询用户成功");
		responseDTO.setStatus(0);
		
		System.out.println("查询出来的总条数:"+pageBean.getData().size());
		System.out.println("分页后当前数据："+pageBean.getData().get(0).getUsername());
		return responseDTO;
	}
}
