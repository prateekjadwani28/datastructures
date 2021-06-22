package com.dsa.array;

import java.util.Arrays;

public class A32_ThreePartitions {

	public static void main(String[] args) {
		
		int nums[] = {1, 14, 5, 20, 4, 2, 54, 15,20, 87, 98, 3, 1, 32};
		createPartitions(nums,14,20);
	}
	
	// 1 2 3 4 14 15 16 20 22 34 

	private static void createPartitions(int[] nums, int x, int y) {

		
		int start = 0;
		int end = nums.length - 1;
		int i=0;
		while(i<=end) {
			
			if(nums[i]<x) {
				int temp = nums[start];
				nums[start] = nums[i];
				nums[i] = temp;
				i++;
				start++;
				
			}
			else if(nums[i]>y) {
				int temp = nums[end];
				nums[end] = nums[i];
				nums[i] = temp;
				end--;
			}
			
			else 
				i++;
		}
		
		System.out.println(Arrays.toString(nums));
	}

}
