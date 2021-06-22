package com.dsa.miscellaneous;

public class MS22_GuessNumber {

	public static void main(String[] args) {
		
		int n = 10;
		int pick = 2;
		
		int result = findNumber(n,pick);
		System.out.println("The number guessed is : "+result);
	}

	private static int findNumber(int n , int pick) {
		
		int left = 1;
		int right = n;
		int mid = -1;
		
		while(left <= right) {
			
			 mid = (left + right)/2;
			
			if(mid == pick) {
				break;
			}
			else if(mid > pick)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return mid;
	}
}
