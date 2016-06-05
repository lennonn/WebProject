<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %> 
<%@ page import = "com.zl.blog.beans.*" %>  
<%@ page import = "com.zl.blog.daos.*" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<ArticleType> atypes = new ArrayList<ArticleType>();
	ArticleTypeDao  atype = new ArticleTypeDao();
	atypes=atype.findArticleType();
	
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
                <span style="float: left;">当前位置是：类型管理-》文章类型列表</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                    <a style="text-decoration: none;" href="#">后台首页</a>
                </span>
            </span>
        </div>
        <div></div>
        <div class="div_search">
            <span>
                <form action="#" method="get">
                    文章类型：<select name="s_product_mark" style="width: 100px;">
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
                        <td>序号ID</td>
                        <td>文章类型名</td>
                        <td>文章类型描述</td>
                        <td>添加图片</td>
                    </tr>
                   <%for(Iterator<ArticleType> it = atypes.iterator();it.hasNext();){ 
                		ArticleType at =it.next();
                	%>
                    <tr id="product4" style="font-family: fantasy;">
                        <td><%=at.getId() %></td>
                        <td><%=at.getType_name() %></td>
                        <td><%=at.getType_desc() %></td>
                       <td><a href ="uploadpictures.jsp?id=<%=at.getId() %>">上传图片</a></td>
                    </tr>
                   <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>