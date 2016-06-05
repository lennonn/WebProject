package com.zl.blog.servlets;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zl.blog.beans.Article;
import com.zl.blog.beans.ArticleType;
import com.zl.blog.daos.ArticleDao;
import com.zl.blog.daos.ArticleTypeDao;

public class ArticleServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ArticleServlet() {
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

		response.setContentType("text/html");
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

		
		request.setCharacterEncoding("utf-8");	
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action.equals("add"))
			this.addArticle(request, response);
		if(action.equals("delete"))
			this.deleteArticle(request, response);
		if(action.equals("modify"))
			this.modifyArticle(request, response);
		
			
		
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 * 
	 */
	public void addArticle(HttpServletRequest request,HttpServletResponse response){
		Article art = new Article();
	
		art.setT_id(Integer.parseInt(request.getParameter("articletype")));
		art.setTitle(request.getParameter("title"));
		art.setAuthor(request.getParameter("author"));
		art.setContent(request.getParameter("content"));
		ArticleDao artd = new ArticleDao();
		artd.addArticle(art);	
	}
	public void deleteArticle(HttpServletRequest request,HttpServletResponse response){

		int id =Integer.parseInt(request.getParameter("id") );
		ArticleDao artd = new ArticleDao();
		artd.deleteArticle(id);	
	}
	
	
	
	public void modifyArticle(HttpServletRequest request,HttpServletResponse response){
		Article art = new Article();
		art.setId(Integer.parseInt(request.getParameter("id")));
		art.setTitle(request.getParameter("title"));
		art.setAuthor(request.getParameter("author"));
		art.setContent(request.getParameter("content"));
		ArticleDao artd = new ArticleDao();
		artd.articleModify(art);	
	}
	
	
	public void init() throws ServletException {
		// Put your code here
	}

}
