package com.zest.web.client.service.zone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.zone.ZoneDAO;
import com.zest.web.client.model.classification.ZoneVO;

@Service
public class ZoneSearchServiceImpl implements ZoneSearchService {

	@Autowired
	private ZoneDAO zoneDao;
	
	
	@Override
	public ZoneVO getZoneVOforName(ZoneVO vo) {
		return zoneDao.getZoneVOforName(vo);
	}

}
