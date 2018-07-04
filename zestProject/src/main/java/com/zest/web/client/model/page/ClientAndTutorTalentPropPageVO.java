package com.zest.web.client.model.page;

import java.sql.Timestamp;
import java.time.LocalDateTime;

//클라이언트,튜터가 신청한 신청받은 수업 페이지 VO 
public class ClientAndTutorTalentPropPageVO {
	
	private Integer to_no;
	private Integer tp_no;
	private Integer talent_no;
	private Integer cl_no;
	private Integer tt_no;
	private Integer tp_career_level;
	private Integer tp_career_month;
	private String tp_message;
	private Integer to_price_total;
	private Timestamp to_reg_date;
	private Integer to_status;
	private String tt_hp;
	private String tc_subject;
	private String cl_hp;
	private String cl_name;
	private LocalDateTime ti_date; //합의된 시간.
	private Integer ts_no; //신청한 수업 번호
	private Integer ts_status;//매칭 수업의 상태
	
	
	
	
	
	public Integer getTs_status() {
		return ts_status;
	}
	public void setTs_status(Integer ts_status) {
		this.ts_status = ts_status;
	}
	public Integer getTs_no() {
		return ts_no;
	}
	public void setTs_no(Integer ts_no) {
		this.ts_no = ts_no;
	}
	@Override
	public String toString() {
		return "ClientAndTutorTalentPropPageVO [to_no=" + to_no + ", tp_no=" + tp_no + ", talent_no=" + talent_no
				+ ", cl_no=" + cl_no + ", tt_no=" + tt_no + ", tp_career_level=" + tp_career_level
				+ ", tp_career_month=" + tp_career_month + ", tp_message=" + tp_message + ", tp_price_total="
				+ to_price_total + ", to_reg_date=" + to_reg_date + ", to_status=" + to_status + ", tt_hp=" + tt_hp
				+ ", tc_subject=" + tc_subject + ", cl_hp=" + cl_hp + ", cl_name=" + cl_name + ", ti_date=" + ti_date
				+ "]";
	}
	public Integer getTo_no() {
		return to_no;
	}
	public void setTo_no(Integer to_no) {
		this.to_no = to_no;
	}
	public LocalDateTime getTi_date() {
		return ti_date;
	}
	public void setTi_date(LocalDateTime ti_date) {
		this.ti_date = ti_date;
	}
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
	public Integer getTo_price_total() {
		return to_price_total;
	}
	public void setTo_price_total(Integer tp_price_total) {
		this.to_price_total = tp_price_total;
	}
	public Timestamp getTo_reg_date() {
		return to_reg_date;
	}
	public void setTo_reg_date(Timestamp to_reg_date) {
		this.to_reg_date = to_reg_date;
	}
	public Integer getTo_status() {
		return to_status;
	}
	public void setTo_status(Integer to_status) {
		this.to_status = to_status;
	}
	public String getTt_hp() {
		return tt_hp;
	}
	public void setTt_hp(String tt_hp) {
		this.tt_hp = tt_hp;
	}
	public String getTc_subject() {
		return tc_subject;
	}
	public void setTc_subject(String tc_subject) {
		this.tc_subject = tc_subject;
	}
	public String getCl_hp() {
		return cl_hp;
	}
	public void setCl_hp(String cl_hp) {
		this.cl_hp = cl_hp;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	
	
	
}
