<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%!private static final int page_size = 5;%>
<%
	String strpageno = request.getParameter("pageno");
	int page_no = 1;
	if (strpageno != null) {
		page_no = Integer.parseInt(strpageno);
	}
	if (page_no < 1)
		page_no = 1;

	List<Message> msgs = new ArrayList<Message>();
	MessageDao md = new MessageDao();
	msgs = md.messageList(page_no, page_size);
%>

<html>
<head>
<meta charset="utf-8">
<title>个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板," />
<meta name="description"
	content="个人博客，" />
<link href="css/base.css" rel="stylesheet">
<link href="css/message.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery.reveal.js"></script>
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
/* body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
reveal-modal */
.reveal-modal-bg{position:fixed;height:100%;width:100%;background-color:#000;z-index:100;display:none;top:0;left:0;}
.reveal-modal{visibility:hidden;top:100px;left:50%;margin-left:-300px;width:420px;background:#eee url(images/modal-gloss.png) no-repeat -200px -80px;position:absolute;z-index:101;padding:30px 40px 34px;-moz-border-radius:5px;-webkit-border-radius:5px;border-radius:5px;-moz-box-shadow:0 0 10px rgba(0,0,0,.4);-webkit-box-shadow:0 0 10px rgba(0,0,0,.4);-box-shadow:0 0 10px rgba(0,0,0,.4);}
.reveal-modal .close-reveal-modal {
font-size:22px;line-height:.5;position:absolute;top:8px;right:11px;color:#aaa;text-shadow:0 -1px 1px rbga(0,0,0,.6);font-weight:bold;cursor:pointer;} 
.reveal-modal h2{font-size:18px;color:#990000;padding:0 0 20px 0;}
.reveal-modal p{padding:0 0 15px 0;}
</style>
	
</head>
<body>

	<header>
	<div id="logo">
		<a href="/"></a>
	</div>
	<nav class="topnav" id="topnav">
	<a href="index.jsp"><span>首页</span><span class="en">Protal</span>
	</a>
	<a href="about.jsp"><span>关于我</span><span class="en">About</span>
	</a>
	
	<a href="photolist.jsp"><span>我的相册</span><span class="en">Photo</span>
	</a>
	
	<a href="message.jsp"><span>留言版</span><span class="en">Message</span>
	</a></nav> </nav> </header>
	<article class="aboutcon">
	<h1 class="t_nav">
		<span>像“草根”一样，紧贴着地面，低调的存在，冬去春来，枯荣无恙。</span><a href="/" class="n1">网站首页</a><a
			href="/" class="n2">关于我</a>



	</h1>
	<div class="about left">
		
		<ul>
		
			<%
				for (Iterator<Message> it = msgs.iterator(); it.hasNext();) {
					Message msg = it.next();
			%>
			<div class="book">
			
				<div class="about_c">
				<li><img src="images/face1.gif" ></img><p><span><%=msg.getName()%></span></p>
					
				<p><%=msg.getContent()%></p>
				
				</li>
			
				<p><img src="images/web.jpg" ></img><reply><%=msg.getRevert()%></reply></p>
				
				</div>
				<p class="dateview">
					&nbsp;&nbsp;&nbsp;&nbsp;<span>发布时间：<%=msg.getTime()%></span> &nbsp &nbsp <a href="javascript:void(0);" data-reveal-id="myModal">回复</a>&nbsp
					&nbsp; <a href="">转发</a>

				</p>

				<hr>
				<div id="myModal" class="reveal-modal">
	<h2>回复留言</h2>
	<form action="MessageServlet?action=reply&id=<%=msg.getId()%>" method="post">
	
	<p>昵称：<input name="name" type="text" class="input"></p>
	<p>回复：<textarea name="revert"  class="input" ></textarea></p>
	
	<p><input name="sub" type="submit"  value="发表"/></p>
	<a class="close-reveal-modal">&#215;</a>
	</form>
</div>

			</div>

			<%
				}
			%>
			
			</h1><a href="message.jsp?pageno=1">1</a>
		<a href="message.jsp?pageno=2">2</a>
		<a href="message.jsp?pageno=<%=page_no - 1%>">&lt;</a> <a
			href="message.jsp?pageno=<%=page_no + 1%>">&gt;</a> <a
			href="/news/s/index_2.html">&gt;&gt;</a>
		<hr>
		</ul>
		
		
		<jsp:include  page="comment.jsp"/> 
	</div>


	<aside class="right">
	<div class="about_c">
		<p>
			网名：<span>lennon</span> | 哈哈哈
		</p>
		<p>姓名：张磊</p>
		<p>生日：1992-05-05</p>
		<p>籍贯：甘肃省―定西市</p>
		<p>现居：辽宁省―大连市</p>
		<p>喜欢的书：《红与黑》《红楼梦》</p>
		<p>喜欢的音乐：《burning》《just one last dance》</p>
		<a target="_blank"
			href="http://wp.qq.com/wpa/qunwpa?idkey=d4d4a26952d46d564ee5bf7782743a70d5a8c405f4f9a33a60b0eec380743c64">
			<img src="http://pub.idqqimg.com/wpa/images/group.png" alt="个人博客网站"
			title="个人博客网站">
		</a> <a target="_blank"
			href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=bF1cXltcWF5fXFssHR1CDwMB"><img
			src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_22.png"
			alt="个人博客网站">
		</a>
	</div>
	</aside> 
	</article>
	<footer>
	<p>
		Design by Lennon <a href="http://www.miitbeian.gov.cn/"
			target="_blank">大连工业大学</a> <a href="/">个人博客</a>
	</p>
	</footer>
	<script src="js/silder.js"></script>
	
</body>
</html>