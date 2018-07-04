package com.zest.web.client.dao.cate;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zest.web.client.model.classification.CategoryVO;
import com.zest.web.client.model.page.CategoryPageVO;

@Controller
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//카테고리 리스트를 불러오는 DAO
	@Override
	public List<CategoryVO> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	// 카테고리(대분류) 페이지 리스트를 불러오는 메서드
	@Override
	public List<CategoryPageVO> getCategoryPageList(Object obj) {
		System.out.println("카테고리(대분류) dao 진입");
		return sqlSessionTemplate.selectList("com.zest.categoryPage.getCategoryPageList", obj);
	}
	
	// 카테고리(소분류) 페이지 리스트를 불러오는 메서드
	public List<CategoryPageVO> getLecturePageList(Object obj){
			System.out.println("카테고리(소분류) dao 진입");
			return sqlSessionTemplate.selectList("com.zest.categoryPage.getLecturePageList", obj);
		}
	
	@Override
	public Integer getCategoryPageListCount(Object obj) {
		return sqlSessionTemplate.selectOne("com.zest.categoryPage.getCategoryPageListCount",obj);
	}

}
