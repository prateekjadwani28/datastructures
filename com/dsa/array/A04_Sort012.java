package com.dsa.array;

import java.util.Arrays;

public class A04_Sort012 {

	public static void main(String[] args) {

		int nums[] = {2,2,0,0,2,2,1,1,0,0,1};
		sortTheNumbers(nums);
	}

	private static void sortTheNumbers(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		
		while(mid<=right) {
			
			if(nums[mid] == 0) {
				swap(nums,mid,left);
				left++;
				mid++;
			}
			else if(nums[mid] == 1) {
				mid++;
			}
			else {
				swap(nums,mid,right);
				right--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	private static void swap(int[] nums, int mid, int right) {

		int temp = nums[mid];
		nums[mid] = nums[right];
		nums[right] = temp;
	}

}
