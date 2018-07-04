package com.zest.web.client.model.client;

import java.sql.Timestamp;

//클라이언트의 포인트 모델
@SuppressWarnings("unused")
public class Client_pointVO {

	//primary key	
	private Integer cp_no;
	//client의  pk
	private Integer cl_no;
	//수업 주문 테이블의  pk
	private Integer to_no;
	//포인트 사용인지 입금인지의 타입 
	private String cp_type;
	//누적 포인트
	private Integer cp_in_point;
	//사용 포인트
	private Integer cp_out_point;
	//합계 포인트
	private Integer cp_total_point;
	//해당 포인트가 사용되거나 누적된 날짜
	private Timestamp cp_date;
	public Integer getCp_no() {
		return cp_no;
	}
	public void setCp_no(Integer cp_no) {
		this.cp_no = cp_no;
	}
	public Integer getCl_no() {
		return cl_no;
	}
	public void setCl_no(Integer cl_no) {
		this.cl_no = cl_no;
	}
	public Integer getTo_no() {
		return to_no;
	}
	public void setTo_no(Integer to_no) {
		this.to_no = to_no;
	}
	public String getCp_type() {
		return cp_type;
	}
	public void setCp_type(String cp_type) {
		this.cp_type = cp_type;
	}
	public Integer getCp_in_point() {
		return cp_in_point;
	}
	public void setCp_in_point(Integer cp_in_point) {
		this.cp_in_point = cp_in_point;
	}
	public Integer getCp_out_point() {
		return cp_out_point;
	}
	public void setCp_out_point(Integer cp_out_point) {
		this.cp_out_point = cp_out_point;
	}
	public Integer getCp_total_point() {
		return cp_total_point;
	}
	public void setCp_total_point(Integer cp_total_point) {
		this.cp_total_point = cp_total_point;
	}
	public Timestamp getCp_date() {
		return cp_date;
	}
	public void setCp_date(Timestamp cp_date) {
		this.cp_date = cp_date;
	}
	
	
	
	
	
}
