package com.zest.web.admin.dao;

import java.util.List;

import com.zest.web.admin.model.StatisticsVO;

public interface StatisticsDAO {
	
	// 카테고리별 누적 인원 수
	Integer getCount(StatisticsVO vo);
	
	// 카테고리별 활동 수
	Integer getCateCount(StatisticsVO vo);
	
	// 카테고리별 매출
	Integer getSales(StatisticsVO vo);
	
	// 메인페이지 월별 위부터 = 가입한 회원,결제갯수,튜터,수업
	Integer getCLCounter();
	Integer getTOCounter();
	Integer getTTCounter();
	Integer getTLCounter();
	
	
}
