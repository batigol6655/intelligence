package com.intelligence.manager.vo;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
public class ItTitleMapper implements RowMapper{

public ItTitleMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
	ItTitle it = new ItTitle();
    
    it.setId(rs.getString("ID"));
    it.setContentId(rs.getString("CONTENT_ID"));
    it.setCreatePerson(rs.getString("CREATE_PERSON"));
    it.setCreateTime(rs.getTimestamp("CREATE_TIME"));
    it.setTitle(rs.getString("TITLE"));
    it.setType(rs.getString("TYPE"));
    
    return it;
  }
}