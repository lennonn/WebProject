<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="java.util.ArrayList"%>
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
	int id = Integer.parseInt(request.getParameter("id"));
	Article art = ArticleDao.findArticle(id);
	Article art1 = ArticleDao.findArticle(id - 1);
	Article art2 = ArticleDao.findArticle(id + 1);
	List<Article> articles = new ArrayList<Article>();
	ArticleDao ud = new ArticleDao();
	articles = ud.newArticle();
	List<Article> scanarts = new ArrayList<Article>();
	scanarts = ud.scanArticle();
	List<ArticleComment> aclist = new ArrayList<ArticleComment>();
	ArticleCommentDao acd = new ArticleCommentDao();
	aclist =acd.commentlist(page_no, pagesize,id);
	
	
	
%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>个人博客网站</title>
<meta name="keywords" content="个人博客" />
<meta name="description"
	content="个人博客" />
<link href="css/base.css" rel="stylesheet">
<link href="css/new.css" rel="stylesheet">
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
	<a href="message.jsp"><span>留言版</span><span class="en">Gustbook</span>
	</a></nav> </nav> </header>
	<article class="blogs">
	<h1 class="t_nav">
		<span>您当前的位置：<a href="/index.jsp">首页</a>&nbsp;&gt;&nbsp;</a>&nbsp;&gt;&nbsp;<a href="articletypelist.jsp">文章</a>
		</span><a href="/" class="n1">网站首页</a><a href="/" class="n2">日记</a>
	</h1>
	<div class="index_about">
		<h2 class="c_titile"><%=art.getTitle()%></h2>
		<p class="box_c">
			<span class="d_time">发布时间：<%=art.getTime()%></span><span>编辑：<%=art.getAuthor()%></span><span>QQ：<a
				href="http://wp.qq.com/wpa/qunwpa?idkey=d4d4a26952d46d564ee5bf7782743a70d5a8c405f4f9a33a60b0eec380743c64">123456789</a>
			</span>
		</p>
		<ul class="infos">
			<%=art.getContent()%>
		</ul>
		<div class="keybq">
			<p>
				<span><a  href="javascript:void(0);" data-reveal-id="myModal">发表你的评论</a></span>	

<div id="myModal" class="reveal-modal">
	<h2>发表评论</h2>
	<form action="ArticleCommentServlet?action=add&a_id=<%=art.getId()%>" method="post">
	<p>昵称：<input name="name" type="text" class="input"></p>
	<p>内容：<textarea name="content"  class="input" ></textarea></p>
	
	<p><input name="sub" type="submit"  value="发表"/></p>
	<a class="close-reveal-modal">&#215;</a>
	</form>
</div>
	
			</p>

		</div>
		<div class="ad"></div>
		<div class="nextinfo">
			<p>
				上一篇：<a href="articledetail.jsp?id=<%=art1.getId()%>"><%=art1.getTitle()%></a>
			</p>
			<p>
				下一篇：<a href="articledetail.jsp?id=<%=art2.getId()%>"><%=art2.getTitle()%></a>
			</p>
		</div>
		<div class="otherlink">
			<h2>评论列表</h2>
			<ul>
				<%	if(aclist!=null){
					for (Iterator<ArticleComment> it = aclist.iterator(); it.hasNext();) {
						ArticleComment ac = it.next();
						
				%>
				<li><font color=#ff0000> <%=ac.getA_user() %>:</font> <%=ac.getA_comment() %>
				</li><%}}else{%>
			
				<li>暂无评论！</li>
				<%} %>
			</ul>
		</div>
	</div>
	<aside class="right"> <!-- Baidu Button BEGIN -->
	<div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare">
		<a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a
			class="bds_renren"></a><span class="bds_more"></span><a
			class="shareCount"></a>
	</div>
	<script type="text/javascript" id="bdshare_js"
		data="type=tools&amp;uid=6574585"></script> <script
		type="text/javascript" id="bdshell_js"></script> <script
		type="text/javascript">
			document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion="
					+ Math.ceil(new Date() / 3600000)
		</script> <!-- Baidu Button END -->
	<div class="blank"></div>
	<div class="news">
		<h3>
			<p>
				栏目<span>最新</span>
			</p>
		</h3>
		<ul class="rank">

			<%
				for (Iterator<Article> it = articles.iterator(); it.hasNext();) {
					Article arts = it.next();
			%>
			<li><a href="articledetail.jsp?id=<%=arts.getId()%>"
				title="<%=arts.getTitle()%>" target=""><%=arts.getTitle()%></a></li>
			<%
				}
			%>
		</ul>
		 <h3 class="ph">
      <p>点击<span>排行</span></p>
    </h3>
    <ul class="paih">
      <%for(Iterator<Article> it =scanarts.iterator();it.hasNext();){ 
                		Article scanart =it.next();
                	%>
			<li><a href="articledetail.jsp?id=<%=scanart.getId()%>" title="<%=scanart.getTitle() %>" target="_blank">
		<%=scanart.getTitle() %></a>
			</li>
		<%} %>
    </ul>
	</div>
	<div class="visitors">
		<h3>
			<p>最近访客</p>
		</h3>
		<ul>
		</ul>
	</div>
	</aside> </article>
	<footer>
	<p>
		Design by lennon <a href="http://www.miitbeian.gov.cn/"
			target="_blank">大连工业大学</a> <a href="/">个人博客</a>
	</p>
	</footer>
	<script src="js/silder.js"></script>
</body>
</html>