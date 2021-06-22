package com.leet.array;

import java.util.Arrays;

public class A19_ReverseString {

	public static void main(String[] args) {

		char [] s = {'h','e','l','l','o','s'};
		reverse(s);
	}

	private static void reverse(char[] s) {
		
		int i = 0;
		int j = s.length - 1;
		
		while(i<j) {
			
			char ch = s[i];
			s[i] = s[j];
			s[j] = ch;
			
			i++;
			j--;
		}
		System.out.println(Arrays.toString(s));
	}
}
