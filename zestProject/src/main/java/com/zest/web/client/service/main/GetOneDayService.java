package com.zest.web.client.service.main;

import java.util.List;

import com.zest.web.client.model.page.CategoryPageVO;

public interface GetOneDayService {
	// 메인페이지 인기원데이 리스트 가져오는 메서드
	List<CategoryPageVO> getOneDayCategory();
}
