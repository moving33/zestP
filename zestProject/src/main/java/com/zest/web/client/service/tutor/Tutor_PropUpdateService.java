package com.zest.web.client.service.tutor;

import com.zest.web.client.model.tutor.Tutor_PropVO;

public interface Tutor_PropUpdateService {


	//상태 , 이미지 파일 경로 업데이트하기 , 내용 업데이트하기
	void updateTutor_prop(Tutor_PropVO vo);
}
