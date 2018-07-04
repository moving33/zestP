package com.zest.web.client.model.talent;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

/*수업의 주요 내용 
 * worker : J
 * */
public class Talent_contentVO {
	private Integer tc_no; // 주요내용의 주요키 
	private Integer talent_no; // talent 테이블의 주요키
	private Integer tutor_no; //등록한 튜터의 넘버
	private String tc_subject; //제목
	private Integer tc_max_client; //최대인원
	private String tc_price_detail; //추가비용의 상세내용
	private String tc_tt_message; //튜터의 한마디 30자이내
	private String tc_tt_info; //튜터소개
	private String tc_class_info; //수업소개
	private String tc_class_taget; //수업 타겟 정보
	private String[] tc_curriculum; //수업 커리큘렴
	private String tc_curri; //실제로 db에 들어가는 컬럼 "!@#%" 구분자 로 커리큘럼 내용을 나눈다.
	private String tc_image_path; // 이미지경로
	private String tc_video_path; //비디오 경로
	private Integer tc_status; //승인여부 0 기본값 1일시 승인 
	private String tc_location; //대표위치의 대략적인 좌표값 x,y 로 들어감
	private MultipartFile[] talentImg; // 수업 이미지 파일

	
	
	
	public String getTc_curri() {
		return tc_curri;
	}
	public void setTc_curri(String tc_curri) {
		this.tc_curri = tc_curri;
	}
	public MultipartFile[] getTalentImg() {
		return talentImg;
	}
	public void setTalentImg(MultipartFile[] talentImg) {
		this.talentImg = talentImg;
	}
	public Integer getTc_no() {
		return tc_no;
	}
	public void setTc_no(Integer tc_no) {
		this.tc_no = tc_no;
	}
	public Integer getTalent_no() {
		return talent_no;
	}
	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
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
	public String[] getTc_curriculum() {
		return tc_curriculum;
	}
	public void setTc_curriculum(String[] tc_curriculum) {
		this.tc_curriculum = tc_curriculum;
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
	public Integer getTc_status() {
		return tc_status;
	}
	public void setTc_status(Integer tc_status) {
		this.tc_status = tc_status;
	}
	public String getTc_location() {
		return tc_location;
	}
	public void setTc_location(String tc_location) {
		this.tc_location = tc_location;
	}
	@Override
	public String toString() {
		return "Talent_contentVO [tc_no=" + tc_no + ", talent_no=" + talent_no + ", tutor_no=" + tutor_no
				+ ", tc_subject=" + tc_subject + ", tc_max_client=" + tc_max_client + ", tc_price_detail="
				+ tc_price_detail + ", tc_tt_message=" + tc_tt_message + ", tc_tt_info=" + tc_tt_info
				+ ", tc_class_info=" + tc_class_info + ", tc_class_taget=" + tc_class_taget + ", tc_curriculum="
				+ Arrays.toString(tc_curriculum) + ", tc_curri=" + tc_curri + ", tc_image_path=" + tc_image_path
				+ ", tc_video_path=" + tc_video_path + ", tc_status=" + tc_status + ", tc_location=" + tc_location
				+ ", talentImg=" + Arrays.toString(talentImg) + "]";
	}
	
	
	
	
	

	
}
