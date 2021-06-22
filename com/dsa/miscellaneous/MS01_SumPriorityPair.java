package com.dsa.miscellaneous;

import java.util.LinkedHashMap;
import java.util.Map;

public class MS01_SumPriorityPair {

	public static void main(String[] args) {

		int nums[] = {1,2,4,7,11,6,8,14};
		findSumPair(nums,10);
	}

	private static void findSumPair(int[] nums, int k) {

		Map<Integer,Integer> map = new LinkedHashMap<>();
		int complement = 0;
		for(int i=0;i<nums.length;i++) {
			
			complement = k - nums[i];
			if(map.containsKey(complement)) {
				System.out.println("Pair is : " + complement +" and " +nums[i]);
				return;
			}
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		} 
	}
}
