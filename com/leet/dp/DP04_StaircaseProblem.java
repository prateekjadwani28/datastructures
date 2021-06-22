package com.leet.dp;

public class DP04_StaircaseProblem {

	public static void main(String[] args) {
		int dist = 2;
        System.out.println("Ways to cover " + dist +" steps : " +printCountDP(dist));
	}

	private static int printCountDP(int dist) {
		
		int dp[] = new int[dist + 1];
		
		dp[0] = 1;
		if(dist >= 1)
			dp[1] = 1;
		if(dist >= 2)
			dp[2] = 2;
		
		for(int i=3;i<=dist;i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		
		return dp[dist];
	}

}
