package com.zest.web.admin.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private String add_id;
	private Integer add_no;
	private String add_name;
	private String add_title;
	private String add_content;
	private Date add_reg_date; // 글쓴 날짜...
	private String add_ip;
	private Integer add_readcount; // 글의 조회수
	private Integer add_status; // 페이지 숨김처리
	
	//FileUpload VO
	private MultipartFile uploadFile;
	
	//Search VO
	private String searchCondition;
	private String searchKeyword;
	

	public String getAdd_id() {
		return add_id;
	}

	public void setAdd_id(String add_id) {
		this.add_id = add_id;
	}

	public int getAdd_no() {
		return add_no;
	}

	public void setAdd_no(int add_no) {
		this.add_no = add_no;
	}

	public String getAdd_name() {
		return add_name;
	}

	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}

	public String getAdd_title() {
		return add_title;
	}

	public void setAdd_title(String add_title) {
		this.add_title = add_title;
	}

	public String getAdd_content() {
		return add_content;
	}

	public void setAdd_content(String add_content) {
		this.add_content = add_content;
	}

	public Date getAdd_reg_date() {
		return add_reg_date;
	}

	public void setAdd_reg_date(Date add_reg_date) {
		this.add_reg_date = add_reg_date;
	}

	public String getAdd_ip() {
		return add_ip;
	}

	public void setAdd_ip(String add_ip) {
		this.add_ip = add_ip;
	}

	public Integer getAdd_readcount() {
		return add_readcount;
	}

	public void setAdd_readcount(Integer add_readcount) {
		this.add_readcount = add_readcount;
	}


	public Integer getAdd_status() {
		return add_status;
	}

	public void setAdd_status(Integer add_status) {
		this.add_status = add_status;
	}
	
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "BoardVO [add_id=" + add_id + ", add_no=" + add_no + ", add_name=" + add_name + ", add_title="
				+ add_title + ", add_content=" + add_content + ", add_reg_date=" + add_reg_date + ", add_ip=" + add_ip
				+ ", add_readcount=" + add_readcount + ", add_status=" + add_status + ", searchCondition="
				+ searchCondition + ", searchKeyword=" + searchKeyword + "]";
	}

	
	

}