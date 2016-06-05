<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.zl.blog.daos.UserDao"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>

<link href="css/login.css" type="text/css" rel="stylesheet" />

</head>
<body id="userlogin_body">

	<div id="user_login">
		<dl>
			<dd id="user_top">
				<ul>
					<li class="user_top_l"></li>
					<li class="user_top_c"></li>
					<li class="user_top_r"></li>
				</ul>
			</dd>
			<dd id="user_main">

				<ul>
					<form name="login" action="../UserServlet" method="post"
						value="login">
						<input type="hidden" name="action" value="login">
						<li class="user_main_l"></li>
						<li class="user_main_c">
							<div class="user_main_box">

								<ul>
									<li class="user_main_text">用户名：</li>
									<li class="user_main_input"><input name="username"
										maxlength="20" id="TxtUserName" class="txtusernamecssclass">
									</li>
								</ul>
								<ul>
									<li class="user_main_text">密 码：</li>
									<li class="user_main_input"><input type="password"
										name="password" id="TxtPassword" class="txtpasswordcssclass">
									</li>
								</ul>
								<ul>
									<li class="user_main_text">&nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;</li>
									<li class="user_main_input"><a href="register.jsp">忘记密码？</a>&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp">注冊用戶</a></li>


								</ul>
								<ul>
									<li class="user_main_text">
										<%
											String mess = (String) session.getAttribute("message");
											if(mess==null||mess.equals(""))
											mess="请输入用户名和密码！";
										%> 
									
										<%=mess%>
										
									
								</ul>



							</div></li>

						<li class="user_main_r"><input class=IbtnEnterCssClass
							id=IbtnEnter type="image" method="submit" name="enter"
							src="img/user_botton.gif" alt="图片按钮"></li>
					</form>
				</ul>

			</dd>
			<dd id="user_bottom">
				<ul>
					<li class="user_bottom_l"></li>
					<li class="user_bottom_c"></li>
					<li class="user_bottom_r"></li>
				</ul>
			</dd>
		</dl>
	</div>


</body>
</html>