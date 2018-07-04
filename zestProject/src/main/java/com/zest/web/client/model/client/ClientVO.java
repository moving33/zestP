package com.zest.web.client.model.client;

//사용자 클라이언트 모델
@SuppressWarnings("unused")
public class ClientVO {
	
	//primary Key no
	private Integer cl_no;
	//email
	private String cl_email;
	//name
	private String cl_name;	
	//passwprd
	private String cl_pass;
	//핸드폰
	private String cl_hp;
	//포인트	
	private Integer cl_point;
	//닉네임
	private String cl_nn;
	//누적금액
	private Integer cl_acc_money;
	//수업중인지 여부
	private Integer cl_study;
	//이미지 경로
	private String cl_im_path;
	//마지막 로그인 날짜
	private String cl_ll_date;
	//가입 날짜
	private String cl_reg_date;
	//탈퇴 날짜
	private String cl_se_date;
	
	
	public Integer getCl_no() {
		return cl_no;
	}
	public void setCl_no(Integer cl_no) {
		this.cl_no = cl_no;
	}
	public String getCl_email() {
		return cl_email;
	}
	public void setCl_email(String cl_email) {
		this.cl_email = cl_email;
	}
	public String getCl_pass() {
		return cl_pass;
	}
	public void setCl_pass(String cl_pass) {
		this.cl_pass = cl_pass;
	}
	public String getCl_hp() {
		return cl_hp;
	}
	public void setCl_hp(String cl_hp) {
		this.cl_hp = cl_hp;
	}
	public Integer getCl_point() {
		return cl_point;
	}
	public void setCl_point(Integer cl_point) {
		this.cl_point = cl_point;
	}
	public String getCl_nn() {
		return cl_nn;
	}
	public void setCl_nn(String cl_nn) {
		this.cl_nn = cl_nn;
	}
	public Integer getCl_acc_money() {
		return cl_acc_money;
	}
	public void setCl_acc_money(Integer cl_acc_money) {
		this.cl_acc_money = cl_acc_money;
	}
	public Integer getCl_study() {
		return cl_study;
	}
	public void setCl_study(Integer cl_study) {
		this.cl_study = cl_study;
	}
	public String getCl_im_path() {
		return cl_im_path;
	}
	public void setCl_im_path(String cl_im_path) {
		this.cl_im_path = cl_im_path;
	}
	public String getCl_ll_date() {
		return cl_ll_date;
	}
	public void setCl_ll_date(String cl_ll_date) {
		this.cl_ll_date = cl_ll_date;
	}
	public String getCl_reg_date() {
		return cl_reg_date;
	}
	public void setCl_reg_date(String cl_reg_date) {
		this.cl_reg_date = cl_reg_date;
	}
	public String getCl_se_date() {
		return cl_se_date;
	}
	public void setCl_se_date(String cl_se_date) {
		this.cl_se_date = cl_se_date;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	@Override
	public String toString() {
		return "ClientVO [cl_no=" + cl_no + ", cl_email=" + cl_email + ", cl_name=" + cl_name + ", cl_pass=" + cl_pass
				+ ", cl_hp=" + cl_hp + ", cl_point=" + cl_point + ", cl_nn=" + cl_nn + ", cl_acc_money=" + cl_acc_money
				+ ", cl_study=" + cl_study + ", cl_im_path=" + cl_im_path + ", cl_ll_date=" + cl_ll_date
				+ ", cl_reg_date=" + cl_reg_date + ", cl_se_date=" + cl_se_date + "]";
	}
	
	
	
	
	
	

	
	
	
}
