package com.zest.web.client.service.talent;

import com.zest.web.client.model.talent.Talent_info;
import com.zest.web.client.model.tutor.TuTorVO;
import com.zest.web.client.model.talent.TalentTimeUtil;
import com.zest.web.client.model.talent.TalentVO;
import com.zest.web.client.model.talent.Talent_contentVO;

//강의 등록 서비스
public interface TalentInsertService {
	
	//강의등록 서비스
	void insertTalent(TalentVO talentVO, Talent_contentVO contentVO,Talent_info talentInfo,TuTorVO tutorVO,TalentTimeUtil timeUtil);
}
