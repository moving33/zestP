package com.zest.web.client.dao.tutor;

import java.util.List;

import com.zest.web.client.model.tutor.Tutor_PropVO;

//튜터신청테이블의 DAO 
public interface Tutor_PropDAO {
	
	//신청
	void insertTutor_prop(Tutor_PropVO vo);
	
	//상태 , 이미지 파일 경로 업데이트하기 , 내용 업데이트하기
	void updateTutor_prop(Tutor_PropVO vo);
	
	//개별검색
	Tutor_PropVO getTutor_prop(Tutor_PropVO vo);
	
	//상태 체크
	Tutor_PropVO getTutor_propStatus(Tutor_PropVO vo);
	
	//리스트 검색
	List<Tutor_PropVO> getListTutor_prop(Object obj);

	//primary key 가지고 검색
	Tutor_PropVO getTutor_propNumber(Integer integer);

	//승인할 애들의 총 개수 가져오기
	Integer getTutor_propCount(Object obj);
	



	
	
	
	
}
