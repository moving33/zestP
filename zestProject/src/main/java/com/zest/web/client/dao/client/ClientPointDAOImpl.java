package com.zest.web.client.dao.client;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.client.Client_pointVO;

@Repository
public class ClientPointDAOImpl implements ClientPointDAO {

	@Autowired
	private SqlSessionTemplate session;	

	private String path = "com.zest.client_point";	
	

	@Override
	public void insertCP(Client_pointVO vo) {
		session.insert(path+".insertCP",vo);
	}

}
