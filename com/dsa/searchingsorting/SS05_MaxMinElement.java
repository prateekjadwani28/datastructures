package com.dsa.searchingsorting;

public class SS05_MaxMinElement {

	public static void main(String[] args) {
		int nums[]= {7,3,10,1,8,5,3,11};
		findMaxMin(nums);
	}

	private static void findMaxMin(int[] nums) {

		int min = 0, max = 0, i = 0;

		if(nums.length%2==0)
		{
			if(nums[0] > nums[1]) {
				min = nums[1];
				max = nums[0];
			}
			else {
				min = nums[0];
				max = nums[1];
			}
			i = 2;
		}
		else {
			min = nums[0];
			max = nums[0];
			i = 1;
		}
		
		for(;i<nums.length;i=i+2) {
			
			if(nums[i]>nums[i+1]) {
				if(nums[i]>max)
					max=nums[i];
				if(nums[i+1]<min)
					min=nums[i+1];
			}
			else {
				if(nums[i+1]>max)
					max=nums[i+1];
				if(nums[i]<min)
					min=nums[i];
			}
		}
		
		System.out.println(min +" "+ max);
	}
}
