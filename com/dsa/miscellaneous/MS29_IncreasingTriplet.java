package com.dsa.miscellaneous;

public class MS29_IncreasingTriplet {

	public static void main(String[] args) {

		int nums[] = {5, 7, 4, 8};
		findIncreasingTriplet(nums);
	}

	private static void findIncreasingTriplet(int[] nums) {

		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		int i;

		for(i = 0; i < nums.length; i++) 
			if(nums[i] <= first) 
				first = nums[i];
			else if(nums[i] <= second) 
				second = nums[i];
			else 
				break;
			

		if(nums.length == i) {
			System.out.println("No Triplet");
			return ;
		}

		for (int j = 0; j <= i; j++){
			if (nums[j] < second){
				first = nums[j];
				System.out.print(first+" "+second+" "+ nums[i]);
				break;
			}
		}
		return;
	}
}
