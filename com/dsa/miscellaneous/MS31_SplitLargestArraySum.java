package com.dsa.miscellaneous;

public class MS31_SplitLargestArraySum {

	public static void main(String[] args) {

		int nums[] = {2,4,6,3,4,11,8,7};
		int k = 2;
		System.out.println(splitArray(nums,k));
 	}

	private static int splitArray(int[] nums, int k) {
		
		int start = 0;
		int end = 0;
		int ans = 0;
		
		for(int i=0; i<nums.length; i++) {
			start = Math.max(start, nums[i]); // Tracking largest number in an entire array. Taking it as first element.
			end = end + nums[i]; // Taking upper limit for binary search.
		}
		
		while(start<=end) {
			
			int mid = (start + end)/2;
			if(check(nums,mid,k)) {
				ans = mid; 
				end = mid - 1;
			}
			else
				start = mid + 1;
		}
		return ans;
	}
	
	/*
	 * In this method, we will find how many windows can be formed by comparing it 
	 * with mid of a BS
	 * 
	 * For Ex : 2,4,6,3,4,11,8,7 --> start = 11 and end = 43
	 * 	mid = 27
	 * 2,4,6,3,4 --> 1st window
	 * 11,8 --> 2nd window
	 * 7 --> 3rd window
	 * */
	private static boolean check(int[] nums, int mid, int k) {
		int count = 0;
		int sum = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > mid)
				return false;
			
			sum = sum + nums[i];
			if(sum > mid) {
				count++;
				sum = nums[i];
			}
		}
		count++;
		
		if(count == k)
			return true;
		return false;
	}	

}
