package com.zest.web.admin.model;

public class AdminVO {
	private String id;
	private String pass;
	private String name;
	private String tell;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	@Override
	public String toString() {
		return "AdminVO [id=" + id + ", pass=" + pass + ", name=" + name + ", tell=" + tell + "]";
	}
	
	
	
	
}
