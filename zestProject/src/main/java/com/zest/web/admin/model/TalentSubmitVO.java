package com.zest.web.admin.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

//돈 승인 table
public class TalentSubmitVO {

	private Integer ts_no;
	private Integer to_no;
	private Integer tt_no;
	private Integer ts_cl_no;
	private Integer ts_status;
	private Integer to_real_price;
	private Integer to_price_total;
	private Integer benefit;	
	private LocalDateTime ti_date;
	private Timestamp to_reg_date;
	
	
	
	
	
	@Override
	public String toString() {
		return "TalentSubmitVO [ts_no=" + ts_no + ", to_no=" + to_no + ", tt_no=" + tt_no + ", ts_cl_no=" + ts_cl_no
				+ ", ts_status=" + ts_status + ", to_real_price=" + to_real_price + ", to_price_total=" + to_price_total
				+ ", benefit=" + benefit + ", ti_date=" + ti_date + ", to_reg_date=" + to_reg_date + "]";
	}
	public Integer getTs_no() {
		return ts_no;
	}
	public void setTs_no(Integer ts_no) {
		this.ts_no = ts_no;
	}
	public Integer getTo_no() {
		return to_no;
	}
	public void setTo_no(Integer to_no) {
		this.to_no = to_no;
	}
	public Integer getTt_no() {
		return tt_no;
	}
	public void setTt_no(Integer tt_no) {
		this.tt_no = tt_no;
	}
	public Integer getTs_cl_no() {
		return ts_cl_no;
	}
	public void setTs_cl_no(Integer ts_cl_no) {
		this.ts_cl_no = ts_cl_no;
	}
	public Integer getTs_status() {
		return ts_status;
	}
	public void setTs_status(Integer ts_status) {
		this.ts_status = ts_status;
	}
	public Integer getTo_real_price() {
		return to_real_price;
	}
	public void setTo_real_price(Integer to_real_price) {
		this.to_real_price = to_real_price;
	}
	public Integer getTo_price_total() {
		return to_price_total;
	}
	public void setTo_price_total(Integer to_price_total) {
		this.to_price_total = to_price_total;
	}
	public Integer getBenefit() {
		return benefit;
	}
	public void setBenefit(Integer benefit) {
		this.benefit = benefit;
	}
	public LocalDateTime getTi_date() {
		return ti_date;
	}
	public void setTi_date(LocalDateTime ti_date) {
		this.ti_date = ti_date;
	}
	public Timestamp getTo_reg_date() {
		return to_reg_date;
	}
	public void setTo_reg_date(Timestamp to_reg_date) {
		this.to_reg_date = to_reg_date;
	}
	
	
	
	
}
