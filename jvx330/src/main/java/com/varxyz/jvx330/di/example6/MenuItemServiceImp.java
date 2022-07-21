package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuItemServiceImp implements MenuItemService {
	
	@Autowired
	private MenuItemDao menuItemDao;
	
	public void addMenuItem(MenuItem menuItem) {
		menuItemDao.addMenuItem(menuItem);
	}
	
	public List<MenuItem> allMenuItemList() {
		return menuItemDao.allMenuItemList();
	}
	
	public MenuItem findMenuItemByName(String name) {
		System.out.println("\"" + name + "\" 검색결과 입니다.");
		return menuItemDao.findMenuItemByName(name);
	}
	

}
