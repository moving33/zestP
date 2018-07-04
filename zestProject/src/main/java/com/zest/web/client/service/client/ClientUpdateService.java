package com.zest.web.client.service.client;

import com.zest.web.client.model.client.ClientVO;

public interface ClientUpdateService {
	
	//마지막 로그인 업데이트
	void clientLastLogin(ClientVO vo);
	
	//누적사용금액 업데이트 
	void plusAccMoney(ClientVO clientVO);
}
