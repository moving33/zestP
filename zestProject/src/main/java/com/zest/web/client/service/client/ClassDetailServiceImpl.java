package com.zest.web.client.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.category.ClassDetailDAO;
import com.zest.web.client.model.talent.Talent_info;
import com.zest.web.client.model.talent.ClassDetailVO;
import com.zest.web.client.model.talent.ClassDetail_TutorVO;
import com.zest.web.client.model.talent.ReviewVO;
import com.zest.web.client.model.talent.TalentOneDayTimeVO;
import com.zest.web.client.model.talent.TalentVO;
import com.zest.web.client.model.talent.Talent_notOneDayTime;



@Service
public class ClassDetailServiceImpl implements ClassDetailService {
	
	@Autowired
	ClassDetailDAO dao;
	
	//수업상세 보기
	@Override
	public List<ClassDetailVO> classCall(Integer talent_no) {
		System.out.println("classCall 메소드 : " + talent_no);
		return dao.classCall(talent_no);
	}
	
	//talent_content 불러오기
	@Override
	public ClassDetailVO contentCall(Integer talent_no) {
		System.out.println("contentCall 메소드 : " + talent_no);
		return dao.contentCall(talent_no);
	}
	
	//talent 불러오기
	@Override
	public TalentVO talentCall(Integer talent_no) {
		return dao.talentCall(talent_no);
	}
	
	//tutor 정보 불러오기
	@Override
	public ClassDetail_TutorVO tutorCall(Integer talent_no) {
		return dao.tutorCall(talent_no);
	}
	
	//review 불러오기
	@Override
	public List<ReviewVO> reviewCall(Integer talent_no){
		return dao.reviewCall(talent_no);
	}
	
	//review 값 평균 불러오기
	@Override
	public ReviewVO reviewValue(Integer talent_no) {
		return dao.reviewValue(talent_no);
	}
	
	//ZONE & DAY 불러오기 (TALENT_INFO)
	@Override
	public List<Talent_info> zoneDayCall(Integer talent_no){
		return dao.zoneDayCall(talent_no);
	}
	
	
	//not원데이 객체 불러오기
	@Override
	public Talent_notOneDayTime getTalent_notOneDayTime(Talent_notOneDayTime vo) {
		return dao.getTalent_notOneDayTime(vo);
	}
	
	
	//원데이 객체 불러오기
	@Override
	public TalentOneDayTimeVO getTalent_OnedayTime(TalentOneDayTimeVO vo) {
		return dao.getTalent_OnedayTime(vo);
	}
	
	
	

	@Override
	public Integer getReviewCount(Integer talent_no) {
		return dao.getReviewCount(talent_no);
	}

	@Override
	public List<ReviewVO> getReviewList(Object obj) {
		return dao.getReviewList(obj);
	}

	public ClassDetailDAO getDao() {
		return dao;
	}

	public void setDao(ClassDetailDAO dao) {
		this.dao = dao;
	}
	
	
	
	

}
