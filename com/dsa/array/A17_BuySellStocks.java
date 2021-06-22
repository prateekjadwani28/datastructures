package com.dsa.array;

public class A17_BuySellStocks {

	public static void main(String[] args) {

		int nums[] = {7, 2, 5, 3, 6, 1 ,4};
		maxProfittedStocks(nums);
	}

	private static void maxProfittedStocks(int[] nums) {

		int minPrice=Integer.MAX_VALUE,maxProfit=0;
		
		for(int i=0;i<nums.length;i++) {
			
			if(nums[i]<minPrice)
				minPrice = nums[i];
			else if(nums[i] - minPrice > maxProfit)
				maxProfit = nums[i] - minPrice;
		}
		System.out.println("Minimum Price a stock can be bought : " +minPrice);
		System.out.println("Maximum Profit : " +maxProfit);
	}
}
