package com.zest.web.client.model.talent;

//강의 원데이가 아닌 항목의 테이블
public class Talent_notOneDayTime {
	private Integer tt_nod_no; //주요키
	private String time1; //시간 1
	private String time2; //시간 2
	private String time3; //시간 3
	
	public Integer getTt_nod_no() {
		return tt_nod_no;
	}
	public void setTt_nod_no(Integer tt_nod_no) {
		this.tt_nod_no = tt_nod_no;
	}
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	public String getTime3() {
		return time3;
	}
	public void setTime3(String time3) {
		this.time3 = time3;
	}
	@Override
	public String toString() {
		return "Talent_notOneDayTime [tt_nod_no=" + tt_nod_no + ", time1=" + time1 + ", time2=" + time2 + ", time3="
				+ time3 + "]";
	}
	
	
	
	
	
}
