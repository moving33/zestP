package com.zest.web.admin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.admin.model.Zest_AccountVO;

@Repository
public class ZestAccountDAOImpl implements ZestAccountDAO{

	@Autowired
	private SqlSessionTemplate session;
	
	private String path = "com.zest.account";
	
	
	//주문결제시 처리
	@Override
	public void insertZestAccount(Zest_AccountVO vo) {
		
		session.insert(path+".insertZestAccount",vo);
		
	}

	//잔고보기 
	@Override
	public Integer getAccountMoney() {		
		int test = session.selectOne(path+".getAccountMoney",null);
		if(test == 0) {
			System.out.println("nul!!!!!!!!!!!!l");
			return 0;
		}		
		return test;
	}
	
	
	

}
