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


<html>
<head>
<meta charset="gb2312">
<title>个人博客网站</title>
<meta name="keywords" content="个人博客,个人博客,个人博客模板,Lennon" />
<meta name="description"
	content="个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
<link href="css/base.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
<link rel="stylesheet" href="css/screen.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/lightbox.css" type="text/css" media="screen" />

<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->


</head>
<body>

	<header>
	<div id="logo">
		<a href="/"></a>
	</div>
	<nav class="topnav" id="topnav"> <a href="index.jsp"><span>=首页</span><span
		class="en">Protal</span> </a> <a href="about.jsp"><span>关于我</span><span
		class="en">About</span> </a> <a href="photolist.jsp"><span>我的相册</span><span
		class="en">Photo</span> </a> <a href="message.jsp"><span>留言版</span><span
		class="en">Message</span> </a></nav> </nav> 
	</header>
	<article class="aboutcon">
	<h1 class="t_nav">
		<span>不纠结，不抱怨，不生气</span><a href="/" class="n1">网站首页</a><a href="/"
			class="n2">关于我</a>

	</h1>
	<div class="about left">

		<ul>
			<div class="imageRow">
				<div class="set">
					<div class="single first">
						<%
							for (Iterator<Image> it = imgs.iterator(); it.hasNext();) {
								Image image = it.next();
						%>
						<a href="admin\<%=image.getImgurl()%>" rel="lightbox[plants]"
							title="图片描述：<%=image.getImgdesc() %>&nbsp&nbsp&nbsp上传时间：<%=image.getTime()%>"><img
							src="admin\<%=image.getImgurl()%>" width="160px" height="100px"
							alt="图片名称：<%=image.getImgname() %>" /> </a>
						<%
							}
						%>
					</div>
				</div>
			</div>
			<script type="text/javascript" src="js/jquery-zoom.min.js"></script>
			<script type="text/javascript" src="js/lightbox.js"></script>
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
			网名：<span>Lennon</span> | 哈哈哈
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
			title="个人博客网站"> </a> <a target="_blank"
			href="http://mail.qq.com/cgi-bin/qm_share?t=qm_mailme&email=bF1cXltcWF5fXFssHR1CDwMB">
			<img
			src="http://rescdn.qqmail.com/zh_CN/htmledition/images/function/qm_open/ico_mailme_22.png"
			alt="个人博客网站"> </a>
	</div>
	</aside> </article>
	<footer>
	<p>
		Design by lennon <a href="http://www.miitbeian.gov.cn/"
			target="_blank">大连工业大学</a> <a href="/">张磊</a>
	</p>
	</footer>
	<script src="js/silder.js"></script>
</body>
</html>