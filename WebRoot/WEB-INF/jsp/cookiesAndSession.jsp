<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
String str=request.getParameter("str");
/* List list=request.getParameter("list");	 */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="id" align="left">
		${str}
	</div>
	<%-- <div id="id2" style="background-color: gray;">
	<% for(Iterator it=list.iterator;it.hasNext();){
		Cookie c=(Cookie) it.next(); %>
	
	</div>
	<%} %> --%>
</body>
</html>