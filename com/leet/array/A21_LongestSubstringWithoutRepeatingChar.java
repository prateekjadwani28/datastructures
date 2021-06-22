package com.leet.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A21_LongestSubstringWithoutRepeatingChar {

	public static void main(String[] args) {
		
		String str = "abcaabcdba";
		findLengthUsingSet(str);
		findLengthUsingMap(str);
	}

	/*
	 * This method has the TC as O(N) and SC as O(N) - abcaabcdba
	 * */
	private static int findLengthUsingMap(String str) {

		// Add the character and its index in the map 
		Map<Character,Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;
		int len = 0;
		
		while(right<str.length()) {
			if(map.containsKey(str.charAt(right)))
				// added 1, to move left pointer to start of the new substring w/o repeating character by avoiding meaningless jumps
				left = Math.max(map.get(str.charAt(right)) + 1, left);  

			map.put(str.charAt(right), right);
			len = Math.max(len, right - left + 1);
			right++;
		}
		System.out.println("The longest substring length without "
				+ "repeating characters is : " + len);
		return len;
	}

	
	/*
	 * This method has the TC as O(2N) and SC as O(N), since both left and right 
	 * pointers traverse an array once
	 * */
	private static int findLengthUsingSet(String s) {

		Set<Character> set = new HashSet<>();
		int left = 0;
		int right = 0;
		int maxLength = 0;
		
		//abcabcbb
		while(right<s.length()) {
			
			if(!set.contains(s.charAt(right))) {
				
				set.add(s.charAt(right));
				maxLength = Math.max(maxLength, set.size());
				right++;
			}
			else {
				
				set.remove(s.charAt(left));
				left++;
			}
		}
		System.out.println("The longest substring length without "
				+ "repeating characters is : " + maxLength);
		return maxLength;
	}

	
}
