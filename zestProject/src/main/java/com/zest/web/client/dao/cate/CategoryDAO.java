package com.zest.web.client.dao.cate;

import java.util.List;

import com.zest.web.client.model.classification.CategoryVO;
import com.zest.web.client.model.page.CategoryPageVO;

public interface CategoryDAO {
	
	
	
	//카테고리 리스트를 불러오는 메서드 
	List<CategoryVO> getCategoryList();
	
	// 카테고리(대분류) 페이지 리스트를 불러오는 메서드
	List<CategoryPageVO> getCategoryPageList(Object obj);
	
	// 카테고리(소분류) 페이지 리스트를 불러오는 메서드
	List<CategoryPageVO> getLecturePageList(Object obj);
	
	//가져올 글개수 카운트
	Integer getCategoryPageListCount(Object obj);

}
