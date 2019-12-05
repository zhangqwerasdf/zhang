package com.zhiyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.mapper.SpeakMapper;
import com.zhiyou.model.Speaker;

@Service
public class SpeakerServiceImpl implements SpeakerService{
    
	@Autowired
	SpeakMapper speakermapper;
	
	public List<Speaker> selectAll() {
		
		return speakermapper.selectAll();
	}

	public void addSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		speakermapper.addSpeaker(speaker);
	}

	public void deleteSpeaker(int id) {
		// TODO Auto-generated method stub
		speakermapper.deleteSpeaker(id);
	}

	public void updateSpeaker(Speaker speaker) {
		// TODO Auto-generated method stub
		speakermapper.updateSpeaker(speaker);
	}

	public void deleteAllSpeaker(int[] ids) {
		// TODO Auto-generated method stub
		speakermapper.deleteAllSpeaker(ids);
	}

	public Speaker selectByIdS(int id) {
		// TODO Auto-generated method stub
		return speakermapper.selectByIdS(id);
	}

}
