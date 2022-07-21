package com.varxyz.jv300.mod009;

import java.util.*;

public class MapExample {
	// Map -> key-value
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(Integer.valueOf(1), "짱구"); // new Integer(1) 대신 사용
		map.put(2, "철수"); 					//autoboxing
		map.put(new Integer(3), "맹구");		// java9 이후 deprecate됨
		
		System.out.println(map.get(Integer.valueOf(3))); //map.get(key) 로 값 호출
		
		Set<Integer> set = map.keySet(); // 키값만 출력
		for (Integer integer : set) {
			System.out.print(integer);
			System.out.println(" = " + map.get(integer)); // 키값을 넣어서 value출력
		}
	}

}
