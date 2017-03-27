<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>save user</title>
<link rel="stylesheet"  href="css/style.css"  type="text/css"  media="screen">
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<form id="user"  action="login.action"  class="ajax"  method="post">
		<div>   
			<input  id="username"type="text"  name="username"  placeholder="you name..."/>
		</div>
		<div>
			<input id ="password" type="password"  name="password"  placeholder="you password..."/>
		</div>
		<div>
			<span id="message"></span>
		</div>
		<div>
			<input id="sub"  type ="submit"  value="Login"/>
		</div>	
	</form>
	
</body>
</html>

<script>
			var sub = document.getElementById("submit");
		/* 	 $("#sub").click(function(){
				console.log("test");
			});  */
		//	trigger();
		/* 	function trigger(){
			$("form.ajax").find("[name]").each(function(){
					var input =$(this);
					name=input.attr("name");
					$(name).on("click",function(){
						document.getElementById("message").innerHTML="";
					});
			});
			}; */
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
		}); 
	</script>