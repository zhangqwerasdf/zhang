package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhiyou.model.Course;
import com.zhiyou.model.User;
import com.zhiyou.service.CourseService;

@Controller
public class CourseController {
    
	@Autowired 
    CourseService service;
	
	@RequestMapping("courseShow")
	public String courseShow(HttpServletRequest req,HttpServletResponse rep) {
		req.setAttribute("list", service.selectAll());
		return "jsp/showbackcourse";
	}
	@RequestMapping("addCourse")
	public String addCourse(Course course,HttpServletRequest req,HttpServletResponse rep) {
		service.addCourse(course);
		req.getSession().setAttribute("course", course);
		return "jsp/showbackcourse";
	}
	
	@RequestMapping("addc")
	public String addc(HttpServletRequest req,HttpServletResponse rep) {
		return "jsp/addcourse";
	}
	
	@RequestMapping("deleteCourse")
	public String deleteCourse( Integer id,HttpServletRequest req,HttpServletResponse rep) {
		
		service.deleteCourse(id);
		return "redirect:showbackcourse";
	}
	
	//更新
	@RequestMapping("updateCourse")
	public String updateCourse( Course course,HttpServletRequest req,HttpServletResponse rep) {
		req.getSession().setAttribute("course", course);
		service.updateCourse(course);
		return "redirect:jsp/showbackcourse.jsp";
	}
	
    @RequestMapping(value="updatec")
	public String updatec(HttpServletRequest req,HttpServletResponse rep) {
    	return "jsp/altercourse";
    }
	
    //批量删除
	@RequestMapping("deleteAll")
	public String deleteAll(int[] ids,HttpServletRequest req,HttpServletResponse rep) {
		service.deleteAll(ids);
		return"redirect:showbackcourse";
	}
	
	
	@RequestMapping("selectByIdC")
	public String selectByIdC(int id,HttpServletRequest req,HttpServletResponse rep) {
		
		req.setAttribute("course", service.selectByIdC(id));
		return "showbackcourse";
	}
	
	
	//分页
}
