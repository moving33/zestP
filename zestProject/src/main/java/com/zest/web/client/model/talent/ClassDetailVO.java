package com.zest.web.client.model.talent;

import java.security.Timestamp;
import java.util.Arrays;

public class ClassDetailVO {
	//TalentVO
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
	private Integer talent_category_id; // 강의의 대분류 코드
	private Integer talent_lecture_id; // 강의의 소분류 코드
	private Integer talent_status; // 강의의 승인 여부
	
	//Talent_contentVO
	private Integer tc_no; // 주요내용의 주요키 
	private Integer tutor_no; //등록한 튜터의 넘버
	private String tc_subject; //제목
	private Integer tc_max_client; //최대인원
	private String tc_price_detail; //추가비용의 상세내용
	private String tc_tt_message; //튜터의 한마디 30자이내
	private String tc_tt_info; //튜터소개
	private String tc_class_info; //수업소개
	private String tc_class_taget; //수업 타겟 정보
	private String tc_curriculum; //수업 커리큘렴 
	private String tc_image_path; // 이미지경로
	private String tc_video_path; //비디오 경로
	private String tc_location; //대표위치의 대략적인 좌표값 x,y 로 들어감
	
	//TuTorVO
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
	
	//TalentInfo
	private Integer ti_no; // 주요키
	private String zone_id; //위치 
	private String ti_zone_detail; //상세 위치 
	private Integer ti_mon; //코드가 들어감 0 일시 시간협의 월요일 화요일 순서
	private Integer ti_tue;
	private Integer ti_wed;
	private Integer ti_tur;
	private Integer ti_fri;
	private Integer ti_sat;
	private Integer ti_sun;
	private Integer tc_status; //상태 코드
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
	public Integer getTalent_category_id() {
		return talent_category_id;
	}
	public void setTalent_category_id(Integer talent_category_id) {
		this.talent_category_id = talent_category_id;
	}
	public Integer getTalent_lecture_id() {
		return talent_lecture_id;
	}
	public void setTalent_lecture_id(Integer talent_lecture_id) {
		this.talent_lecture_id = talent_lecture_id;
	}
	public Integer getTalent_status() {
		return talent_status;
	}
	public void setTalent_status(Integer talent_status) {
		this.talent_status = talent_status;
	}
	public Integer getTc_no() {
		return tc_no;
	}
	public void setTc_no(Integer tc_no) {
		this.tc_no = tc_no;
	}
	public Integer getTutor_no() {
		return tutor_no;
	}
	public void setTutor_no(Integer tutor_no) {
		this.tutor_no = tutor_no;
	}
	public String getTc_subject() {
		return tc_subject;
	}
	public void setTc_subject(String tc_subject) {
		this.tc_subject = tc_subject;
	}
	public Integer getTc_max_client() {
		return tc_max_client;
	}
	public void setTc_max_client(Integer tc_max_client) {
		this.tc_max_client = tc_max_client;
	}
	public String getTc_price_detail() {
		return tc_price_detail;
	}
	public void setTc_price_detail(String tc_price_detail) {
		this.tc_price_detail = tc_price_detail;
	}
	public String getTc_tt_message() {
		return tc_tt_message;
	}
	public void setTc_tt_message(String tc_tt_message) {
		this.tc_tt_message = tc_tt_message;
	}
	public String getTc_tt_info() {
		return tc_tt_info;
	}
	public void setTc_tt_info(String tc_tt_info) {
		this.tc_tt_info = tc_tt_info;
	}
	public String getTc_class_info() {
		return tc_class_info;
	}
	public void setTc_class_info(String tc_class_info) {
		this.tc_class_info = tc_class_info;
	}
	public String getTc_class_taget() {
		return tc_class_taget;
	}
	public void setTc_class_taget(String tc_class_taget) {
		this.tc_class_taget = tc_class_taget;
	}

	public String getTc_image_path() {
		return tc_image_path;
	}
	public void setTc_image_path(String tc_image_path) {
		this.tc_image_path = tc_image_path;
	}
	public String getTc_video_path() {
		return tc_video_path;
	}
	public void setTc_video_path(String tc_video_path) {
		this.tc_video_path = tc_video_path;
	}
	public String getTc_location() {
		return tc_location;
	}
	public void setTc_location(String tc_location) {
		this.tc_location = tc_location;
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
	public Integer getTi_no() {
		return ti_no;
	}
	public void setTi_no(Integer ti_no) {
		this.ti_no = ti_no;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getTi_zone_detail() {
		return ti_zone_detail;
	}
	public void setTi_zone_detail(String ti_zone_detail) {
		this.ti_zone_detail = ti_zone_detail;
	}
	public Integer getTi_mon() {
		return ti_mon;
	}
	public void setTi_mon(Integer ti_mon) {
		this.ti_mon = ti_mon;
	}
	public Integer getTi_tue() {
		return ti_tue;
	}
	public void setTi_tue(Integer ti_tue) {
		this.ti_tue = ti_tue;
	}
	public Integer getTi_wed() {
		return ti_wed;
	}
	public void setTi_wed(Integer ti_wed) {
		this.ti_wed = ti_wed;
	}
	public Integer getTi_tur() {
		return ti_tur;
	}
	public void setTi_tur(Integer ti_tur) {
		this.ti_tur = ti_tur;
	}
	public Integer getTi_fri() {
		return ti_fri;
	}
	public void setTi_fri(Integer ti_fri) {
		this.ti_fri = ti_fri;
	}
	public Integer getTi_sat() {
		return ti_sat;
	}
	public void setTi_sat(Integer ti_sat) {
		this.ti_sat = ti_sat;
	}
	public Integer getTi_sun() {
		return ti_sun;
	}
	public void setTi_sun(Integer ti_sun) {
		this.ti_sun = ti_sun;
	}
	public Integer getTc_status() {
		return tc_status;
	}
	public void setTc_status(Integer tc_status) {
		this.tc_status = tc_status;
	}
	public String getTc_curriculum() {
		return tc_curriculum;
	}
	public void setTc_curriculum(String tc_curriculum) {
		this.tc_curriculum = tc_curriculum;
	}
	
	

	
	
	
	

}
