package com.intelligence.manager.vo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
public class ItTitleMapper implements RowMapper{

public ItTitleMapper(){}

public Object mapRow(ResultSet rs, int rowNum)throws SQLException{
	ItTitle it = new ItTitle();
    it.setId(rs.getString("ID"));
    it.setTitle(rs.getString("TITLE"));
    it.setCreate_time(rs.getTimestamp("CREATE_TIME"));
    it.setCreate_person(rs.getString("CREATE_PERSON"));
    it.setType(rs.getString("TYPE"));
    it.setPrice_old(rs.getDouble("PRICE_OLD"));
    it.setPrice_new(rs.getDouble("PRICE_NEW"));
    it.setState(rs.getString("STATE"));
    it.setContent_id(rs.getString("CONTENT_ID"));
    return it;
  }
}