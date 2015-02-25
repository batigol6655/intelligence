package com.intelligence.view.dao;

import java.sql.Blob;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;



import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.CarPictureMapper;
import com.bringspring.gateway.vo.PartMapper;
import com.bringspring.gateway.vo.TradInfoMapper;
import com.bringspring.gateway.vo.TradInfo;
import com.intelligence.common.PageHelpper;
import com.intelligence.common.Pagination;
import com.intelligence.manager.vo.ItTitle;
import com.intelligence.manager.vo.ItTitleMapper;


public class ShowDAO extends JdbcDaoSupport  {
	public List<ItTitle> list(){
		StringBuffer buf = new StringBuffer();
		buf.append("select * from it_title order by create_time desc limit 8");
		ItTitleMapper mapper = new ItTitleMapper();
		return this.getJdbcTemplate().query(buf.toString(), mapper);
	}
	
}
