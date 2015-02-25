package com.intelligence.manager.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class ItContentMapper implements RowMapper{

public ItContentMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
    ItContent trad = new ItContent();
    
    trad.setHour(rs.getString("HOUR"));
    trad.setSum(rs.getString("SUM"));
    
    return trad;
  }
}