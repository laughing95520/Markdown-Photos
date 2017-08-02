package com.wyh.service;

import com.wyh.dao.UserDao;

public class UserService {
	
	public boolean saveuser(String username, String password) {
		UserDao userDao = new UserDao();
		return userDao.saveuser(username,password);
		 
	}

	public  boolean checkuser(String username, String password) throws Exception {
		UserDao userDao = new UserDao();
		return userDao.checkuser(username,password);
		
	}
	
}
