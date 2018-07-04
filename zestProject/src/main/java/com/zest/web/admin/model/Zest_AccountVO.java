package com.zest.web.admin.model;

import java.sql.Timestamp;

//zest 계좌 
public class Zest_AccountVO {
	private Integer dep_no;
	private String dep_type;
	private Integer to_no;
	private Integer ts_no;
	private Integer dep_money;
	private Integer wit_money;
	private Integer zest_dep;
	private Integer td_no;
	private Integer rf_no;
	private Integer dep_talent_no;
	private Integer dep_cl_no; //입급한 튜터의 고유번호.
	private Integer dep_tt_no; //출금할 튜터의 고유번호.
	private Timestamp dep_reg_date;
	
	
	
	@Override
	public String toString() {
		return "Zest_AccountVO [dep_no=" + dep_no + ", dep_type=" + dep_type + ", to_no=" + to_no + ", ts_no=" + ts_no
				+ ", dep_money=" + dep_money + ", wit_money=" + wit_money + ", zest_dep=" + zest_dep + ", td_no="
				+ td_no + ", rf_no=" + rf_no + ", dep_talent_no=" + dep_talent_no + ", dep_cl_no=" + dep_cl_no
				+ ", dep_tt_no=" + dep_tt_no + ", dep_reg_date=" + dep_reg_date + "]";
	}

	public Timestamp getDep_reg_date() {
		return dep_reg_date;
	}

	public void setDep_reg_date(Timestamp dep_reg_date) {
		this.dep_reg_date = dep_reg_date;
	}

	

	public Integer getDep_no() {
		return dep_no;
	}

	public void setDep_no(Integer dep_no) {
		this.dep_no = dep_no;
	}

	public String getDep_type() {
		return dep_type;
	}

	public void setDep_type(String dep_type) {
		this.dep_type = dep_type;
	}

	public Integer getTo_no() {
		return to_no;
	}

	public void setTo_no(Integer to_no) {
		this.to_no = to_no;
	}

	public Integer getTs_no() {
		return ts_no;
	}

	public void setTs_no(Integer ts_no) {
		this.ts_no = ts_no;
	}

	public Integer getDep_money() {
		return dep_money;
	}

	public void setDep_money(Integer dep_money) {
		this.dep_money = dep_money;
	}

	public Integer getWit_money() {
		return wit_money;
	}

	public void setWit_money(Integer wit_money) {
		this.wit_money = wit_money;
	}

	public Integer getZest_dep() {
		return zest_dep;
	}

	public void setZest_dep(Integer zest_dep) {
		this.zest_dep = zest_dep;
	}

	public Integer getTd_no() {
		return td_no;
	}

	public void setTd_no(Integer td_no) {
		this.td_no = td_no;
	}

	public Integer getRf_no() {
		return rf_no;
	}

	public void setRf_no(Integer rf_no) {
		this.rf_no = rf_no;
	}

	public Integer getDep_talent_no() {
		return dep_talent_no;
	}

	public void setDep_talent_no(Integer dep_talent_no) {
		this.dep_talent_no = dep_talent_no;
	}

	public Integer getDep_cl_no() {
		return dep_cl_no;
	}

	public void setDep_cl_no(Integer dep_cl_no) {
		this.dep_cl_no = dep_cl_no;
	}

	public Integer getDep_tt_no() {
		return dep_tt_no;
	}

	public void setDep_tt_no(Integer dep_tt_no) {
		this.dep_tt_no = dep_tt_no;
	}
	
	
	
	
	
	
}
