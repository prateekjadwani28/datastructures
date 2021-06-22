package com.dsa.searchingsorting;

public class SS29_TrailingZerorsFactorial {

	public static void main(String[] args) {

		int num = 6;
		findSmallestNumberWithTrailingZero(num);
	}

	private static void findSmallestNumberWithTrailingZero(int num) {

		int low=0;
		int high=5*num;


		while(low<high) {

			int mid = (low+high)/2;
			if(check(mid,num))
				high = mid;
			else 
				low = mid + 1;
		}
		System.out.println(low);
	}

	private static boolean check(int mid, int num) {
		int count = 0;
		int factor = 5;

		while(factor<=mid) {
			count +=Math.floor(mid/factor);
			factor = factor * 5;
		}
		return count>=num;
	}

}
