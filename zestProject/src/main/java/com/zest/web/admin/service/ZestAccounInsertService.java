package com.zest.web.admin.service;

import com.zest.web.admin.model.Zest_AccountVO;
import com.zest.web.client.model.payment.Talent_OrderVO;

public interface ZestAccounInsertService {

	
	//결제시 저장
	void insertZestAccount(Zest_AccountVO zest_AccountVo,Talent_OrderVO orderVo);
}
