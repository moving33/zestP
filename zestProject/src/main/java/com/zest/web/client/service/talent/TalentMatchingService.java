package com.zest.web.client.service.talent;


import java.util.List;

import com.zest.web.client.model.page.ClientAndTutorTalentPropPageVO;
import com.zest.web.client.model.talent.Talent_SuccessVO;

public interface TalentMatchingService {
	
	void insertTS(Talent_SuccessVO vo);
	
	// 매칭 대기중인 강의를 얻어오는 서비스
	Talent_SuccessVO getTSforStatus(Talent_SuccessVO vo);
	
	// 매칭 대기중인 강의를 얻어오는 쿼리문[튜터쪽]
	List<ClientAndTutorTalentPropPageVO> getTSforTutor(ClientAndTutorTalentPropPageVO vo);
	
	// 신청한 수업을 매칭 완료 업데이트 
	void updateTalentStatus(Talent_SuccessVO vo);
	// Talent_No 가져오기
	int getTalent_no(Talent_SuccessVO vo);
	
	
}
