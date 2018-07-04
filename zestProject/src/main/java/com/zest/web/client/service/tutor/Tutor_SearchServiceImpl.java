package com.zest.web.client.service.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.dao.tutor.TutorDAO;
import com.zest.web.client.model.tutor.TuTorVO;

@Repository
public class Tutor_SearchServiceImpl implements Tutor_SearchService {

	@Autowired
	private TutorDAO tutorDAO;
	
	
	@Override
	public TuTorVO getTutorForClientEmail(String TutorEmailId) {
		return tutorDAO.getTutorForClinetId(TutorEmailId);
	}

}
