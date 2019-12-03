package com.zhiyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhiyou.model.User;

public interface UserMapper {

	void add(User user);

	void update(User user);

	void delete(int id);

	List<User> selectAll();

	User selectById(int id);

	User findUserByLogin(@Param("nickname")String nickname, @Param("password")String password) ;

}
