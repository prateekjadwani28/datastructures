package com.dsa.lcs;

public class LCS07_MinimumNumberOfInsertionPalindrome {

	public static void main(String[] args) {
		String a = "agbcba";
		String b = reverse(a);
		int m = a.length();
		int n =b.length();
		int [][] dp = new int[m+1][n+1];
		
		int lps = findLPS(a,b,m,n,dp);
		System.out.println("Minimum insertions : "+(a.length()-lps));
	}
	private static int findLPS(String a, String b, int m, int n, int[][] dp) {

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

	private static String reverse(String a) {
		int i=0;
		int j=a.length()-1;
		char ch[] = a.toCharArray();
		
		while(i<j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(ch);
	}
}
