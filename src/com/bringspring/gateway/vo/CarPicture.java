package com.bringspring.gateway.vo;

public class CarPicture {
	private String id;
	private String tradinfoId;
	private String pictureName;
	private byte[] pic;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTradinfoId() {
		return tradinfoId;
	}
	public void setTradinfoId(String tradinfoId) {
		this.tradinfoId = tradinfoId;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
}
