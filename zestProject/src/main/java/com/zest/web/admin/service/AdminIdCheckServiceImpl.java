package com.zest.web.admin.service;

import org.springframework.stereotype.Service;

import com.zest.web.admin.model.AdminVO;

@Service
public class AdminIdCheckServiceImpl implements AdminIdCheckService {

	@Override
	public boolean adminIdCheck(AdminVO dbvo) {
		AdminVO vo = new AdminVO();
		if(dbvo.getId().equals(vo.getId())) {
			System.out.println("아이디 중복확인 결과: 중복 없음");
			return true;
		}
		System.out.println("아이디 중복확인 결과: 중복!");
		return false;
	}

}
