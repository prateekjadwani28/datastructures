package com.dsa.dp.unboundedknapsack;


//given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated 
//with n items respectively. Also given an integer W which represents knapsack capacity, 
//find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
public class UK01_UnboundedKnapsack {

	public static void main(String[] args) {

		int weight[] = {30,10,20};
		int value[] = {50,100,20};

		int bagWeight = 50;
		int n = weight.length;

		int maxProfitByRecursion = knapSackRecursive(weight,value,bagWeight,n);
		System.out.println("Max Profit by recursion : " +maxProfitByRecursion);

		int maxProfitByMemoization = knapSackMemoization(weight,value,bagWeight,n);
		System.out.println("Max Profit by memoization : " +maxProfitByMemoization);

		int maxProfitByTopDown = knapSackTopDown(weight,value,bagWeight,n);
		System.out.println("Max Profit by Top down : " +maxProfitByTopDown);

	}

	private static int knapSackRecursive(int[] weight, int[] value, int bagWeight, int n) {

		if(bagWeight == 0 || n == 0)
			return 0;

		if(weight[n-1] > bagWeight)
			return knapSackRecursive(weight, value, bagWeight, n-1);
		else
			return Math.max(value[n-1] + knapSackRecursive(weight, value, bagWeight-weight[n-1], n), knapSackRecursive(weight, value, bagWeight, n-1));
	}


	private static int knapSackMemoization(int[] weight, int[] value, int bagWeight, int n) {
		int[][] dp = new int[n + 1][bagWeight + 1];

		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < bagWeight + 1; j++) {
				dp[i][j] = -1; // Just initialize whole 2-D Array or Matrix by -1
			}
		}
		return knapSackRecMemoization(weight, value, bagWeight, n, dp);
	}

	private static int knapSackRecMemoization(int[] weight, int[] value, int bagWeight, int n, int[][] dp) {

		// Base condition (If we dont have any items or we have no capacity left in knapsack)
		if(n == 0 || bagWeight == 0)
			return 0;

		// Used for memoization
		if(dp[n][bagWeight]!=-1)
			return dp[n][bagWeight]; // if at any grid, -1 is not stored, just return that value.


		// If item in weight array to be included or not condition., choice diagram logic
		if(weight[n-1] > bagWeight)
			return dp[n][bagWeight] = knapSackRecMemoization(weight, value, bagWeight, n-1,dp);
		else
			return dp[n][bagWeight] = Math.max(value[n-1] + knapSackRecMemoization(weight, value, bagWeight-weight[n-1], n, dp), 
					knapSackRecMemoization(weight, value, bagWeight, n-1, dp));
	}
	
	
	// For Top down approach , we will not use recursion. 
	private static int knapSackTopDown(int[] weight, int[] value, int bagWeight, int n) {
		int[][] dp = new int[n + 1][bagWeight + 1];

		for(int i = 0; i < n + 1; i++) {
			for(int j = 0; j < bagWeight + 1; j++) {
				if(i == 0 || j == 0)
					dp[i][j] = 0; // equivalent to (n == 0 || W == 0) -- equivalent to the base condition in recursion
			}
		}
		
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < bagWeight + 1; j++) {
				
				if(weight[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(value[i-1] + dp[i][j - weight[i-1]], dp[i-1][j]);
			}
		}
		return dp[n][bagWeight];
	}
}


