package com.dsa.dp.unboundedknapsack;

public class UK02_RodCutting {

	public static void main(String[] args) {
		
		int length = 8;
		int size [] = {1,2,3,4,5,6,7,8};
		int price [] = {3,5,8,9,10,17,17,20};
		
		System.out.println("Max price after cutting rod : "
		+cutRodProfit(size,price,length,size.length));
	}
	
	// For Top down approach , we will not use recursion. 
		private static int cutRodProfit(int[] size, int[] price, int rodLength, int n) {
			int[][] dp = new int[n + 1][rodLength + 1];

			for(int i = 0; i < n + 1; i++) {
				for(int j = 0; j < rodLength + 1; j++) {
					if(i == 0 || j == 0)
						dp[i][j] = 0; // equivalent to (n == 0 || W == 0) -- equivalent to the base condition in recursion
				}
			}
			
			for(int i = 1; i < n + 1; i++) {
				for(int j = 1; j < rodLength + 1; j++) {
					
					if(size[i-1] > j)
						dp[i][j] = dp[i-1][j];
					else
						dp[i][j] = Math.max(price[i-1] + dp[i][j - size[i-1]], dp[i-1][j]);
				}
			}
			return dp[n][rodLength];
		}
}
