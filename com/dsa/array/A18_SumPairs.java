package com.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class A18_SumPairs {

	public static void main(String[] args) {

		int nums[] =  {1, 5, 7, 1,5}; 
		/* 1 1 5 5 7 - when we want a pair of numbers whose sum is equivalent to a given number, then we will use two pointer algorithm, 
		it won't provide the duplicate pairs
		*/
		int k = 6;
		findAllPairsUsingMap(nums,k);
	} 
	// [1,2] [5,2] [7,1] 
	private static void findAllPairsUsingMap(int[] nums, int k) {
		Map<Integer,Integer> numsMap = new HashMap<>();
		int count = 0;

		for(int i=0;i<nums.length;i++) {
			int temp = k - nums[i];
			if(numsMap.containsKey(temp)) {

				count = count + numsMap.get(temp); // 1 - 2 - 4
				numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0)+1);
			}
			else
				numsMap.put(nums[i],1);
		}
		System.out.println(numsMap);
		System.out.println(count);
	}

}
