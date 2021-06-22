package com.dsa.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A27_SubArrayOfArray {

	public static void main(String[] args) {

		int nums1[] = {11,1,13,21,3,7}; // 1 3 7 11 21 --1 3 7 11 13 21
		int nums2[] = {22,3,7,1}; // 1 3 7 15 -- 1 3 7 22

		isSubArrayByHashing(nums1,nums2);
		isSubArrayBySorting(nums1,nums2);
	}

	private static void isSubArrayBySorting(int[] nums1, int[] nums2) {

		boolean flag = true;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i=0,j=0;
		while(i<nums1.length && j<nums2.length) {
			
			if(nums1[i]<nums2[j])
				i++;
			else if(nums1[i]==nums2[j]) {
				j++;
				i++;
			}
			else if(nums1[i]>nums2[j]) {
				
				flag = false;
				break;
			}
		}
		if(j<nums2.length)
			flag=false;
		System.out.println(flag);
	}

	private static void isSubArrayByHashing(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		boolean flag = true;
		for(int i=0;i<nums1.length;i++)
			set.add(nums1[i]);

		for(int i=0;i<nums2.length;i++) {
			if(!set.contains(nums2[i]))
				flag = false;
		}
		System.out.println(flag);
	}
}
