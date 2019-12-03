package com.zhiyou.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhiyou.model.User;


public interface UserService {

	 void add(User user);   //方法名保持与对应mapper中的id一致
	 void update(User user);//参数与mapper中的parameterType一致
	 void delete(int id);
	 List<User> selectAll();//返回值与mapper中的resultType一致
     User selectById(int id);
	User findUserByLogin(String nickname, String password);
	

}
