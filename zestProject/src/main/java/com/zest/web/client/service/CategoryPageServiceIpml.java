package com.zest.web.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.category.CategoryDAO;
import com.zest.web.client.model.page.CategoryPageVO;

@Service
public class CategoryPageServiceIpml implements CategoryPageService {

	@Autowired
	CategoryDAO dao;
	
	// 카테고리(대분류) 리스트 가져오는 메서드
	@Override
	public List<CategoryPageVO> getCategoryPageList(Object obj) {
		return dao.getCategoryPageList(obj);
	}
	
	// 카테고리(대분류) 리스트 가져오는 메서드
	public List<CategoryPageVO> getLecturePageList(Object obj){
		return dao.getLecturePageList(obj);
	}
	
	//가져올 글개수 카운트
	@Override
	public Integer getCategoryPageListCount(Object obj) {
		return dao.getCategoryPageListCount(obj);
	}

}
