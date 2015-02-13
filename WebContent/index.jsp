<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.test.dwrpush.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	User user = (User) session.getAttribute("user");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<script type="text/javascript">
		 function init(){
			 document.location.href="show/list.action";
		 }
  </script>
	</head>
	<body onload="init()"></body>
</html>

