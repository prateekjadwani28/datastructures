package com.dsa.array;

import java.util.Arrays;

public class A20_AlternativePosNegNbrs {

	public static void main(String[] args) {

		int nums[] = {1, 2, -6, -4, -1, 9,-3,1};
		alternatingNumbersWithoutMaintainingOrder(nums);
	}

	/* First we will segregate the array and then we will place the negative numbers
		on to the odd places to make the negative positive alernative
	*/
	private static void alternatingNumbersWithoutMaintainingOrder(int[] nums) {

		// segregate positive and negative elements in the array 
		int i=0,j=nums.length-1;

		while(i<j) {
			if(nums[i]>0)
				i++;
			else if(nums[j]<0) {
				j--;
			}	
			else {
				swap(nums,i,j);
				i++;
				j--;
			}
		}
		System.out.println("Segregated Array : " +Arrays.toString(nums));

		// ith index is the starting point of the negative elements
		for(int k=0;k<nums.length;k=k+2) {

			if(i<nums.length) {
				int tmp = nums[k];
				nums[k] = nums[i];
				nums[i] = tmp;

				i++;
			}
		}

		System.out.println("Resultant Array : " +Arrays.toString(nums));
	}
	
	private static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;

	}

}
