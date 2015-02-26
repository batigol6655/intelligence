package com.intelligence.manager.vo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
public class ItPictureMapper implements RowMapper{

public ItPictureMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
	ItPicture p = new ItPicture();
    p.setId(rs.getString("ID"));
    p.setTitle_id(rs.getString("TITLE_ID"));
    p.setPicture_name("img/picture/"+rs.getString("PICTURE_NAME"));
    return p;
  }
}