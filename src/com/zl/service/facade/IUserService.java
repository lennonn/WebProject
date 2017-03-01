package com.zl.service.facade;



import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.zl.dto.domain.User;

public interface IUserService {
	
	public User getUser();

}
