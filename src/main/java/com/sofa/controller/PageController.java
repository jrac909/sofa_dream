package com.sofa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("/userpage")
	public String userpage(){
		return "user_manager";
	}
}
