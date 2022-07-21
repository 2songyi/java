package com.varxyz.jv300.mod009;

import java.util.*;

public class SetExample {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add("second");			// 중복비허용, 추가안됨
		set.add(new Integer(4));	// 중복비허용, 추가안됨
		System.out.println(set);
	}

}
