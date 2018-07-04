package com.zest.web.admin.dao;

import java.util.List;

import com.zest.web.admin.model.AdminVO;
import com.zest.web.admin.model.TalentSubmitVO;

public interface AdminDAO {
	
	// 관리자 등록
	public void adminRegi(AdminVO vo);
	
	// 관리자 조회
	public AdminVO adminSearch(AdminVO vo);
	
	//매칭 승인
	List<TalentSubmitVO> getTalentSubmit();
	
}
