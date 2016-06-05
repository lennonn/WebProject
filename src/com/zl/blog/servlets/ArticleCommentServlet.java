package com.zl.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.blog.beans.ArticleComment;
import com.zl.blog.daos.ArticleCommentDao;

public class ArticleCommentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ArticleCommentServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action= request.getParameter("action");
		
		if(action.equals("add"))
			this.addComment(request, response);
		if(action.equals("delete"))
			this.deleteComment(request, response);

		
	}

	/**
	 * Initialization of the servlet. <br>
	 * @throws IOException 
	 * @throws ServletException if an error occurs
	 */
	public void addComment(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		int aid=Integer.parseInt(request.getParameter("a_id"));
		ArticleComment ac= new ArticleComment();
		ac.setA_id(aid);
		ac.setA_user(request.getParameter("name"));
		ac.setA_comment(request.getParameter("content"));
		ArticleCommentDao acs= new ArticleCommentDao();
		acs.addComment(ac);
		response.sendRedirect("articledetail.jsp?id="+aid);
	}
	public void deleteComment(HttpServletRequest request,HttpServletResponse response) throws IOException{
		int id= Integer.parseInt(request.getParameter("id"));
		ArticleCommentDao acd= new ArticleCommentDao();
		acd.deleteComment(id);
		response.sendRedirect("admin/comment.jsp");
		
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
