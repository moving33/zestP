package com.zest.web.client.service;

import java.util.List;

import com.zest.web.client.model.classification.LectureVO;

public interface LectureService {
	
	//카테고리(소/강의) 리스트를 가져오는 메서드 
	List<LectureVO> getLectureList(LectureVO lectureVO);
}
