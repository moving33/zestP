package com.zest.web.client.service.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.client.ClientDAO;
import com.zest.web.client.dao.client.ClientPointDAO;
import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.client.Client_pointVO;

@Service
public class ClientPointServiceImpl implements ClientPointService {
	
	@Autowired
	private ClientPointDAO clientPointDAO;
	
	@Autowired
	private ClientDAO clientDAO;
	
	

	//포인트처리	
	@Override
	public void insertCP(Client_pointVO vo) {		
		clientPointDAO.insertCP(vo);
	}


	//포인트 결과 반영 (적립)
	@Override
	public void updateClient_CP(ClientVO vo) {
		clientDAO.inPoint(vo);		
	}
	
	
	
	
	
	
	

}
