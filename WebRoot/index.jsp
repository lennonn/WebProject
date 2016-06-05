<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	

	List<Article> articles = new ArrayList<Article>();
	ArticleDao ud = new ArticleDao();
    articles=ud.newArticle();
    List<Article> scanarts = new ArrayList<Article>();
	ArticleDao scanartdao = new ArticleDao();
    scanarts=scanartdao.scanArticle();
    
		
	ArticleTypeDao at = new ArticleTypeDao();
	List<ArticleType> arttypes = new ArrayList<ArticleType>();
	arttypes = at.findArticleType();

	
%>
<html>
<head>
<meta charset="gb2312">
<title>个人博客</title>
<meta name="keywords" content="个人博客模板,博客模板" />
<meta name="description" content="寻梦主题的个人博客模板，优雅、稳重、大气,低调。" />
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">


	
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<header>
	<div id="logo">
		<a href="/"></a>
	</div>
	
	<nav class="topnav" id="topnav"> <a href="index.jsp"><span>首页</span><span
		class="en">Protal</span> </a> <a href="about.jsp"><span>关于我</span><span
		class="en">About</span> </a>  </a> <a href="photolist.jsp"><span>我的相册</span><span
		class="en">Learn</span> </a> <a href="message.jsp"><span>留言版</span><span
		class="en">Gustbook</span> </a> </nav>


	</header>
	<div class="banner">
		<section class="box">
		<ul class="texts">
			<p>打了死结的青春，捆死一颗苍白绝望的灵魂。</p>
			<p>为自己掘一个坟墓来葬心，红尘一梦，不再追寻。</p>
			<p>加了锁的青春，不会再因谁而推开心门。</p>
		</ul>
		<div class="avatar">
			<a href="#"><span>张磊</span> </a>
		</div>
		</section>
	</div>
	<div class="template">
		<div class="box">
			<h3>
				<p>
					<span>个人博客</span>网友喜欢
				</p>
			</h3>
			<ul>

			</ul>
		</div>

	</div>
	<jsp:include page="rolling.jsp" />

	<article>
	<h2 class="title_tj">
		<p>
			文章<span>推荐</span>
		</p>
	</h2>
	<div class="bloglist left">
	<%for(Iterator<ArticleType> it = arttypes.iterator();it.hasNext();){ 
                		ArticleType arttype =it.next();
                		ArticleDao adao = new ArticleDao();
                	Article	art= adao.findArticle(arttype);
                	if(art!=null)
                	%>
		<h3><%=art.getTitle()%></h3>
		<figure> <img src="<%="images" + "/" + 0 + 0 + 0 + art.getId() + ".jpg"%>"></figure>
		<ul>
			<p><%=art.getContent(200)%></p>
			<a title="全部内容" href="articledetail.jsp?id=<%=art.getId()%>" target=""
				class="readmore">阅读全文>></a>
		</ul>
		<p class="dateview">
			<span><%=art.getTime()%></span><span>作者：<%=art.getAuthor()%></span>&nbsp;&nbsp;<span>浏览：[<%=art.getScan() %>]</span><span>个人博客：[<a
				href="articletypelist.jsp?typeid=<%=arttype.getId()%>"><%=arttype.getType_name()%></a>]</span>
				
		</p>
<%} %>
		
	</div>
	<aside class="right">
	<div class="weather">
		<iframe width="250" scrolling="no" height="60" frameborder="0"
			allowtransparency="true"
			src="http://i.tianqi.com/index.php?c=code&id=12&icon=1&num=1"></iframe>
	</div>
	<div class="news">
	
		<h3>
			<p>
				最新<span>文章</span>
			</p>
		</h3>
		<ul class="rank">
		
		<%for(Iterator<Article> it = articles.iterator();it.hasNext();){ 
                		Article arts =it.next();
                	%>
			<li><a href="articledetail.jsp?id=<%=arts.getId()%>" title="<%=arts.getTitle() %>" target=""><%=arts.getTitle() %></a>
			</li>
			<% }%>
		</ul>
		<h3 class="ph">
			<p>
				点击<span>排行</span>
			</p>
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
		<h3 class="links">
			<p>
				友情<span>链接</span>
			</p>
		</h3>
		<ul class="website">
			<li><a href="/">个人博客</a>
			</li>
			<li><a href="/">个人博客</a>
			</li>
			<li><a href="/">百度</a>
			</li>
			<li><a href="/">新浪</a>
			</li>
		</ul>
	</div>
	<!-- Baidu Button BEGIN -->
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
		</script> <!-- Baidu Button END --> <a href="/" class="weixin"> </a></aside> </article>
	<footer>
	<p>
		Design by Lennon <a href="http://www.miitbeian.gov.cn/"
			target="_blank">大连工业大学</a> <a href="/">个人博客</a>
	</p>
	</footer>
	<script src="js/silder.js"></script>
</body>
</html>
