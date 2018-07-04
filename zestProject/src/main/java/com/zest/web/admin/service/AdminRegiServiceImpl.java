package com.zest.web.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.AdminDAO;
import com.zest.web.admin.model.AdminVO;



@Service
public class AdminRegiServiceImpl implements AdminRegiService {
	
	@Autowired
	AdminDAO adminDAO;
	
	@Override
	public void adminRegi(AdminVO vo) {
		adminDAO.adminRegi(vo);
	}

}
