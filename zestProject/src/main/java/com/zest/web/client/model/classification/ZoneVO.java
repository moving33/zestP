package com.zest.web.client.model.classification;

//zone VO
public class ZoneVO {
	private String zone_id; //영어 아이디
	private String zone_name; // 지역 한글이름
	private String city_id; // 도시 이름
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	@Override
	public String toString() {
		return "ZoneVO [zone_id=" + zone_id + ", zone_name=" + zone_name + ", city_id=" + city_id + "]";
	}
	
	
}
