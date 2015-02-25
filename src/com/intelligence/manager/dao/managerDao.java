package com.intelligence.manager.dao;

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


public class managerDao extends JdbcDaoSupport  {
	
/**
 * 首页展示通道信息和图片信息
 * @return
 * @throws Exception
 * @author fanzl
 * 2014.03.25
 */
	public List tradList(String videoId,String isNew,String inout) throws Exception {
		StringBuffer sql = new StringBuffer();
		
		//页面定时刷新的新数据，只取最后10条
		if(isNew!=null && isNew.equals("new")){
			sql.append("SELECT * FROM (SELECT REPLACE(PLATE_NO,'NoPlate','') PLATE_NO,REPLACE(PLATE_NO_OTHER,'NoPlate','') PLATE_NO_OTHER,TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss') CATCH_TIME,ID,VIDEO_ID,PLATE_TYPE,PHOTO_NUM,CREDIBILITY,STATUS FROM HQ_TRADINFO WHERE 1=1");  
			if(videoId!=null && !videoId.equals("")){
				sql.append(" AND VIDEO_ID='"+videoId+"' ");
			}
			//入口车辆为in，出口车辆为out
			if(inout!=null && inout.equals("in")){
				sql.append(" AND VIDEO_ID IN ('1','2','3','4','5','6')");
			}else if(inout!=null && inout.equals("out")){
				sql.append(" AND VIDEO_ID IN ('7','8','9','10','11','12')");
			}
			sql.append(" ORDER BY CATCH_TIME DESC)");
			sql.append(" WHERE ROWNUM<=10");
		}else{
			//去全部车辆数据
			sql.append("SELECT REPLACE(PLATE_NO,'NoPlate','') PLATE_NO,REPLACE(PLATE_NO_OTHER,'NoPlate','') PLATE_NO_OTHER,TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss') CATCH_TIME,ID,VIDEO_ID,PLATE_TYPE,PHOTO_NUM,CREDIBILITY,STATUS FROM HQ_TRADINFO WHERE 1=1");
			if(videoId!=null && !videoId.equals("")){
				sql.append(" AND VIDEO_ID='"+videoId+"' ");
			}
			//入口通道
			if(inout!=null && inout.equals("in")){
				sql.append(" AND VIDEO_ID IN ('1','2','3','4','5','6')");
			//出口通道
			}else if(inout!=null && inout.equals("out")){
				sql.append(" AND VIDEO_ID IN ('7','8','9','10','11','12')");
			}
			sql.append("  ORDER BY CATCH_TIME DESC");
		}
		//System.out.println(sql);
		TradInfoMapper showMapper = new TradInfoMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}
	public Pagination tradAllList(String videoId, String startTime, String endTime,
			String plateType, String plateNo,int currentPage) throws Exception {
		StringBuffer sql = new StringBuffer();
		
			//去全部车辆数据
			sql.append("SELECT REPLACE(PLATE_NO,'NoPlate','') PLATE_NO,REPLACE(PLATE_NO_OTHER,'NoPlate','') PLATE_NO_OTHER,TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss') CATCH_TIME,ID,VIDEO_ID,PLATE_TYPE,PHOTO_NUM,CREDIBILITY,STATUS FROM HQ_TRADINFO WHERE 1=1");
			if(videoId!=null && !videoId.equals("")){
				sql.append(" AND VIDEO_ID='"+videoId+"' ");
			}
			if(plateType!=null && !plateType.equals("")){
				sql.append(" AND PLATE_TYPE='"+plateType+"'");
			}
			if(plateNo!=null && !plateNo.equals("")){
				sql.append(" AND PLATE_NO LIKE '%"+plateNo+"%'");
			}
			if(startTime!=null && !startTime.equals("")){
				sql.append(" AND ");
			}
			if(endTime!=null && !endTime.equals("")){
				
			}
			sql.append("  ORDER BY CATCH_TIME DESC");
		System.out.println(sql);
		PageHelpper pagehelpper = new PageHelpper();
		
		return pagehelpper.getPagination(sql.toString(), currentPage, 10, this.getJdbcTemplate(),new TradInfoMapper());
	}
	public void update(String ids){
		String sql = "UPDATE HQ_TRADINFO SET STATUS=1 WHERE ID IN ("+ids+")";
		//System.out.println(sql);
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
		//System.out.println(sql);
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
		//System.out.println(sql);
		return this.getJdbcTemplate().queryForObject(sql,showMapper);
	}
	
	public List<TradInfo> loadTrad(String tradId) {
		String sql = "SELECT REPLACE(PLATE_NO,'NoPlate','') PLATE_NO,REPLACE(PLATE_NO_OTHER,'NoPlate','') PLATE_NO_OTHER,TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss') CATCH_TIME,ID,VIDEO_ID,PLATE_TYPE,PHOTO_NUM,CREDIBILITY,STATUS FROM HQ_TRADINFO WHERE  ID='"+tradId+"'";
		TradInfoMapper showMapper = new TradInfoMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}
	
	public List getInParts(String in) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT TO_CHAR(CATCH_TIME,'HH24')||'时' HOUR,COUNT(*) SUM FROM HQ_TRADINFO WHERE 1=1 ");
		if(in!=null && in.equals("yes")){
			sql.append(" AND VIDEO_ID IN ('1','2','3','4','5')");
		}else{
			sql.append(" AND VIDEO_ID IN ('6','7','8','9','10','11','12')");
		}
		sql.append(" AND TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss')>TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		sql.append("GROUP BY TO_CHAR(CATCH_TIME,'HH24')");
		//System.out.println(sql);
		PartMapper showMapper = new PartMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}
	
	public List getTradInfo(String in) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT VIDEO_ID HOUR,COUNT(*) SUM FROM HQ_TRADINFO WHERE 1=1 ");
		if(in!=null && in.equals("yes")){
			sql.append(" AND VIDEO_ID IN ('1','2','3','4','5')");
		}else{
			sql.append(" AND VIDEO_ID IN ('6','7','8','9','10','11','12')");
		}
		sql.append(" AND TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss')>TO_CHAR(SYSDATE,'yyyy-mm-dd')");
		sql.append("GROUP BY VIDEO_ID ORDER BY TO_NUMBER(HOUR)");
		//System.out.println(sql);
		PartMapper showMapper = new PartMapper();
		return this.getJdbcTemplate().query(sql.toString(),showMapper);
	}
}
