package com.dsa.array;

import java.util.Arrays;

// Program to find Next Permutation from given integers of an array.
// Refer take u forward for detail explanation

public class A15_NextPermutation {
	
	public static void nextPermutation(int nums[]) {
		//1,3,5,4,2
		int k = nums.length - 2; // Here we have taken length -2 bcz we are comparing it with its previous element. Below condition nums[k] > nums[k+1]
		while(k>=0 && nums[k]>=nums[k+1]) { // Now here we are traversing till we get breakpoint that is arr[i] < arr[i+1]
			k--;
		}
		if(k == -1) {
			reverse(0,nums.length-1,nums);
			System.out.println("Required next permutation is : " + Arrays.toString(nums));
			return;
		}
		for(int i=nums.length - 1; i>k; i--) {
			if(nums[i]>nums[k]) {
				int temp = nums[i];
				nums[i] = nums[k];
				nums[k] = temp;
				break;
			}
		}
		
		reverse(k+1, nums.length - 1, nums);
		System.out.println("Required next permutation is : " + Arrays.toString(nums));
	}
  
	public static void reverse(int left, int right, int nums[]) {
		while(left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //int nums[] = {2,3,1};
        //int nums[] = {1,5,1};
		int nums[] = {1,3,5,4,2};
        A15_NextPermutation.nextPermutation(nums);
	}

}