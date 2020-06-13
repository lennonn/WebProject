package com.zl.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class CookiesAndSessionServlet extends HttpServlet {

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		HttpSession session=req.getSession();
		Long time=session.getCreationTime();
		Cookie cookie[]=req.getCookies();
		resp.setContentType(" text/html;charset=gb2312");
		List list =Arrays.asList(cookie);
		sb.append("SessionId:"+session.getId()+"<br/>");
		sb.append("RemoteAddr:"+req.getRemoteAddr()+"<br/>");
		sb.append("LoalAddr:"+req.getLocalAddr()+"<br/>");
		sb.append("加密类型:"+req.getAuthType()+"<br/>");
		sb.append("请求类型:"+req.getHeader("Content-Type")+"<br/>");
		sb.append("session创建时间:"+session.getCreationTime()+"<br/>");
		sb.append("是否是新建Session:"+session.isNew());
		req.setAttribute("list", list);
		req.setAttribute("str", sb.toString());
		req.getRequestDispatcher("/WEB-INF/jsp/cookiesAndSession.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	public CookiesAndSessionServlet() {
		// TODO Auto-generated constructor stub
	}

}
