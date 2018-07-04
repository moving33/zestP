package com.zest.web.notice.model;

import java.util.Date;

// 공지사항 모델
public class NoticeVO {
	private Integer notice_no; // 고유번호
	private String notice_title; // 제목
	private String notice_content; // 내용
	private Date notice_date; // 날짜
	private String notice_count; // 조회수
	public Integer getNotice_no() {
		return notice_no;
	}
	public void setNotice_no(Integer notice_no) {
		this.notice_no = notice_no;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
	public String getNotice_count() {
		return notice_count;
	}
	public void setNotice_count(String notice_count) {
		this.notice_count = notice_count;
	}
	public Date getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}
	@Override
	public String toString() {
		return "NoticeVO [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_content="
				+ notice_content + ", notice_date=" + notice_date + ", notice_count=" + notice_count + "]";
	}
	
	
	
	
}
