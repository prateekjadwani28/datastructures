package com.dsa.searchingsorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SS10_DifferencePairs {

	public static void main(String[] args) {

		int nums [] = {3,1,8,6,4,9}; // 1,3,4,6,8,9
		findPairWithDifferenceUsingSorting(nums,5);
		findPairWithDifferenceUsingHashing(nums,5);

	}
	// 3==1 || 1==1 || 8==1 || 6==1 || 4==1 || 9==1
	private static void findPairWithDifferenceUsingHashing(int[] nums, int k) {
		System.out.print("The pair with difference "+ k +" : " );
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) 
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

		for(int i=0;i<nums.length;i++) {
			int temp = k + nums[i];
			if(map.containsKey(temp)) {
				System.out.print("("+nums[i] +","+temp +") ");
			}
		}
	}
	// 1 3 4 6 8 9
	private static void findPairWithDifferenceUsingSorting(int[] nums, int k) {

		int i=0,j=1;

		Arrays.sort(nums);
		while(i<nums.length && j<nums.length) {

			if(i!=j && nums[j] - nums[i] == k) {
				System.out.print("The pair with difference "+ k + " :-  "+nums[i] +","+ nums[j]+" ");
				System.out.println();
				i++;
				j++;
			}
			else if(nums[j] - nums[i] < k)
				j++;
			else
				i++;
		}
	}
}
