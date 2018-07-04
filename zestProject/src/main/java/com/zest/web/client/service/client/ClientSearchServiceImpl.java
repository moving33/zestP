package com.zest.web.client.service.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.client.ClientDAO;
import com.zest.web.client.model.client.ClientVO;

@Service
public class ClientSearchServiceImpl implements ClientSearchService {

	private Logger logger = LoggerFactory.getLogger(ClientSearchServiceImpl.class);
	
	@Autowired
	private ClientDAO clientDAO;
	
	//개별회원검색	
	@Override
	public ClientVO getClient(ClientVO clientVO) {
		
		return clientDAO.getClient(clientVO);
	}
	
	//회원 리스트 검색
	@Override
	public List<ClientVO> getClientList(ClientVO clientVO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	@Override
	public ClientVO getClientForId(ClientVO clientVO) {
		return clientDAO.getClientForId(clientVO);
	}
	
	

	

	
	
}
