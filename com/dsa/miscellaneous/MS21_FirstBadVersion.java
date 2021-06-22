package com.dsa.miscellaneous;

public class MS21_FirstBadVersion {

	public static void main(String[] args) {

		int n = 7;
		int firstBad = findFirstBadVersion(n);
		System.out.println("First bad version is at : "+firstBad);
	}
	
	private static int findFirstBadVersion(int n) {
		int left = 1;
		int right = n;
		int ans = -1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(isbadVersion(mid)) {
				ans = mid;
				right = mid - 1;
			}
			else
				left = mid + 1;
		}
		return ans;
	}

	public static boolean isbadVersion(int bad) {
		if(bad == 3 ||bad == 4 || bad == 5 || bad == 6 || bad == 7)
			return true;
		else
			return false;
	}
}
