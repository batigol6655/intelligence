package com.intelligence.manager.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class PartMapper implements RowMapper{

public PartMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
    Part trad = new Part();
    
    trad.setHour(rs.getString("HOUR"));
    trad.setSum(rs.getString("SUM"));
    
    return trad;
  }
}