package com.zest.web.admin.dao;

import com.zest.web.admin.model.Zest_AccountVO;

//zest 계좌 테이블
public interface ZestAccountDAO {
	
	//결제시 저장
	void insertZestAccount(Zest_AccountVO vo);
	
	//잔고보기
	Integer getAccountMoney();
}
