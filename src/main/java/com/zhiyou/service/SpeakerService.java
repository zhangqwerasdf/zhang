package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Speaker;

public interface SpeakerService {
    
	//查询全部
	List<Speaker> selectAll();
    
	//增加
	void addSpeaker(Speaker speaker);
    
	//删除
	void deleteSpeaker(int id);
    
	//更新
	void updateSpeaker(Speaker speaker);
    
	//批量删除
	void deleteAllSpeaker(int[] ids);
     
	//通过id查询
	Speaker selectByIdS(int id);
    
	
}
