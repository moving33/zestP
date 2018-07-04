package com.zest.web.client.service;

import java.util.List;

import com.zest.web.client.model.page.CategoryPageVO;

public interface CategoryPageService {
	
	// 카테고리(대분류) 리스트 가져오는 메서드
	List<CategoryPageVO> getCategoryPageList(Object obj);
	
	// 카테고리(소분류) 리스트 가져오는 메서드
	List<CategoryPageVO> getLecturePageList(Object obj);
	
	//가져올 글개수 카운트
	Integer getCategoryPageListCount(Object obj);
}
