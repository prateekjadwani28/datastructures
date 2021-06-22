package com.leet.array;

public class A26_FindRange {

	public static void main(String[] args) {
		
		int nums[] = {5,7,7,8,8,8,8,10};
		
		findRangeOfNumber(nums, 8);
	}

	private static void findRangeOfNumber(int[] nums , int k) {
		int i = 0;
		int j = nums.length - 1;
		int mid = 0;
		
		while(i<j) {
			mid = (i+j)/2;
			
			if(nums[mid] == k)
				break;
			else if(k < nums[mid])
				j = mid - 1;
			else
				i = mid + 1;
		}
		
		int leftRange = 0;
		int rightRange = 0;
		
		for(int x=mid;x<nums.length;x++) {
			if(nums[x]!=k) 
				break;
			rightRange = x;
		}
		
		for(int y=mid;y>=0;y--) {
			if(nums[y]!=k) 
				break;
			leftRange = y;
		}
		
		System.out.println("The range of number : "+k+ " is --> ["+leftRange+","+(rightRange)+"]");
	}
}
