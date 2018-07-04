package com.zest.web.client.service.talent.time;

import com.zest.web.client.model.talent.TalentOneDayTimeVO;

//강의의 시간을 등록하는 서비스
public interface TalentTimeInsertService {

	//원데이 시간 등록
	int insertOneDayTime(TalentOneDayTimeVO vo);
}
