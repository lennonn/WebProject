<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
	<button id="show" onclick="getData();">显示类容</button>
	<div id="errorMsg"></div>
	<div id="content">请求信息：</div>
	<div id="ajaxJquery">
		ajaxJquery
		<div id="ajContent"></div>
		<div id ="ajError"></div>
	</div>
</body>
<script>
	$("#ajaxJquery").click(function(){
		$.ajax({
			type:"get",
			url:"txt/ajax_load.txt",
			dataType :"html",
			success:function(data, textStatus,jqXHR){
				document.getElementById("ajContent").innerHTML=data;
			},
			error:function(jqXHR,msg,status){
				document.getElementById("ajError").innerHTML="失败信息："+jqXHR.responseText+"</br>"+status;
			},
			complete:function(jqXHR,status){
				if(status="success"){
					alert("请求成功完成！");
				}else{
					alert("请求失败！");
				}
			}
		});
	});

	function getData() {
		var xmlhr = null;
		//1.创建XMLHttpRequest
		if (window.XMLHttpRequest) {
			xmlhr = new XMLHttpRequest();
		} else {
			xmlhr = new new ActiveXObject("Microsoft.XMLHTTP");
		}
		//2.连接服务器
		//URL是相对于当前页面的路径，也可以使用绝对路径
		xmlhr.open("get", "http://127.0.0.1:8080/SSHXmlConfigration/jquery_myjquery", true)
		//3.发送请求
		xmlhr.send();
		//4.处理返回结果
		var errorMsg = "";
		xmlhr.onreadystatechange = function() {
				if (xmlhr.readyState == 0 && xmlhr.status == 200) {
					errorMsg =  "请求未建立 </br>";
				} else if (xmlhr.readyState == 1 && xmlhr.status == 200) {
					errorMsg = "服务器已连接</br>";
				} else if (xmlhr.readyState == 2 && xmlhr.status == 200) {
					errorMsg ="请求已接收 </br>";
				} else if (xmlhr.readyState == 3 && xmlhr.status == 200) {
					errorMsg =  "请求处理中</br> ";
				}else if (xmlhr.readyState == 4 && xmlhr.status == 200) {
					errorMsg =  "请求已完成</br> ";
					document.getElementById("content").innerHTML = xmlhr.responseText;
				}
			if (errorMsg != null || errorMsg != "")
				document.getElementById("errorMsg").innerHTML = "请求过程:</br>"
						+ errorMsg;
		}
	}
</script>
</html>