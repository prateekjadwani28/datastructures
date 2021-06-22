package com.leet.string;

public class ST02_PalindromeString {

	public static void main(String[] args) {

		String str = "maDaM";
		isPalindrome(str);
	}
	/*
	 * There is also another method of finding palindrome which is : 
	 * 	
	 * reverse a string and check that reversed string is same as the provided string
	 * 
	 * */
	private static void isPalindrome(String str) {

		int begin = 0;
		int last = str.length() - 1;
		
		String lowerStr = str.toLowerCase();
		while(begin<last) {
			
			if(lowerStr.charAt(begin) != lowerStr.charAt(last)) {
				System.out.println("The given String "+str+" is not a palindrome");
				return;
			}
			begin++;
			last--;
		}
		System.out.println("The given String "+str+" is a palindrome");
	}
}
