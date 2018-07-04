package com.zest.web.client.model.tutor;

import java.sql.Timestamp;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

//튜터 신청테이블의 모델
public class Tutor_PropVO {
	
	private Integer tp_no; // 신청테이블의 고유번호
	private String tp_category_id; //신청한 튜터의 특기 (카테고리별)
	private String tp_email; // 신청한 튜터의 이메일
	private String tp_hp; //신청한 튜터의 핸드폰 번호
	private String tp_nn; //신청한 튜터의 닉네임
	private String tp_image_path; // 신청한 튜터의 인증관련 이미지의 경로
	private MultipartFile[] file_add; // 추가한 파일 사진 
	private Timestamp tp_prop_date; // 튜터의 신청일자
	private String tp_message; // 튜터 승인여부 관련메세지 
	private Integer tp_status; // 튜터신청의 상태  0은 미승인 1은 승인
	private String format_tpd; // 튜터의 신청일자를 원하는 날짜형식으로 변환


	public String getFormat_tpd() {
		return format_tpd;
	}

	public void setFormat_tpd(String format_tpd) {
		this.format_tpd = format_tpd;
	}

	public MultipartFile[] getFile_add() {
		return file_add;
	}
	public void setFile_add(MultipartFile[] file_add) {
		this.file_add = file_add;
	}
	
	public Integer getTp_no() {
		return tp_no;
	}
	public void setTp_no(Integer tp_no) {
		this.tp_no = tp_no;
	}
	public String getTp_category_id() {
		return tp_category_id;
	}
	public void setTp_category_id(String tp_category_id) {
		this.tp_category_id = tp_category_id;
	}
	public String getTp_email() {
		return tp_email;
	}
	public void setTp_email(String tp_email) {
		this.tp_email = tp_email;
	}
	public String getTp_hp() {
		return tp_hp;
	}
	public void setTp_hp(String tp_hp) {
		this.tp_hp = tp_hp;
	}
	public String getTp_nn() {
		return tp_nn;
	}
	public void setTp_nn(String tp_nn) {
		this.tp_nn = tp_nn;
	}
	public String getTp_image_path() {
		return tp_image_path;
	}
	public void setTp_image_path(String tp_image_path) {
		this.tp_image_path = tp_image_path;
	}
	public Timestamp getTp_prop_date() {
		return tp_prop_date;
	}
	public void setTp_prop_date(Timestamp tp_prop_date) {
		this.tp_prop_date = tp_prop_date;
	}
	public String getTp_message() {
		return tp_message;
	}
	public void setTp_message(String tp_message) {
		this.tp_message = tp_message;
	}
	public Integer getTp_status() {
		return tp_status;
	}
	public void setTp_status(Integer tp_status) {
		this.tp_status = tp_status;
	}

	@Override
	public String toString() {
		return "Tutor_PropVO{" +
				"tp_no=" + tp_no +
				", tp_category_id='" + tp_category_id + '\'' +
				", tp_email='" + tp_email + '\'' +
				", tp_hp='" + tp_hp + '\'' +
				", tp_nn='" + tp_nn + '\'' +
				", tp_image_path='" + tp_image_path + '\'' +
				", file_add=" + Arrays.toString(file_add) +
				", tp_prop_date=" + tp_prop_date +
				", tp_message='" + tp_message + '\'' +
				", tp_status=" + tp_status +
				", format_tpd='" + format_tpd + '\'' +
				'}';
	}
}
