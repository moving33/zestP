package com.zest.web.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.ZestAccountDAO;
import com.zest.web.admin.model.Zest_AccountVO;

@Service
public class ZestAccountSearchServiceImpl implements ZestAccountSearchService {

	@Autowired
	private ZestAccountDAO zestAccountDAO;
	
	//잔고 가져오기
	@Override
	public Integer getAccountMoney() {
		return zestAccountDAO.getAccountMoney(); 
	}

}
