package com.zest.web.client.service.talent;

import java.util.List;

import com.zest.web.client.model.page.ClientAndTutorTalentPropPageVO;

//결제신청한 수업 내용 확인 서비스
public interface TalentPropConfirmService {
	List<ClientAndTutorTalentPropPageVO> getOrderTalentForCL(ClientAndTutorTalentPropPageVO vo);
}
