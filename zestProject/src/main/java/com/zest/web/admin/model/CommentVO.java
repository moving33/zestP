package com.zest.web.admin.model;

import java.util.Date;

public class CommentVO {

	
	private String  ad_reple_id;
	private Integer ad_reple_no;
	private String  ad_reple_content;
	private Integer ad_reple_addno;
	
	private Integer ad_reple_ref; // ���� �׷�ȭ �ϱ����� �ʵ�
	private Integer ad_reple_step; // ��ۼ���
	private Integer ad_reple_level; // �����ġ

	private Date reple_reg_date; // ��۾���¥

	public String getAd_reple_id() {
		return ad_reple_id;
	}

	public void setAd_reple_id(String ad_reple_id) {
		this.ad_reple_id = ad_reple_id;
	}

	public Integer getAd_reple_no() {
		return ad_reple_no;
	}

	public void setAd_reple_no(Integer ad_reple_no) {
		this.ad_reple_no = ad_reple_no;
	}

	public String getAd_reple_content() {
		return ad_reple_content;
	}

	public void setAd_reple_content(String ad_reple_content) {
		this.ad_reple_content = ad_reple_content;
	}

	public Integer getAd_reple_addno() {
		return ad_reple_addno;
	}

	public void setAd_reple_addno(Integer ad_reple_addno) {
		this.ad_reple_addno = ad_reple_addno;
	}

	public Integer getAd_reple_ref() {
		return ad_reple_ref;
	}

	public void setAd_reple_ref(Integer ad_reple_ref) {
		this.ad_reple_ref = ad_reple_ref;
	}

	public Integer getAd_reple_step() {
		return ad_reple_step;
	}

	public void setAd_reple_step(Integer ad_reple_step) {
		this.ad_reple_step = ad_reple_step;
	}

	public Integer getAd_reple_level() {
		return ad_reple_level;
	}

	public void setAd_reple_level(Integer ad_reple_level) {
		this.ad_reple_level = ad_reple_level;
	}

	public Date getReple_reg_date() {
		return reple_reg_date;
	}

	public void setReple_reg_date(Date reple_reg_date) {
		this.reple_reg_date = reple_reg_date;
	}

	@Override
	public String toString() {
		return "CommentVO [ad_reple_id=" + ad_reple_id + ", ad_reple_no=" + ad_reple_no + ", ad_reple_content="
				+ ad_reple_content + ", ad_reple_addno=" + ad_reple_addno + ", ad_reple_ref=" + ad_reple_ref
				+ ", ad_reple_step=" + ad_reple_step + ", ad_reple_level=" + ad_reple_level + ", reple_reg_date="
				+ reple_reg_date + "]";
	}
	
}
