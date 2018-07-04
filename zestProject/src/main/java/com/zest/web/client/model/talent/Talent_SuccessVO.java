package com.zest.web.client.model.talent;

import java.time.LocalDateTime;

//매칭 관련 VO
public class Talent_SuccessVO {

	private Integer ts_no;
	private Integer to_no;
	private Integer tt_no;
	private Integer ts_cl_no;
	private LocalDateTime ti_date;
	private Integer ti_curr_round;
	private Integer ti_end_round;
	private Integer ps_money;
	private Integer ts_status;
	
	
	
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
	public LocalDateTime getTi_date() {
		return ti_date;
	}
	public void setTi_date(LocalDateTime ti_date) {
		this.ti_date = ti_date;
	}
	public Integer getTi_curr_round() {
		return ti_curr_round;
	}
	public void setTi_curr_round(Integer ti_curr_round) {
		this.ti_curr_round = ti_curr_round;
	}
	public Integer getTi_end_round() {
		return ti_end_round;
	}
	public void setTi_end_round(Integer ti_end_round) {
		this.ti_end_round = ti_end_round;
	}
	public Integer getPs_money() {
		return ps_money;
	}
	public void setPs_money(Integer ps_money) {
		this.ps_money = ps_money;
	}
	public Integer getTs_status() {
		return ts_status;
	}
	public void setTs_status(Integer ts_status) {
		this.ts_status = ts_status;
	}
	@Override
	public String toString() {
		return "Talent_SuccessVO [ts_no=" + ts_no + ", to_no=" + to_no + ", tt_no=" + tt_no + ", ts_cl_no=" + ts_cl_no
				+ ", ti_date=" + ti_date + ", ti_curr_round=" + ti_curr_round + ", ti_end_round=" + ti_end_round
				+ ", ps_money=" + ps_money + ", ts_status=" + ts_status + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
