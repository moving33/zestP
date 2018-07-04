package com.zest.web.admin.model;

public class StatisticsVO {
	private Integer count; // 카테고리별 누적인원수
	private String talent_category_id; // 카테고리 아이디
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getTalent_category_id() {
		return talent_category_id;
	}
	public void setTalent_category_id(String talent_category_id) {
		this.talent_category_id = talent_category_id;
	}
	@Override
	public String toString() {
		return "StatisticsVO [count=" + count + ", talent_category_id=" + talent_category_id + "]";
	}
	
	
	
}
