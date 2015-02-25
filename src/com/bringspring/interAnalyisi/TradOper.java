package com.bringspring.interAnalyisi;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bringspring.gateway.vo.CarPicture;
import com.bringspring.gateway.vo.TradInfo;
import com.intelligence.common.DBConnect;

public class TradOper {
	public DBConnect db = null;
	
	public TradOper()
	{
		if(db==null)
		{
			try {
				db = new DBConnect();
			}catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
	}
	
	public void saveInfo(TradInfo info){
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO HQ_TRADINFO(ID, PLATE_NO, PLATE_NO_OTHER, VIDEO_ID, ");
		sql.append("PLATE_TYPE, PHOTO_NUM, CATCH_TIME,CREDIBILITY) VALUES('");
		sql.append(info.getId());
		sql.append("','");
		sql.append(info.getPlateNo());
		sql.append("','");
		sql.append(info.getPlateNoOther());
		sql.append("','");
		sql.append(info.getVideoId());
		sql.append("','");
		sql.append(info.getPlateType());
		sql.append("','");
		sql.append(info.getPhotoNum());
		sql.append("',to_date('");
		sql.append(info.getCatchTime());
		sql.append("','yyyy-mm-dd hh24:mi:ss'),'");
		sql.append(info.getCredibility());
		sql.append("') ");
		
		try {
			this.db.executeUpdate(sql.toString());
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void savePicture(CarPicture pic){
		StringBuffer sql = new StringBuffer();
		
		sql.append("INSERT INTO HQ_CAR_PICTURE(ID, TRADINFO_ID, PICTURE_NAME, PIC) VALUES('");
		sql.append(pic.getId());
		sql.append("','");
		sql.append(pic.getTradinfoId());
		sql.append("','");
		sql.append(pic.getPictureName());
		sql.append("',empty_blob()) ");
		
		try {
			this.db.executeUpdate(sql.toString());
			
			sql.delete(0, sql.length());
			sql.append("SELECT PIC FROM HQ_CAR_PICTURE WHERE ID='");
			sql.append(pic.getId());
			sql.append("' for update");
			
			ResultSet rs = this.db.executeQuery(sql.toString());
			if(rs.next()){
				oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob(1);  
				  
				OutputStream outStream = blob.getBinaryOutputStream();  
				outStream.write(pic.getPic());
				
				outStream.flush();  
				outStream.close();  
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
