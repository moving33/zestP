package com.zest.web.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.AdminDAO;
import com.zest.web.admin.model.TalentSubmitVO;

@Service
public class TalentSubmitServiceImpl implements TalentSubmitService {

	@Autowired
	private AdminDAO adminDAO;
	
	
	@Override
	public List<TalentSubmitVO> getTalentSubmit() {		
		return adminDAO.getTalentSubmit();
	}

}
