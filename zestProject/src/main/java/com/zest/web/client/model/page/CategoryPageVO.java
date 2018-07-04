package com.zest.web.client.model.page;


public class CategoryPageVO {
	private Integer talent_no; // talent 테이블 고유번호
	private Integer talent_price_hour; // 1시간당 가격
	private Integer talent_acc_client; // 누적 인원 수
	private String tc_subject; //제목
	private String tc_image_path; // 이미지경로
	private String zone_id; // 구역의 영어 약자
	private String zone_name; // 구역의 한글 이름
	private String talent_category_id; // 카테고리 아이디
	private String talent_lecture_id; // 카테고리(소분류) 아이디
	private String search_text; // 검색 텍스트
	private String tr_content; // 리뷰 내용
	private String tc_reg_date; // 리뷰 작성일
	private String cl_name; // 리뷰 작성자
	private Integer tr_client_no; //리뷰 작성자의 번호 
	
	
	
	public Integer getTr_client_no() {
		return tr_client_no;
	}
	public void setTr_client_no(Integer tr_client_no) {
		this.tr_client_no = tr_client_no;
	}
	public Integer getTalent_no() {
		return talent_no;
	}
	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
	}
	public Integer getTalent_price_hour() {
		return talent_price_hour;
	}
	public void setTalent_price_hour(Integer talent_price_hour) {
		this.talent_price_hour = talent_price_hour;
	}
	public Integer getTalent_acc_client() {
		return talent_acc_client;
	}
	public void setTalent_acc_client(Integer talent_acc_client) {
		this.talent_acc_client = talent_acc_client;
	}
	public String getTc_subject() {
		return tc_subject;
	}
	public void setTc_subject(String tc_subject) {
		this.tc_subject = tc_subject;
	}
	public String getTc_image_path() {
		return tc_image_path;
	}
	public void setTc_image_path(String tc_image_path) {
		this.tc_image_path = tc_image_path;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	public String getTalent_category_id() {
		return talent_category_id;
	}
	public void setTalent_category_id(String talent_category_id) {
		this.talent_category_id = talent_category_id;
	}
	public String getTalent_lecture_id() {
		return talent_lecture_id;
	}
	public void setTalent_lecture_id(String talent_lecture_id) {
		this.talent_lecture_id = talent_lecture_id;
	}
	public String getSearch_text() {
		return search_text;
	}
	public void setSearch_text(String search_text) {
		this.search_text = search_text;
	}
	public String getTr_content() {
		return tr_content;
	}
	public void setTr_content(String tr_content) {
		this.tr_content = tr_content;
	}
	public String getTc_reg_date() {
		return tc_reg_date;
	}
	public void setTc_reg_date(String tc_reg_date) {
		this.tc_reg_date = tc_reg_date;
	}
	public String getCl_name() {
		return cl_name;
	}
	public void setCl_name(String cl_name) {
		this.cl_name = cl_name;
	}
	@Override
	public String toString() {
		return "CategoryPageVO [talent_no=" + talent_no + ", talent_price_hour=" + talent_price_hour
				+ ", talent_acc_client=" + talent_acc_client + ", tc_subject=" + tc_subject + ", tc_image_path="
				+ tc_image_path + ", zone_id=" + zone_id + ", zone_name=" + zone_name + ", talent_category_id="
				+ talent_category_id + ", talent_lecture_id=" + talent_lecture_id + ", search_text=" + search_text
				+ ", tr_content=" + tr_content + ", tc_reg_date=" + tc_reg_date + ", cl_name=" + cl_name
				+ ", tr_client_no=" + tr_client_no + "]";
	}
	
	
	
	


	
}
