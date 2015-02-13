package com.bringspring.gateway.service;



import java.sql.Blob;
import java.util.List;

import com.bringspring.gateway.dao.tradDao;
import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.Trad;
import com.bringspring.gateway.vo.TradInfo;





public class tradServiceImp implements tradService {
	
	private tradDao tradDao;
	
	public tradDao getTradDao() {
		return tradDao;
	}

	public void setTradDao(tradDao tradDao) {
		this.tradDao = tradDao;
	}
	


	public List tradList() throws Exception {
		List<Trad> list = tradDao.tradList();
		
		return list;
	}

	@Override
	public List imgList(String tradId) throws Exception {
		return tradDao.imgList(tradId);
	}

	@Override
	public byte[] getImgBlob(String imgId) {
		byte[] blob = null;
		CarPicture cp  = (CarPicture) tradDao.getImgBlob(imgId);
		if(cp!=null && !cp.equals("")){
			blob = cp.getPic();
		}
		return blob;
	}

	@Override
	public List<TradInfo> loadTrad(String tradId) {
		return tradDao.loadTrad(tradId);
	}

	
	

}
