package com.zest.web.client.service.main;

import java.util.List;

import com.zest.web.client.model.page.CategoryPageVO;

// 메인페이지 카테고리 가져오는 기능
public interface MainPageGetCategoryService {
	
	// 메인페이지 인기수업 가져오는 메서드
	List<CategoryPageVO> mainPageGetHotCategory(Object obj);
}
