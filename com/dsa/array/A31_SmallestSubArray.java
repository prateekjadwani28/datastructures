package com.dsa.array;

public class A31_SmallestSubArray {

	public static void main(String[] args) {
		
		int nums[] = {1, 4, 45, 6, 0, 19};
		
		findSmallestSubarray(nums,51);
	}

	// Using sliding window technique to get the smallest sub-array 
	private static void findSmallestSubarray(int[] nums, int k) {

		int i = 0;
		int j = 0;
		int count = Integer.MAX_VALUE;
		int sum = 0;
		
		while(i<=j && j<nums.length) {
			
			if(sum <=k) {
				sum = sum + nums[j];
				j++;
			}
			else {
				count = Math.min(count, j-i);
				sum = sum - nums[i];
				i++;
			}
		}
		System.out.println(count);
	}

}
