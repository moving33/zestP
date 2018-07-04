package com.zest.web.client.model.talent;

import java.security.Timestamp;

/*수업의 모델*/
public class TalentVO {
	
	private Integer talent_no; // 수업의 주요키
	private Integer talent_price_hour; // 1시간당 가격
	private Integer talent_total_price; // 수업의 총가격
	private float talent_dc_rate; // 할인률
	private Integer talent_meet_time; //만나는 시간
	private Integer talent_meet_count; //만나는 횟수
	private Timestamp talent_reg_date; //등록일자
	private Timestamp talent_se_date; //삭제일자
	private Integer talent_acc_client; //누적인원
	private float talent_value; // 리뷰점수
	private Integer talent_sold_out; // 마감 했을시 기본값 0 에서 1로 바뀜
	private Integer talent_tt_no; // 강의를 신청한 튜터의 프라이머리키
	private String talent_category_id; // 강의의 대분류 코드
	private String talent_lecture_id; // 강의의 소분류 코드
	private Integer talent_status; // 강의의 승인 여부	
	
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
	public Integer getTalent_total_price() {
		return talent_total_price;
	}
	public void setTalent_total_price(Integer talent_total_price) {
		this.talent_total_price = talent_total_price;
	}
	public float getTalent_dc_rate() {
		return talent_dc_rate;
	}
	public void setTalent_dc_rate(float talent_dc_rate) {
		this.talent_dc_rate = talent_dc_rate;
	}
	public Integer getTalent_meet_time() {
		return talent_meet_time;
	}
	public void setTalent_meet_time(Integer talent_meet_time) {
		this.talent_meet_time = talent_meet_time;
	}
	public Integer getTalent_meet_count() {
		return talent_meet_count;
	}
	public void setTalent_meet_count(Integer talent_meet_count) {
		this.talent_meet_count = talent_meet_count;
	}
	public Timestamp getTalent_reg_date() {
		return talent_reg_date;
	}
	public void setTalent_reg_date(Timestamp talent_reg_date) {
		this.talent_reg_date = talent_reg_date;
	}
	public Timestamp getTalent_se_date() {
		return talent_se_date;
	}
	public void setTalent_se_date(Timestamp talent_se_date) {
		this.talent_se_date = talent_se_date;
	}
	public Integer getTalent_acc_client() {
		return talent_acc_client;
	}
	public void setTalent_acc_client(Integer talent_acc_client) {
		this.talent_acc_client = talent_acc_client;
	}
	public float getTalent_value() {
		return talent_value;
	}
	public void setTalent_value(float talent_value) {
		this.talent_value = talent_value;
	}
	public Integer getTalent_sold_out() {
		return talent_sold_out;
	}
	public void setTalent_sold_out(Integer talent_sold_out) {
		this.talent_sold_out = talent_sold_out;
	}
	public Integer getTalent_tt_no() {
		return talent_tt_no;
	}
	public void setTalent_tt_no(Integer talent_tt_no) {
		this.talent_tt_no = talent_tt_no;
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
	public Integer getTalent_status() {
		return talent_status;
	}
	public void setTalent_status(Integer talent_status) {
		this.talent_status = talent_status;
	}
	@Override
	public String toString() {
		return "TalentVO [talent_no=" + talent_no + ", talent_price_hour=" + talent_price_hour + ", talent_total_price="
				+ talent_total_price + ", talent_dc_rate=" + talent_dc_rate + ", talent_meet_time=" + talent_meet_time
				+ ", talent_meet_count=" + talent_meet_count + ", talent_reg_date=" + talent_reg_date
				+ ", talent_se_date=" + talent_se_date + ", talent_acc_client=" + talent_acc_client + ", talent_value="
				+ talent_value + ", talent_sold_out=" + talent_sold_out + ", talent_tt_no=" + talent_tt_no
				+ ", talent_category_id=" + talent_category_id + ", talent_lecture_id=" + talent_lecture_id
				+ ", talent_status=" + talent_status + "]";
	}
	
	

}
