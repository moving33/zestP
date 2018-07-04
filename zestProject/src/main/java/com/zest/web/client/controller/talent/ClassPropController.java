package com.zest.web.client.controller.talent;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.talent.TalentVO;
import com.zest.web.client.service.client.ClassDetailService;


//클래스신청 컨트롤러
@Controller
public class ClassPropController {	
	
	private Logger logger = LoggerFactory.getLogger(ClassPropController.class);
	
	@Autowired
	private ClassDetailService classDetailService;
	
	
	//신청페이지 보여주기
	@RequestMapping(value="/talentProp")
	public ModelAndView talentPropPageView(ModelAndView modelAndView,HttpSession session,
				@RequestParam(required=false)String talent_no) {
		
		//클라이언트 넘겨주기
		ClientVO clientVO = (ClientVO) session.getAttribute("client");
		
		//미로그인시 
		if(clientVO == null) {
			modelAndView.addObject("fail", "loginError");
			modelAndView.setViewName("talent/talentPropPage");
			return modelAndView;
		}		
		
		//수업 가져오기
		TalentVO talentVO = classDetailService.talentCall(Integer.valueOf(talent_no));
		
		logger.info(clientVO.toString());
		logger.info(talentVO.toString());
		modelAndView.setViewName("talent/talentPropPage");	
		modelAndView.addObject("client",clientVO);
		modelAndView.addObject("talent", talentVO);
		return modelAndView;
	}
	
	
}
