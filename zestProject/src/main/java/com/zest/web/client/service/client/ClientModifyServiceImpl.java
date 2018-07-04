package com.zest.web.client.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.client.ClientDAO;
import com.zest.web.client.model.client.ClientVO;

@Service
public class ClientModifyServiceImpl implements ClientModifyService {
	
	private Logger logger = LoggerFactory.getLogger(ClientModifyServiceImpl.class);
	
	@Autowired
	private ClientDAO clientDAO;

	@Override
	public void modifyClient(ClientVO clientVO) {
		logger.info("회원정보수정..ing");
		clientDAO.modifyClient(clientVO);
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	

}
