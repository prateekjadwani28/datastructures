package com.dsa.miscellaneous;

public class MS14_MaximiseSplitOneZero {

	// https://www.geeksforgeeks.org/maximize-count-of-0s-in-left-and-1s-in-right-substring-by-splitting-given-binary-string/
	
	public static void main(String[] args) {
		String s = "1000110111101";
		System.out.println("Maximum sum count of zeroes(left) and ones(right) : "+findMaxCount(s));
	}

	private static int findMaxCount(String s) {

		int maxCount = 0;
		int totalOnes = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == '1')
				totalOnes++;
		}
		
		int zeroes = 0 , ones = 0;	
		for(int i=0; i<s.length(); i++) {
			
			if(s.charAt(i) == '0')
				zeroes++;
			else
				ones++;
			
			maxCount = Math.max(maxCount, zeroes + (totalOnes - ones));
		}
		
		return maxCount;
	}
}
