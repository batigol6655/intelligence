package com.bringspring.gateway.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class TradInfoMapper implements RowMapper{

public TradInfoMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
    TradInfo tradinfo = new TradInfo();
    
    tradinfo.setId(rs.getString("ID"));
    tradinfo.setPlateNo(rs.getString("PLATE_NO"));
    tradinfo.setPhotoNum(rs.getInt("PHOTO_NUM"));
    tradinfo.setPlateType(rs.getString("PLATE_TYPE"));
    tradinfo.setVideoId(rs.getString("VIDEO_ID"));
    tradinfo.setCatchTime(rs.getString("CATCH_TIME"));
    tradinfo.setCredibility(rs.getInt("CREDIBILITY"));
    tradinfo.setStatus(rs.getInt("STATUS"));
    tradinfo.setPlateNoOther(rs.getString("PLATE_NO_OTHER"));
    
    return tradinfo;
  }
}