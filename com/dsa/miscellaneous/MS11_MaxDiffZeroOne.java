package com.dsa.miscellaneous;

public class MS11_MaxDiffZeroOne {
	
	// https://www.youtube.com/watch?v=_V6VKhBSg2c
	// You have given a string of ones and zeroes,
	//Find the maximum difference of zeroes and ones
	public static void main(String[] args) {
		
		String s = "11000010001"; // -- 6 from index 2 to index 9
		System.out.println(findMaxSubstring(s));
	}

	private static int findMaxSubstring(String s) {

		int currentMax = 0; int finalMax = 0;
		for(int i=0; i<s.length(); i++) {
			
			int current = 0;
			if(s.charAt(i) == '0')
				current = 1;
			else
				current = -1;
			currentMax = Math.max(currentMax + current, current);
			finalMax = Math.max(finalMax, currentMax);
			
		}
		return finalMax;
	}

}
