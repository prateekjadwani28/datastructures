package com.leet.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A15_ContainsDuplicate {

	public static void main(String[] args) {

		int [] nums = {2,1,3,4,5,3,2,1,5};
		
		containsDuplicateUsingHash(nums);
		containsDuplicateUsingSorting(nums);
	}

	private static void containsDuplicateUsingSorting(int[] nums) {

		Arrays.sort(nums);
		
		for(int i=0;i<nums.length;i++) {
			
			if(i+1 < nums.length && nums[i] == nums[i+1]) {
				System.out.println("Sorting --> Array contains duplicate elements");
				break;
			}
		}
	}

	private static void containsDuplicateUsingHash(int[] nums) {

		Set<Integer> set = new HashSet<>();
		
		for(int i : nums) {
			
			if(set.contains(i)) {
				System.out.println("Hashing --> Array contains duplicate elements");
				break;
			}
			set.add(i);
		}
	}
}
