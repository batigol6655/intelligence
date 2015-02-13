package com.bringspring.gateway.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class TradMapper implements RowMapper{

public TradMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
    Trad trad = new Trad();
    
    trad.setId(rs.getString("ID"));
    trad.setTradName(rs.getString("TRAD_NAME"));
    trad.setTradVideo(rs.getString("TRAD_VIDEO"));
    
    return trad;
  }
}