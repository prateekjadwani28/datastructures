package com.dsa.miscellaneous;

public class MS08_PeakElemenet {

	public static void main(String[] args) {

		int array[]= {3,8,3,9,7,2};
		
		System.out.println(findPeakElement(array));
	}

	private static int findPeakElement(int[] nums) {
		
		int begin=0;
		int end=nums.length - 1;
		int mid=0;
		
		while(begin<end) {
			
			mid=(begin+end)/2;
			if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])
				return mid;
			if(nums[mid]<nums[mid-1])
				end = mid ;
			else
				begin = mid + 1;
		}
		return mid;
	}

}
