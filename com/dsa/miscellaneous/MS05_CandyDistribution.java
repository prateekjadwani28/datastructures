package com.dsa.miscellaneous;

import java.util.Arrays;

public class MS05_CandyDistribution {

	public static void main(String[] args) {

		int[] rating = {12,4,3,11,34,34,1,67};
		System.out.println("The minimum candies required : "+getMinimumCandies(rating));
	}
	// 1 1 1 1 1 1 1 1
	// 1 1 1 2 3 1 1 2
	// 3 2 1 2 3 2 1 2 = 16
	private static int getMinimumCandies(int[] rating) {

		int[] candies = new int[rating.length];
		Arrays.fill(candies, 1);
		
		for(int i=0;i<rating.length-1;i++) {
			if(rating[i+1] > rating[i])
				candies[i+1] = candies[i] + 1;
		}
		int sum = candies[rating.length - 1];
		for(int i=rating.length-1;i>0;i--) {
			if(rating[i-1] > rating[i])
				candies[i-1] = Math.max(candies[i-1], candies[i]+1);
			/*
			 * 		 12 4 3 11 34 37 1 67
				left : 1 1 1 1 1 1 1 1
				left : 1 1 1 2 3 4 1 2 --> we are taking Math.max in case of 37.. do check once that scenario 
			 * */
			sum = sum + candies[i-1];
		}
		return sum;
	}
}
