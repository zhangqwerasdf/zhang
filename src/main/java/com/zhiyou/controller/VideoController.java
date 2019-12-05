package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhiyou.service.VideoService;

@Controller
public class VideoController {
    
	@Autowired
    VideoService service;
	
	@RequestMapping("videoshow")
	public String videoShow(HttpServletRequest req,HttpServletResponse rep) {
		req.setAttribute("list", service.selectAllVideo());
		return "jsp/showcourse";
	}
	
	
	
}
