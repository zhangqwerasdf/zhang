package com.zhiyou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.AdminMapper;
import com.zhiyou.model.Admin;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
	AdminMapper mapper;
    
	public Admin selectByEmail(String accounts) {
		
		return mapper.selectByEmail(accounts);
	}

}
