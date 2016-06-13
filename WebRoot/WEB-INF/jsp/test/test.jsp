<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
	<form name="form1">
		<input type="text" name="input1" value="test1"> <input
			type="text" name="input2" value="test2"> <input type="button"
			value="submit" onclick="getValue();">
	</form>
	<script>
   	function getValue(){
		$(document).ready(function form1(){
		var arr  =$("input[type='text']");
			for(var i=0;i<arr.length;i++){
				alert(arr[i].value);
			}
		});
		/* var input = document.getElementsByTagName('input');
		for(var i =0;i < input.length;i++){
			alert(input[i].value);
   		} */
   	}
</script>
</body>
</html>