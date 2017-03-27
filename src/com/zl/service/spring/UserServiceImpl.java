package com.zl.service.spring;

import com.zl.dto.domain.CUser;
import com.zl.persistence.dao.UserDao;
import com.zl.service.facade.UserService;


public class UserServiceImpl implements UserService {
	UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserServiceImpl() {
		super();
	}

	@Override
	public CUser getUser() {
		CUser user = new CUser();
		user.setName("admin");
		user.setPassword("123456");
		return user;
	}

	/* (non-Javadoc)
	 * @see com.zl.service.facade.UserService#saveUser()
	 */
	@Override
	public void saveUser(CUser user) {
		userDao.saveUser(user);
	}

}
