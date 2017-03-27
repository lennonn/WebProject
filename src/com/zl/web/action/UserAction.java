/**
 * 
 */
package com.zl.web.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.CUser;
import com.zl.service.facade.UserService;
import com.zl.spring.security.CustomUserDetailsService;

/**
 * @author zlennon
 *
 */
public class UserAction extends ActionSupport {
		CUser user;
		String jsonStr;
		UserService userService;
		String string;
		CustomUserDetailsService customUserDetailsService;

		public void setCustomUserDetailsService(
				CustomUserDetailsService customUserDetailsService) {
			this.customUserDetailsService = customUserDetailsService;
		}
		public String getJsonStr() {
			return jsonStr;
		}
		public void setJsonStr(String jsonStr) {
			this.jsonStr = jsonStr;
		}

		HttpServletRequest hRequest;
		public CUser getUser() {
			return user;
		}
		public void setUser(CUser user) {
			this.user = user;
		}
		public UserService getUserService() {
			return userService;
		}
		public void setUserService(UserService userService) {
			this.userService = userService;
		}			
		public String loginSuccess(){
			   UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			   string= userDetails.getUsername();
			   return "success";
		}
		public String saveUser(){
			try{
				hRequest =ServletActionContext.getRequest();
				user= new CUser();
				user.setName(hRequest.getParameter("username"));
				user.setPassword(hRequest.getParameter("password"));
				UserDetails userDetails=customUserDetailsService.loadUserByUsername(hRequest.getParameter("username"));
				if(userDetails!=null){
					 return SUCCESS;
				}
			 //Principal principal = ServletActionContext.getRequest().getUserPrincipal();
					return  ERROR;
			}catch(Exception e){
				return  ERROR;
			}
		}
}
