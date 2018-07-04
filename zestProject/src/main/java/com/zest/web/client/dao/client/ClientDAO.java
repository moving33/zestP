package com.zest.web.client.dao.client;

import java.util.List;

import com.zest.web.client.model.client.ClientVO;

public interface ClientDAO {
	
	//회원가입 
	void insertClient(ClientVO clientVO);
	//회원탈퇴
	void deleteClient(ClientVO clientVO);
	//회원조회다수
	List<ClientVO> getClientList(ClientVO clientVO);	
	//특정회원조회
	ClientVO getClient(ClientVO clientVO);
	//로그아웃시 마지막 날짜 업데이트 
	void updateLastLogin(ClientVO clientVO);
	//회원수정
	void modifyClient(ClientVO clientVO);
	
	//포인트 업데이트 (적립)
	void inPoint(ClientVO clientVO);
	
	//누적사용금액 업데이트 
	void plusAccMoney(ClientVO clientVO);
	
	//no값으로 조회
	ClientVO getClientForId(ClientVO clientVO);
	
}
