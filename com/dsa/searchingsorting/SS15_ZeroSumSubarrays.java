package com.dsa.searchingsorting;

import java.util.HashMap;
import java.util.Map;

public class SS15_ZeroSumSubarrays {

	public static void main(String[] args) { 	

		int nums[] = {0,0,5,5,0,0,-5,5}; //{6,-1,-3,4,-2,2,4,6,-12,-7}
		
		printAllZeroSumSubarrays(nums);
	}
	// 0==2 5==2 10==3
	private static void printAllZeroSumSubarrays(int[] nums) {

		int currentSum = 0;
		int count = 0;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			
			currentSum = currentSum + nums[i];
			if(currentSum==0)
				count++;
			if(map.containsKey(currentSum)) {
				count = count + map.get(currentSum);
				map.put(currentSum, map.getOrDefault(currentSum, 0)+1);
			}
			else
				map.put(currentSum, 1);
		}
		System.out.println(count);
	}

}
