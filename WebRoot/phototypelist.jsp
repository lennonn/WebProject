<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>

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

 
 List<ImageType> images = new ArrayList<ImageType>();
	ImageTypeDao itad = new ImageTypeDao();
	images = itad.findImageType();
	List<Image> imgs = new ArrayList<Image>();
	ImageDao idao = new ImageDao();
	images = itad.findImageType();
	imgs = idao.photoList();
%>
<% 
	int tid = Integer.parseInt(request.getParameter("imagetype"));
	List<Image> imgtypes = new ArrayList<Image>();
	ImageDao imgtype = new ImageDao();
	imgtypes =imgtype.findImage(tid); 
	%>

<html>
<head>
<meta charset="gb2312">
<title>个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板," />
<meta name="description"
	content="个人博客，" />
<link href="css/base.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
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
		class="en">About</span> </a>  <a href="photolist.jsp"><span>我的相册</span><span
		class="en">Photo</span> </a> <a href="message.jsp"><span>留言版</span><span
		class="en">Message</span> </a></nav> </nav> </header>
	<article class="aboutcon">
	<h1 class="t_nav">
		<span>像“草根”一样，紧贴着地面，低调的存在，冬去春来，枯荣无恙。</span><a href="/" class="n1">网站首页</a><a
			href="/" class="n2">关于我</a>



	</h1>
	<div class="about left">

		<ul>



			<div class="about_c">
				<%
					for (Iterator<Image> it = imgtypes.iterator(); it.hasNext();) {
						Image image = it.next();
				%>
				<li>
				
					<img src="admin\<%=image.getImgurl()%>" float="left"></img>
					
				    <span><a href=""><%=image.getImgdesc()%></a></span>
				<%
					}
				%>
				</li>
			</div>



		</ul>
		

	</div>

	<aside class="right">
	<div class="about_c">
		<p>
		<form action="phototypelist.jsp" method="post">

			相册类型: <select name="imagetype" onchange="document.form.submit()"
				style="width: 100px;">

				<%
					for (Iterator<ImageType> it = images.iterator(); it.hasNext();) {
						ImageType itype = it.next();
				%>
				<option selected="selected" value="<%=itype.getId()%>"><%=itype.getType_name()%></option>

				<%
					}
				%>
			</select> <input value="查看" type="submit" />


		</form>
		</p>
		<p>
			网名：<span>DanceSmile</span> | 即步非烟
		</p>
		<p>姓名：张烈</p>
		<p>生日：1992-05-05</p>
		<p>籍贯：甘肃省―定西市</p>
		<p>现居：辽宁省―大连市</p>
		<p>职业：网站设计、网站制作</p>
		<p>喜欢的书：《红与黑》《红楼梦》</p>
		<p>喜欢的音乐：《burning》《just one last dance》《相思引》</p>
		<a target="_blank"
			href="http://wp.qq.com/wpa/qunwpa?idkey=d4d4a26952d46d564ee5bf7782743a70d5a8c405f4f9a33a60b0eec380743c64">
			<img src="http://pub.idqqimg.com/wpa/images/group.png" alt="个人博客网站"
			title="个人博客网站"> </a> <a target="_blank"
			href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&amp;email=HHh9cn95b3F1cHVye1xtbTJ-c3E"><img
			src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_22.png"
			alt="个人博客网站"> </a>
	</div>
	</aside> </article>
	<footer>
	<p>
		Design by DanceSmile <a href="http://www.miitbeian.gov.cn/"
			target="_blank">蜀ICP备11002373号-1</a> <a href="/">网站统计</a>
	</p>
	</footer>
	<script src="js/silder.js"></script>
</body>
</html>