package com.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A25_SpeficiedOccurenceOfElement {

	public static void main(String[] args) {
		int nums[] = {3,1,2,2,1,2,3,3,2,3,3,3,3,2,3,3,3,4}; // 16
		findOccurenceByHashing(nums,4); // k = 4 --> 16/4 = 4
		System.out.println();
		findOccurenceBySorting(nums,4);
	}

	private static void findOccurenceByHashing(int[] nums, int k) {

		int number = nums.length/k;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			
			if(entry.getValue()>number)
				System.out.print(entry.getKey()+" ");
		}
	}
	
	private static void findOccurenceBySorting(int[] nums, int k) {
		Arrays.sort(nums);
		int currentCount=1;
		boolean temp = true;
		int number = nums.length/k;
		
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] == nums[i+1])
				currentCount++;
			else {
				currentCount=1;
				temp = true;
				
			}
			if(currentCount>number && temp){
				System.out.print(nums[i]+" ");
				temp = false;
			}
		}
	}// 1 1 1 1 1 1 1 2 2 3 3 3 3 4 - 3
}
