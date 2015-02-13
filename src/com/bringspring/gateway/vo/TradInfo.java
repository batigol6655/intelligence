package com.bringspring.gateway.vo;

import java.util.Date;

public class TradInfo {
	private String id;
    private String plateNo;
    private String videoId;
    private String plateType;
    private Integer photoNum;
    private String catchTime;
    private Integer credibility;
    private Integer status;
    private String plateNoOther;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getPlateType() {
		return plateType;
	}
	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}
	public Integer getPhotoNum() {
		return photoNum;
	}
	public void setPhotoNum(Integer photoNum) {
		this.photoNum = photoNum;
	}
	public String getCatchTime() {
		return catchTime;
	}
	public void setCatchTime(String catchTime) {
		this.catchTime = catchTime;
	}
	public Integer getCredibility() {
		return credibility;
	}
	public void setCredibility(Integer credibility) {
		this.credibility = credibility;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPlateNoOther() {
		return plateNoOther;
	}
	public void setPlateNoOther(String plateNoOther) {
		this.plateNoOther = plateNoOther;
	}
	
}
