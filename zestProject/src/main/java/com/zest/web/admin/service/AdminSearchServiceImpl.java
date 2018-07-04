package com.zest.web.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.AdminDAO;
import com.zest.web.admin.model.AdminVO;

@Service
public class AdminSearchServiceImpl implements AdminSearchService {

	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public AdminVO adminSearch(AdminVO vo) {
		return adminDAO.adminSearch(vo);
		 
	}

}
