package com.dsa.array;

import java.util.HashMap;
import java.util.Map;

public class A37_LargestSubarrayWithZero {
	
	public static void main(String arg[]) {
		int nums[] = {1,-1,3,2,-2,-8,1,7,10,23};
		findLargestSubarrayWithZero(nums);

	}

	private static void findLargestSubarrayWithZero(int[] nums) {

		int sum = 0,max=0;
		Map<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<nums.length;i++) {
			
			sum = sum+nums[i];
			if(sum==0)
				max = i+1;
			else {
				if(map.containsKey(sum)) {
					max= Math.max(max, i-map.get(sum));
				}
				else
					map.put(sum, i);
			}
		}
		System.out.println(max);
	}
}
