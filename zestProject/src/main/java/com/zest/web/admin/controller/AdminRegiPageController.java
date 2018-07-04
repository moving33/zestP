package com.zest.web.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.admin.model.AdminVO;
import com.zest.web.admin.service.AdminRegiService;
import com.zest.web.admin.service.AdminSearchService;


@Controller
public class AdminRegiPageController {

	
	@Autowired
	AdminRegiService adminRegiService;
	
	@Autowired
	AdminSearchService adminSearchService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder; // 암호화
	
	// 관리자 등록 페이지로 이동
	@RequestMapping("/adminRegi")
	public String AdminRegiPage() {

		return "admin/adminRegiPage";
	}

	// 관리자 등록 페이지
	@RequestMapping(value = "/adminRegi", method = RequestMethod.POST)
	public ModelAndView AdminRegi(AdminVO vo) {
		
		// 비밀번호 암호화
		String encPassword = passwordEncoder.encode(vo.getPass());
		vo.setPass(encPassword);
		
		AdminVO dbAdmin = adminSearchService.adminSearch(vo); 
		// 관리자 아이디 중복확인
		if(dbAdmin != null) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("result","fail");
			modelAndView.setViewName("admin/adminRegiPage");
			System.out.println("아아디 중복!!");
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView();
			// 관리자 등록
			adminRegiService.adminRegi(vo);
			System.out.println("관리자 등록 완료" + vo.toString());
			modelAndView.setViewName("redirect:adminLogin");
			
			return modelAndView;
		}
		
	}
}
