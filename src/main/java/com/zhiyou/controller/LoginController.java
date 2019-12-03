package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class LoginController {
	UserService service;
	
	@RequestMapping
    public String login(String nickname,String password,HttpServletRequest req,HttpServletResponse rep) {
		User user = service.findUserByLogin(nickname,password);
		if (user != null) {
			return "redirect:jsp/HomePage.jsp";
		}
    	return "redirect:login.jsp";
    }
}
