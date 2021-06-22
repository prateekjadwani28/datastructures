package com.dsa.array;

import java.util.Arrays;

public class A35_SortedArraysMedian {

	public static void main(String[] args) {

		int nums1 [] = {1,4}; // 1 2  
		int nums2 [] = {2,3,5}; // 3
		
		
		System.out.println();
		findMedianBySorting(nums1,nums2);
	}


	private static void findMedianBySorting(int[] nums1, int[] nums2) {

		int i=0;
		int j=0;
		// 1 2 12 13 15 - 17 26 30 38 45
		while(i<nums1.length && j<nums2.length) {
			
			if(nums1[i]<=nums2[j])
				i++;
			else {
				int temp = nums1[i];
				nums1[i] = nums2[j];
				nums2[j] = temp;
				i++;
				
				Arrays.sort(nums2);
			}
		}
		
		if(nums1.length!=nums2.length) {
			
			if(nums1.length > nums2.length) 
				System.out.println("The median of 2 sorted arrays is : " +nums1[nums1.length - 1]);
			
			else 
				System.out.println("The median of 2 sorted arrays is : " +nums2[0]);
			return;
		}
		
		int median = (nums1[nums1.length-1] + nums2[0])/2;
		System.out.println("The median of 2 sorted arrays is : " +median);
	}

}
