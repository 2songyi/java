package com.varxyz.jv300.mod009;

import java.util.*;

public class ListExample2 {
	// Generics
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("second");
		list.add("second"); // list는 중복 데이터 허용, 순서가 존재한다.
		System.out.println(list);
		
		for (String s : list) {
			System.out.println(s);
		}
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
		
//		List<Integer> list2 = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		System.out.println(list);
	}
	
}
