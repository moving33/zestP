package com.zest.web.client.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.service.client.ClientInsertService;
import com.zest.web.client.service.client.ClientSearchService;

//페이스북 로그인 컨트롤러
@Controller
public class facebookLoginController {

	private Logger logger = LoggerFactory.getLogger(facebookLoginController.class);

	@Autowired
	private ClientSearchService clientSearchService;

	@Autowired
	private ClientInsertService clientInsertService;

	// 페이스북 로그인 정보 받아와서 세션 등록
	@RequestMapping(value = "/facebookLogin/session", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView facebookLoginSession(HttpSession session, HttpServletRequest request,
			ModelAndView modelAndView) {
		logger.info("...ing-페북 로그인");
		
		if (session.getAttribute("client") != null) {
			session.removeAttribute("client");
		}
		ClientVO vo = new ClientVO();

		// 페이스북에서 받아온 유저 정보 모델에 저장
		vo.setCl_name(request.getParameter("name")); // 이름
		vo.setCl_email(request.getParameter("id")); // 페북 아이디

		// DB에 페북 유저 정보가 있는지 확인

		vo = clientSearchService.getClient(vo);
		if (vo != null) {
			session.setAttribute("client", vo);
			modelAndView.addObject("result", "success");
			modelAndView.setViewName("common/loginPage");
			return modelAndView;
		}

		ClientVO vo1	= new ClientVO();
		// 세션에 해당 사용자 내용 추가 및 db에 정보 추가
		vo1.setCl_name(request.getParameter("name")); // 이름
		vo1.setCl_email(request.getParameter("id")); // 페북 아이디

		clientInsertService.insertClient(vo1);
		session.setAttribute("client", clientSearchService.getClient(vo1));

		modelAndView.addObject("result", "success");
		modelAndView.setViewName("common/loginPage");
		return modelAndView;

	}

}
