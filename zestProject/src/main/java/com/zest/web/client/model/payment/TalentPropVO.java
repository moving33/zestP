package com.zest.web.client.model.payment;

import java.sql.Timestamp;

//수업신청 테이블
public class TalentPropVO {

	private Integer tp_no;
	private Integer talent_no;
	private Integer cl_no;
	private Integer tt_no;
	private Integer tp_career_level;
	private Integer tp_career_month;
	private String tp_message;
    private Integer tp_price_total;
    private Timestamp tp_reg_date;
    private Integer tp_status;
	
    
    public Integer getTp_no() {
		return tp_no;
	}
	public void setTp_no(Integer tp_no) {
		this.tp_no = tp_no;
	}
	public Integer getTalent_no() {
		return talent_no;
	}
	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
	}
	public Integer getCl_no() {
		return cl_no;
	}
	public void setCl_no(Integer cl_no) {
		this.cl_no = cl_no;
	}
	public Integer getTt_no() {
		return tt_no;
	}
	public void setTt_no(Integer tt_no) {
		this.tt_no = tt_no;
	}
	public Integer getTp_career_level() {
		return tp_career_level;
	}
	public void setTp_career_level(Integer tp_career_level) {
		this.tp_career_level = tp_career_level;
	}
	public Integer getTp_career_month() {
		return tp_career_month;
	}
	public void setTp_career_month(Integer tp_career_month) {
		this.tp_career_month = tp_career_month;
	}
	public String getTp_message() {
		return tp_message;
	}
	public void setTp_message(String tp_message) {
		this.tp_message = tp_message;
	}
	public Integer getTp_price_total() {
		return tp_price_total;
	}
	public void setTp_price_total(Integer tp_price_total) {
		this.tp_price_total = tp_price_total;
	}
	public Timestamp getTp_reg_date() {
		return tp_reg_date;
	}
	public void setTp_reg_date(Timestamp tp_reg_date) {
		this.tp_reg_date = tp_reg_date;
	}
	public Integer getTp_status() {
		return tp_status;
	}
	public void setTp_status(Integer tp_status) {
		this.tp_status = tp_status;
	}
	
	@Override
	public String toString() {
		return "TalentPropVO [tp_no=" + tp_no + ", talent_no=" + talent_no + ", cl_no=" + cl_no + ", tt_no=" + tt_no
				+ ", tp_career_level=" + tp_career_level + ", tp_career_month=" + tp_career_month + ", tp_message="
				+ tp_message + ", tp_price_total=" + tp_price_total + ", tp_reg_date=" + tp_reg_date + ", tp_status="
				+ tp_status + "]";
	}
    
    
	
    
}
