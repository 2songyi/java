package com.varxyz.jv300.mod009;

import java.util.*;

public class ListExample {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("second");
		list.add("3rd");
		list.add(new Integer(4));
		list.add(new Float(5.0F));
		list.add("second");			// 중복허용
		list.add(new Integer(4));	// 중복허용
		System.out.println(list);
	}

}
