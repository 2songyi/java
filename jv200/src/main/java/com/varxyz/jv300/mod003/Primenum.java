package com.varxyz.jv300.mod003;

public class Primenum {

	public static void main(String[] args) {
		int i;
		int j;
		int count = 0;
		
		//1000까지의 수 중에 소수 구하기
		for (i = 2; i <= 1000; i++) {
			// i를 j로 나눴을때 나머지가 0이되면 count증가
			for (j = 2; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			// count가 1이면 소수(자기자신만을 약수로 가지는 경우)
			if (count == 1) {
				System.out.print(i + " ");
			}
			// count 초기화
			count = 0;
		}
		
		

	}
	
	

}
