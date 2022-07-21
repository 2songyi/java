package com.varxyz.jv300.mod007;

public class ComposetTest2 {

	public static void main(String[] args) {
		int checkNum = 10; //검사할 숫자
		
		try {
			System.out.println(numCheck(checkNum));
		} catch (ComposetException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Boolean numCheck(int num) throws ComposetException {
		//primeNum을 하나의 class로 생성해서 사용 가능, static을 사용한 이유
		//약수를 출력할때 곱한값이 입력값과 같은지 확인 과정 필요, -처리 필요, boolean처리
		//배열생성 -> comArray[i++] 해서 값을 담고 comArray[0], comArray[i-1]로 출력
		//i는 배열 길이가 아닌 인덱스
		int count = 0;
		String strNum = Integer.toString(num);
		int arrIndex = 0;
		int arr = 2;
		int comArray[] = new int[arr];
		boolean result = false;
		
		//소수 구하기
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}
		
		if (count != 1) {
			//합성수의 약수 구하기
			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					//j(약수)를 배열에 담고 index증가
					if (arrIndex > arr) {
						arr += 1;
						
					}
					comArray[arrIndex] = j;
					arrIndex++;
					System.out.println(comArray.length);
//					for (int k = 0; k < comArray.length; k++) {
//						System.out.print(comArray[k]);
//					}
				}
			}
			//소수가 아닌 경우 에러생성
			throw new ComposetException(strNum + "은 소수가 아닙니다.");
		} else {
			System.out.println(strNum + "은 소수입니다.");
			result = true;;
		}
		
		return result;
	}

}
