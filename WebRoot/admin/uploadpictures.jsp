<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int id = Integer.parseInt(request.getParameter("id"));
	
	List<ImageType> images = new ArrayList<ImageType>();
	ImageTypeDao itad = new ImageTypeDao();
	images = itad.findImageType();
	String messages=(String)request.getAttribute("messages");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<center>
		<table width="778" border="0" cellspacing="0" cellpadding="0"
			bgcolor="#FFFFFF" style="word-break:break-all">

			<tr>

				<td align="center" valign="top">
					<form action=../UploadServlet " method="post"
						enctype="multipart/form-data" name="form1">
						<input type="hidden" name="id" value="<%=id%>">
						<table border="0" width="100%" cellspacing="0" cellpadding="8">
							<tr height="60">
								<td colspan="2">文章管理->>【上传照片】</td>
							</tr>
							
							<tr>
								<td align="center">选择照片：</td>
								<td><input type="file" name="file" size="50"></td>
							</tr>

							<tr height="50">
								<td colspan="2" align="center"><input type="submit"
									name="Submit" value="开始上传" class="btn_bg"></td>
							</tr>
							
						</table>
					</form>
				</td>
			</tr>

		</table>
	</center>
	

</body>
</html>