package com.leet.string;

public class ST16_LevelReverseString {

	public static void main(String[] args) {

		String s ="1100010000";
		validReverseString(s);
	}

	private static void validReverseString(String s) {

		boolean flag = false;
		for(int i=s.length()-1;i>=0;i--) {
			if(!flag) {
				if(!(s.charAt(i) == '0')) {
					System.out.print(s.charAt(i));
					flag = true;
				}
			}
			else
				System.out.print(s.charAt(i));
		}
	}
}
