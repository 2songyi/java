package com.varxyz.jv300.mod003;

public class SubString {

	public static void main(String[] args) {
		String text = "The cat in the hat";
		System.out.println(isSubString("cat", text));
	}
	
	public static boolean isSubString(String item, String line) {
		int i;
		int j;
		int count = 0;
		int textLength = line.length();
		int itemLength = item.length();
		boolean subString = false;
		
		for (i = 0; i < textLength - itemLength + 1; i++) {
			for (j = 0; j < itemLength; j++) {
				char itemc = item.charAt(j);
				char linec = line.charAt(i + j);
				
				// 문자가 서로 다르면 다음 글자로 넘어가기
				if (itemc != linec) {
					break;
				// 같으면 count를 더하고 다음 문자 연속으로 비교
				} else if (linec == itemc){
					count++;
				}
				// count가 문자의 길이와 같아지면 true를 반환 
				if (count == itemLength) {
					subString = true;
				}
			}
			
		}
		return subString;
	}

}
