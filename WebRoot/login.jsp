<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jquery点击弹出登陆窗口</title>

<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function($){

	$('.theme-login').click(function(){
		$('.theme-popover-mask').show();
		$('.theme-popover-mask').height($(document).height());
		$('.theme-popover').slideDown(200);
	})
	$('.theme-poptit .close').click(function(){
		$('.theme-popover-mask').hide();
		$('.theme-popover').slideUp(200);
	})

});
</script>
	
</head>

<body>
<div class="theme-buy">
	<a class="btn btn-primary theme-login" href="javascript:;">登陆</a>
</div>

<div class="theme-popover-mask"></div>

<div class="theme-popover">
	<div class="theme-poptit">
		<a href="javascript:;" title="关闭" class="close">×</a>
		<h3>登录 是一种态度</h3>
	</div>
	<div class="theme-popbod dform">
		<form class="theme-signin" name="loginform" action="" method="post">
			<ol>
				<li><h4>你必须先登录！</h4></li>
				<li><strong>用户名：</strong><input class="ipt" type="text" name="log" value="17sucai" size="20" /></li>
				<li><strong>密码：</strong><input class="ipt" type="password" name="pwd" value="***" size="20" /></li>
				<li><input class="btn btn-primary" type="submit" name="submit" value=" 登 录 " /></li>
			</ol>
		</form>
	</div>
</div>


</body>
</html>
    