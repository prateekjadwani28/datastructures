package com.dsa.array;

import java.util.Arrays;

public class A01_ReverseArray {

	public static void main(String[] args) {

		int nums [] = {1,2,3,4,5};
		reverse(nums);
	}

	private static void reverse(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		
		while(left < right) {
			
			swap(nums,left,right);
			left++;
			right--;
		}
		System.out.println(Arrays.toString(nums));
	}

	private static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		
	}

}
