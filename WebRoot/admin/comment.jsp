<%@ page language="java" contentType="text/html; charset=gbk"
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

	List<ArticleComment> aclist = new ArrayList<ArticleComment>();
	ArticleCommentDao acd = new ArticleCommentDao();
	aclist =acd.commentlist(page_no, pagesize);
%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=gbk" />

<title>会员列表</title>

<link href="./css/mine.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<style> 
hp.tr_color { 
	background-color: #9F88FF 
} 
</style>
	<div class="div_head">
		<span> <span style="float: left;">当前位置是：类型管理-》文章列表</span> <span
			style="float: right; margin-right: 8px; font-weight: bold;"> <a
				style="text-decoration: none;" href="#">【添加商品】</a> </span> </span>
	</div>
	<div></div>
	<div class="div_search">
		<span>
			<form action="#" method="get">
				昵称<select name="s_product_mark" style="width: 100px;">
					<option selected="selected" value="0">请选择</option>
					<option value="1">苹果apple</option>
				</select> <input value="查询" type="submit" />
			</form> </span>
	</div>
	<div style="font-size: 13px; margin: 10px 5px;">
		<table class="table_a" border="1" width="100%">
			<tbody>

				<tr style="font-weight: bold;">

					
					<td>昵称</td>
					
					<td>内容</td>
					<td>时间</td>
					<td>删除</td>
				</tr>
				<%
					for (Iterator<ArticleComment> it = aclist.iterator(); it.hasNext();) {
						ArticleComment ac = it.next();
				%>
				<tr id="product4" style="font-family: fantasy;">
					<td><%=ac.getA_user()%></td>
					<td><%=ac.getA_comment()%></td>
					<td><%=ac.getA_time()%></td>
					
					<td><a target="right"
						href="../ArticleCommentServlet?action=delete&id=<%=ac.getId()%>"
						onclick="return confirm('真的要删除?')">删除 </a>
					</td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
		<a href="comment.jsp?pageno=<%=page_no - 1%>">上一页</a> <a
			href="comment.jsp?pageno=<%=page_no + 1%>">下一页</a>
	</div>
</body>
</html>