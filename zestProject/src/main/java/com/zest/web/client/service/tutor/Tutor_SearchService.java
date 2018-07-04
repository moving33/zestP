package com.zest.web.client.service.tutor;

import com.zest.web.client.model.tutor.TuTorVO;

//튜터 서치 서비스
public interface Tutor_SearchService {
	
	//client Email id로 튜터 검색
	TuTorVO getTutorForClientEmail(String TutorEmailId); 
		
	
}
