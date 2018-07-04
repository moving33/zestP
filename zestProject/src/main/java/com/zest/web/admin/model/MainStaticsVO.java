package com.zest.web.admin.model;

//메인페이지 통계 VO
public class MainStaticsVO {
	private Integer cl_counter;
	private Integer to_counter;
	private Integer tt_counter;
	private Integer tl_counter;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "MainStaticsVO [cl_counter=" + cl_counter + ", to_counter=" + to_counter + ", tt_counter=" + tt_counter
				+ ", tl_counter=" + tl_counter + "]";
	}
	public Integer getCl_counter() {
		return cl_counter;
	}
	public void setCl_counter(Integer cl_counter) {
		this.cl_counter = cl_counter;
	}
	public Integer getTo_counter() {
		return to_counter;
	}
	public void setTo_counter(Integer to_counter) {
		this.to_counter = to_counter;
	}
	public Integer getTt_counter() {
		return tt_counter;
	}
	public void setTt_counter(Integer tt_counter) {
		this.tt_counter = tt_counter;
	}
	public Integer getTl_counter() {
		return tl_counter;
	}
	public void setTl_counter(Integer tl_counter) {
		this.tl_counter = tl_counter;
	}
	
	
	
	
	
		
	
}
