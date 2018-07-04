package com.zest.web.client.service.talent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.talent.TalentOrderDAO;
import com.zest.web.client.model.payment.Talent_OrderVO;

@Service
public class TalentOrderInsertServiceImpl implements TalentOrderInsertService {

	@Autowired
	private TalentOrderDAO dao;
	
	
	@Override
	public int insertTO(Talent_OrderVO vo) {
		return dao.insertTO(vo);
	}

}
