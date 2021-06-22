package com.dsa.searchingsorting;

public class SS22_PivotElement {

	public static void main(String[] args) {

		int nums[] = {12,14,2,6,7,8,9}; // 5,7,8,9,12,2,3,4
		findPivotElement(nums);
	}

	private static void findPivotElement(int[] nums) {

		int left=0;
		int right=nums.length-1;
		int mid=0; int pivot=0;
		
		while(left<right) {
			mid=(left+right)/2;
			if(nums[mid]>nums[mid+1]) {
				pivot = nums[mid];
				break;
				}
			else if(nums[mid]>nums[left])
				left = mid + 1;
			else
				right = mid - 1;
		}
		System.out.println(pivot);
	}
}
