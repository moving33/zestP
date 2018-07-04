package com.zest.web.client.dao.tutor;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.tutor.Tutor_PropVO;

@Repository
public class Tutor_PropDAOImpl implements Tutor_PropDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private Logger logger = LoggerFactory.getLogger(Tutor_PropDAOImpl.class);
	
	//추가
	@Override
	public void insertTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		sqlSessionTemplate.insert("com.zest.tutorProp.insertTutorProp",vo);

	}

	//상태 업데이트 
	@Override
	public void updateTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		sqlSessionTemplate.update("com.zest.tutorProp.updateTutorProp",vo);

	}
	
	
	//상태 체크
	@Override
	public Tutor_PropVO getTutor_propStatus(Tutor_PropVO vo) {
		return sqlSessionTemplate.selectOne("com.zest.tutorProp.checkStauts",vo);
	}

	@Override
	public Tutor_PropVO getTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		return sqlSessionTemplate.selectOne("com.zest.tutorProp.searchTutorProp",vo);
	}

	//튜터 리스트 검색
	@Override
	public List<Tutor_PropVO> getListTutor_prop(Object obj) {

		return sqlSessionTemplate.selectList("com.zest.tutorProp.getTutorPropList",obj);

	}

	@Override
	public Tutor_PropVO getTutor_propNumber(Integer integer) {
		return sqlSessionTemplate.selectOne("com.zest.tutorProp.searchTutorPropNumber",integer);
	}

	@Override
	public Integer getTutor_propCount(Object obj) {
		return sqlSessionTemplate.selectOne("com.zest.tutorProp.countTutorProp",obj);
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	

}
