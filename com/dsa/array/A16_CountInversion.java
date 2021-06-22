package com.dsa.array;

public class A16_CountInversion {

	public static void main(String[] args) {

		int nums[] = {3,5,2,1,8,6,4,9};
		countInversions(nums);
	}

	private static void countInversions(int[] nums) {

		int anchor = 0;
		int explorer = 1;
		
		long count = 0;
		while(anchor<nums.length) {
			
			if(explorer < nums.length && nums[anchor] > nums[explorer])
				count++;
			if(explorer > nums.length) {
				anchor++;
				explorer = anchor;
				
			}
			explorer++;
		}
		System.out.println(count);
	}
}
