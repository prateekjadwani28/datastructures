package com.dsa.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A28_Triplet {

	public static void main(String[] args) {

		int nums[] = {0,-1,2,-3,1,4,3}; // 1,4,6,8,10,45
		System.out.println(findTripletsByHashing(nums,2));
		findTripletsBySorting(nums,2);
	}

	private static boolean findTripletsByHashing(int[] nums, int n) {

		for(int i=0;i<nums.length;i++) {
			int temp = n - nums[i]; //57
			Set<Integer> set = new HashSet<>();

			for(int j=i+1;j<nums.length;j++) {
				if(set.contains(temp-nums[j]))
					return true;
				set.add(nums[j]);
			}
		}
		return false;
	}
	// 1,2,4,6,10,45 - 61
	private static void findTripletsBySorting(int[] nums,int n) {
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++) {

			int l = i+1, r=nums.length-1;

			while(l<r) {
				int triplet = nums[i] + nums[l] + nums[r];
				if(triplet<n)
					l++;
				else if(triplet>n)
					r--;
				else {
					System.out.println("The triplet is : " +nums[i] +" " +nums[l] +" "+nums[r]);
					l++;
					r--;
				}
			}
		}
	}

}
