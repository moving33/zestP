package com.zest.web.client.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.client.ClientDAO;
import com.zest.web.client.model.client.ClientVO;

@Service
public class ClientInsertServiceImpl implements ClientInsertService {

	private Logger logger = LoggerFactory.getLogger(ClientInsertServiceImpl.class);
	
	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	public void insertClient(ClientVO clientVO) {
		logger.info("..ing");
		clientDAO.insertClient(clientVO);		
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	

}
