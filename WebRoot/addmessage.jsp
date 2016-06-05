 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import = "com.zl.blog.beans.*" %>
      <%@ page import = "com.zl.blog.daos.*" %>
      <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String cont = request.getParameter("content");
	Message msg = new Message();
	msg.setName(name);
	msg.setContent(cont);
	MessageDao.addMessage(msg);
	response.sendRedirect("message.jsp");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>