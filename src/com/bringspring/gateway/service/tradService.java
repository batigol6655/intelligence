package com.bringspring.gateway.service;
import java.sql.Blob;
import java.util.List;

import com.bringspring.gateway.vo.TradInfo;





public interface tradService {
	
	

	public List tradList() throws Exception;
	
	public List imgList(String tradId) throws Exception;

	public byte[] getImgBlob(String imgId);
	
	public List<TradInfo> loadTrad(String tradId);


}
