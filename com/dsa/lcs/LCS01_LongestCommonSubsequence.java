package com.dsa.lcs;

public class LCS01_LongestCommonSubsequence {

	public static void main(String[] args) {
		String first = "abcdgh";
		String second = "abedfhr";

		int lenByRecursive = findLongestCommonSubsequenceByRecursive(first,second,first.length(),second.length());
		System.out.println("Recursive length : "+lenByRecursive);
		
		int dp [][] = new int[first.length() + 1][second.length() + 1];
		int lenByMemoization = findLongestCommonSubsequenceByMemoization(first,second,first.length(),second.length(),dp);
		System.out.println("Memoized length : "+lenByMemoization);
		
		int tp [][] = new int[first.length() + 1][second.length() + 1];
		int lenByTopDown = findLongestCommonSubsequenceByTopDown(first,second,first.length(),second.length(),tp);
		System.out.println("Top-down length : "+lenByTopDown);
	}

	private static int findLongestCommonSubsequenceByRecursive(String first, String second,int m, int n) {
		if(m==0 || n==0)
			return 0;

		if(first.charAt(m-1) == second.charAt(n-1))
			return 1 + findLongestCommonSubsequenceByRecursive(first, second, m-1, n-1);
		else
			return Math.max(findLongestCommonSubsequenceByRecursive(first, second, m-1, n), findLongestCommonSubsequenceByRecursive(first, second, m, n-1));
	}
	
	
	private static int findLongestCommonSubsequenceByMemoization(String first, String second, int m, int n, int dp[][]) {
		if(m==0 || n==0)
			return 0;
		
		if(dp[m][n] != 0)
			return dp[m][n];
		if(first.charAt(m-1) == second.charAt(n-1))
			return 1 + findLongestCommonSubsequenceByMemoization(first, second, m-1, n-1, dp);
		else
			return Math.max(findLongestCommonSubsequenceByMemoization(first, second, m-1, n, dp), findLongestCommonSubsequenceByMemoization(first, second, m, n-1, dp));
	}
	
	private static int findLongestCommonSubsequenceByTopDown(String first, String second, int m, int n,int tp[][]) {
		
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0)
					tp[i][j] = 0;
			}
		}
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(first.charAt(i-1) == second.charAt(j-1))
					tp[i][j] =  1 + tp[i-1][j-1];
				else
					tp[i][j] = Math.max(tp[i-1][j], tp[i][j-1]);
			}
		}
		return tp[m][n];
	}
}
