package com.zest.web.client.service.talent;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.talent.TalentMatchingDAO;
import com.zest.web.client.model.page.ClientAndTutorTalentPropPageVO;
import com.zest.web.client.model.talent.Talent_SuccessVO;

@Service
public class TalentMatchingServiceImpl implements TalentMatchingService {

	@Autowired
	private TalentMatchingDAO talentMatchingDAO;
	
	
	
	
	@Override
	public void updateTalentStatus(Talent_SuccessVO vo) {
		talentMatchingDAO.updateTalentStatus(vo);
	}
	@Override
	public int getTalent_no(Talent_SuccessVO vo) {
		return talentMatchingDAO.getTalent_no(vo);
	}




	@Override
	public List<ClientAndTutorTalentPropPageVO> getTSforTutor(ClientAndTutorTalentPropPageVO vo) {
		return talentMatchingDAO.getTSforTutor(vo);
	}




	@Override
	public Talent_SuccessVO getTSforStatus(Talent_SuccessVO vo) {
		return talentMatchingDAO.getTSforStatus(vo);
	}




	@Override
	public void insertTS(Talent_SuccessVO vo) {
		talentMatchingDAO.insertTSforClient(vo);
	}

}
