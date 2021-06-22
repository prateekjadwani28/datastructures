package com.dsa.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class MS12_PairSumElementPresent {

	public static void main(String[] args) {

		int nums[] = {4,1,6,3,2,5}; // -- 4,1 1,3 1,5 3,2 4,2 
		isSumPairElementPresent(nums); // 1 2 3 4 5 6
	}

	private static void isSumPairElementPresent(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for(int i : nums)
			set.add(i);

		int anchor = 0;
		int explorer = 1;

		while(explorer<nums.length) {

			if(set.contains(nums[anchor] + nums[explorer]))
			{
				System.out.print("["+nums[anchor]+","+nums[explorer]+"] ");
				explorer++;
				anchor++;
			}
			else
				explorer++;

		}
	}

}
