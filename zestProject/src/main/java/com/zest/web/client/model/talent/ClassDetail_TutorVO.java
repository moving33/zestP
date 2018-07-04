package com.zest.web.client.model.talent;

import java.security.Timestamp;

public class ClassDetail_TutorVO {
	private Integer talent_no; // talent 테이블의 주요키
	private Integer tt_no; //프라이머리키
	private String tt_email; //이메일
	private String tt_name; //이름
	private String tt_pass; //비밀번호
	private String tt_hp; //휴대폰번호
	private String tt_nn; //닉네임
	private String tt_categroy_id; //카테고리아이디 
	private Timestamp tt_reg_date; //가입 일자
	private Timestamp tt_se_date; //탈퇴 일자
	private Integer tt_tutoring; // 강의 중인지 여부 0은 안하고 1은 하는중
	private Integer tt_acc_money; //누적금액
	private String tt_ac_no; //계좌번호
	private String tt_im_path; //이미지파일 경로
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
	public String getTt_email() {
		return tt_email;
	}
	public void setTt_email(String tt_email) {
		this.tt_email = tt_email;
	}
	public String getTt_name() {
		return tt_name;
	}
	public void setTt_name(String tt_name) {
		this.tt_name = tt_name;
	}
	public String getTt_pass() {
		return tt_pass;
	}
	public void setTt_pass(String tt_pass) {
		this.tt_pass = tt_pass;
	}
	public String getTt_hp() {
		return tt_hp;
	}
	public void setTt_hp(String tt_hp) {
		this.tt_hp = tt_hp;
	}
	public String getTt_nn() {
		return tt_nn;
	}
	public void setTt_nn(String tt_nn) {
		this.tt_nn = tt_nn;
	}
	public String getTt_categroy_id() {
		return tt_categroy_id;
	}
	public void setTt_categroy_id(String tt_categroy_id) {
		this.tt_categroy_id = tt_categroy_id;
	}
	public Timestamp getTt_reg_date() {
		return tt_reg_date;
	}
	public void setTt_reg_date(Timestamp tt_reg_date) {
		this.tt_reg_date = tt_reg_date;
	}
	public Timestamp getTt_se_date() {
		return tt_se_date;
	}
	public void setTt_se_date(Timestamp tt_se_date) {
		this.tt_se_date = tt_se_date;
	}
	public Integer getTt_tutoring() {
		return tt_tutoring;
	}
	public void setTt_tutoring(Integer tt_tutoring) {
		this.tt_tutoring = tt_tutoring;
	}
	public Integer getTt_acc_money() {
		return tt_acc_money;
	}
	public void setTt_acc_money(Integer tt_acc_money) {
		this.tt_acc_money = tt_acc_money;
	}
	public String getTt_ac_no() {
		return tt_ac_no;
	}
	public void setTt_ac_no(String tt_ac_no) {
		this.tt_ac_no = tt_ac_no;
	}
	public String getTt_im_path() {
		return tt_im_path;
	}
	public void setTt_im_path(String tt_im_path) {
		this.tt_im_path = tt_im_path;
	}
	@Override
	public String toString() {
		return "ClassDetail_TutorVO [talent_no=" + talent_no + ", tt_no=" + tt_no + ", tt_email=" + tt_email
				+ ", tt_name=" + tt_name + ", tt_pass=" + tt_pass + ", tt_hp=" + tt_hp + ", tt_nn=" + tt_nn
				+ ", tt_categroy_id=" + tt_categroy_id + ", tt_reg_date=" + tt_reg_date + ", tt_se_date=" + tt_se_date
				+ ", tt_tutoring=" + tt_tutoring + ", tt_acc_money=" + tt_acc_money + ", tt_ac_no=" + tt_ac_no
				+ ", tt_im_path=" + tt_im_path + "]";
	}
	
	
	


}
