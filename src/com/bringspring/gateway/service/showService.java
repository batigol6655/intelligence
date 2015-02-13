package com.bringspring.gateway.service;
import java.sql.Blob;
import java.util.List;

import com.bringspring.common.Pagination;
import com.bringspring.gateway.vo.TradInfo;





public interface showService {
	
	

	public List tradList(String videoId,String isNew,String inout) throws Exception;
	
	public Pagination tradAllList(String videoId,String startTime,String endTime,String plateType,String plateNo,int currentPage) throws Exception;
	
	public List imgList(String tradId) throws Exception;

	public byte[] getImgBlob(String imgId);
	
	public List<TradInfo> loadTrad(String tradId);
	
	public List getInParts(String in) throws Exception;
	
	public List getTradInfo(String in) throws Exception;

}
