<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//List<Article> articles = new ArrayList<Article>();
	//ArticleDao art = new ArticleDao();
	//articles = art.findArticle();
	
	
%>
<% 
    request.setCharacterEncoding("utf-8");
	 int id  = Integer.parseInt(request.getParameter("id"));
	Article articles =ArticleDao.findArticle(id);
%>
<html>
    <head>
        <title>添加文章类型</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <link href="./css/mine.css" type="text/css" rel="stylesheet">
    </head>

    <body>

        <div class="div_head">
            <span>
                <span style="float:left">当前位置是：类型管理-》修改文章类型信息</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="articletypemodify.jsp">【返回】</a>
                </span>
            </span>
        </div>
        <div></div>

        <div style="font-size: 13px;margin: 10px 5px">
            <form action="../ArticleServlet" method="post" >
            	<input type="hidden" name="id" value="<%=id %>">
            	<input type="hidden" name="action" value="modify">
            <table border="1" width="100%" class="table_a">
              
               <tr>
                    <td>文章标题</td>
                    <td><input type="text" name="title" size="80" value=<%=articles.getTitle() %> /></td>
                </tr>
               
              
                <tr>
                    <td>文章作者</td>
                    <td>
                        <input type="text" name="author" size="80" value=<%=articles.getAuthor() %> />
                    </td>
                </tr>
                <tr>
                    <td>文章内容</td>
                    <td>
                        <input type="text" name="content" size="80" value=<%=articles.getContent() %> />
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="修改">
                    </td>
                </tr>  
            </table>
            </form>
        </div>
    </body>
</html>