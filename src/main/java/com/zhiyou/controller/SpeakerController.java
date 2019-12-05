package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.Course;
import com.zhiyou.model.Speaker;
import com.zhiyou.service.SpeakerService;

@Controller
public class SpeakerController {
    
	@Autowired
	SpeakerService speakerservice;
	
	@RequestMapping("speakershow")
	public String speakerShow(HttpServletRequest req,HttpServletResponse rep) {
		req.setAttribute("list", speakerservice.selectAll());
		return "forward:speakershow";
	}
	
	@RequestMapping("addspeaker")
	public String addSpeaker(Speaker speaker,HttpServletRequest req,HttpServletResponse rep) {
		speakerservice.addSpeaker(speaker);
		req.getSession().setAttribute("speaker", speaker);
		return "";
	}
	
	@RequestMapping("adds")
	public String adds(HttpServletRequest req,HttpServletResponse rep) {
		return "";
	}
	
	
	@RequestMapping("deletespeaker")
	public String deleteSpeaker(int id,HttpServletRequest req,HttpServletResponse rep) {
		speakerservice.deleteSpeaker(id);
		return "";
	}
	
	//更新
	@RequestMapping("updatespeaker")
	public String updateSpeaker(Speaker speaker,HttpServletRequest req,HttpServletResponse rep) {
		speakerservice.updateSpeaker(speaker);
		req.getSession().setAttribute("speaker", speaker);
		return "redirect:jsp/showbackcourse.jsp";
	}
	
    @RequestMapping(value="updates")
	public String updates(HttpServletRequest req,HttpServletResponse rep) {
    	return "";
    }
	
    //批量删除
	@RequestMapping("deleteAllSpeaker")
	public String deleteAllSpeaker(int[] ids,HttpServletRequest req,HttpServletResponse rep) {
		speakerservice.deleteAllSpeaker(ids);
		return"";
	}
	
	
	@RequestMapping("selectByIdS")
	public String selectByIdS(int id,HttpServletRequest req,HttpServletResponse rep) {
		
		req.setAttribute("id", speakerservice.selectByIdS(id));
		return "";
	}
	
}
