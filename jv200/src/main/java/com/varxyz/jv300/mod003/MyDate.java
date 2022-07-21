package com.varxyz.jv300.mod003;

public class MyDate {
	// 멤버변수
	private int day;
	private int month;
	private int year;

	public MyDate(int day, int month, int year) {
		day = this.day;
		month = this.month;
		year = this.year;
	}
	
	public MyDate(MyDate date) {
		this.day = date.day; //이미 내가 가지고있는 값을 가지고있는값으로 넣은거
		this.month = date.month;
		this.year = date.year;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public String toString() {
		return "day=" + day +", month="+ month +", year=" + year;
	}
	
//	public MyDate addDays(int moreDays) {
//		MyDate
//	}
	
	
}
