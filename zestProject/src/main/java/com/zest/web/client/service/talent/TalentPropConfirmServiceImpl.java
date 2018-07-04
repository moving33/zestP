package com.zest.web.client.service.talent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.talent.TalentDAO;
import com.zest.web.client.model.page.ClientAndTutorTalentPropPageVO;

@Service
public class TalentPropConfirmServiceImpl implements TalentPropConfirmService {

	@Autowired
	private TalentDAO talentDAO;
	
	
	@Override
	public List<ClientAndTutorTalentPropPageVO> getOrderTalentForCL(ClientAndTutorTalentPropPageVO vo) {		
		return talentDAO.getOrderTalentForCL(vo);
		
	}

}
