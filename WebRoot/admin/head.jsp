<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ page import=" com.zl.blog.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% User u = (User)session.getAttribute("loginer");
%>
<html>
<head>
<meta http-equiv=content-type content="text/html; charset=utf-8" />
<link href="./css/admin.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<table cellspacing=0 cellpadding=0 width="100%"
		background="./img/header_bg.jpg" border=0>
		<tr height=56>
			<td width=260><img height=56 src="./img/header_left.jpg"
				width=260>
			</td>
			<td style="font-weight: bold; color: #fff; padding-top: 20px"
				align=middle>欢迎登陆：<%=u.getUsername().toString() %> &nbsp;&nbsp; 
				<a style="color: #fff"
				href="" target=main>修改口令</a> &nbsp;&nbsp;
				<a style="color: #fff"
				href="../index.jsp" target=selt>前台首页</a> &nbsp;&nbsp;
				 <a style="color: #fff"
				onclick="if (confirm('确定要註銷吗？')) return true; else return false;"
				href="../UserServlet?action=logout" target=main>注销</a></td>
			<td align=right width=268><img height=56
				src="./img/header_right.jpg" width=268>
			</td>
		</tr>
	</table>
	<table cellspacing=0 cellpadding=0 width="100%" border=0>
		<tr bgcolor=#1c5db6 height=4>
			<td></td>
		</tr>
	</table>
</body>
</html>