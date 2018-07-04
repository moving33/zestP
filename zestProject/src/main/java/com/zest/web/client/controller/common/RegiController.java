package com.zest.web.client.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.service.client.ClientInsertService;
import com.zest.web.client.service.client.ClientSearchService;

//회원가입 페이지 컨트롤러
@Controller
public class RegiController {

	private Logger logger = LoggerFactory.getLogger(RegiController.class);

	@Autowired
	private ClientSearchService clientSearchService;
	
	@Autowired
	private ClientInsertService clientInsertService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// 회원 가입 페이지만 호출
	@RequestMapping(value = "/common/regiPage", method = RequestMethod.GET)
	public ModelAndView viewMainPage(HttpSession session) {
		logger.info("...ing");
		logger.info("가입되는 곳의 세션 :" +session.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("common/regiPage");
		return modelAndView;
	}

	// 회원가입 post (실제 회원가입)
	@RequestMapping(value = "/common/regiPage", method = RequestMethod.POST)
	public ModelAndView regist(ClientVO clientVO, HttpServletRequest request, ModelAndView model, HttpSession session) {
		logger.info("...ing");
		logger.info("입력된 사용자의 정보: "+clientVO.toString());
		logger.info("가입되는 곳의 세션 :" +session.getId());
		//해당 client가 있는 지 확인
		ClientVO vo = new ClientVO();
		vo = clientSearchService.getClient(clientVO);
		
		//로그인 관련 기능
		
		if(session.getAttribute("client") != null) {
			session.removeAttribute("client");
		}

		//해당 이메일 번호가 있을시 , 중복처리  
		if (vo != null) {				
		
			model.addObject("result","fail");
			model.setViewName("common/regiPage");
			return model;
			
			// 이상 없을시 
		} else {			
			//비밀번호 암호화
			String encPassword = passwordEncoder.encode(clientVO.getCl_pass());
			clientVO.setCl_pass(encPassword);
			//세션에 해당 사용자 내용 추가
			clientInsertService.insertClient(clientVO);
			//저장된 내용 가져오기
			clientVO = clientSearchService.getClient(clientVO);			
			session.setAttribute("client", clientVO);			
			
			model.addObject("result","success");
			model.setViewName("common/regiPage");
			return model;
		}
	}

	public ClientSearchService getClientSearchService() {
		return clientSearchService;
	}

	public void setClientSearchService(ClientSearchService clientSearchService) {
		this.clientSearchService = clientSearchService;
	}

	public ClientInsertService getClientInsertService() {
		return clientInsertService;
	}

	public void setClientInsertService(ClientInsertService clientInsertService) {
		this.clientInsertService = clientInsertService;
	}

	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	
	
}
