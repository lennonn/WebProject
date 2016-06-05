<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	private static final int page_size=4;
	
 %>
<% 

	int typeid = Integer.parseInt(request.getParameter("typeid"));
	String strpageno =request.getParameter("pageno");
	int page_no = 1;
	if(strpageno!=null){
		page_no = Integer.parseInt(strpageno);
	}
	if(page_no<1)   page_no=1;
	if(page_no>3)	page_no=1;
    ArticleDao ud = new ArticleDao();
	List<Article> articles = new ArrayList<Article>();
	articles=ud.findArticle(typeid, page_no,page_size) ;
	List<Article> artNew = new ArrayList<Article>();
    artNew=ud.newArticle();
    List<Article> scanarts = new ArrayList<Article>();
    scanarts=ud.scanArticle();
	
%>
<html>
<head>
<meta charset="gb2312">
<title>个人博客网站</title>
<meta name="keywords" content="个人博客,杨个人博客,个人博客模板,杨青" />
<meta name="description" content="杨个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
<link href="css/base.css" rel="stylesheet">
<link href="css/learn.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
</head>
<body>
<header>
  <div id="logo"><a href="/"></a></div>
  <nav class="topnav" id="topnav">
  <a href="index.jsp"><span>首页</span><span class="en">Protal</span></a>
  <a href="about.jsp"><span>关于我</span><span class="en">About</span></a>
  <a href="photolist.jsp"><span>学无止境</span><span class="en">Photo</span></a>
  <a href="message.jsp"><span>留言版</span><span class="en">Message</span></a></nav>
  </nav>
</header>
<article class="blogs">
<h1 class="t_nav"><span>我们长路漫漫，只因学无止境。 </span><a href="index.jsp" class="n1">网站首页</a><a href="message.jsp" class="n2">留言板</a></h1>
<div class="newblog left">
    <%for(int i =0;i<articles.size();i++) {
	    Article arts = articles.get(i);
	   
	%> 
	<% ArticleTypeDao atd = new ArticleTypeDao();
	ArticleType atype = atd.findArticleType(typeid);%>
	
   <h2><%=arts.getTitle() %></h2>
   <p class="dateview"><span>发布时间：<%=arts.getTime() %></span><span>作者：<%=arts.getAuthor() %></span><span>分类：[<a href="articletypelist.jsp?typeid=<%=atype.getId()%>"><%=atype.getType_name()%></a>]</span></p>
    <figure><img src="<%="images" + "/" + 0 + 0 + 0 + arts.getId() + ".jpg"%>"></figure>
    <ul class="nlist">
      <p>
      <%=arts.getContent(100) %>
      </p>
      <a title="/" href="articledetail.jsp?id=<%=arts.getId() %>" target="" class="readmore">详细内容>></a>
    </ul>
   <%} %>
    <div class="line"></div>
    <div class="blank"></div>
    <div class="ad">  
  
    </div>
    <div class="page"> <a href="articletypelist.jsp?pageno=1&typeid=<%=typeid%>">1</a>
    	<a href="articletypelist.jsp?pageno=2&typeid=<%=typeid %>">2</a>
    	<a href="articletypelist.jsp?pageno=<%=page_no-1 %>&typeid=<%=typeid%>">&lt;</a>
    	<a href="articletypelist.jsp?pageno=<%=page_no+1 %>&typeid=<%=typeid%>">&gt;</a>
    	</div>
	</div>
<aside class="right">
 
<div class="news">
<h3>
      <p>最新<span>文章</span></p>
    </h3>
    <ul class="rank">
      <%for(Iterator<Article> it = artNew.iterator();it.hasNext();){ 
                		Article artnew =it.next();
                	%>
			<li><a href="articledetail.jsp?id=<%=artnew.getId()%>" title="<%=artnew.getTitle() %>" target=""><%=artnew.getTitle() %></a>
			</li>
			<% }%>
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
      <div class="rnav">
      <h2>栏目导航</h2>
      <ul>
       <li><a href="/download/" target="_blank">CSS3|Html5</a></li>
       <li><a href="/newsfree/" target="_blank">推荐工具</a></li>
       <li><a href="/newsfree/" target="_blank">心得笔记</a></li>
       <li><a href="/newsfree/" target="_blank">IP查询</a></li>
<li><a href="/newsfree/" target="_blank">JS经典实例</a></li>
<li><a href="/newsfree/" target="_blank">网站建设</a></li>
     </ul>      
    </div>
    <div class="visitors">
      <h3><p>最近访客</p></h3>
      <ul>

      </ul>
    </div>
     <!-- Baidu Button BEGIN -->
    <div id="bdshare" class="bdshare_t bds_tools_32 get-codes-bdshare"><a class="bds_tsina"></a><a class="bds_qzone"></a><a class="bds_tqq"></a><a class="bds_renren"></a><span class="bds_more"></span><a class="shareCount"></a></div>
    <script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6574585" ></script> 
    <script type="text/javascript" id="bdshell_js"></script> 
    <script type="text/javascript">
document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + Math.ceil(new Date()/3600000)
</script> 
    <!-- Baidu Button END -->   
</aside>
</article>
<footer>
  <p>Design by DanceSmile <a href="http://www.miitbeian.gov.cn/" target="_blank">大连工业大学</a> <a href="/">lennon</a></p>
</footer>
<script src="js/silder.js"></script>
</body>
</html>