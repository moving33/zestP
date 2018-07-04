package com.zest.web.client.dao.main;

import java.util.List;

import com.zest.web.client.model.page.CategoryPageVO;

// 메인페이지 DAO
public interface MainPageDAO {
	
	// 메인페이지 인기수업 가져오는 메서드
	List<CategoryPageVO> mainPageGetHotCategory(Object obj);
	
	// 메인페이지 인기원데이 리스트 가져오는 메서드
	List<CategoryPageVO> getOneDayCategory();
	
	// 메인페이지 리뷰 리스트 가져오는 메서드
	List<CategoryPageVO> getReviewCategory();
	
	// 메인페이지 리뷰 리스트 가져오는 메서드
	List<CategoryPageVO> getReviewClient(CategoryPageVO reviewList);
}
