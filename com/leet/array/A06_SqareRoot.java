package com.leet.array;

public class A06_SqareRoot {

	public static void main(String[] args) {

		System.out.println(findSquareRoot(8));
	}

	// num/mid = mid  
	private static int findSquareRoot(int num) {

		int start = 1;
		int end = num;

		if(num<2)
			return num;
		while(start<end) {
			int mid = start + (end - start)/2;
			if(mid==num/mid)
				return mid;
			else if(mid > num/mid)
				end = mid;
			else 
				start = mid + 1;
		}
		return start - 1;
	}
}
