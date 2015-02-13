package com.bringspring.gateway.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class CarPictureMapper implements RowMapper{

public CarPictureMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
    CarPicture car = new CarPicture();
    
    car.setId(rs.getString("ID"));
   car.setPictureName(rs.getString("PICTURE_NAME"));
   car.setTradinfoId(rs.getString("TRADINFO_ID"));
   car.setPic(rs.getBytes("PIC"));
    
    return car;
  }
}