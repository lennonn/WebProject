<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<% List<Article> articles = new ArrayList<Article>();
	ArticleDao adao = new ArticleDao();
	articles=adao.goodArticle();
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>基于JQuery新浪新版带箭头的图片左右滚动代码_演示页_huiyi8脚本</title>
<link href="./css/163css.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="./js/jquery-latest.js"></script>
	
	<script type="text/javascript" src="./js/slides.min.jquery.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#slides').slides({
				effect : 'slide'
			});
		})
	</script>
</head>
<body>
	
		<div id="slides">
			<ul class="slides_container">
			
			<% 
                for(int i=1;i<articles.size();i++)	{	
                		
                		%>
                		<li>
				<a href="#" target="_blank"><img src="<%="images"+"/"+0+0+0+articles.get(1).getId()+".jpg" %>" /><span><%=articles.get(1).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(2).getId()%>" target=""><img src="<%="images"+"/"+0+0+0+articles.get(2).getId()+".jpg" %>" /><span><%=articles.get(2).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(3).getId()%>" target=""><img src="<%="images"+"/"+0+0+0+articles.get(3).getId()+".jpg" %>" /><span><%=articles.get(3).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(4).getId()%>" target=""><img src="<%="images"+"/"+0+0+0+articles.get(4).getId()+".jpg" %>" /><span><%=articles.get(4).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(5).getId()%>" target=""><img src="<%="images"+"/"+0+0+0+articles.get(5).getId()+".jpg" %>" /><span><%=articles.get(5).getTitle() %></span>
				</a>		
				</li>		
				
				<li>
				<a href="articledetail.jsp?id=<%=articles.get(6).getId()%>" target="_blank"><img src="<%="images"+"/"+0+0+0+articles.get(6).getId()+".jpg" %>" /><span><%=articles.get(6).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(7).getId()%>" target="_blank"><img src="<%="images"+"/"+0+0+0+articles.get(7).getId()+".jpg" %>" /><span><%=articles.get(7).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(8).getId()%>" target="_blank"><img src="<%="images"+"/"+0+0+0+articles.get(8).getId()+".jpg" %>" /><span><%=articles.get(8).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(9).getId()%>" target="_blank"><img src="<%="images"+"/"+0+0+0+articles.get(9).getId()+".jpg" %>" /><span><%=articles.get(9).getTitle() %></span>
				</a><a href="articledetail.jsp?id=<%=articles.get(10).getId()%>" target="_blank"><img src="<%="images"+"/"+0+0+0+articles.get(10).getId()+".jpg" %>" /><span><%=articles.get(10).getTitle() %></span>
				</a>		
				</li>	
				<% }%>
				
				
			</ul>
			<a href="#" class="prev">prev</a> <a href="#" class="next">next</a>
		</div>
</body>
</html>
