package com.dsa.dp.knapsack;

public class KS02_SubsetSum {

	public static void main(String[] args) {

		int nums [] = {2,3,7,8,11,13};
		int sum = 6;

		System.out.println("Is a subset with sum "+sum+" present : "+isSubsetSumPresent(nums,sum));
	}

	
	private static boolean isSubsetSumPresent(int[] nums, int sum) {

		boolean dp[][] = new boolean[nums.length+1][sum+1];
		
		// base condition
		for(int i=0; i<nums.length+1; i++) {
			for(int j=0; j<sum+1; j++) {

				if(i == 0)
					dp[i][j] = false;
				if(j == 0)
					dp[i][j] = true;
			}
		}
		// choice diagram
		for(int i=1; i<nums.length+1; i++) {
			for(int j=1; j<sum+1; j++) {
				
				if(nums[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
			}
		}
		return dp[nums.length][sum];
	}

}
