 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.zl.blog.beans.*" %>
      <%@ page import = "com.zl.blog.daos.*" %>
      <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<ArticleType> articletypes = new ArrayList<ArticleType>();
	ArticleTypeDao ad = new ArticleTypeDao();
	articletypes = ad.findArticleType();
  
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
                <span style="float:left">当前位置是：类型管理-》添加文章类型信息</span>
                <span style="float:right;margin-right: 8px;font-weight: bold">
                    <a style="text-decoration: none" href="index.jsp">【返回】</a>
                </span>
            </span>
        </div>
        <div></div>

        <div style="font-size: 13px;margin: 10px 5px">
            <form action="../ArticleServlet" method="post" >
            <input type ="hidden" name="action" value ="add">;
            <table border="1" width="100%" class="table_a">
            	 <tr>
            	 <td>文章类型</td>
            	 <td><select name="articletype" onchange="document.form.submit()" style="width: 200px;">
					
				<%
					for (Iterator<ArticleType> it = articletypes.iterator(); it.hasNext();) {
						ArticleType at = it.next();
				%>
					<option  selected="selected" value="<%=at.getId() %>"><%=at.getType_name() %></option>
					<% 
					}
					%>
				</select> 
				</td>
                   </tr>
               <tr>
                    <td>标题</td>
                    <td><input type="text" name="title" /></td>
                </tr>
               
               <tr>
                    <td>作者</td>
                    <td><input type="text" name="author" /></td>
                </tr>
                <tr>
                    <td>内容</td>
                    <td>
                        <textarea name="content"></textarea>
                    </td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="添加文章">
                    </td>
                </tr>  
            </table>
            </form>
        </div>
    </body>
</html>