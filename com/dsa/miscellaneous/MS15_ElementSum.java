package com.dsa.miscellaneous;

import java.util.Arrays;

public class MS15_ElementSum {

	//given : [126,125,67,28, 658] expected: [9, 8, 13, 10, 19] without using a 2 loops
	public static void main(String[] args) {

		int nums [] = {126,102,67,28,658,999};
		findElementSumArray(nums,0);
		System.out.println(Arrays.toString(nums));
 	}

	private static void findElementSumArray(int[] nums, int index) {

		if(index >= nums.length)
			return;
		
		int temp = nums[index];
		int sum = 0;
		
		while(temp!=0) {
			
			sum = sum + temp%10;
			temp = temp/10;
		}
		
		nums[index] = sum;
		findElementSumArray(nums, index+1);
		
		return;
	}

}
