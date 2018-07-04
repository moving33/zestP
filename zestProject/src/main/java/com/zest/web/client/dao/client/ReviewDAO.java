package com.zest.web.client.dao.client;

import com.zest.web.client.model.talent.ReviewVO;

public interface ReviewDAO {
	
	
	//리뷰쓰기
	void insertReview(ReviewVO vo);
	
	//리뷰수정
	void updateReview(ReviewVO vo);
	
	//리뷰삭제
	void deleteReview(ReviewVO vo);
	

}
