<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		描述信息：<button id="btn" class="hide-me">获取</button>
		<div id="content"></div>
</body>
</html>
<script>
	var btn = document.getElementById("btn");
	var con = document.getElementById("content");
	var ourRequest = new XMLHttpRequest();
	var count =1;
	btn.addEventListener("click",function(){
		if(count !=1){
			ourRequest.open("GET", "file/json/annimals.json");
		}else{
			ourRequest.open("GET", "file/json/people.json");
		}
		ourRequest.onload =function(){
			var data = JSON.parse(ourRequest.responseText);
			readHtml(data);
			
		}
		ourRequest.send();
		count++;
		if(count>2){
			alert("最后一个json文件被加载");
			btn.disabled=true;
		}
	});
	function readHtml(data){
		var htmlString ="";
		for(i=0;i<data.length;i++){
			htmlString +="<p>"+data[i].name;
			htmlString +=" is " +data[i].species+" , likes eat ";
			for(j=0;j<data[i].food.like.length;j++){	
				if(j==data[i].food.like.length-1){
					htmlString +=data[i].food.like[j];
				}else{
					htmlString +=data[i].food.like[j]+",";
				}
			}
			htmlString +=" and dislike ";
			for(k=0;k<data[i].food.dislike.length;k++){
				if(k==data[i].food.dislike.length-1){
					htmlString +=data[i].food.dislike[k];
				}else{
					htmlString +=data[i].food.dislike[k]+",";
				}
			}
			htmlString +=".</p>";
		}
		con.insertAdjacentHTML("beforeend", htmlString);
	}
	
	
</script>