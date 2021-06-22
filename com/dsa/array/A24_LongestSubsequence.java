package com.dsa.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A24_LongestSubsequence {

	public static void main(String[] args) {

		int nums[] = {1,9,3,7,8,11,10,4,20,2}; // 1 2 3 4 7 8 9 10 11 20

		findLongestSubsequenceByHashing(nums);
		findLongestSubsequenceBySorting(nums);

	}

	private static void findLongestSubsequenceByHashing(int[] nums) {

		Set<Integer> set = new HashSet<>();
		int sequenceCount = 1, currentCount=1;

		for(int i=0;i<nums.length;i++) {
			set.add(nums[i]);
		}

		for(int i=0;i<nums.length;i++) {

			boolean flag = true;
			int temp = nums[i]+1;
			while(flag) {

				if(set.contains(temp)) {
					currentCount++;
					temp++;
				}
				else
					flag = false;
			}
			sequenceCount = Math.max(currentCount, sequenceCount);
			currentCount=1;
		}
		System.out.println(sequenceCount);
	}

	//1 2 3 4 7 8 9 10 11 20
	private static void findLongestSubsequenceBySorting(int[] nums) {

		Arrays.sort(nums);
		int sequenceCount = 1, currentCount=1;

		for(int i=0;i<nums.length-1;i++) {

			if(nums[i+1] - nums[i] == 1) {
				currentCount++;
			}
			else
				currentCount=1;
			sequenceCount = Math.max(sequenceCount, currentCount);
		}
		System.out.println(sequenceCount);
	}

}
