package com.dsa.array;

public class A13_KadaneAlgo {

	public static void main(String[] args) {

		int nums[] = {1,2,3,-2,5};
		implementKadane(nums);
	}

	private static void implementKadane(int[] nums) {

		int currentSum=0,finalSum=0;
		
		for(int i=0;i<nums.length;i++) {
			
			currentSum = Math.max(currentSum+nums[i], nums[i]);
			finalSum = Math.max(finalSum, currentSum);
		}
		System.out.println(finalSum);
	}

}
