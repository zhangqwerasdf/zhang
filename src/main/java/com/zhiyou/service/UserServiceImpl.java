package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.UserMapper;
import com.zhiyou.model.User;
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserMapper mapper;
	
	public void add(User user) {
		mapper.add(user);
	}

	public void update(User user) {
		mapper.update(user);
	}

	public void delete(int id) {
		mapper.delete(id);
	}

	public List<User> selectAll() {
		return mapper.selectAll();
	}

	public User selectById(int id) {
		return mapper.selectById(id);
	}

	public User findUserByLogin(String nickname, String password) {
		
		return mapper.findUserByLogin(nickname, password);
	}
	
}
