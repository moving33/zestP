package com.zest.web.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.StatisticsDAO;
import com.zest.web.admin.model.MainStaticsVO;
import com.zest.web.admin.model.StatisticsVO;

//통계 서비스
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	StatisticsDAO dao;

	// 카테고리별 누적 인원 수
	@Override
	public Map<String, Object> getCount() {
		System.out.println("카테고리별 누적 인원 수 서비스 진입");
		String[] categoryList = { "beauty", "business", "design", "food", "language", "life", "music", "program",
				"sports" };

		List<StatisticsVO> vo = new ArrayList<StatisticsVO>(categoryList.length);
		Map<String, Object> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < categoryList.length; i++) {
			StatisticsVO statis = new StatisticsVO();

			// vo에 카테고리를 입력
			statis.setTalent_category_id(categoryList[i]);

			vo.add(statis);
			System.out.println("dao에 들어갈 vo의 카테고리 이름: " + vo.get(i).getTalent_category_id());

			// 카테고리별 받아온 누적 인원 수
			Integer inputData = dao.getCount(vo.get(i));
			if (inputData == null) {
				inputData = 0;
			}
			map.put("count" + i, inputData);
			sum += inputData;
		}
		map.put("sum", sum);
		return map;
	}

	// 카테고리별 활동 수
	@Override
	public Map<String, Object> getCateCount() {
		System.out.println("카테고리별 활동 수 서비스 진입");
		String[] categoryList = { "beauty", "business", "design", "food", "language", "life", "music", "program",
				"sports" };

		List<StatisticsVO> vo = new ArrayList<StatisticsVO>(categoryList.length);
		Map<String, Object> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < categoryList.length; i++) {
			StatisticsVO statis = new StatisticsVO();

			// vo에 카테고리를 입력
			statis.setTalent_category_id(categoryList[i]);

			vo.add(statis);
			System.out.println("dao에 들어갈 vo의 카테고리 이름: " + vo.get(i).getTalent_category_id());

			// 카테고리별 받아온 활동 수
			Integer inputData = dao.getCateCount(vo.get(i));
			if (inputData == null) {
				inputData = 0;
			}
			map.put("count" + i, inputData);
			sum += inputData;
		}
		map.put("sum", sum);
		return map;
	}

	// 카테고리별 매출
	@Override
	public Map<String, Object> getSales() {
		System.out.println("카테고리별 매출 서비스 진입");
		String[] categoryList = { "beauty", "business", "design", "food", "language", "life", "music", "program",
				"sports" };

		List<StatisticsVO> vo = new ArrayList<StatisticsVO>(categoryList.length);
		Map<String, Object> map = new HashMap<>();
		int sum = 0;

		for (int i = 0; i < categoryList.length; i++) {
			StatisticsVO statis = new StatisticsVO();

			// vo에 카테고리를 입력
			statis.setTalent_category_id(categoryList[i]);

			vo.add(statis);
			System.out.println("dao에 들어갈 vo의 카테고리 이름: " + vo.get(i).getTalent_category_id());

			// 카테고리별 받아온 매출 금액
			Integer inputData = dao.getSales(vo.get(i));
			if (inputData == null) {
				inputData = 0;
			}
			map.put("count" + i, inputData);
			sum += inputData;
		}
		map.put("sum", sum);
		return map;
	}

	@Override
	public MainStaticsVO getMainStatics() {
		int cl_counter = dao.getCLCounter();
		int to_counter = dao.getTOCounter();
		int tt_counter = dao.getTTCounter();
		int tl_counter = dao.getTLCounter();
		MainStaticsVO vo = new MainStaticsVO();
		vo.setCl_counter(cl_counter);
		vo.setTo_counter(to_counter);
		vo.setTt_counter(tt_counter);
		vo.setTl_counter(tl_counter);		
		return vo;	
	}
	
	
	

}
