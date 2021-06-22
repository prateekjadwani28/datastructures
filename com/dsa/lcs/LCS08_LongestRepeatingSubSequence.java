package com.dsa.lcs;

public class LCS08_LongestRepeatingSubSequence {

	public static void main(String[] args) {
		String a = "AABEBCDD";
        int n = a.length();
        
        int [][] dp = new int[n+1][n+1];
        int count =  lcs(a,a,n,n,dp);
        System.out.println("Longest Repeating Sub-sequence : " + count);
	}

	private static int lcs(String a, String b, int m, int n, int[][] dp) {
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1) && i!=j)
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}
}
