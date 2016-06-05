<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery实现微博分享评论表情</title>
</head>
<body>

<link type="text/css" rel="stylesheet" href="css/rl_exp.css" />

<style type="text/css">
.xm-bq{margin:20px 0;font-size:14px;color:#333;}
.xm-bq a{color:#09c;margin:0 5px;}
.xm-bq a:hover{color:#E10602;}
.comment-main{display:inline-block; *display:inline;zoom:1;width:680px;margin:0auto;border:1pxsolid#ddd;background:#eee;padding:5px;border-radius:3px;text-align:left;}
.comment-main textarea{width:100%;border:1px solid #dcdcdc;}
.comment-main textarea:focus{outline:none;border-color:#4bf;}
.comment-main a{font-size:12px;text-decoration:none;color:#09c;}
.comment-main a:hover{color:#E10602;}
</style>

<div style="text-align:center;" id="xm">
	<div class="xm-bq"></div>
	<div id="comment" class="comment-main">
		<form action="addmessage.jsp" method="post">
		<input type="text" name="name" style="width:680px"/>
		<textarea name="content" id="rl_exp_input" cols="30" rows="10"></textarea>
		<a href="javascript:void(0);" id="rl_exp_btn">表情</a>
		<input type="submit" name="submit" value="發佈" />
	</div>
	<div class="rl_exp" id="rl_bq" style="display:none;">
		<ul class="rl_exp_tab clearfix">
			<li><a href="javascript:void(0);" class="selected">默认</a></li>
			<li><a href="javascript:void(0);">拜年</a></li>
			<li><a href="javascript:void(0);">浪小花</a></li>
			<li><a href="javascript:void(0);">暴走漫画</a></li>
		</ul>
		<ul class="rl_exp_main clearfix rl_selected"></ul>
		<ul class="rl_exp_main clearfix" style="display:none;"></ul>
		<ul class="rl_exp_main clearfix" style="display:none;"></ul>
		<ul class="rl_exp_main clearfix" style="display:none;"></ul>
		<a href="javascript:void(0);" class="close">×</a>
	</div>
</div>

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/rl_exp.js"></script>

</body>
</html>
