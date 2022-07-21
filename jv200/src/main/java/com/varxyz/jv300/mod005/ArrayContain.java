package com.varxyz.jv300.mod005;

public class ArrayContain {

	public static void main(String[] args) {
//		주어진 배열에 새로운 배열이(target) 포함되는지, 겹치는지, 다른지 판별
		int[] nums = {1, 2, 3, 4, 5};
		int[] target1 = {1, 2, 3}; //포함	
		int[] target2 = {6, 7, 8}; //다름
		int[] target3 = {4, 5, 6}; //교집합
		
		ArrayCheck(nums, target1);
		ArrayCheck(nums, target2);
		ArrayCheck(nums, target3);
	}
	
	public static void ArrayCheck(int[] num, int[] target) {
		int i;
		int j;
		int count = 0;
		String result = "";

		for (j = 0; j < target.length; j++) {
			for (i = 0; i < num.length; i++) {
				int numNum = num[i];
				int targetNum = target[j];

				if (numNum == targetNum) {
					count++;
					break;
				}
			}

//			System.out.println(count);
			if (count == target.length) {
				result = "포함";
			} else if (count > 0) {
				result = "일부포함";
			} else {
				result = "다름";
			}
		}
		System.out.println(result);
	}

}
