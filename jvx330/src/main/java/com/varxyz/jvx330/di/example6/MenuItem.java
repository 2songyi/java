package com.varxyz.jvx330.di.example6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
	private String name;
	private int price;
	
	@Override
	public String toString() {
		return "메뉴이름=" + name + ", 가격=" + price;
	}
	
}
