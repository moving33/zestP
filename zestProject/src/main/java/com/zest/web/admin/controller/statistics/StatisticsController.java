package com.zest.web.admin.controller.statistics;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.admin.service.StatisticsService;

// 통계 컨트롤러
@Controller
public class StatisticsController {

	@Autowired
	StatisticsService statisticsService;
	
	// 카테고리별 누적 인원 수
	@RequestMapping(value = "admin/statistics")
	public ModelAndView statisticsMain(ModelAndView modelAndView) {
		modelAndView.setViewName("admin/statistics/statisticsPage");
		modelAndView.addObject("model",statisticsService.getCount());
		
		return modelAndView;
	}
	
	// 카테고리별 활동 수
	@RequestMapping(value = "admin/statisticsCate")
	public ModelAndView statisticsCate(ModelAndView modelAndView) {
		modelAndView.setViewName("admin/statistics/statisticsCate");
		modelAndView.addObject("model",statisticsService.getCateCount());
			
		return modelAndView;
	}
}
