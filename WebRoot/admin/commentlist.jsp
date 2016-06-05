<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "com.zl.blog.beans.*" %>
      <%@ page import = "com.zl.blog.daos.*" %>
      <%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	private static final int pagesize= 4;
 %>
<% 
	
	
	String strpageno =request.getParameter("pageno");
	int page_no = 1;
	if(strpageno!=null){
		page_no = Integer.parseInt(strpageno);
	}
	if(page_no<1)   page_no=1;
	
	List<Article> articles = new ArrayList<Article>();
	ArticleDao ad = new ArticleDao();
	articles = ad.findArticle(page_no, pagesize);
%>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />

        <title>会员列表</title>

        <link href="./css/mine.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <style> 
            p.tr_color{background-color: #9F88FF} 
        </style>
        <div class="div_head">
            <span>
                <span style="float: left;">当前位置是：类型管理-》文章列表</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                    <a style="text-decoration: none;" href="#">后台首页</a>
                </span>
            </span>
        </div>
        <div></div>
        <div class="div_search">
            <span>
                <form action="#" method="get">
                    文章类型<select name="s_product_mark" style="width: 100px;">
                        <option selected="selected" value="0">请选择</option>
                        <option value="1">苹果apple</option>
                    </select>
                    <input value="查询" type="submit" />
                </form>
            </span>
        </div>
        <div style="font-size: 13px; margin: 10px 5px;">
            <table class="table_a" border="1" width="100%">
                <tbody>
                	
                	<tr style="font-weight: bold;">
                       
                        <td>文章类型ID</td>
                        <td>标题</td>
                        <td>作者</td>
                        <td>内容</td>
                         <td>添加图片</td>
                      
                        
                    </tr>
                   <%for(Iterator<Article> it = articles.iterator();it.hasNext();){ 
                		Article art =it.next();
                	%>
                    <tr id="product4" style="font-family: fantasy;">
                        <td><%=art.getT_id() %></td>
                        <td><%=art.getTitle() %></td>
                        <td><%=art.getAuthor()%></td>
                        <td><%=art.getContent(30) %></td>
                       <td><a href ="uploadpictures.jsp?id=<%=art.getId() %>">上传图片</a></td>
                    </tr>
                   <% }%>
                   	
                </tbody>
            </table>
            <a href="articlelist.jsp?pageno=<%=page_no-1 %>">上一页</a>
    	    <a href="articlelist.jsp?pageno=<%=page_no+1 %>">下一页</a>
        </div>
    </body>
</html>