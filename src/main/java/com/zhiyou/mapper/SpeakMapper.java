package com.zhiyou.mapper;

import java.util.List;

import com.zhiyou.model.Speaker;

public interface SpeakMapper {

	List<Speaker> selectAll();

	void addSpeaker(Speaker speaker);

	void deleteSpeaker(int id);

	void updateSpeaker(Speaker speaker);

	void deleteAllSpeaker(int[] ids);

	Speaker selectByIdS(int id);

}
