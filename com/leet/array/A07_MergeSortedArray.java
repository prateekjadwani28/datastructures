package com.leet.array;

import java.util.Arrays;

public class A07_MergeSortedArray {

	public static void main(String[] args) {

		int nums1[] = {2,0,0,0};
		int m = 1;
		int nums2 [] = {1,3,5};

		mergeSortedArray(nums1,m,nums2,nums2.length);
	}

	public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
		int len = m+n;

		if(m==0){
			for(int i=0;i<len;i++) {
				nums1[i] = nums2[i];
			}
			return;
		}

		m = m -1 ;
		n = n - 1;

		for(int i=len-1;i>=0;i--){

			if(m>=0 && n>=0 && nums1[m]>nums2[n]){
				nums1[i] = nums1[m];
				m--;
			}
			else if(n>=0){
				nums1[i] = nums2[n];
				n--;
			}
		}
		System.out.println(Arrays.toString(nums1));
	}
}
