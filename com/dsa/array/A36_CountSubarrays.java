package com.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class A36_CountSubarrays {

	public static void main(String[] args) {

		int nums[] = {3,4,7,2,-3,1,4,2,-6,4,3,-1};
		countNumberOfSubarrays(nums,7);
	}

	private static void countNumberOfSubarrays(int[] nums, int k) {

		Map<Integer,Integer> map = new HashMap<>();
		int currentSum=0,count=0;
		
		for(int i=0;i<nums.length;i++) {
			
			currentSum = currentSum + nums[i];
			if(currentSum==k)
				count++;
			if(map.containsKey(currentSum-k)) {
				count = count + map.get(currentSum-k);
				map.put(currentSum,map.getOrDefault(currentSum, 0)+1);
				}
			else
				map.put(currentSum, 1);
		}
		System.out.println(count);
	}

}
