package com.dsa.miscellaneous;

public class MS27_ContainerWithMostWater {

	public static void main(String[] args) {

		int nums[] = {6,4,2,5,4,6,1,3,5};
		System.out.println("Max Area filled with water is : " +findMaxArea(nums));
		
	}

	private static int findMaxArea(int[] nums) {

		int left = 0;
		int right = nums.length - 1;
		int maxArea = 0;
		
		while(left<right) {
			int height = Math.min(nums[left], nums[right]);
			maxArea = Math.max(maxArea, height * (right - left));
			
			if(nums[left] < nums[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}

}
