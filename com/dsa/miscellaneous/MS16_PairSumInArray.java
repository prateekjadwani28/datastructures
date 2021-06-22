package com.dsa.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class MS16_PairSumInArray {

	public static void main(String[] args) {
		
		int nums[] = {4,3,5,6,1,2};
		findPairsUsingSet(nums);
	}

	private static void findPairsUsingSet(int[] nums) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i : nums) {
			set.add(i);
		}
		
		System.out.print("The pairs are : ");
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(set.contains(nums[i]+nums[j]))
					System.out.print(nums[i]+","+nums[j]+" ");
			}
		}
	}
}
