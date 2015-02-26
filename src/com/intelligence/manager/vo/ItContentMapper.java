package com.intelligence.manager.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class ItContentMapper implements RowMapper{

public ItContentMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
    ItContent content = new ItContent();
    content.setId(rs.getString("ID"));
    content.setBrand(rs.getString("BRAND"));
    content.setPlatform(rs.getString("PLATFORM"));
    content.setNumber(rs.getString("NUMBER"));
    content.setColor(rs.getString("COLOR"));
    content.setSuitable(rs.getString("SUITABLE"));
    content.setContent(rs.getString("CONTENT"));
    content.setDescribe(rs.getString("DESCRIBE"));
    return content;
  }
}