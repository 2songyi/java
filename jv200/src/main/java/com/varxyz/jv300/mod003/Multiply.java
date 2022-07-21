package com.varxyz.jv300.mod003;

public class Multiply {

	public static void main(String[] args) {
		//곱셈
		
		int i;
		int j;
		int multiply;
		
		for (i = 1; i < 10; i++) {
			for (j = 2; j < 10; j++) {
				multiply = i*j;
				System.out.print(j + "*" + i +"=" + multiply + "\t");
			}
			System.out.println();
		}
	}
}
