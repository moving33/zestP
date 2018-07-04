package com.zest.web.client.dao.main;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.page.CategoryPageVO;


// 메인페이지 DAO
@Repository
public class MainPageDAOImpl implements MainPageDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 메인페이지 인기수업 가져오는 메서드
	@Override
	public List<CategoryPageVO> mainPageGetHotCategory(Object obj) {
		return sqlSessionTemplate.selectList("com.zest.mainPage.getHotCategory", obj);
	}
	
	// 메인페이지 인기원데이 리스트 가져오는 메서드
	@Override
	public List<CategoryPageVO> getOneDayCategory(){
		return sqlSessionTemplate.selectList("com.zest.mainPage.getOneDayCategory");
	}
	
	// 메인페이지 리뷰 리스트 가져오는 메서드
	@Override
	public List<CategoryPageVO> getReviewCategory(){
		return sqlSessionTemplate.selectList("com.zest.mainPage.getReviewCategory");
	}
	
	// 메인페이지 리뷰 리스트 가져오는 메서드
	@Override
	public List<CategoryPageVO> getReviewClient(CategoryPageVO reviewList){
		System.out.println("리뷰 작성자 dao");
		return sqlSessionTemplate.selectList("com.zest.mainPage.getReviewClient", reviewList);
	}

}
