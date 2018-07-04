package com.zest.web.client.dao.cate;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.talent.Talent_info;
import com.zest.web.client.model.talent.ClassDetailVO;
import com.zest.web.client.model.talent.ClassDetail_TutorVO;
import com.zest.web.client.model.talent.ReviewVO;
import com.zest.web.client.model.talent.TalentOneDayTimeVO;
import com.zest.web.client.model.talent.TalentVO;
import com.zest.web.client.model.talent.Talent_notOneDayTime;



@Repository
public class ClassDetailDAOImpl implements ClassDetailDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 강의디테일 불러오기
	@Override
	public List<ClassDetailVO> classCall(Integer talent_no) {
		System.out.println("classCall 메서드 : " + talent_no);
		List<ClassDetailVO> vo = sqlSession.selectList("com.zest.classDetail.getClass", talent_no);

		return vo;
	}
	
	//talent_content 불러오기
	@Override
	public ClassDetailVO contentCall(Integer talent_no) {
		ClassDetailVO vo = sqlSession.selectOne("com.zest.classDetail.ContentClass", talent_no);
		return vo;
	}
	
	//talent 불러오기
	@Override
	public TalentVO talentCall(Integer talent_no) {
		TalentVO vo = sqlSession.selectOne("com.zest.classDetail.talentClass", talent_no);
		return vo;
	}
	
	//tutor 정보 불러오기
	@Override
	public ClassDetail_TutorVO tutorCall(Integer talent_no) {
		ClassDetail_TutorVO vo = sqlSession.selectOne("com.zest.classDetail.talentInfo", talent_no);
		return vo;
	}
	
	//review 불러오기
	@Override
	public List<ReviewVO> reviewCall(Integer talent_no){
		List<ReviewVO> vo = sqlSession.selectList("com.zest.classDetail.reviewInfo", talent_no);
		return vo;
	}
	
	//review 값 평균 불러오기
	@Override
	public ReviewVO reviewValue(Integer talent_no) {
		ReviewVO vo = sqlSession.selectOne("com.zest.classDetail.reviewValue", talent_no);
		return vo;
	}
	
	//ZONE & DAY 불러오기 (TALENT_INFO)
	@Override
	public List<Talent_info> zoneDayCall(Integer talent_no){
		List<Talent_info> vo = sqlSession.selectList("com.zest.talent_Info.zoneDay", talent_no);
		return vo;
	}
	

	@Override
	public Talent_notOneDayTime getTalent_notOneDayTime(Talent_notOneDayTime vo) {
		return sqlSession.selectOne("com.zest.talent_NotOneDay.getnotOndayTime",vo);
	}
	

	
	@Override
	public TalentOneDayTimeVO getTalent_OnedayTime(TalentOneDayTimeVO vo) {
		return sqlSession.selectOne("com.zest.talent_OneDay.getOnedayTime", vo);
	}
	
	
	
	

	@Override
	public Integer getReviewCount(Integer talent_no) {
		return sqlSession.selectOne("com.zest.classDetail.reviewCount", talent_no);
	}

	@Override
	public List<ReviewVO> getReviewList(Object obj) {
		List<ReviewVO> vo = sqlSession.selectList("com.zest.classDetail.reviewAll", obj);
		System.out.println("리뷰리스트불러오기 :" + vo.toString());
		return vo;
	}

	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	

}
