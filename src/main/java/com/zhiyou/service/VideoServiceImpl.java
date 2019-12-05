package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.VideoMapper;
import com.zhiyou.model.Video;

@Service
public class VideoServiceImpl implements VideoService {
     
	@Autowired
	VideoMapper mapper;
	
	public List<Video> selectAllVideo() {
		// TODO Auto-generated method stub
		return mapper.selectAllVideo();
	}

}
