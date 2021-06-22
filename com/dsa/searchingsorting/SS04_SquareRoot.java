package com.dsa.searchingsorting;

public class SS04_SquareRoot {

	public static void main(String[] args) {

		System.out.println(findSquareRoot(8));
	}

	private static int findSquareRoot(int num) {

		int start = 1;
		int end = num;

		if(num<2)
			return num;
		while(start<end) {
			int mid = start + (end - start)/2;
			if(mid==num/mid) // 4*4 = 16 == 8 False -- 2*2 = 4 == 8 False -- 3*3 = 9 == 8 False
				return mid;
			else if(mid > num/mid)
				end = mid;
			else 
				start = mid + 1;
		}
		return start - 1;
	}
}
