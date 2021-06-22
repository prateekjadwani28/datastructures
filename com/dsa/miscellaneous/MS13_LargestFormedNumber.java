package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MS13_LargestFormedNumber {

	/*
	 * Given two array of Integer 0-9, find the largest number 
	 * formed by these arrays when numbers are rearranged
	 * 
	 * Refer to Question A40
	 * */
	public static void main(String[] args) {

		int nums1 [] = {6,8,0,0,5,6,7,6,7,4,3,6,9,9};
		int nums2 [] = {5,9,6,7,4,3,5,6,8,3,5,6,7,6};
		
		String num1 = formLargestNumber(nums1);
		String num2 = formLargestNumber(nums2);
		
		System.out.println("Number 1 : "+num1);
		System.out.println("Number 2 : "+num2);
		int ans = num1.compareTo(num2);
		
		if(ans > 0)
			System.out.println("Array 1 will make largest number");
		else
			System.out.println("Array 2 will make largest number");
			
	}

	private static String formLargestNumber(int[] nums) {

		List<String> list = new ArrayList<>();
		
		for(int n : nums)
			list.add(String.valueOf(n));
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				String s1 = o1 + o2; // 216
				String s2 = o2 + o1; // 621
				
				return s2.compareTo(s1);
			}
		});
		
		String result = "";
		
		for(String str : list)
			result = result + str;
		
		return result;
		
	}

}
