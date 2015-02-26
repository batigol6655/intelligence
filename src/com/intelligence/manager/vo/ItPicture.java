package com.intelligence.manager.vo;

import java.sql.Timestamp;



public class ItPicture {
	private String id;									//id
	private String title_id;								//标题id
	private String picture_name;//图片链接
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle_id() {
		return title_id;
	}
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}
	public String getPicture_name() {
		return picture_name;
	}
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}
	
	
}
