package com.zest.web.client.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.main.MainPageDAO;
import com.zest.web.client.model.page.CategoryPageVO;

//메인페이지 카테고리 가져오는 기능
@Service
public class MainPageGetCategoryServiceImpl implements MainPageGetCategoryService {

	@Autowired
	MainPageDAO dao;
	
	// 메인페이지 인기수업 가져오는 메서드
	@Override
	public List<CategoryPageVO> mainPageGetHotCategory(Object obj) {
		return dao.mainPageGetHotCategory(obj);
	}

}
