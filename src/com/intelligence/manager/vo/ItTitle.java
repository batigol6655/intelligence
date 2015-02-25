package com.intelligence.manager.vo;

import java.sql.Timestamp;



public class ItTitle {
	private String id;									//id
	private String title;								//标题
	private Timestamp create_time;				//创建时间
	private String create_person;					//创建人
	private String type;								//类型
	private double price_old;//原价
	private double price_new;//折扣价
	private String content_id;						//内容id
	private String state;//状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public String getCreate_person() {
		return create_person;
	}
	public void setCreate_person(String create_person) {
		this.create_person = create_person;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice_old() {
		return price_old;
	}
	public void setPrice_old(double price_old) {
		this.price_old = price_old;
	}
	public double getPrice_new() {
		return price_new;
	}
	public void setPrice_new(double price_new) {
		this.price_new = price_new;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
