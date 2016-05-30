<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>upload</title>


</head>
<body>

				<s:form action="uploadSingle" method="post"  enctype="multipart/form-data" >
				<div class="box">
					<s:file name="upload"  ></s:file>
				<s:submit name="submit" value="开始上传"></s:submit>
				</div>
				</s:form>


	</body>
</html>
