package com.zl.service.facade;



import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.zl.dto.domain.User;

public interface UserService {
	
	public User getUser();
	public void saveUser(User user);
}
