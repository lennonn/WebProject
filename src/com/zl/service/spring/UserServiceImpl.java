package com.zl.service.spring;

import com.zl.dto.domain.User;
import com.zl.service.facade.IUserService;


public class UserServiceImpl implements IUserService {

	public UserServiceImpl() {
		super();
	}

	public User getUser() {
		User user = new User();
		user.setName("admin");
		user.setPassword("123456");
		return user;
	}

}
