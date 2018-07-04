package com.zest.web.client.controller.payment;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.admin.model.Zest_AccountVO;
import com.zest.web.admin.service.ZestAccounInsertService;
import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.client.Client_pointVO;
import com.zest.web.client.model.payment.TalentPropVO;
import com.zest.web.client.model.payment.Talent_OrderVO;
import com.zest.web.client.model.talent.TalentVO;
import com.zest.web.client.service.client.ClassDetailService;
import com.zest.web.client.service.client.ClientPointService;
import com.zest.web.client.service.client.ClientUpdateService;
import com.zest.web.client.service.talent.TalentOrderInsertService;
import com.zest.web.client.service.talent.TalentPropInsertService;
import com.zest.web.client.service.talent.TalentPropSearchService;
import com.zest.web.client.service.talent.TalentPropUpdateService;
import com.zest.web.util.GetRemoteIP;

//결제 관련 페이지
@Controller
public class PaymentController {

	private Logger logger = LoggerFactory.getLogger(PaymentController.class);

	// 부가세
	private double priceVAT = 1.1;

	// 포인트 적립 퍼센트
	private double pointPer = 0.03;

	// 결제
	@Autowired
	private TalentOrderInsertService talentorderinsertservice;

	@Autowired
	private TalentPropUpdateService talentpropupdateservice;

	@Autowired
	private TalentPropInsertService talentPropInsertService;

	@Autowired
	private ClassDetailService classDetailService;

	@Autowired
	private ClientUpdateService clientupdateservice;

	@Autowired
	private ZestAccounInsertService zestAccounInsertService;

	@Autowired
	private TalentPropSearchService talentPropSearchService;

	// 포인트
	@Autowired
	private ClientPointService clientpointservice;

	// 카카오 결제 page보여주기
	@RequestMapping(value = "/payment/kkaoPay")
	public ModelAndView kkaoPaymentView(ModelAndView modelAndView, HttpSession session, @RequestParam Integer point,
			@RequestParam Integer talent_no) {

		logger.info(point + " /" + talent_no);

		TalentVO talentVO = classDetailService.talentCall(talent_no);
		ClientVO clientVO = (ClientVO) session.getAttribute("client");
		logger.info(clientVO.toString());

		// 실제 결제 금액 작업하기
		double realprice = talentVO.getTalent_total_price() * priceVAT;
		realprice = Math.floor(realprice);
		realprice = realprice - point;

		Integer realPriceResult = (int) realprice;

		logger.info(String.valueOf(realPriceResult));

		modelAndView.addObject("point", point);
		modelAndView.addObject("realPrice", realPriceResult);
		modelAndView.addObject("talent", talentVO);
		modelAndView.addObject("client", clientVO);
		modelAndView.setViewName("/payment/kkaopaymentPage");
		return modelAndView;
	}

	// 카카오 실결제
	@RequestMapping(value = "/payment/kkaoPayMent", method = RequestMethod.POST)
	public ModelAndView kkaoPayment(ModelAndView modelAndView, HttpServletRequest req, Talent_OrderVO talent_OrderVO,
			HttpSession session) {

		GetRemoteIP getIp = new GetRemoteIP();
		talent_OrderVO.setTo_ip(getIp.getIp(req));
		talent_OrderVO.setTp_status(1);
		logger.info(talent_OrderVO.toString());
		// 결제처리하고 key값 받아오기
		int to_no = talentorderinsertservice.insertTO(talent_OrderVO);

		// 결제처리후 신청 테이블 업데이트하기
		TalentPropVO talentPropVO = new TalentPropVO();
		talentPropVO.setCl_no(talent_OrderVO.getCl_no());
		talentPropVO.setTalent_no(talent_OrderVO.getTalent_no());

		talentpropupdateservice.completeProp(talentPropVO);

		// 포인트 처리하기
		Client_pointVO client_pointVO = new Client_pointVO();
		client_pointVO.setCl_no(talent_OrderVO.getCl_no());
		client_pointVO.setTo_no(to_no);
		client_pointVO.setCp_type("out");

		// 적립 포인트 계산
		double cp_in_point = talent_OrderVO.getTo_real_price() * pointPer;
		cp_in_point = Math.floor(cp_in_point);
		int inpoint = (int) cp_in_point;
		logger.info("적립 포인트 :" + String.valueOf(inpoint));
		client_pointVO.setCp_in_point(inpoint);

		client_pointVO.setCp_out_point(talent_OrderVO.getTo_use_point());

		// 총 포인트 계산....
		ClientVO clientVO = (ClientVO) session.getAttribute("client");
		int totalPoint = clientVO.getCl_point() - talent_OrderVO.getTo_use_point() + inpoint;
		client_pointVO.setCp_total_point(totalPoint);

		// 포인트 값 넣기
		clientpointservice.insertCP(client_pointVO);

		// 포인트 결과 client에게 반영 (적립)
		clientVO.setCl_point(totalPoint);
		clientpointservice.updateClient_CP(clientVO);

		// 누적금액 업데이트
		clientVO.setCl_acc_money(clientVO.getCl_acc_money() + talent_OrderVO.getTo_real_price());
		clientupdateservice.plusAccMoney(clientVO);

		// zestAccount에 결제 내용 넣기
		Zest_AccountVO zest_ac_vo = new Zest_AccountVO();
		zest_ac_vo.setTo_no(to_no);
		zestAccounInsertService.insertZestAccount(zest_ac_vo, talent_OrderVO);

		modelAndView.setViewName("/payment/kkaopaymentPage");
		modelAndView.addObject("result", "success");
		return modelAndView;
	}

	@RequestMapping(value = "/payment/phoneCertification")
	public ModelAndView phoneCertification(ModelAndView modelAndView) {
		modelAndView.setViewName("/payment/phoneCertification");
		return modelAndView;
	}

	@RequestMapping(value = "/payment/kcpPayment")
	public ModelAndView kcpPayment(ModelAndView modelAndView) {
		modelAndView.setViewName("/payment/kcpPaymentPage");
		return modelAndView;
	}

	// 주문 신청
	@RequestMapping(value = "/payment/talentProp")
	@ResponseBody
	public String talentProp(ModelAndView modelAndView, @RequestBody HashMap<String, String> data, TalentPropVO propVO,
			HttpSession session) {

		// data 받기
		int talent_no = Integer.valueOf(data.get("talent_no"));
		int tt_no = Integer.valueOf(data.get("tt_no"));
		int price_total = Integer.valueOf(data.get("price_total"));
		int career_level = Integer.valueOf(data.get("career_level"));
		int career = Integer.valueOf(data.get("career"));
		String tp_message = data.get("tp_message");
		ClientVO clientVO = (ClientVO) session.getAttribute("client");

		// 미로그인시
		if (clientVO == null) {
			return "loginError";
		}

		// 주문 처리 서비스
		propVO.setTalent_no(talent_no);
		propVO.setCl_no(clientVO.getCl_no());
		propVO.setTt_no(tt_no);
		propVO.setTp_career_level(career_level);
		propVO.setTp_career_month(career);
		propVO.setTp_message(tp_message);
		propVO.setTp_price_total(price_total);

		talentPropInsertService.insertTP(propVO);
		return "success";
	}

	// 주문 신청확인
	@RequestMapping(value = "/payment/talentPropCheck")
	@ResponseBody
	public String talentPropConfirm(ModelAndView modelAndView, @RequestBody HashMap<String, String> data,
			HttpSession session) {
		int talent_no = Integer.valueOf(data.get("talent_no"));
		ClientVO clientVO = (ClientVO) session.getAttribute("client");

		TalentPropVO propVO = new TalentPropVO();
		propVO.setTalent_no(talent_no);
		propVO.setCl_no(clientVO.getCl_no());
		System.out.println(talent_no+".."+clientVO.getCl_no());
		// 값을 집어넣기 전에 이미 신청한 사람인지 확인해야함 (미완)
		TalentPropVO confirmVo = new TalentPropVO();
		confirmVo = talentPropSearchService.getPropUser(propVO);
		// 신청한 사용자가 있으면
		if (confirmVo == null) {		
			return "success";			
		} else {
			return "fail";
		}
	}

}
