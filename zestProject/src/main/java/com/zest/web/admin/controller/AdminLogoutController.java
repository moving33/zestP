package com.zest.web.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.admin.service.AdminLoginService;

@Controller
public class AdminLogoutController {

	ModelAndView modelAndView = new ModelAndView();

	@Autowired
	AdminLoginService adminLoginService;


	// 관리자 로그인 페이지
	@RequestMapping(value = "/admin/logout")
	public String adminLogout(HttpSession session) {
			session.invalidate();
			
		System.out.println("관리자 로그아웃");
		
		return"redirect:/adminLogin";
	}
}
