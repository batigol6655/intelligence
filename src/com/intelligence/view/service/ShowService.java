package com.intelligence.view.service;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import com.bringspring.gateway.vo.TradInfo;
import com.intelligence.common.Pagination;
import com.intelligence.manager.vo.ItContent;
import com.intelligence.manager.vo.ItPicture;
import com.intelligence.manager.vo.ItTitle;





public interface ShowService {
	
	public List<ItTitle> list() throws Exception;
	public ItTitle find(String id)throws Exception;
	public ItContent findContent(String id) throws Exception;
	public List<ItPicture> findPicture(String id) throws Exception;
}
