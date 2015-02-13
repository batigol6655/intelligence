package com.bringspring.gateway.dao;

import java.sql.Blob;
import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.CarPictureMapper;
import com.bringspring.gateway.vo.TradInfoMapper;
import com.bringspring.gateway.vo.TradInfo;
import com.bringspring.gateway.vo.TradMapper;



public class tradDao extends JdbcDaoSupport  {
	
/**
 * 首页展示通道信息和图片信息
 * @return
 * @throws Exception
 * @author fanzl
 * 2014.03.25
 */
	public List tradList() throws Exception {
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM HQ_TRAD WHERE 1=1");
		
		TradMapper showMapper = new TradMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}

	public void update(String ids){
		String sql = "UPDATE HQ_TRADINFO SET STATUS=1 WHERE ID IN ("+ids+")";
		System.out.println(sql);
		this.getJdbcTemplate().execute(sql);
	}
	
	public List imgList(String tradId) throws Exception {
		StringBuffer sql = new StringBuffer();
		
		sql.append("SELECT * FROM HQ_CAR_PICTURE WHERE 1=1");
		if(tradId!=null && !tradId.equals("")){
			sql.append(" AND TRADINFO_ID='"+tradId+"' ");
		}
		sql.append(" AND PIC IS NOT NULL");
		sql.append(" ORDER BY ID DESC");
		System.out.println(sql);
		CarPictureMapper showMapper = new CarPictureMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}
	
	public String saveInfo(TradInfo info){
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO HQ_TRADINFO(ID, PLATE_NO, VIDEO_ID, ");
		sql.append("PLATE_TYPE, PHOTO_NUM, CATCH_TIME,CREDIBILITY) VALUES('");
		sql.append(info.getId());
		sql.append("','");
		sql.append(info.getPlateNo());
		sql.append("','");
		sql.append(info.getVideoId());
		sql.append("','");
		sql.append(info.getPlateType());
		sql.append("','");
		sql.append(info.getPhotoNum());
		sql.append("','");
		sql.append(info.getCatchTime());
		sql.append("','");
		sql.append(info.getCredibility());
		sql.append("') ");
		
		this.getJdbcTemplate().execute(sql.toString());
		
		return info.getId();
	}
	
	public void savePicture(CarPicture pic){
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO HQ_CAR_PICTURE(ID, TRADINFO_ID, PICTURE_NAME) VALUES('");
		sql.append(pic.getId());
		sql.append("','");
		sql.append(pic.getTradinfoId());
		sql.append("','");
		sql.append(pic.getPictureName());
		sql.append("') ");
		
		this.getJdbcTemplate().execute(sql.toString());
	}

	public Object getImgBlob(String imgId) {
		String sql = "SELECT * FROM HQ_CAR_PICTURE WHERE ID='"+imgId+"'";
		CarPictureMapper showMapper = new CarPictureMapper();
		System.out.println(sql);
		return this.getJdbcTemplate().queryForObject(sql,showMapper);
	}
	
	public List<TradInfo> loadTrad(String tradId) {
		String sql = "SELECT * FROM HQ_TRADINFO WHERE ID='"+tradId+"'";
		TradInfoMapper showMapper = new TradInfoMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}
}
