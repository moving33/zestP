package com.zest.web.client.service.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.tutor.TutorDAO;
import com.zest.web.client.model.tutor.TuTorVO;

@Service
public class TutorImageUpdateServiceImpl implements TutorImageUpdateService {

	@Autowired
	private TutorDAO tutorDAO;
	
	@Override
	public void updateImage(TuTorVO vo) {
		
		tutorDAO.updateTutorImage(vo);

	}

	public void setTutorDAO(TutorDAO tutorDAO) {
		this.tutorDAO = tutorDAO;
	}
	
	

}
