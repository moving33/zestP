package com.zest.web.client.service.client;

import java.util.List;

import com.zest.web.client.model.client.ClientVO;

public interface ClientSearchService {
	
	//개별 회원 검색 서비스
	ClientVO getClient(ClientVO clientVO);
	
	//회원 리스트로 검색 서비스
	List<ClientVO> getClientList(ClientVO clientVO);
	
	//id값으로 조회 
	ClientVO getClientForId(ClientVO clientVO);
	
}
