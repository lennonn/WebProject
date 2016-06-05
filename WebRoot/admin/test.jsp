<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!private static final int pagesize = 4;%>
<%
	String strpageno = request.getParameter("pageno");
	int page_no = 1;
	if (strpageno != null) {
		page_no = Integer.parseInt(strpageno);
	}
	if (page_no < 1)
		page_no = 1;

	List<ImageType> images = new ArrayList<ImageType>();
	ImageTypeDao itad = new ImageTypeDao();
	images = itad.findImageType();
%>

	
	
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<title>会员列表</title>

<link href="./css/mine.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<style>
p.tr_color {
	background-color: #9F88FF
}
</style>
	<div class="div_head">
		<span> <span style="float: left;">当前位置是：我的相册-》相册列表</span> <span
			style="float: right; margin-right: 8px; font-weight: bold;"> <a
				style="text-decoration: none;" href="#">返回</a> </span> </span>
	</div>
	<div></div>
	<div class="div_search">
		<span>
			<form action="../ImageServlet" method="post">
				<input type="hidden" name="action" value="select"> 请选择相册类型<select
					name="imagetype" onchange="document.form.submit()"
					style="width: 200px;">

					<%
					 ArrayList imageList=(ArrayList)session.getAttribute("imageList");
						for (Iterator<ImageType> it = images.iterator(); it.hasNext();) {
							ImageType itype = it.next();
					%>
					<option selected="selected" value="<%=itype.getId()%>"><%=itype.getType_name()%></option>
					<%
						}
					%>
				</select> <input value="查询相册" type="submit" />
			</form> </span>
	</div>
	<div style="font-size: 13px; margin: 10px 5px;">

		

						<%
					for (int i = 0; i < imageList.size(); i++) {
					Image image= (Image)imageList.get(i);
				%>
			
				
				<%=image.getImgname() %>
				
				<% out.print("<tr height='120'>");
                 out.print("<td width='25%' style='padding-left:10'>");%>
				<img src="<%=image.getImgurl() %>"  float="left" border='0' width='120' height='120' style='border:1 solid;border-color:black'/>
				<%
					 %>
				
					<%=image.getImgdesc() %>			
			
				
				<%
				               out.println("</td>");
                        		out.println("</tr>");
					}
					
				%>
		
				
		
		<a href="articlelist.jsp?pageno=<%=page_no - 1%>">上一页</a> <a
			href="articlelist.jsp?pageno=<%=page_no + 1%>">下一页</a>
	</div>
</body>
</html>