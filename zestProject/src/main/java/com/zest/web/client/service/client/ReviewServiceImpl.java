package com.zest.web.client.service.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.dao.category.ClassDetailDAO;
import com.zest.web.client.dao.client.ReviewDAO;
import com.zest.web.client.model.talent.ReviewVO;
import com.zest.web.client.model.talent.Talent_contentVO;

@Repository
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDAO;
	


	@Override
	public ReviewVO ReviewInsert(ReviewVO vo) {
		double avg;
		int curri = vo.getTr_curri_value();
		int deli = vo.getTr_commu_value();
		int pre = vo.getTr_ready_value();
		int kind = vo.getTc_kind_value();
		int time = vo.getTc_time_value();
		
		avg = (double)(curri + deli + pre + kind + time) / 5.0;
		System.out.println("평균 점수:" + avg);
		
		vo.setTotal_value(avg);
		
	
		
		reviewDAO.insertReview(vo);
		return vo;

	}


	public ReviewDAO getReviewDAO() {
		return reviewDAO;
	}


	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}
	
	
	


}
