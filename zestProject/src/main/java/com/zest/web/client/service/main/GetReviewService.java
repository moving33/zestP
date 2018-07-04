package com.zest.web.client.service.main;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zest.web.client.model.page.CategoryPageVO;

// 메인페이지 리뷰 리스트를 가져오는 기능
public interface GetReviewService {
	// 메인페이지 인기원데이 리스트 가져오는 메서드
	List<CategoryPageVO> getReviewCategory();
	// 메인페이지 리뷰 리스트 가져오는 메서드
	List<CategoryPageVO> getReviewClient(CategoryPageVO categoryPageVO);
}
