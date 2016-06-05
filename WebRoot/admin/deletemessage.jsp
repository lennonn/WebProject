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
	
	List<Message> messages = new ArrayList<Message>();
	MessageDao md = new MessageDao();
	messages = md.messageList(page_no, pagesize);
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
                <span style="float: left;">当前位置是：留言管理-》留言列表</span>
                <span style="float: right; margin-right: 8px; font-weight: bold;">
                    <a style="text-decoration: none;" href="#">【添加商品】</a>
                </span>
            </span>
        </div>
        <div></div>
        <div class="div_search">
            <span>
                <form action="#" method="get">
                    品牌<select name="s_product_mark" style="width: 100px;">
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
                       
                       
                        <td>标题</td>
                        
                        <td>内容</td>
                        <td>时间</td>
                        <td>操作</td>
                    </tr>
                   <%for(Iterator<Message> it = messages.iterator();it.hasNext();){ 
                		Message msg =it.next();
                	%>
                    <tr id="product4" style="font-family: fantasy;">
                        <td><%=msg.getName() %></td>
                        <td><%=msg.getContent(20) %></td>
                        <td><%=msg.getTime()%></td>
                       <td><a href = "../MessageServlet?action=delete&id=<%=msg.getId() %>" onclick="return confirm('真的要删除?')">刪除</a></td>
                       </tr>
                   <% }%>
                   	
                </tbody>
            </table>
            <a href="deletemessage.jsp?pageno=<%=page_no-1 %>">上一页</a>
    	    <a href="deletemessage.jsp?pageno=<%=page_no+1 %>">下一页</a>
        </div>
    </body>
</html>