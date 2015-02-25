package com.intelligence.manager.service;



import java.sql.Blob;
import java.util.List;

import com.bringspring.gateway.dao.showDao;
import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.TradInfo;
import com.intelligence.common.Pagination;





public class managerServiceImp implements managerService {
	
	private showDao showDao;
	
	public showDao getShowDao() {
		return showDao;
	}

	public void setShowDao(showDao showDao) {
		this.showDao = showDao;
	}
	


	public List tradList(String videoId,String isNew,String inout) throws Exception {
		List<TradInfo> list = showDao.tradList(videoId,isNew,inout);
		/**
		String ids = "";
		if(list!=null && (list.size()!=0) && isNew!=null){
			for (Object object : list) {
				TradInfo trad = (TradInfo) object;
				ids +="'"+ trad.getId()+"',";
			}
			showDao.update(ids.substring(0,ids.length()-1));
		}
		*/
		return list;
	}

	public List imgList(String tradId) throws Exception {
		return showDao.imgList(tradId);
	}

	public byte[] getImgBlob(String imgId) {
		byte[] blob = null;
		CarPicture cp  = (CarPicture) showDao.getImgBlob(imgId);
		if(cp!=null && !cp.equals("")){
			blob = cp.getPic();
		}
		return blob;
	}

	public List<TradInfo> loadTrad(String tradId) {
		return showDao.loadTrad(tradId);
	}

	public List getInParts(String in) throws Exception  {
			return showDao.getInParts(in);
	}

	public List getTradInfo(String in) throws Exception {
		return showDao.getTradInfo(in);
	}

	public Pagination tradAllList(String videoId, String startTime, String endTime,
			String plateType, String plateNo,int currentPage) throws Exception {
		return showDao.tradAllList(videoId,startTime,endTime,plateType,plateNo,currentPage);
	}

	
	

}
