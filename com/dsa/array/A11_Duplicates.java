package com.dsa.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A11_Duplicates {

	public static void main(String[] args) {

		int nums[] = {3,1,5,2,3};
		/*findDuplicatesBySorting(nums);
		System.out.println();
		findDuplicatesByHashing(nums);
		System.out.println();
		*/
		findDuplicatesByIndexing(nums,nums.length);
	}

	/* This solution is only for the array having elements as N + 1 integers 
	 * where N is the length of an array
	 * */

	private static void findDuplicatesByIndexing(int[] array,int length) {
		int repeat = 0;
		for(int i=0; i < length; i++) {
			if(array[Math.abs(array[i]) - 1] < 0) {
				repeat = Math.abs(array[i]);
			}
			else {
				array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1];
			}
		}
		System.out.println("The duplicate number is : "+repeat);
	}



	private static void findDuplicatesBySorting(int[] nums) {
		Arrays.sort(nums);
		int count=0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] == nums[i+1] && count<1) {
				System.out.print(nums[i]+" ");
				count++;
			}
			else
				count=0;
		}
	}

	/*
	 * This is a generic solution to find duplicates without any restrictions on array/elements
	 * 
	 */
	private static void findDuplicatesByHashing(int[] nums) {

		Map<Integer,Integer> map = new HashMap<>();

		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {

			int i = (int) entry.getValue();
			if(i > 1)
				System.out.print(entry.getKey()+" ");
		}
	}
}
