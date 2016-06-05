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
    request.setCharacterEncoding("utf-8");
	 int id  = Integer.parseInt(request.getParameter("id"));
	
  
  
 
 
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
            <form action="../ArticleTypeServlet" method="post" ">
            <input type ="hidden" name="action" value="modify">
            <table border="1" width="100%" class="table_a">
                <tr>
                    <td>文章类型名</td>
                    <td><input type="text" name="id" size="80"  readonly value=<%=id %> /></td>
                </tr>
               <tr>
                    <td>文章类型名</td>
                    <td><input type="text" name="typename" size="80" value=<%=atype.findArticleType(id).getType_name() %> /></td>
                </tr>
               
              
                <tr>
                    <td>文章类型描述</td>
                    <td>
                        <input type="text" name="typedesc" size="80" value=<%=atype.findArticleType(id).getType_desc() %> />
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