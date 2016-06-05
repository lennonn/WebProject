package com.zl.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zl.blog.beans.Article;
import com.zl.blog.beans.ArticleType;
import com.zl.blog.daos.ArticleDao;
import com.zl.blog.daos.ArticleTypeDao;

public class ArticleTypeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ArticleTypeServlet() {
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

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String action = request.getParameter("action");
		if(action.equals("add"))
			this.addArticleType(request, response);
		if(action.equals("delete"))
			this.deleteArticleType(request, response);
		if(action.equals("modify"))
			this.modifyArticleType(request, response);
	}

	public void modifyArticleType(HttpServletRequest request,HttpServletResponse response){
		ArticleType atype = new ArticleType();
		atype.setId(Integer.parseInt(request.getParameter("id")));
		atype.setType_name(request.getParameter("typename"));
		atype.setType_desc(request.getParameter("typedesc"));
		ArticleTypeDao atypedao = new ArticleTypeDao();
		atypedao.articleTypeModify(atype);
	}
	
	public void deleteArticleType(HttpServletRequest request,HttpServletResponse response){

		int id =Integer.parseInt(request.getParameter("id") );
		ArticleTypeDao atype = new ArticleTypeDao();
		atype.articleTypeDelete(id);	
	}
	
	public void addArticleType(HttpServletRequest request,HttpServletResponse response){
		
		  ArticleType atype = new ArticleType();

		  atype.setType_name(request.getParameter("typename"));
		  atype.setType_desc(request.getParameter("typedesc"));
		  ArticleTypeDao.addArticleType(atype);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
