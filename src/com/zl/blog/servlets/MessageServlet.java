package com.zl.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.blog.beans.ArticleType;
import com.zl.blog.beans.Message;
import com.zl.blog.daos.ArticleTypeDao;
import com.zl.blog.daos.MessageDao;

public class MessageServlet extends HttpServlet {

	
	public MessageServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if(action.equals("delete"))
			this.deleteMessage(request, response);
		if(action.equals("reply"))
			this.replyMessage(request, response);
		
	}

	public void replyMessage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("GBK");
		String messages="";
		String forward="";
		String href="";
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Message msg = new Message();
			msg.setId(id);
			msg.setName(request.getParameter("name"));
			msg.setRevert(request.getParameter("revert"));
			MessageDao md = new MessageDao(); 
			md.messageModify(msg);
			if(msg.getRevert()!=null){
				messages="回复成功！";
				forward="message.jsp";
				href="<a href='/message.jsp'>[返回]</a>";
			}
		} catch (Exception e) {
			messages="回复失败！";
			forward="/error.jsp";
			href="<a href='javascript:window.history.go(-1)'>[返回]</a>";
			e.printStackTrace();
		}
		
		request.setAttribute("messages",messages);
		request.setAttribute("href",href);
		
		response.sendRedirect(forward);
		
	}
	
	public void deleteMessage(HttpServletRequest request,HttpServletResponse response){

		int id = Integer.parseInt(request.getParameter("id"));
		MessageDao md = new MessageDao();
		md.deleteMessage(id);
	
	}
	
	public void addMessage(HttpServletRequest request,HttpServletResponse response){
		
		  ArticleType atype = new ArticleType();

		  atype.setType_name(request.getParameter("typename"));
		  atype.setType_desc(request.getParameter("typedesc"));
		  ArticleTypeDao.addArticleType(atype);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
