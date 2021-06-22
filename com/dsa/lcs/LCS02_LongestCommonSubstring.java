package com.dsa.lcs;

public class LCS02_LongestCommonSubstring {

	public static void main(String[] args) {
		String first = "abcdgh";
		String second = "abedfhr";
		
		int dp [][] = new int[first.length() + 1][second.length() + 1];
		System.out.println("Length of LCS is : "+findLongestCommonSubstring(first,second,first.length(),second.length(),dp));
	}

	private static int findLongestCommonSubstring(String first, String second, int m, int n, int[][] dp) {
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1; j<n+1;j++) {
				if(first.charAt(i-1) == second.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = 0;
			}
		}
		return dp[m][n];
	}
}
