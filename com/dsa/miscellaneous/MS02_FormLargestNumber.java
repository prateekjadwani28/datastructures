package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MS02_FormLargestNumber {

	public static void main(String[] args) {

		int nums[] = {1,56,78,9,2}; // 1 56 78 9 2 --> 9785621
		formLargestNum(nums);
	}

	// 9 78 56 2 1
	private static void formLargestNum(int[] nums) {

		List<String> list = new ArrayList<>();
		for(int n : nums)
		{
			String temp = String.valueOf(n);
			list.add(temp);
		}		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				String first = o1 + o2; // 78 9 
				String second = o2 + o1; // 9 78

				return (second).compareTo((first));
			}
		});
		String number = "";

		for(Object n : list) {
			number = number + n;
		}
		System.out.println("The largest number formed is : "+number);
	}
}
