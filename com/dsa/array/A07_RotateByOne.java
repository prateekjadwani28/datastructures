package com.dsa.array;

import java.util.Arrays;

public class A07_RotateByOne {

	public static void main(String[] args) {
 
		int nums[] = {1,2,3,4,5}; // 2,3,4,5,1 -- 5 4 3 2 1 -- 4 5 1 2 3 -- 3 4 5 1 2
		//rotateArray(nums,7); // right rotation  
		arrayLeftRotate(nums,7);
	}

	private static void rotateArray(int[] nums, int k) {
		
		
		if(k>nums.length)
			k=k%nums.length;
		int n = nums.length;
		
		reverse(nums,0,n-1);
		reverse(nums,0,k-1);
		reverse(nums, k, n-1);
		
		System.out.println(Arrays.toString(nums));
	}
	
	private static void arrayLeftRotate(int[] arr, int d) {
		
		int len = arr.length;
		d = d % len;
		
		reverse(arr,0,len-1);
		reverse(arr,0,len-d-1);
		reverse(arr,len-d,len-1);
		
		System.out.println(Arrays.toString(arr));
	}

	private static void reverse(int[] nums, int i, int j) {

		while(i<j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			
			i++;
			j--;
		}
	}

}
