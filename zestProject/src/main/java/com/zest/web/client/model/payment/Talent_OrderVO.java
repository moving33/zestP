package com.zest.web.client.model.payment;

//결제 VO
public class Talent_OrderVO {

	private Integer to_no;
	private Integer talent_no;
	private Integer cl_no;
	private Integer tt_no;
	private Integer to_real_price;
	private Integer to_use_point;
	private Integer to_price_total;
	private Integer to_meet_count;
	private Integer to_reg_date;
	private String to_type;
	private String to_client_ac_no;
	private String to_ip;
	private Integer tp_status;
	
	@Override
	public String toString() {
		return "Talent_OrderVO [to_no=" + to_no + ", talent_no=" + talent_no + ", cl_no=" + cl_no + ", tt_no=" + tt_no
				+ ", to_real_price=" + to_real_price + ", to_use_point=" + to_use_point + ", to_price_total="
				+ to_price_total + ", to_meet_count=" + to_meet_count + ", to_reg_date=" + to_reg_date + ", to_type="
				+ to_type + ", to_client_ac_no=" + to_client_ac_no + ", to_ip=" + to_ip + ", tp_status=" + tp_status
				+ "]";
	}

	public Integer getTo_no() {
		return to_no;
	}

	public void setTo_no(Integer to_no) {
		this.to_no = to_no;
	}

	public Integer getTalent_no() {
		return talent_no;
	}

	public void setTalent_no(Integer talent_no) {
		this.talent_no = talent_no;
	}

	public Integer getCl_no() {
		return cl_no;
	}

	public void setCl_no(Integer cl_no) {
		this.cl_no = cl_no;
	}

	public Integer getTt_no() {
		return tt_no;
	}

	public void setTt_no(Integer tt_no) {
		this.tt_no = tt_no;
	}

	public Integer getTo_real_price() {
		return to_real_price;
	}

	public void setTo_real_price(Integer to_real_price) {
		this.to_real_price = to_real_price;
	}

	public Integer getTo_use_point() {
		return to_use_point;
	}

	public void setTo_use_point(Integer to_use_point) {
		this.to_use_point = to_use_point;
	}

	public Integer getTo_price_total() {
		return to_price_total;
	}

	public void setTo_price_total(Integer to_price_total) {
		this.to_price_total = to_price_total;
	}

	public Integer getTo_meet_count() {
		return to_meet_count;
	}

	public void setTo_meet_count(Integer to_meet_count) {
		this.to_meet_count = to_meet_count;
	}

	public Integer getTo_reg_date() {
		return to_reg_date;
	}

	public void setTo_reg_date(Integer to_reg_date) {
		this.to_reg_date = to_reg_date;
	}

	public String getTo_type() {
		return to_type;
	}

	public void setTo_type(String to_type) {
		this.to_type = to_type;
	}

	public String getTo_client_ac_no() {
		return to_client_ac_no;
	}

	public void setTo_client_ac_no(String to_client_ac_no) {
		this.to_client_ac_no = to_client_ac_no;
	}

	public String getTo_ip() {
		return to_ip;
	}

	public void setTo_ip(String to_ip) {
		this.to_ip = to_ip;
	}

	public Integer getTp_status() {
		return tp_status;
	}

	public void setTp_status(Integer tp_status) {
		this.tp_status = tp_status;
	}
	
	
	
	
	
	
}
