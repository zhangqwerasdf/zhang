package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.User;

@Service
public class CourseServiceImpl implements CourseService{
    
	@Autowired
	CourseMapper mapper;
	
	public List<Course> selectAll() {
		
		return mapper.selectAll();
	}

	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		mapper.deleteAll(ids);
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		mapper.addCourse(course);
	}

	public void deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		mapper.deleteCourse(id);
	}

	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		mapper.updateCourse(course);
	}

	public Course selectByIdC(Integer id) {
		
		return mapper.selectByIdC(id);
	}

	

    
	
}
