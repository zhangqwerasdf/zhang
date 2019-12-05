package com.zhiyou.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.util.FTPUtil;

@Controller
public class UserController {
    
	@Autowired
	UserService service;

	@RequestMapping(value = "/userLogin")
	public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		String accounts = req.getParameter("email");
		String password = req.getParameter("password");
		User user = service.selectByAccounts(req, accounts, password);
		if (user != null) {
			req.getSession().setAttribute("user", user);
			resp.getWriter().write("sucess".toCharArray());
		}
	}

	@RequestMapping(value = "/loginout")
	public void loginout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("utf-8");
		req.getSession().setAttribute("user", null);
		resp.sendRedirect("index.jsp");

	}

	@RequestMapping(value = "/usershow")
	public String usershow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "jsp/personalcenter";

	}

	@ResponseBody
	@RequestMapping("add")
	public String add(User user, HttpServletRequest req, HttpServletResponse resp) {
		service.add(user);
		return "success";
	}

	@ResponseBody
	@RequestMapping("selectAll")
	public String selectAll(HttpServletRequest req, HttpServletResponse rep) {
		String aString = null;
		List<User> list = service.selectAll();
		if (list == null) {
			aString = "false";
		} else {
			aString = "success";
		}
		return aString;
	}

	@RequestMapping("selectById")
	public String selectById(Integer id, HttpServletRequest req, HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("utf-8");
		req.setAttribute("user", service.selectById(id));
		return "userUpdate";
	}

	@RequestMapping("userUpdate")
	public String update(User user, HttpServletRequest req, HttpServletResponse rep) throws Exception {
		req.setCharacterEncoding("utf-8");
		service.update(user);
		req.getSession().setAttribute("user", user);
		return "jsp/personalcenter";
	}

	// 跳转到更新页面
	@RequestMapping(value = "/updateshow")
	public String updateshow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "jsp/alterdata";

	}
	
	//图片上传
	@RequestMapping("upload.do")
	public String upload3(MultipartFile file123,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		System.out.println(FTPUtil.upload2(file123.getInputStream(), file123.getOriginalFilename()));
		return "jsp/alterimg";
		
	}

	@RequestMapping(value = "/imgshow")
	public String imgshow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "jsp/alterimg";
	}
	
	//密码修改
	@RequestMapping(value = "/passwordshow")
	public String passwordshow(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return "jsp/alterpassword";
	}
	
	@RequestMapping("alterpassword")
	public String alterpassword(User user2, HttpServletRequest req, HttpServletResponse resp) throws Exception {
		service.update(user2);
		req.getSession().setAttribute("user", service.selectById(user2.getId()));
		return "redirect:loginout";
	}
	
}
