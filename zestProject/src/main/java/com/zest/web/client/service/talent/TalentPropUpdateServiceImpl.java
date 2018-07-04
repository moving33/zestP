package com.zest.web.client.service.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.talent.TalentPropDAO;
import com.zest.web.client.model.payment.TalentPropVO;

@Service
public class TalentPropUpdateServiceImpl implements TalentPropUpdateService {

	@Autowired
	private TalentPropDAO talentPropDAO;
	
	
	@Override
	public void completeProp(TalentPropVO vo) {
		talentPropDAO.completeProp(vo);
	}

}
