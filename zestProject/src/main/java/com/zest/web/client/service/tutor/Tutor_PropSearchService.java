package com.zest.web.client.service.tutor;

import java.util.List;

import com.zest.web.client.model.tutor.Tutor_PropVO;

//튜터 신청테이블 검색 서비스
public interface Tutor_PropSearchService {
	
	
	//개별검색
	Tutor_PropVO getTutor_prop(Tutor_PropVO vo);
	Tutor_PropVO getTutor_propNumber(Integer integer);
	
	//상태 검색
	Tutor_PropVO getTutor_propStatus(Tutor_PropVO vo);

	
	//리스트 검색
	List<Tutor_PropVO> getListTutor_prop(Object obj);

	//가져올 글개수 카운트
	Integer getTutor_propCount(Object obj);
}
