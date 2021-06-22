package com.dsa.leet.medium;

public class LT44_MaxSumProduct {

	public static void main(String[] args) {

		int[] nums = {2,5,1,0,-1,-6,6,-5};
		findMaxSumProductPair(nums,nums.length);
	}

	private static void findMaxSumProductPair(int[] nums, int length) {

		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		for(int i=0; i<nums.length; i++) {
			
			if(nums[i] > firstMax) {
				secondMax = firstMax;
				firstMax = nums[i];
			}
			else if(nums[i] > secondMax)
				secondMax = nums[i];
			
			if(nums[i] < firstMin) {
				secondMin = firstMin;
				firstMin = nums[i];
			}
			else if(nums[i] < secondMin)
				secondMin = nums[i];
		}
		
		System.out.println("Maximum two number sum is : "+(firstMax + secondMax));
		
		if(firstMax*secondMax > firstMin*secondMin)
			System.out.println("Maximum two number product is "+firstMax*secondMax);
		else
			System.out.println("Maximum two number product is "+firstMin*secondMin);
	}

}
