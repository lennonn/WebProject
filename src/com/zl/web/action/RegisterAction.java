package com.zl.web.action;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.User;
import com.zl.service.facade.UserService;

public class RegisterAction extends ActionSupport {

	/**
	 *
	 */

	private static final long serialVersionUID = 1L;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private User user;
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public RegisterAction() {
		// TODO Auto-generated constructor stub
	}
	@Action(value="regist",results={@Result(name="success",location="register.jsp")})
	public String excute(){
		return SUCCESS;
	}
	@Action(value="registerInfo",
			results={@Result(name="success",location="common/success.jsp"),
					 @Result(name="error" ,location="common/errorPage.jsp")
	})
	public String saveRegisterInfo(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date);
		user.setRegisterTime(Timestamp.valueOf(time));
		userService.saveRegisterInfo(user);

		return SUCCESS;
	}

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date);
		System.out.println(Timestamp.valueOf(time));
	}
}
