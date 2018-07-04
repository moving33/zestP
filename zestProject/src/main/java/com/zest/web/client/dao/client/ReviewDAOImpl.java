package com.zest.web.client.dao.client;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.talent.ReviewVO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//리뷰쓰기
	@Override
	public void insertReview(ReviewVO vo) {
		sqlSessionTemplate.insert("com.zest.rievew.insertReview", vo);

	}

	@Override
	public void updateReview(ReviewVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReview(ReviewVO vo) {
		// TODO Auto-generated method stub

	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
	
}
