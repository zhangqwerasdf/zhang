package com.zhiyou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Admin;
import com.zhiyou.service.AdminService;

@Controller
public class AdminLoginController {
    

	@Autowired
	 AdminService service;
	
	@RequestMapping("adminLogin")
	public void adminLogin(String accounts,String password,Admin admin,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("accounts1: "+accounts);
		admin = service.selectByEmail(accounts);
		System.out.println("accounts2: "+accounts);
		if (admin!=null) {
			// 用管理员存在
			if (admin.getPassword().equals(password)) {
				// 进入这里代表登录成功
				System.out.println("登录成功");
//				System.out.println("admin: "+admin);
				req.getSession().setAttribute("admin",admin);
//				req.getServletContext().setAttribute("admin",admin);
				req.getRequestDispatcher("/jsp/showbackcourse.jsp").forward(req, resp);	
				//resp.sendRedirect("/jsp/showbackcourse.jsp");
				return;
			}else {
				System.out.println("邮箱或密码错误");	
			}
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}
