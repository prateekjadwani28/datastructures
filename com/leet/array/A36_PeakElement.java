package com.leet.array;

public class A36_PeakElement {

	public static void main(String[] args) {

		int nums[] = {1,2,1,3,5,6,4};
		findPeakElement(nums);
	}

	private static void findPeakElement(int[] nums) {

		int i = 0;
		int j = nums.length - 1;
		
		while(i<j) {
			
			int mid = (i+j)/2;
			
			
			if(nums[mid] > nums[mid+1])
				j = mid;
			else
				i = mid + 1;
		}
		
		System.out.println("Peak Element is at index "+i+" with a value as "+nums[i]);
	}

}
