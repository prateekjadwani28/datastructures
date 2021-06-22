package com.dsa.dp.knapsack;

public class KS04_CountSubSetSum {

	public static void main(String[] args) {

		int nums[] = {2,3,5,6,8,10};
		int sum = 10;
		System.out.println(" Number of subset sum equal to "+sum
				+ " : "+countSubsetSum(nums,sum));
	}

	private static int countSubsetSum(int[] nums, int sum) {

		int dp[][] = new int[nums.length+1][sum+1];
	
		// intialization
		for(int i=0; i<nums.length+1; i++) {
			for(int j=0; j<sum+1; j++) {
				
				if(i == 0)
					dp[i][j] = 0;
				if(j == 0)
					dp[i][j] = 1;
			}
		}
		
		// choice diagram
		for(int i=1; i<nums.length+1; i++) {
			for(int j=1; j<sum+1; j++) {
				
				if(nums[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j - nums[i-1]] + dp[i-1][j];
			}
		}
		return dp[nums.length][sum];
	}

}
