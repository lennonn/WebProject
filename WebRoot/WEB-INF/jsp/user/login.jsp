<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>save user</title>
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<form name="f" action="index" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<fieldset>
			<legend>Please Login</legend>
			<div class="alert alert-error">
				<c:if test="${param.error=='3' }">
					<c:out value=" Invalid username and password."></c:out>
				</c:if>
			</div>
			<div class="alert alert-success">
				<c:if test="${param.logout=='out'}">
					<c:out value="You have been logged out." />
					</c:if>
			</div>
			<div>
			<label for="username">Username</label> <input type="text"
				id="username" name="username" /> </div>
				<div>
				<label for="password">Password</label>
			<input type="password" id="password" name="password" /></div>
			<div class="form-actions">
				<button type="submit" class="btn">Log in</button>
			</div>
		</fieldset>
	</form>

</body>
</html>

<script>
	/* 		var sub = document.getElementById("submit");
			 $("#sub").click(function(){
				console.log("test");
			});  
		//	trigger();
			function trigger(){
			$("form.ajax").find("[name]").each(function(){
					var input =$(this);
					name=input.attr("name");
					$(name).on("click",function(){
						document.getElementById("message").innerHTML="";
					});
			});
			}; 
		  $("form.ajax").on(function(){
			
			var userForm = $(this);
				url =userForm.attr("action");
			 	method = userForm.attr("method");
				data={};
				userForm.find("[name]").each(function(index,value){
					var input =$(this);
					name=input.attr("name");
					value =input.val();
					data[name]=value;
					console.log(data);
				});
			var jsonStr=JSON.stringify(data);
	$.ajax({
				url:url,
				cache: false,
				async : true,
				type:method,
				data:data, 
				success: function(response){
					document.getElementById("message").innerHTML="提交成功！";
				},
				error: function(msg){
					document.getElementById("message").innerHTML="提交错误！";
				}
			}); 
		});  */
</script>