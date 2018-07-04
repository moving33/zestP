package com.zest.web.client.model.classification;


//강의 (소본류) 모델
public class LectureVO {
	
	private String lecture_id;
	private String lecture_name;
	private Integer lecture_count;
	private String category_id;
	
	
	
	
	public LectureVO() {
	}
	
	
	@Override
	public String toString() {
		return "LectureVO [lecture_id=" + lecture_id + ", lecture_name=" + lecture_name + ", lecture_count="
				+ lecture_count + ", category_id=" + category_id + "]";
	}
	public String getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(String lecture_id) {
		this.lecture_id = lecture_id;
	}
	public String getLecture_name() {
		return lecture_name;
	}
	public void setLecture_name(String lecture_name) {
		this.lecture_name = lecture_name;
	}
	public Integer getLecture_count() {
		return lecture_count;
	}
	public void setLecture_count(Integer lecture_count) {
		this.lecture_count = lecture_count;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	
	
	
}
