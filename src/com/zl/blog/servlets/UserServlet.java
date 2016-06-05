package com.zl.blog.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zl.blog.beans.User;
import com.zl.blog.beans.UserInfo;
import com.zl.blog.daos.UserDao;

public class UserServlet extends HttpServlet {

	public UserServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("login"))
			try {
				this.login(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (action.equals("register"))
			this.register(request, response);
		if (action.equals("logout"))
			this.logout(request, response);
		if (action.equals("updateuser"))
			this.updateuser(request, response);
		// this.logout(request, response);

	}

	private void logout(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("loginer");
		response.sendRedirect("index.jsp");

	}

	private void updateuser(HttpServletRequest request,
			HttpServletResponse response) {
		User u = new User();
		UserInfo uinfo = new UserInfo();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		uinfo.setReal_name(request.getParameter("xingming"));
		uinfo.setEmail(request.getParameter("email"));
		UserDao udao = new UserDao();
		udao.register(u);
		udao.register(uinfo);

	}

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		    UserDao udao = new UserDao();
			UserInfo uinfo= new UserInfo();
			User u= new User();
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String repeat=request.getParameter("repeat");
			String email=request.getParameter("account");
			String str="[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9]+(\\.(com))";
			String username = null;
			
			List<User> users=udao.gerUser();
			  Pattern p = Pattern.compile(str);//实例化Pattern类  
		        Matcher m = p.matcher(email);//验证内容是否合法  
			for(int i=0;i<users.size();i++){
				 username=users.get(i).getUsername();
			}
			if(name.length()<=0||name.length()>=32){
				HttpSession session=request.getSession();
           	 session.setAttribute("messages","请检查用户名长度,请重新填写！");
				response.sendRedirect("admin/register.jsp");	
			}
			else if(name.equals(username)){
				HttpSession session=request.getSession();
				session.setAttribute("messages","该用户名已被注册,请重新填写！");
				response.sendRedirect("admin/register.jsp");	
			}else if(password.length()<6){
				HttpSession session=request.getSession();
				session.setAttribute("messages","密码不能少于6位字符,请重新填写！");
				response.sendRedirect("admin/register.jsp");	
			}
			else if(!password.equals(repeat)){
				HttpSession session=request.getSession();
				session.setAttribute("messages","两次密码不一致，请重新填写！");
				response.sendRedirect("admin/register.jsp");	
			}
			
			else if(!m.matches()){
				//System.out.println(email);
				HttpSession session=request.getSession();
            	session.setAttribute("messages","邮箱格式不正确,请重新填写！");
 				response.sendRedirect("admin/register.jsp");	
            }
			else{
			u.setUsername(name);
			u.setPassword(request.getParameter("password"));
			udao.register(u);
			uinfo.setLogin_id(udao.findMaxId());
			uinfo.setReal_name(request.getParameter("real"));
			uinfo.setEmail(request.getParameter("account"));
			udao.register(uinfo);
			HttpSession session=request.getSession();
			session.setAttribute("messages","注册成功，直接登录");
			response.sendRedirect("admin/login.jsp");	
			}
	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		boolean flag = validateLogon(request, response);
		RequestDispatcher rd = null;
		if (flag) {
			UserDao udao = new UserDao();
			User loginer = new User();
			loginer.setUsername(request.getParameter("username"));
			loginer.setPassword(request.getParameter("password"));
			//boolean mark = udao.login(loginer).equals(null) ? false : true;
				boolean mark = udao.login(loginer);
			if (!mark) {
				HttpSession session = request.getSession();
				session.setAttribute("message", "<li>输入的用户名不存在或密码错误！</li>");
				response.sendRedirect("admin/login.jsp");
				// rd=request.getRequestDispatcher("admin/login.jsp");
				// rd.forward(request,response);
			} else {
				HttpSession session = request.getSession();
				//loginer.setId(udao.login(loginer));
				session.setAttribute("loginer", loginer);
				response.sendRedirect("admin/index.jsp");
			}
		} else {
			response.sendRedirect("admin/login.jsp");
			// rd=request.getRequestDispatcher("admin/login.jsp");
			// rd.forward(request,response);
		}

	}

	public boolean validateLogon(HttpServletRequest request,
			HttpServletResponse response) {
		boolean mark = true;
		String message = "";
		HttpSession session = request.getSession();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if (name == null || name.equals("")) {
			mark = false;
			message += "<li>请输入<b>用户名！用户名不能为空！</b></li>";
		}
		if (name.length() > 30) {
			mark = false;
			message += "<li>用户名必须少于30个字符！</b></li>";
		}
		if (password == null || password.equals("")) {
			mark = false;
			message += "<li>请输入<b>密&nbsp;&nbsp;吗！</b></li>";
		}
		session.setAttribute("message", message);
		return mark;
	}

	// public void logout(HttpServletRequest request, HttpServletResponse
	// response) throws IOException {
	// HttpSession session=request.getSession();
	// session.removeAttribute("loginer");
	// response.sendRedirect("admin/login.jsp");
	// }
	public void init() throws ServletException {
		// Put your code here
	}

}
