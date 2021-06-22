package com.dsa.searchingsorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SS12_CountTheTriplets {

	public static void main(String[] args) {

		int nums[] = {5, 1, 3, 4, 7}; // 1 3 4 5 7
		countTheTriplets(nums,12);
	}

	// 1 3 4 5 7 -- [1,3,7] [1,3,4] [1,3,5] [1,4,5] 
	private static void countTheTriplets(int[] nums,int k) {

		Arrays.sort(nums);

		int tripletCount = 0;
		for(int i=0;i<nums.length;i++) {

			int left = i+1;
			int right = nums.length-1;
			while(left<right) {
				if(nums[i] + nums[left] + nums[right]<k) {
					tripletCount = tripletCount + (right-left);
					left++;
				}
				else
					right--;
			}
		}
		System.out.println(tripletCount);
	}
}
