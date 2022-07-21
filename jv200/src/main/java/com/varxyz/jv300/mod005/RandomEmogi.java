package com.varxyz.jv300.mod005;

public class RandomEmogi {
	/*이모티콘의 종류가 총 7가지가 있다.
	각각의 이모티콘이 특정 이벤트에서 랜덤하게 화면에 나타난다.
	이모티콘의 출현 확률이 다음과 같도록 이모티콘을 생성기에 작성하라.
	동그라미- 70% / 삼각형- 50% / 사각형- 30% / 오각형- 5% / 육각형- 1% / 팔각형- 0.5% / 별- 0.1% */
//	배열, Math.random() 사용하기
	
	public static void main(String[] args) {
		int a = (int) (Math.random()*1000); //0.1퍼의 확률도 있기때문에 *1000
		System.out.println(a);
		
		int i;
		
//		circle 70%
		int circle[] = new int[700];
		for (i = 0; i < circle.length; i++) {
			circle[i] = i;
			if (a == circle[i]) {
				System.out.println("동그라미");
			}
		}
		
//		triangle  50%
		int triangle[] = new int[500];
		for (i = 0; i < triangle.length; i++) {
			triangle[i] = i;
			if (a == triangle[i]) {
				System.out.println("삼각형");
			}
		}
		
//		square 30%
		int square[] = new int[300];
		for (i = 0; i < square.length; i++) {
			square[i] = i;
			if (a == square[i]) {
				System.out.println("사각형");
			}
		}
		
//		pentagon 5%
		int pentagon[] = new int[50];
		for (i = 0; i < pentagon.length; i++) {
			pentagon[i] = i;
			if (a == pentagon[i]) {
				System.out.println("오각형");
			}
		}
		
//		hexagon 1%
		int hexagon[] = new int[10];
		for (i = 0; i < hexagon.length; i++) {
			hexagon[i] = i;
			if (a == hexagon[i]) {
				System.out.println("육각형");
			}
		}
		
//		octagon 0.5%
		int octagon[] = new int[5];
		for (i = 0; i < octagon.length; i++) {
			octagon[i] = i;
			if (a == octagon[i]) {
				System.out.println("팔각형");
			}
		}
		
//		star 0.1%
		int star[] = new int[1];
		for (i = 0; i < star.length; i++) {
			star[i] = i;
			if (a == star[i]) {
				System.out.println("별");
			}
		}
	}
	
}
