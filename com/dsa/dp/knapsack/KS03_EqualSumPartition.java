package com.dsa.dp.knapsack;

public class KS03_EqualSumPartition {

	public static void main(String[] args) {

		int nums[] = {1,5,11,5};
		System.out.println("Equal Sum Partition present : " +IsEqualSumPartitionPresent(nums));

	}

	private static boolean IsEqualSumPartitionPresent(int[] nums) {

		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum = sum + nums[i];
		}

		if(sum % 2 != 0)
			return false;
		else
			return isSubSetPresent(nums, sum/2);
	}

	private static boolean isSubSetPresent(int[] nums, int sum) {

		boolean  dp[][] = new boolean[nums.length + 1][sum + 1];

		for(int i=0; i<nums.length+1; i++) {
			for(int j=0; j<sum+1; j++) {

				if(i == 0)
					dp[i][j] = false;
				if(j == 0)
					dp[i][j] = true;
			}
		}

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


