package com.zest.web.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zest.web.admin.model.MainStaticsVO;
import com.zest.web.admin.model.TalentSubmitVO;
import com.zest.web.admin.service.StatisticsService;
import com.zest.web.admin.service.TalentSubmitService;

@Controller
public class AdminMainPageController {

	@Autowired 
	StatisticsService statisticsService; 
	@Autowired
	TalentSubmitService talentSubmitService;
	
	
	// 관리자 메인 페이지
	@RequestMapping("/admin/main")
	public String viewAdminMainPage(HttpSession session,Model model) {
		if(session.getAttribute("admin") == null) {
			session.invalidate();
		}
		
		List<TalentSubmitVO> list = new ArrayList<>();
		
		list = talentSubmitService.getTalentSubmit();		
		
		MainStaticsVO vo = statisticsService.getMainStatics();
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		model.addAttribute("listCounter", list.size());
		System.out.println("승인 요청된 게시글들 :"+ list.size());
		
		System.out.println(vo.toString());
		return "/admin/adminPageMain";	
		
	}
	
	
	
}
