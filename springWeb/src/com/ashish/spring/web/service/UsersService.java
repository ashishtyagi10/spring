package com.ashish.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.spring.web.dao.User;
import com.ashish.spring.web.dao.UserDao;

@Service("usersService")
public class UsersService {

	private UserDao	userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void createUser(User user) {
		userDao.create(user);
	}

	/**
	 * @param username
	 * @return
	 */
	public boolean exists(String username) {
		return userDao.exists(username);
	}
}
