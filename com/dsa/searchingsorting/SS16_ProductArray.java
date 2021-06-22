package com.dsa.searchingsorting;

import java.util.Arrays;

public class SS16_ProductArray {

	public static void main(String[] args) {

		int nums[] =  {10, 3, 5, 6, 2};
		findProdctArrayByDivision(nums);
		findProductArrayOptimized(nums);
	}
	
	 
	private static void findProductArrayOptimized(int[] nums) {

		int products[] = new int[nums.length];
		products[0] = 1;
		
		// 1 10 30 150 900 
		for(int i=1;i<nums.length;i++) {
			products[i] = products[i-1]*nums[i-1];
		}
		
		int right = 1;
		// 180 600 360 300 900 
		for(int i=nums.length-1;i>=0;i--) {
			products[i] = products[i] * right;
			right = right * nums[i];
		}
		
		System.out.println(Arrays.toString(products));
	}
	
	private static void findProdctArrayByDivision(int[] nums) {

		int product = 1;
		for(int i=0;i<nums.length;i++)
			product = product * nums[i];
		
		int products []  = new int[nums.length];
		for(int i=0;i<nums.length;i++) 
			products[i] = product/nums[i];
		
		
		System.out.println(Arrays.toString(products));
	}

}
