package com.intelligence.view.service;



import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import com.bringspring.gateway.dao.showDao;
import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.TradInfo;
import com.intelligence.common.Pagination;
import com.intelligence.manager.vo.ItContent;
import com.intelligence.manager.vo.ItPicture;
import com.intelligence.manager.vo.ItTitle;
import com.intelligence.view.dao.ShowDAO;





public class ShowServiceImp implements ShowService {
	private ShowDAO showDAO;
	

	public ShowDAO getShowDAO() {
		return showDAO;
	}


	public void setShowDAO(ShowDAO showDAO) {
		this.showDAO = showDAO;
	}


	@Override
	public List<ItTitle> list() throws Exception {
		return showDAO.list();
	}


	@Override
	public ItTitle find(String id) throws Exception {
		return showDAO.findById(id);
	}


	@Override
	public ItContent findContent(String id) throws Exception {
		return showDAO.findContent(id);
	}


	@Override
	public List<ItPicture> findPicture(String id) throws Exception {
		// TODO Auto-generated method stub
		return showDAO.findPicture(id);
	}
	
	
	

}
