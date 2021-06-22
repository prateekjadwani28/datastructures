package com.leet.array;

import java.util.Arrays;

public class A05_PlusOne {

	public static void main(String[] args) {

		int nums[] = {9,9,9};
		int result[] = plusOne(nums);
		System.out.println(Arrays.toString(result));
	}

	// 9 9 9 - 1 0 0 0 --> 
	public static int[] plusOne(int[] nums) {
		
		for(int i=nums.length-1;i>=0;i--) {
			
			if(nums[i]<9) {
				nums[i] = nums[i] + 1;
				return nums;
			}
			else {
				nums[i]=0;
			}
		}
		
		int result [] = new int[nums.length + 1];
		result[0] = 1;
		return result;
	}
}
