package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.Course;
import com.zhiyou.model.User;

public interface CourseMapper {

	List<Course> selectAll();
    
	void deleteAll(int[] ids);//批量删除

	void addCourse(Course course);//增加课程

	void deleteCourse(Integer id);//删除课程

	void updateCourse(Course course);//更新

	Course selectByIdC(Integer id);
}
