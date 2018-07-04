package com.zest.web.admin.service;

import java.util.List;

import com.zest.web.admin.model.TalentSubmitVO;

public interface TalentSubmitService {

	//매칭 승인 리스트가져오기
	List<TalentSubmitVO> getTalentSubmit();
}
