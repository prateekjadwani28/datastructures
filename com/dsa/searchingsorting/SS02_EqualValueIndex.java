package com.dsa.searchingsorting;

public class SS02_EqualValueIndex {

	public static void main(String[] args) {

		int nums[] = {9,4,3,7,5};
		findIndex(nums);
	}

	private static void findIndex(int[] nums) {

		for(int i=0;i<nums.length;i++) {
			if(nums[i] == i+1)
				System.out.println(i+1);
		}
	}
}
