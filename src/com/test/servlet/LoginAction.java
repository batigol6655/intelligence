package com.test.servlet;
/** 修改历史
 *   日期               作者          修改内容
 * -----------------------------------------------------------------------------
 * 2011-01-9            李小强         创建CLASS
 */


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dwrpush.User;

public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = -5216193301182504458L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		User user = new User();
		user.setUsername(username);
		user.setRoomName("操场");
		if ("333".equals(username) || "444".equals(username)|| "555".equals(username)) {
			user.setAsso("333的社团");
		}
		if ("111".equals(username) || "222".equals(username)) {
			user.setClazz("111的班级");
		}
		if ("333".equals(username) || "111".equals(username)) {
			user.setRoomName("教室");
		}

		session.setAttribute("user", user);
		response.sendRedirect("index.jsp");
	}
}
