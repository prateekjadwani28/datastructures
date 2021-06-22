package com.leet.array;

import java.util.Arrays;

public class A37_RotateArray {

	public static void main(String[] args) {

		int nums[] = {-1,-100,3,99};
		int k = 2;
		System.out.println("Before rotation - "+Arrays.toString(nums));
		rotateArray(nums,k);
	}

	private static void rotateArray(int[] nums, int k) {
		
		reverse(nums,0,nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
		
		System.out.println("After rotating array by "+k+" times - "+Arrays.toString(nums));
		
	}

	private static void reverse(int[] nums, int i, int j) {

		while(i<j) {
			
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
