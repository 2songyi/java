package com.varxyz.jv300.mod005;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof MyDate) {
			MyDate d = (MyDate)obj;
			//obj에 mydate들어와야함 아니면 casting에 문제가 생김
			if (d.day == day && d.month == month && d.year == year) {
				//내가 가진거랑 obj랑 비교대상을 비교
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyDate d1 = new MyDate(1, 1, 2000);
		MyDate d2 = new MyDate(3, 1, 2000);
		
		boolean flag = d1.equals(d2);
		
		System.out.println(flag);
	}
}
