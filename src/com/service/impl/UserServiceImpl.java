package com.service.impl;

import com.dao.UserDao;
import com.pojo.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;  
    public UserDao getUserDao() {  
        return userDao;  
    }  
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    } 
	
	@Override
	public boolean register(User user) {
		return userDao.register(user);  
	}

	@Override
	public User login(User user) {
		return userDao.login(user);  
	}

}
