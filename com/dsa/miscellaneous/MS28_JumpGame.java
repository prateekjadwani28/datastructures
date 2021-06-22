package com.dsa.miscellaneous;

public class MS28_JumpGame {

	public static void main(String[] args) {
		int nums[] = {1,1,2,5,2,7,0,0,1,3};
		boolean result = jumpGame(nums);
		System.out.println("Jump game possible : "+result);
	}

	private static boolean jumpGame(int[] nums) {
		int maxReacheable = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(i > maxReacheable)
				return false;
			maxReacheable = Math.max(maxReacheable, nums[i] + i);
			
			if(maxReacheable >= nums.length - 1)
				return true;
		}
		return true;
	}
}
