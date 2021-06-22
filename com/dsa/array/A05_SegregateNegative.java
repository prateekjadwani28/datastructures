package com.dsa.array;

import java.util.Arrays;

public class A05_SegregateNegative {

	public static void main(String[] args) {

		int nums[] = {2,3,-1,-5,2,1,-9,-2,-6,-2,-6,4,0};
		segregateNegativeNumbers(nums);
		segregateNegativeNumbersUsingPivot(nums);
	}

	private static void segregateNegativeNumbersUsingPivot(int[] nums) {

		int i=-1;
		int pivot = 0;

		for(int j=0;j<nums.length;j++) {

			if(nums[j]>pivot) {
				i++;
				swap(nums,j,i);
			}
		}
		System.out.println(Arrays.toString(nums));
	}
	//2,3,-1,-5,2,1,0,-9,-2,-6,-2,-6,4
	private static void segregateNegativeNumbers(int[] nums) {

		int left = 0;
		int right = nums.length - 1;

		while(left<right) {

			if(nums[left]>0)
				left++;
			else if(nums[right]<0) {
				right--;
			}	
			else {
				swap(nums,left,right);
				left++;
				right--;
			}
		}


		System.out.println(Arrays.toString(nums));
	}

	private static void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;

	}

}
