package com.dsa.leet.medium;

public class LT01_BuyAndSellStockII {

	public static void main(String[] args) {

		int nums[] = {7,1,5,3,6,4,5};
		System.out.println("The max profit : "+findMaxProfitMultipleTimes(nums,nums.length));
		System.out.println("Maximum Profit by selling twice is : "+findMaxProfitAtmostTwice(nums,nums.length));
	}

	private static int findMaxProfitMultipleTimes(int[] nums, int length) {

		int profit = 0;
		for(int i=1; i<length; i++) {
			int temp = nums[i] - nums[i-1];
			if(temp > 0) {
				profit = profit + temp;
			}
		}
		return profit;
	}

	private static int findMaxProfitAtmostTwice(int[] nums, int length) {

		int left[] = new int[length];
		int right[] = new int[length];

		int leftMin = nums[0];
		int rightMax = nums[length - 1];

		// find the profits from left transactions
		for(int i=1; i<length; i++) {
			left[i] = Math.max(left[i-1], nums[i] - leftMin);
			leftMin = Math.min(leftMin, nums[i]);
		}

		// find the profits from right transactions
		for(int i=length-2; i>=0; i--) {
			right[i] = Math.max(right[i+1], rightMax - nums[i]);
			rightMax = Math.max(rightMax, nums[i]);
		}
		
		int profit = right[0];
		//find profit from both ends
		for(int i=1; i<nums.length; i++) {
			profit = Math.max(profit,left[i-1] + right[i]);
		}
		System.out.println();

		return profit;
	}
}
