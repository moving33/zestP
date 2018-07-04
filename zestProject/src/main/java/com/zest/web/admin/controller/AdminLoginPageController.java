package com.zest.web.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.admin.model.AdminVO;
import com.zest.web.admin.service.AdminLoginService;

@Controller
public class AdminLoginPageController {

	ModelAndView modelAndView = new ModelAndView();

	@Autowired
	AdminLoginService adminLoginService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder; // 암호화

	// 관리자 로그인 페이지
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public ModelAndView adminLoginPage(HttpSession session) {
		if (session.getAttribute("admin") != null) {
			// session.removeAttribute("admin");
			session.invalidate();
		}
		System.out.println("로그인 페이지로 이동");
		modelAndView.setViewName("/admin/adminLoginPage");
		return modelAndView;
	}

	// 관리자 로그인 기능
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView adminLogin(AdminVO vo, HttpSession session) {
		System.out.println("adminLogin 입장");
		if (session.getAttribute("admin") != null) {
			session.removeAttribute("admin");
		}

		// 비밀번호 암호화
		String encPassword = passwordEncoder.encode(vo.getPass());
		/*vo.setPass(encPassword);*/

		// 관리자 조회
		AdminVO dbvo = new AdminVO();
		dbvo = adminLoginService.adminLogin(vo);

		// 등록된 계정이 있는지 확인
		if (dbvo != null) {

			// 비밀번호 확인
			if (passwordEncoder.matches(vo.getPass(), dbvo.getPass())) {

				if (session.getAttribute("admin") != null) {
					// session.removeAttribute("admin");
					session.invalidate();
				}

				session.setAttribute("admin", dbvo);
				modelAndView.addObject("admin", dbvo);
				modelAndView.setViewName("redirect:admin/main");
				System.out.println("로그인 성공");
				System.out.println("세션 확인:" + session.getAttribute("admin"));

				return modelAndView;
			} else {
				
				// 비밀번호가 틀렸을 경우
				System.out.println("비밀번호 불일치");
				modelAndView.setViewName("admin/adminLoginPage");
				modelAndView.addObject("result", "passFail");
				return modelAndView;
			}
		} else {
			// 회원이 없는 경우
			System.out.println("회원이 없음");
			modelAndView.setViewName("admin/adminLoginPage");
			modelAndView.addObject("result", "idFail");
			return modelAndView;
		}

	}

}
