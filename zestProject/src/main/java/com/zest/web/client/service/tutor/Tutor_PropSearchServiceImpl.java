package com.zest.web.client.service.tutor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.tutor.Tutor_PropDAO;
import com.zest.web.client.model.tutor.Tutor_PropVO;

//검색 서비스 구현객체
@Service
public class Tutor_PropSearchServiceImpl implements Tutor_PropSearchService {

	private Logger logger = LoggerFactory.getLogger(Tutor_PropSearchServiceImpl.class);

	@Autowired
	private Tutor_PropDAO tutor_PropDAO;

	
	//개별 검색
	@Override
	public Tutor_PropVO getTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		return tutor_PropDAO.getTutor_prop(vo);
	}
	
	//리스트검색
	@Override
	public List<Tutor_PropVO> getListTutor_prop(Object obj) {

		return tutor_PropDAO.getListTutor_prop(obj);
	}
	//상태검색
	@Override
	public Tutor_PropVO getTutor_propStatus(Tutor_PropVO vo) {
		return tutor_PropDAO.getTutor_propStatus(vo);
	}

	@Override
	public Integer getTutor_propCount(Object obj) {
		return tutor_PropDAO.getTutor_propCount(obj);
	}

	@Override
	public Tutor_PropVO getTutor_propNumber(Integer integer) {
		return tutor_PropDAO.getTutor_propNumber(integer);
	}

	public Tutor_PropDAO getTutor_PropDAO() {
		return tutor_PropDAO;
	}

	public void setTutor_PropDAO(Tutor_PropDAO tutor_PropDAO) {
		this.tutor_PropDAO = tutor_PropDAO;
	}
	
	

}
