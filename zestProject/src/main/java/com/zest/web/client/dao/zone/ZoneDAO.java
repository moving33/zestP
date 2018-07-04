package com.zest.web.client.dao.zone;

import com.zest.web.client.model.classification.ZoneVO;

public interface ZoneDAO {
	
	/*zoneName을 가지고 객체를 가져오는 녀석*/
	ZoneVO getZoneVOforName(ZoneVO vo);
}
