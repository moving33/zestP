package com.zest.web.client.service.talent;

import com.zest.web.client.model.payment.Talent_OrderVO;

public interface TalentOrderInsertService { 
	// 결제
	int insertTO(Talent_OrderVO vo);
}
