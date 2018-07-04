package com.zest.web.client.model.talent;

/*수업의 정보 모델 : 시간 데이터와 수업의 위치를 담고 있음*/
public class Talent_info {
	private Integer ti_no; // 주요키
	private Integer talent_no; // 수업테이블의 주요키
	private String zone_id; //위치 
	private String ti_zone_detail; //상세 위치 
	private Integer ti_mon; //코드가 들어감 0 일시 시간협의 월요일 화요일 순서
	private Integer ti_tue;
	private Integer ti_wed;
	private Integer ti_tur;
	private Integer ti_fri;
	private Integer ti_sat;
	private Integer ti_sun;
	private Integer ti_status; //상태 코드
	
	private String zone_name; //위치 이름 바꾸기
	
	public Integer getTi_no() {
		return ti_no;
	}
	public void setTi_no(Integer ti_no) {
		this.ti_no = ti_no;
	}
	public Integer getTalent_no() {
		return talent_no;
	}
	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
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
	public Integer getTi_status() {
		return ti_status;
	}
	public void setTi_status(Integer tc_status) {
		this.ti_status = tc_status;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	@Override
	public String toString() {
		return "TalentInfo [ti_no=" + ti_no + ", talent_no=" + talent_no + ", zone_id=" + zone_id + ", ti_zone_detail="
				+ ti_zone_detail + ", ti_mon=" + ti_mon + ", ti_tue=" + ti_tue + ", ti_wed=" + ti_wed + ", ti_tur="
				+ ti_tur + ", ti_fri=" + ti_fri + ", ti_sat=" + ti_sat + ", ti_sun=" + ti_sun + ", tc_status="
				+ ti_status + ", zone_name=" + zone_name + "]";
	}
	
	
	
}
