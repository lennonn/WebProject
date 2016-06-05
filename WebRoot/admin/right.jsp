<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
  <%@ page import=" java.util.*"%> 
  <%@ page import=" java.text.*"%>
   <%@ page import=" com.zl.blog.beans.*"%>
   <%@ page import=" com.zl.blog.daos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
User u = (User)session.getAttribute("loginer");
UserDao ud = new UserDao();
UserInfo ui=ud.findUser(u);
//if(login == null || !login.trim().equals("login")) {
	//response.sendRedirect("login.jsp");
	//return;
//}
%>
<html>
    <head>
        <meta http-equiv=content-type content="text/html; charset=utf-8" />
        <link href="css/admin.css" type="text/css" rel="stylesheet" />
   
    </head>
    <body>
        <table cellspacing=0 cellpadding=0 width="100%" align=center border=0>
            <tr height=28>
                <td background=./img/title_bg1.jpg>当前位置: </td></tr>
            <tr>
                <td bgcolor=#b1ceef height=1></td></tr>
            <tr height=20>
                <td background=./img/shadow_bg.jpg></td></tr></table>
        <table cellspacing=0 cellpadding=0 width="90%" align=center border=0>
            <tr height=100>
                <td align=middle width=100><img height=100 src="./img/admin_p.gif" 
                                                width=90></td>
                <td width=60>&nbsp;</td>
                <td>
                    <table height=100 cellspacing=0 cellpadding=0 width="100%" border=0>

                        <tr>
                            <td>当前时间： <% out.print(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())); %></td></tr>
                        <tr>
                            <td style="font-weight: bold; font-size: 16px"><%=u.getUsername().toString()%></td></tr>
                        <tr>
                            <td>欢迎进入博客管理中心！</td></tr></table></td></tr>
            <tr>
                <td colspan=3 height=10></td></tr></table>
        <table cellspacing=0 cellpadding=0 width="95%" align=center border=0>
           
               
            <tr height=22>
                <td style="padding-left: 20px; font-weight: bold; color: #ffffff" 
                    align=middle background=./img/title_bg2.jpg>您的相关信息</td></tr>
            <tr bgcolor=#ecf4fc height=12>
              
           </table>
        <table cellspacing=0 cellpadding=2 width="95%" align=center border=0>
            <tr>
                <td align=right width=100>登陆帐号：</td>
                <td style="color: #880000"><%=u.getUsername().toString()%></td></tr>
            <tr>
                <td align=right>真实姓名：</td>
                <td style="color: #880000"><%=ui.getReal_name() %></td></tr>
            <tr>
                <td align=right>注册时间：</td>
                <td style="color: #880000"><%=ui.getRegist_time() %> </td></tr>
            <tr>
                <td align=right>邮箱：</td>
                <td style="color: #880000"><%=ui.getEmail() %></td></tr>
            <tr>
                <td align=right>上线时间：</td>
                <td style="color: #880000"> <% out.print(new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())); %></td></tr>
           
        </table>		
<div style="text-align:center;">

</div>
    </body>
</html>