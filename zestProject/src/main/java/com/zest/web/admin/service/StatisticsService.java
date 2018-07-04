package com.zest.web.admin.service;

import java.util.Map;

import com.zest.web.admin.model.MainStaticsVO;

// 통계 서비스
public interface StatisticsService {
	
	// 카테고리별 누적 인원 수
	Map<String, Object> getCount();
	
	// 카테고리별 누적 인원 수
	Map<String, Object> getCateCount();
	
	// 카테고리별 매출
	Map<String, Object> getSales();
	
	//메인페이지 통계 
	MainStaticsVO getMainStatics();
}
