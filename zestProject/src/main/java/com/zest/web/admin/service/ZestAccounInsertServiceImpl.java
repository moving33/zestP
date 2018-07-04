package com.zest.web.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.ZestAccountDAO;
import com.zest.web.admin.model.Zest_AccountVO;
import com.zest.web.client.model.payment.Talent_OrderVO;

@Service
public class ZestAccounInsertServiceImpl implements ZestAccounInsertService {

	@Autowired
	private ZestAccountDAO zestAccountDAO;
	
	//주문시 처리
	@Override
	public void insertZestAccount(Zest_AccountVO ac_vo,Talent_OrderVO to_vo) {
		//현재 잔고값 가져오기
		int deposit = zestAccountDAO.getAccountMoney();
		//늘어난 잔고 저장장하기 
		deposit = deposit + to_vo.getTo_real_price(); //가격
		ac_vo.setDep_type("in"); // 타입
		ac_vo.setDep_money(to_vo.getTo_real_price()); //입금금액
		ac_vo.setWit_money(0); //출금 금액
		ac_vo.setZest_dep(deposit); //잔고
		ac_vo.setDep_cl_no(to_vo.getCl_no()); // 신청한 사람
		ac_vo.setDep_talent_no(to_vo.getTt_no()); // 해당 수업의 튜터 넘버
		ac_vo.setDep_talent_no(to_vo.getTalent_no()); // 결제한 수업 넘버
		zestAccountDAO.insertZestAccount(ac_vo);
	}

}
