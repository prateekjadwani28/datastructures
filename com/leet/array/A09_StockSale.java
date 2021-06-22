 	package com.leet.array;

public class A09_StockSale {

	public static void main(String[] args) {

		int nums[] = {7,1,5,3,6,4,10};
		GetMaximumProfit(nums);
		
	}

	private static void GetMaximumProfit(int[] nums) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		for(int i=0;i<nums.length;i++) {
			
			if(nums[i] < minPrice)
				minPrice = nums[i];
			else if(maxProfit < nums[i] - minPrice)
				maxProfit = nums[i] - minPrice;
		}
		
		System.out.println("Maximum Profit : " +maxProfit);
	}
}
