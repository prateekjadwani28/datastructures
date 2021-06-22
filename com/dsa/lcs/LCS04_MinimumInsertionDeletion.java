package com.dsa.lcs;

public class LCS04_MinimumInsertionDeletion {

	public static void main(String[] args) {

		String a = "heap";
		String b ="pea";
		int m = a.length();
		int n = b.length();
		int [][] dp = new int[m+1][n+1];
		
		int lcs = findMinimumDeletion(a,b,m,n,dp);
		System.out.println("Deletion : " +(a.length()-lcs));
		System.out.println("Insertion : " +(b.length()-lcs));
	}

	private static int findMinimumDeletion(String a, String b, int m, int n, int[][] dp) {
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}

}
