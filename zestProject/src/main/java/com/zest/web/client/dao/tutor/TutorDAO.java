package com.zest.web.client.dao.tutor;

import com.zest.web.client.model.tutor.TuTorVO;

public interface TutorDAO {

    //tutor 내용 넣고 primarykey가 저장되있는 객체 반환
    TuTorVO insertTutor(TuTorVO tuTorVO);    
    //튜터 이미지 업데이트 
    void updateTutorImage(TuTorVO torVO);
    //client id로 튜터객체 가져오기
    TuTorVO getTutorForClinetId(String TutorEmailId);
}
