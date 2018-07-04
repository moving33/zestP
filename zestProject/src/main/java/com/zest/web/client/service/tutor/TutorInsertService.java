package com.zest.web.client.service.tutor;

import com.zest.web.client.model.client.ClientVO;
import com.zest.web.client.model.tutor.TuTorVO;
import com.zest.web.client.model.tutor.Tutor_PropVO;

public interface TutorInsertService {

    //튜터 data를 insert하는 메서드
    TuTorVO tutorInsert(Tutor_PropVO tutor_propVO, ClientVO clientVO);
}
