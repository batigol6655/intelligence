package com.bringspring.servlet;
/** 修改历史
 *   日期               作者          修改内容
 * -----------------------------------------------------------------------------
 * 2011-01-9            李小强         创建CLASS
 */


import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bringspring.client.Client;
import com.intelligence.common.DBConnect;

public class GetTradInfo extends HttpServlet {
	private static final long serialVersionUID = -5216193301182504458L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void init() throws ServletException{

		System.out.println(">>开始启动接口线程>>");
		DBConnect db = null;
		try {
			
			db = new DBConnect();
			ResultSet rs = (ResultSet) db.executeQuery("select * from hq_tradserver");
			rs.beforeFirst();
			while(rs.next())
			{
				String ip = rs.getString("SERVER_IP");
				int port = rs.getInt("SERVER_PORT");
				Client cl = new Client(ip, port);
				cl.start();
				Thread.sleep(1000);
//				ConnectionManager.createConnection(ip, port);
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}finally{
			if(db!=null){
        		try {
					db.close();
				} catch (Exception e) {
					System.out.println(e);
					e.printStackTrace();
				}
        	}
		}
	
	} 
	
	public static void main(String[] args)
	{
		Client cl = new Client("172.20.200.144", 33002);
		cl.start();
	}
}
