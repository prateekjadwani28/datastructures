package com.dsa.leet.medium;

public class LT52_ReverseString {

	public static void main(String[] args) {
		String s = "Prateek";
		reverseInConstantSpace(s);
	}

	private static void reverseInConstantSpace(String s) {

		char [] ch = s.toCharArray();
		int start = 0;
		int end = ch.length-1;
		
		while(start<end) {
			char temp = ch[end];
			ch[end] = ch[start];
			ch[start] = temp;
			
			start++;
			end--;
		}
		
		System.out.println(String.valueOf(ch));
	}

}
