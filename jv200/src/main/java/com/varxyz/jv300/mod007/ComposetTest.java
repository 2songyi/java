package com.varxyz.jv300.mod007;

public class ComposetTest {

	public static void main(String[] args) {
		int checkNum = 10; //검사할 숫자
		
		try {
			System.out.println(numCheck(checkNum));
		} catch (ComposetException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Boolean numCheck(int num) throws ComposetException {
		int count = 0;
		int arrIndex = 0;
		int comArray[] = new int[100];
		boolean result = false;
		int multi = 1;
		int inputNum = 0;

		// 음수로 입력 시 절댓값으로 변경
		num = Math.abs(num);
		inputNum = num;

		// 소수 구하기
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}

		// 합성수의 소수의 곱 구하고 배열에 담기
		if (count != 1) {
			int j = 2;
			System.out.print(inputNum + " = ");
			while (true) {
				if (j > 0) {
					if (num % j == 0) {
						num = num / j;
						comArray[arrIndex] = j;
						arrIndex++;
						if (num / j == 1) {
							if (num != 1) {
								comArray[arrIndex] = num;
								arrIndex++;
							}
							break;
						}
					} else {
						j++;
					}
				} else {
					break;
				}
			}

			for (int k = 0; k < arrIndex; k++) {
				System.out.print(comArray[k]);
				multi *= comArray[k];
				if (k < arrIndex - 1) {
					System.out.print("*");
				}
			}

			// 입력값과 소수의 곱이 같은지 확인
			if (multi != inputNum) {
				System.out.println("연산이 잘못되었습니다.");
			}
			
			// 배열에 담긴 숫자별로 count -> 2 이상이면 제곱으로 표시
			//if (count>=2) {} else {위에 sop그대로}
			
			// 소수가 아닌 경우 에러생성
			throw new ComposetException("\n" + inputNum + " 은 소수가 아닙니다. ");
		} else {
			System.out.println(num + "은 소수입니다.");
			result = true;
		}

		return result;
	}

}
