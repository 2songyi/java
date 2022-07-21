package com.varxyz.jv300.mod010;

import com.varxyz.jv300.addUser.User;
import com.varxyz.jv300.addUser.UserDao;

public class UserService {

	private UserDao userDao;
	
	public void addUser(User user) {
		userDao = new UserDao();
		userDao.addUser(user);
	}
	
	public void findAllUser(User user) {
		userDao = new UserDao();
		userDao.findAllUser();
	}

	public User findUser(String userId) {
		userDao = new UserDao();
		User user = userDao.findUser(userId);
		return user;
	}
	
	public void editUser(User user) {
		userDao = new UserDao();
		userDao.editUser(user);
	}
	
	public boolean isValidUser(String userId, String passwd) {
		
		if (findUser(userId) == null) {
			return false;
		} else {
			if (findUser(userId).getPasswd().equals(passwd)) {
				return true;
			} else {
				return false;				
			}
		}
		
		
	}
	
	
	
	
}
