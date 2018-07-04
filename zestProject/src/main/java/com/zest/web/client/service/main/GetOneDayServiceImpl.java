package com.zest.web.client.service.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.main.MainPageDAO;
import com.zest.web.client.model.page.CategoryPageVO;

@Service
public class GetOneDayServiceImpl implements GetOneDayService {

	@Autowired
	MainPageDAO dao;
	
	// 메인페이지 인기원데이 리스트 가져오는 메서드
	@Override
	public List<CategoryPageVO> getOneDayCategory() {
		return dao.getOneDayCategory();
	}

}
