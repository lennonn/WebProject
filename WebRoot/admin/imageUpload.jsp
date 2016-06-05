<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="UTF-8"%>
<%@ page import="com.zl.blog.beans.*"%>
<%@ page import="com.zl.blog.daos.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	
	int tid=Integer.parseInt(request.getParameter("imagetype"));
	List<ImageType> images = new ArrayList<ImageType>();
	ImageTypeDao itad = new ImageTypeDao();
	images = itad.findImageType();
	String messages=(String)request.getAttribute("messages");
%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=gbk">
<title>Insert title here</title>
</head>

<body>

	
	<center>
		<table width="778" border="0" cellspacing="0" cellpadding="0"
			bgcolor="#FFFFFF" style="word-break:break-all">

			<tr>

				<td align="center" valign="top">
					<form action="../ImageServlet?action=upload&tid=<%=tid%>" method="post" enctype="multipart/form-data">
						
						<table border="0" width="100%" cellspacing="0" cellpadding="8">
							<tr height="60">
								<td colspan="2">我的相册->>【上传照片】</td>
							</tr>
							
							<tr>
								<td align="center">选择照片：</td>
								<td><input type="file" name="path" size="50"></td>
							</tr>
							<tr>
								<td align="center">照片描述：</td>
								<td><input type="text" name="info" size="63"></td>
							</tr>
							<tr height="50">
								<td colspan="2" align="center"><input type="submit"
									value="上传" class="btn_bg"> <input type="reset"
									value="重置" class="btn_bg">
								</td>
							</tr>
							<tr align="center">
							<td>
							<%=messages%>
							</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>

		</table>
	</center>

</body>
</html>