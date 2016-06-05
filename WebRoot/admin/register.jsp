<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zl.blog.daos.UserDao"%>
<%@ page import="com.zl.blog.beans.User"%>
<%@ page import="java.sql.*"%>


<%
 	UserDao ud = new UserDao();

 	
 	//String mess = (String) session.getAttribute("messages");
 //	if(mess==null)
 	//mess="请输入注册信息！";
	
	//session.removeAttribute("messages");
	//System.out.println(mess);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function display_alert(){
  var m="<%=session.getAttribute("messages")%>";
  <%session.removeAttribute("messages");%>
 alert(m); 

  }
</script>
<link href="css/register.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="form-bak">
	<form method="post" action="../UserServlet" method="post">
	<input type="hidden" name="action" value="register">
		<div class="left">
			
			<div class="line" id="line_name">
				<div class="info">
					<strong>用户名</strong>
					<span class="tips">最多32个字符</span>
				</div>
				<div class="input">
					<input type="text" name="name" id="name" onblur="v_name();" onkeyup="v_name();" />
				
					<div class="none"><span></span></div>
				</div>
			</div>
			<div class="line" id="line_real">
				<div class="info">
					<strong>姓名</strong>
					<span class="tips">真实姓名</span>
				</div>
				<div class="input">
					<input type="text" name="real" id="real" onblur="v_real();" onkeyup="v_real();" />
					<div class="none"><span></span></div>
				</div>
			</div>
			<div class="line" id="line_password">
				<div class="info">
					<strong>密码</strong>
					<span class="tips">6至16个字符</span>
				</div>
				<div class="input">
					<input type="password" name="password" id="password" onblur="v_password();" onkeyup="v_password();" />
					<div class="none"><span></span></div>
				</div>
			</div>
			<div class="line" id="line_repeat">
				<div class="info">
					<strong>确认密码</strong>
					<span class="tips">再次输入密码</span>
				</div>
				<div class="input">
					<input type="password" name="repeat" id="repeat" onblur="v_repeat();" onkeyup="v_repeat();" />
					<div class="none"><span></span></div>
				</div>
			</div>
			<div class="line" id="line_account">
				<div class="info">
					<strong>邮箱</strong>
					<span class="tips">邮箱账号</span>
				</div>
				<div class="input">
					<input type="text" name="account" id="account" onblur="v_account();" onkeyup="v_account();"/>
					<div class="none"><span></span></div>
				</div>
			</div>
		</div>
		<div class="right">
		<div><strong>用户注册</strong></div>
			<input class="readagreement-wrap" id=IbtnEnter type="image" method="submit" name="enter"
						onclick="display_alert()"	src="img/user_reg_botton.jpg" alt="注册"></li>
		
				
			<div>已经拥有账号，<a href="login.jsp">直接登录</a></div>
			
		</div>
	</form>
	<%session.removeAttribute("messages"); %> 
</div>
<div id="agreement" class="agreement" style="display:none;"> 
	<h1>用户使用协议</h1>
	<iframe src=""></iframe>
	<input type="button" value="同意" onclick="agree();"/>
	<a href="#" class="backtotop" >返回顶部</a>
</div>
<script type="text/javascript">
function enableSubmit(bool){
	if(bool)$("#submit").removeAttr("disabled");
	else $("#submit").attr("disabled","disabled");
}
function v_submitbutton(){
	if($("#agree").attr("checked")!="checked") {
		enableSubmit(false);
		$(".readagreement-wrap").css("outline","1px solid #f99");
		return;
	}else{
		$(".readagreement-wrap").css("outline","1px solid #9f9");
	}
	for(f in flags) if(!flags[f]) {
		enableSubmit(false); 
		return;
	}
	enableSubmit(true);
}
function showAgreement(){
	$("#readagreement").removeAttr("onclick");
	$("#agreement").show();
	$("#agreement iframe").attr("src","http://www.17sucai.com/help");//此处为链接地址
}
function agree(){
	$("#agreement").hide();
	$("#readagreement").attr("onclick","showAgreement();");
	if($("#agree").attr("checked")!="checked") $("#agree").trigger("click");
}
function onReadAgreementClick(){
	return;
	if($("#agree").attr("checked")){
		$("#agree").removeAttr("checked");
	}else{
		$("#agree").attr("checked","checked");
	}
	v_submitbutton();
}
var flags = [false,false,false,false];
//邮箱验证，网上找到的正则
var RegEmail = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
function lineState(name,state,msg){
	if(state=="none"){$("#line_"+name+" .input div").attr("class","none"); return;}
	if(state=="corect"){$("#line_"+name+" .input div").attr("class","corect");return;}
	$("#line_"+name+" .input span").text(msg);$("#line_"+name+" .input div").attr("class","error");
}
function v_account(){
	var account = $("#account").val();
	if(!RegEmail.test(account)) {lineState("account","error","邮箱格式不正确"); flags[0]=false;enableSubmit(false);}
	else{lineState("account","corect","");flags[0] = true;}
	v_submitbutton();
}
function v_name(){
	var name = $("#name").val();
	
	if(name.length==0) {
		lineState("name","error","用户名不能为空"); 
		flags[1]=false;
	}else{
		
		if(name.length>32) {
			lineState("name","error","必须少于32个字符"); 
			flags[1]=false;
		}else{
			lineState("name","corect",""); 
			flags[1] = true;
		}
	}
	v_submitbutton();
}
function v_real(){
	var real = $("#real").val();
	if(real.length==0) {
		lineState("real","error","不得为空"); 
		flags[1]=false;
	}else{
		if(name.length>32) {
			lineState("real","error","必须少于32个字符"); 
			flags[1]=false;
		}else{
			lineState("real","corect",""); 
			flags[1] = true;
		}
	}
	v_submitbutton();
}
function v_password(){
	var password = $("#password").val();
	if(password.length<6) {
		lineState("password","error","必须多于或等于6个字符"); 
		flags[2]=false;
	}else{
		if(password.length>16){
			lineState("password","error","必须少于或等于16个字符"); 
			flags[2]=false;
		}else{
			lineState("password","corect","");
			flags[2] = true;
		}
	}
	v_repeat();
	v_submitbutton();
}
function v_repeat(){
	if(!flags[2]) {
		lineState("repeat","none",""); 
		return;
	}
	if($("#password").val()!=$("#repeat").val()) {
		lineState("repeat","error","密码不一致"); 
		flags[3]=false;
	}else{
		lineState("repeat","corect","");
		flags[3] = true;
	}
	v_submitbutton();
}
function adaptValue(){
	return true;
}
</script>

</body>
</html>
