package com.dsa.array;

public class A29_TrappingRainWater {

	public static void main(String[] args) {

		int nums[] = {4,2,0,6,2,3,5};
		findMaximumTrappedWaterByEfficientWay(nums);
	}

	private static void findMaximumTrappedWaterByEfficientWay(int[] nums) {
		
		int n = nums.length;
		int left = 0;
		int right = n - 1; 
		int leftMax = nums[0];
		int rightMax = nums[n-1];
		int trappedWater = 0;
		
		while(left < right) {
			if(nums[left] <= nums[right]) {
				if(leftMax < nums[left])
					leftMax = nums[left];
				else
					trappedWater = trappedWater + leftMax - nums[left];
				left++;
			}
			else {
				if(rightMax < nums[right])
					rightMax = nums[right];
				else
					trappedWater = trappedWater + rightMax - nums[right];
				right--;
			}
		}
		System.out.println("Trapped Water Qty is : "+trappedWater);
	}
}
