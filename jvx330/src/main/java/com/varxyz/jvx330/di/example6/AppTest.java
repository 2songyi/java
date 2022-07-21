package com.varxyz.jvx330.di.example6;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MenuItemController controller = context.getBean("menuItemController", MenuItemController.class);
		
		controller.addMenuItem(new MenuItem("아메리카노", 1000));
		controller.addMenuItem(new MenuItem("라떼", 1500));
		controller.addMenuItem(new MenuItem("초코케이크", 4500));
		
		System.out.println(controller.allMenuItemList());
		
		System.out.println(controller.findMenuItemByName("아메리카노"));
		
		context.close();
	}
}
