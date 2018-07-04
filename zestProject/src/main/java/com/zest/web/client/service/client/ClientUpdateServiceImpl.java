package com.zest.web.client.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.dao.client.ClientDAO;
import com.zest.web.client.model.client.ClientVO;

@Repository
public class ClientUpdateServiceImpl implements ClientUpdateService {

	//라스트 로그인 서비스	
	private Logger logger = LoggerFactory.getLogger(ClientUpdateServiceImpl.class);
	
	@Autowired
	private ClientDAO clientDAO;
	
	
	
	@Override
	public void plusAccMoney(ClientVO clientVO) {
		clientDAO.plusAccMoney(clientVO);		
	}

	@Override
	public void clientLastLogin(ClientVO vo) {
		logger.info("...ing");
		clientDAO.updateLastLogin(vo);
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	

}
