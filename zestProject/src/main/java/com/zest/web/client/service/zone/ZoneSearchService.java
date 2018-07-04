package com.zest.web.client.service.zone;

import com.zest.web.client.model.classification.ZoneVO;

public interface ZoneSearchService {
	
	//zone이름을 가지고 zone객체를 가지고 오는 
	ZoneVO getZoneVOforName(ZoneVO vo);
}
