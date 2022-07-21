package com.varxyz.jvx330.di.example6;

import java.util.List;

public interface MenuItemService {
	public void addMenuItem(MenuItem menuItem);
	
	public List<MenuItem> allMenuItemList();
	
	public MenuItem findMenuItemByName(String name);
}
