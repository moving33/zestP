package com.zest.web.client.dao.zone;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.classification.ZoneVO;

@Repository
public class ZoneDAOImpl implements ZoneDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	
	@Override
	public ZoneVO getZoneVOforName(ZoneVO vo) {
		return session.selectOne("com.zest.zone.getZoneforName",vo);
	}

}
