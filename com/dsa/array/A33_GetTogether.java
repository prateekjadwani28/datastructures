package com.dsa.array;


public class A33_GetTogether {

	public static void main(String[] args) {

		int nums[] = {2, 1, 5, 6, 3 }; // 2, 7, 9, 5, 8, 7, 4
		bringElementsTogetherByOptimizedApproach(nums,3);
		
	}

	private static void bringElementsTogetherByOptimizedApproach(int[] nums, int k) {

		int good=0,bad=0;
		
		for(int i=0;i<nums.length;i++)
			if(nums[i]<=k)
				good++;
		
		for(int i=0;i<good;i++) 
			if(nums[i]>k)
				bad++;
		
		if(bad == 0) {
			System.out.println("Minimum swaps required to keep elements together is : 0" );
			return ;
		}
			
		// good = 3 and bad = 1 --> create a window of good number of elements i.e. in this case 3 windows slide
		int i=0,j=good-1;
		
		int mi = Integer.MAX_VALUE;
		while(j<nums.length) {
			
			mi = Math.min(mi, bad);
			j++;
			if(j<nums.length && nums[j]>k)
				bad++;
			if(nums[i]>k)
				bad--;
			i++;
		}
		System.out.println("Minimum swaps required to keep elements together is : " +mi);
	}
}
