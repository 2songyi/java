package com.varxyz.jvx330.di.example6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuItemController {
	
	@Autowired
	private MenuItemServiceImp menuItemService;
	
	public MenuItemController() {
//		System.out.println("MenuItemController 생성.");
	}
	
	public void addMenuItem(MenuItem menuItem) {
		menuItemService.addMenuItem(menuItem);
	}
	
	public List<MenuItem> allMenuItemList() {
		return menuItemService.allMenuItemList();
	}
	
	public MenuItem findMenuItemByName(String name) {
		return menuItemService.findMenuItemByName(name);
	}
	
}
