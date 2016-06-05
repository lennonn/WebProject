<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<ArticleType> atypes = new ArrayList<ArticleType>();
	ArticleTypeDao atype = new ArticleTypeDao();
	atypes = atype.findArticleType();
%>
<% 
   
   String action = request.getParameter("action");
   if(action!=null&&action.trim().equals("delete")){
   String typename  = request.getParameter("articletype");
  	 atype.articleTypeDelete(typename);
 }
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
		<span> <span style="float: left;">当前位置是：类型管理-》文章类型删除</span> <span
			style="float: right; margin-right: 8px; font-weight: bold;"> <a
				style="text-decoration: none;" href="#">【添加商品】</a> </span> </span>
	</div>
	<div></div>
	<div class="div_search">
		<span>
			<form action="articletypedelete.jsp" method="post">
			<input type ="hidden" name="action" value="delete">
				文章类型：<select name="articletype" onchange="document.form.submit()" style="width: 200px;">
					
					<%
					for (Iterator<ArticleType> it = atypes.iterator(); it.hasNext();) {
						ArticleType at = it.next();
				%>
					<option  selected="<%=(at.getType_name()!=null)?"selected":"" %> value="0"><%=at.getType_name() %></option>
					<% }%>
				</select> <input value="删除" type="submit" />
			</form>
		 </span>
	</div>
	<div style="font-size: 13px; margin: 10px 5px;">
		<table class="table_a" border="1" width="100%">
			<tbody>

				<tr style="font-weight: bold;">
					<td>序号ID</td>
					<td>文章类型名</td>
					<td>文章类型描述</td>
					<td>文章类型操作</td>
				</tr>
				<%
					for (Iterator<ArticleType> it = atypes.iterator(); it.hasNext();) {
						ArticleType at = it.next();
				%>
				<tr id="product4" style="font-family: fantasy;">
					<td><%=at.getId()%></td>
					<td><%=at.getType_name()%></td>
					<td><%=at.getType_desc()%></td>
					<td>
					
					 <a target="right"
					href="../ArticleTypeServlet?action=delete&id=<%=at.getId()%>"
					onclick="return confirm('真的要删除?')">删除</a>
					</td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>