package com.zest.web.client.service.talent;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.talent.TalentPropDAO;
import com.zest.web.client.model.payment.TalentPropVO;

@Service
public class TalentPropSearchServiceImpl implements TalentPropSearchService {

	
	@Autowired
	private TalentPropDAO talentPropDAO;
	
	@Override
	public TalentPropVO getPropUser(TalentPropVO vo) {
		return talentPropDAO.getPropUser(vo);
	}

}
