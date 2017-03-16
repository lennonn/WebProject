/**
 * 
 */
package com.zl.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.User;
import com.zl.service.facade.UserService;

/**
 * @author zlennon
 *
 */
public class UserAction extends ActionSupport {
		User user;
		String jsonStr;
		UserService userService;

		public String getJsonStr() {
			return jsonStr;
		}
		public void setJsonStr(String jsonStr) {
			this.jsonStr = jsonStr;
		}

		HttpServletRequest hRequest;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public UserService getUserService() {
			return userService;
		}
		public void setUserService(UserService userService) {
			this.userService = userService;
		}
		
		public void saveUser(){
			hRequest =ServletActionContext.getRequest();
			JSONObject obj = JSONObject.fromObject(jsonStr);
			user =(User) JSONObject.toBean(obj, User.class);
			userService.saveUser(user);
		}
}
