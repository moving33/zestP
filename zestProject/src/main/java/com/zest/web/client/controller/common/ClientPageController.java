package com.zest.web.client.controller.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.page.ClientAndTutorTalentPropPageVO;
import com.zest.web.client.model.talent.Talent_SuccessVO;
import com.zest.web.client.model.tutor.TuTorVO;
import com.zest.web.client.model.tutor.Tutor_PropVO;
import com.zest.web.client.service.talent.TalentMatchingService;
import com.zest.web.client.service.talent.TalentPropConfirmService;
import com.zest.web.client.service.tutor.Tutor_SearchService;

//클라이언트 페이지 , 마이페이지
@Controller
public class ClientPageController {
	
	private Logger logger = LoggerFactory.getLogger(ClientPageController.class);
	
	//신청한 수업 확인 서비스
	@Autowired
	private TalentPropConfirmService talentPropConfirmService;
	//매칭하기
	@Autowired
	private TalentMatchingService talentMatchingService;
	@Autowired
	private Tutor_SearchService tutor_SearchService;
	
	
	@RequestMapping(value="/clientPage")
	public ModelAndView viewClientPage(ModelAndView modelAndView,HttpSession session,
								     	ClientVO clientVO,
								     	ClientAndTutorTalentPropPageVO clAndTtVO) {
		logger.info("...ing");
		modelAndView.setViewName("common/myPage");
		//수업신청서 페이지 키값 저장
		modelAndView.addObject("clientPage", "1");
		
		List<ClientAndTutorTalentPropPageVO> propConfirmClList = new ArrayList<>();
		clientVO = (ClientVO) session.getAttribute("client");
		if(clientVO == null) {
			modelAndView.setViewName("redirect:/main");
			return modelAndView;
		}
		
		
		//신청값 조회하기.
		clAndTtVO.setCl_no(clientVO.getCl_no());
		propConfirmClList = talentPropConfirmService.getOrderTalentForCL(clAndTtVO);
		
		if(propConfirmClList != null) { //신청한 값이 없으면 돌려 보낸다.
			logger.info("값 없음");
			int propConfirmCount = propConfirmClList.size(); //신청한 수업의 갯수
			modelAndView.addObject("confirmCount",propConfirmCount);
			modelAndView.addObject("result", propConfirmClList);
		 
		}	
		
		//신청한 수업 내용 조회하기
		propConfirmClList = returnForClientMatchingDate(propConfirmClList, clientVO.getCl_no());		
		
		
		//받은수업신청서가 있는지 확인..
		List<ClientAndTutorTalentPropPageVO> matchingList = new ArrayList<>();
		ClientAndTutorTalentPropPageVO matchingVO = new ClientAndTutorTalentPropPageVO();
		TuTorVO tutorVO = tutor_SearchService.getTutorForClientEmail(clientVO.getCl_email());		
		
		if(tutorVO == null) {
			return modelAndView;
		}		
		
		matchingVO.setTt_no(tutorVO.getTt_no());
		matchingList = talentMatchingService.getTSforTutor(matchingVO);
		if (matchingList == null) {
			return modelAndView;
		}
		//신청한 강좌 개수
		modelAndView.addObject("talentForClientCount",matchingList.size());
		return modelAndView;
	}
	
	
	//튜터와 매칭 서비스(내용넣기)
	@RequestMapping(value="/clientPage/matchingClient" ,method=RequestMethod.POST)
	@ResponseBody
	public String matchingClient(@RequestBody HashMap<String, String> data,HttpSession session) {
		ClientVO clientVO = (ClientVO) session.getAttribute("client");
		//요청 처리하기
		Talent_SuccessVO vo = new Talent_SuccessVO();
		int to_no = Integer.valueOf(data.get("to_no"));
		int tt_no = Integer.valueOf(data.get("tt_no"));
		int ps_money = Integer.valueOf(data.get("ps_money"));
		String ti_dateString = String.valueOf(data.get("ti_date"));
		//날짜 처리하기
		 DateTimeFormatter formatter
         = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
		LocalDateTime ti_date = LocalDateTime.parse(ti_dateString, formatter);		
		System.out.println("승인요청 처리된 날짜 : " + ti_date);
		vo.setTo_no(to_no);
		vo.setTi_date(ti_date);		
		vo.setTt_no(tt_no);
		vo.setTs_cl_no(clientVO.getCl_no());
		vo.setPs_money(ps_money);
		
		//db 처리		
		talentMatchingService.insertTS(vo);
		return "success";
	}
	
	
	//클라이언트에게 매칭에 저장된 날짜를 저장해주는 녀석
	public List<ClientAndTutorTalentPropPageVO> returnForClientMatchingDate(List<ClientAndTutorTalentPropPageVO> list1,int cl_no){		
				
		for(int i=0;i<list1.size();i++) {
			ClientAndTutorTalentPropPageVO vo1 = list1.get(i);
			Talent_SuccessVO tempVO = new Talent_SuccessVO();			
			tempVO.setTo_no(vo1.getTo_no());
			tempVO.setTs_cl_no(cl_no);			
			tempVO = talentMatchingService.getTSforStatus(tempVO);
			if(tempVO != null) {
				list1.get(i).setTi_date(tempVO.getTi_date());
			}					
		}		
		return list1;
	}
																	
	
	
	
}
