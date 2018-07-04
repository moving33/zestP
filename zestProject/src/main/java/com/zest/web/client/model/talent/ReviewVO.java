package com.zest.web.client.model.talent;

import java.sql.Timestamp;

public class ReviewVO {
	private Integer tr_no; //리뷰 테이블의 고유키
	private Integer talent_no; //수업 테이블의 고유키
	private Integer tt_no; //튜터테이블의 고유키
	private Integer tr_client_no; //해당수업을 들은 학생의 넘버
	private Integer tr_curri_value; //커리큘럼
	private Integer tr_commu_value; //전달력
	private Integer tr_ready_value; //준비성
	private Integer tc_kind_value; //친절도
	private Integer tc_time_value; //시간준수
	private String tr_content; //리뷰내용
	private double total_value; //평균
	private Timestamp tc_reg_date; //리뷰등록일자
	private String cl_name; //클라이언트 이름
	
	public Integer getTr_no() {
		return tr_no;
	}
	public void setTr_no(Integer tr_no) {
		this.tr_no = tr_no;
	}
	public Integer getTalent_no() {
		return talent_no;
	}
	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
	}
	public Integer getTt_no() {
		return tt_no;
	}
	public void setTt_no(Integer tt_no) {
		this.tt_no = tt_no;
	}
	public Integer getTr_curri_value() {
		return tr_curri_value;
	}
	public void setTr_curri_value(Integer tr_curri_value) {
		this.tr_curri_value = tr_curri_value;
	}
	public Integer getTr_commu_value() {
		return tr_commu_value;
	}
	public void setTr_commu_value(Integer tr_commu_value) {
		this.tr_commu_value = tr_commu_value;
	}
	public Integer getTr_ready_value() {
		return tr_ready_value;
	}
	public void setTr_ready_value(Integer tr_ready_value) {
		this.tr_ready_value = tr_ready_value;
	}
	public Integer getTc_kind_value() {
		return tc_kind_value;
	}
	public void setTc_kind_value(Integer tc_kind_value) {
		this.tc_kind_value = tc_kind_value;
	}
	public Integer getTc_time_value() {
		return tc_time_value;
	}
	public void setTc_time_value(Integer tc_time_value) {
		this.tc_time_value = tc_time_value;
	}
	public String getTr_content() {
		return tr_content;
	}
	public void setTr_content(String tr_content) {
		this.tr_content = tr_content;
	}

	public Timestamp getTc_reg_date() {
		return tc_reg_date;
	}
	public void setTc_reg_date(Timestamp tc_reg_date) {
		this.tc_reg_date = tc_reg_date;
	}
	public double getTotal_value() {
		return total_value;
	}
	public void setTotal_value(double total_value) {
		this.total_value = total_value;
	}
	public Integer getTr_client_no() {
		return tr_client_no;
	}
	public void setTr_client_no(Integer tr_client_no) {
		this.tr_client_no = tr_client_no;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	@Override
	public String toString() {
		return "ReviewVO [tr_no=" + tr_no + ", talent_no=" + talent_no + ", tt_no=" + tt_no + ", tr_client_no="
				+ tr_client_no + ", tr_curri_value=" + tr_curri_value + ", tr_commu_value=" + tr_commu_value
				+ ", tr_ready_value=" + tr_ready_value + ", tc_kind_value=" + tc_kind_value + ", tc_time_value="
				+ tc_time_value + ", tr_content=" + tr_content + ", total_value=" + total_value + ", tc_reg_date="
				+ tc_reg_date + ", cl_name=" + cl_name + "]";
	}
	
	
	
	
	
	

}
