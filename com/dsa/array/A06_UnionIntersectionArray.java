package com.dsa.array;

public class A06_UnionIntersectionArray {

	public static void main(String[] args) {

		int nums1[] = {1,2,2,3,3,4,5};
		int nums2[] = {3,3,7,8}; // 1,2,3,4,5,7,8

		findUnion(nums1,nums2);
	}

	private static void findUnion(int[] nums1, int[] nums2) {

		int i = 0 , j = 0, unionCount = 0, interCount = 0;

		while(i<nums1.length-1 && j<nums2.length-1) {

			if(nums1[i] == nums1[i+1])
				i++;
			if(nums2[j] == nums2[j+1])
				j++;
			
			if(nums1[i]<nums2[j]) {
				System.out.print(nums1[i]+" ");
				i++;
				unionCount++;
			}
			else if(nums1[i]>nums2[j]) {
				System.out.print(nums2[j]+" ");
				j++;
				unionCount++;
			}
			else {
				System.out.print(nums1[i]+" ");
				i++;
				j++;
				unionCount++;
				interCount++;
				
			}
		}
		while(i<nums1.length) {
			System.out.print(nums1[i]+" ");
			unionCount++;
			i++;
		}
		while(j<nums2.length) {
			System.out.print(nums2[j]+" ");
			unionCount++;
			j++;
		}
		System.out.println();
		System.out.println(unionCount);
		System.out.println(interCount);
	}

}
