package com.dsa.array;

import java.util.HashSet;
import java.util.Set;

public class A21_SubArrayWithSumZero {

	public static void main(String[] args) {

		int nums[] = {4,2,-12,1,6,5};
		findSubarrayByBruteForce(nums);
		findSubarrayByHashing(nums);
	}

	private static void findSubarrayByHashing(int[] nums) {

		Set<Integer> set = new HashSet<>();
		int sum = 0;
		boolean flag = false;
		for(int i=0;i<nums.length;i++) {
			
			sum+=nums[i];
			
			if(sum==0 || nums[i]==0 || set.contains(sum)) {
				flag = true;
				break;
			}
			set.add(sum);
		}
		System.out.println(flag);
	}

	private static void findSubarrayByBruteForce(int[] nums) {
		
		boolean flag=false;
		for(int i=0;i<nums.length;i++) {
			int sum=0;
			for(int j=i;j<nums.length;j++) {
				sum+=nums[j];
				if(sum==0) {
					flag=true;
					break;
				}
			}
		}
		System.out.println(flag);
	}

}
