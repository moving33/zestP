package com.zest.web.admin.controller.sales;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.admin.service.StatisticsService;

// 통계 컨트롤러
@Controller
public class SalesController {

	@Autowired
	StatisticsService statisticsService;
	
	// 카테고리별 매출 통계
	@RequestMapping(value = "admin/sales")
	public ModelAndView statisticsMain(ModelAndView modelAndView) {
		modelAndView.setViewName("admin/sales/salesPage");
		modelAndView.addObject("model",statisticsService.getSales());
		
		return modelAndView;
	}
	
}
