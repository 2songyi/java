package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


public class MenuItemDao {
	
	List<MenuItem> menuList = new ArrayList<MenuItem>();
	
	public void addMenuItem(MenuItem menuItem) {
		menuList.add(menuItem);
	}
	
	public List<MenuItem> allMenuItemList() {
		return menuList;
	}
	
	public MenuItem findMenuItemByName(String name) {
		for(MenuItem menuItem : menuList) {
			if (menuItem.getName().equals(name)) {
				return menuItem;
			}
		}
		return null;
	}
	
}
