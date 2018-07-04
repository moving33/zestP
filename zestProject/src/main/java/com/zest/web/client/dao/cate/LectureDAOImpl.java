package com.zest.web.client.dao.cate;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.classification.CategoryVO;
import com.zest.web.client.model.classification.LectureVO;

@Repository
public class LectureDAOImpl implements LectureDAO {	
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//카테고리 소 분류 리스트를 리턴해주는 메서드
	@Override
	public List<LectureVO> getLectureList(LectureVO lectureVO) {		
		
		List<LectureVO> list = sqlSession.selectList("com.zest.lecture.getLectureList", lectureVO);		
		return list;
		
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	

}
