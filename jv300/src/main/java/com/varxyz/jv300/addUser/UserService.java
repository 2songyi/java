package com.varxyz.jv300.addUser;

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
		User user = findUser(userId);
		if (user == null) {
			return false;
		} else {
			if (user.getPasswd() == passwd) {
				return true;
			} else {
				return false;				
			}
		}
	}
	
	
	
	
}
