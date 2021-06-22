package com.dsa.array;

import java.util.Arrays;

public class A12_MergeArrays {

	public static void main(String[] args) {

		int nums1[] = {1,2,4,6,8}; // 1 2 4 6 8 2 3 5 7 -- 1 2 2 3 4 5 6 7 8
		int nums2[] = {2,3,5,7};

		// 1 2 2 3 4 
		// 5 6 7 8
		mergeArraysWithExtraSpace(nums1,nums2);
		System.out.println();
		mergeArrayWithoutExtraSpace(nums1,nums2);
		System.out.println();
	}

	private static void mergeArrayWithoutExtraSpace(int[] nums1, int[] nums2) {

		int i=0,j=0;
		while(i<nums1.length) {

			if(nums1[i]>nums2[j]) {
				int temp=nums1[i];
				nums1[i]=nums2[j];
				nums2[j]=temp;

				Arrays.sort(nums2);
				i++;
			}
			else if(nums1[i]<=nums2[j]) {
				i++;
			}
		}
		System.out.print(Arrays.toString(nums1)+" -- ");
		System.out.print(Arrays.toString(nums2));

	}
	
	public static void mergeArraysWithExtraSpace(int arr1[], int arr2[]) {   
		int length1 = arr1.length;
		int length2 = arr2.length;
		int arr3[] = new int[length1 + length2];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < length1 && j < length2) {
			if(arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				k++;
				i++;
			}
			else {
				arr3[k] = arr2[j];
				k++;
				j++;
			}
			
		}
		while (i < length1) {
			arr3[k++] = arr1[i++];
		}
		while(j < length2) {
			arr3[k++] = arr2[j++];
		}
		
		for(int x=0;x<arr1.length;x++) {
			arr1[x] = arr3[x];
		}
		for(int x=0;x<arr2.length;x++) {
			arr2[x] = arr3[arr1.length+x];
		}

		System.out.print(Arrays.toString(arr1)+" -- ");
		System.out.print(Arrays.toString(arr2));	

		
	}



	private static void mergeArrays(int[] nums1, int[] nums2) {

		int i=0,j=0;

		while(i<nums1.length && j<nums2.length) {

			if(nums1[i] < nums2[j]) {
				System.out.print(nums1[i]+" ");
				i++;
			}
			else if(nums1[i] > nums2[j]) {
				System.out.print(nums2[j]+" ");
				j++;
			}
			else {
				System.out.print(nums1[i]+" ");
				System.out.print(nums2[j]+" ");
				i++;
				j++;
			}
		}

		while(i<nums1.length) {
			System.out.print(nums1[i]+" ");
		}

		while(i<nums2.length) {
			System.out.print(nums2[i]+" ");
		}
	}

}
