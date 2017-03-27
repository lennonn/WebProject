package com.zl.service.facade;



import com.zl.dto.domain.CUser;

public interface UserService {
	
	public CUser getUser();
	public void saveUser(CUser user);
}
