package com.zl.service.spring;

import com.zl.dto.domain.User;
import com.zl.persistence.hibernate.dao.UserDao;
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

	public User getUser() {
		User user = new User();
		user.setName("admin");
		user.setPassword("123456");
		return user;
	}

	/* (non-Javadoc)
	 * @see com.zl.service.facade.UserService#saveUser()
	 */
	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

}
