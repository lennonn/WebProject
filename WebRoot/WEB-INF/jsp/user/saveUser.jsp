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
	<form id="user"  action="saveUser"  class="ajax"  method="post">
		<div>
			<input type="text"  name="username"  placeholder="you name..."/>
		</div>
		<div>
			<input type="password"  name="password"  placeholder="you password..."/>
		</div>
		<div>
			<input id="sub"  type ="submit"  value="submit"/>
		</div>	
	</form>
	
</body>
</html>

<script>
			var sub = document.getElementById("submit");
		/* 	 $("#sub").click(function(){
				console.log("test");
			});  */
		 $("form.ajax").on("submit",function(){
			
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
				type:method,
				dataType:"json",
				data:jsonStr,
				success: function(response){
					console.log(response);
				}
			});
		}); 
	</script>