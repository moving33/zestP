package com.zest.web.client.service.tutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.tutor.Tutor_PropDAO;
import com.zest.web.client.model.tutor.Tutor_PropVO;

@Service
public class Tutor_PropInsertServiceImpl implements Tutor_PropInsertService {

	
	private Logger logger = LoggerFactory.getLogger(Tutor_PropInsertServiceImpl.class);
	
	@Autowired
	private Tutor_PropDAO tutor_PropDAO; 
	
	//신청
	@Override
	public void insertTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		tutor_PropDAO.insertTutor_prop(vo);

	}

	public Tutor_PropDAO getTutor_PropDAO() {
		return tutor_PropDAO;
	}

	public void setTutor_PropDAO(Tutor_PropDAO tutor_PropDAO) {
		this.tutor_PropDAO = tutor_PropDAO;
	}
	
	

}
