package com.dsa.array;

import java.util.Arrays;

public class A34_PalindromeArray {

	public static void main(String[] args) {

		int nums[] = {55,222,333,12,44,55};
		
		isElementArrayPallindromed(nums);
		findMinimumToMakePallindrome(nums);
		
	}
	
	private static void findMinimumToMakePallindrome(int[] nums) {
		
		int i=0,j=nums.length-1;
		
		int count=0;
		while(i<=j) {
			
			if(nums[i] == nums[j]) {
				i++;
				j--;
			}
			else if(nums[i]>nums[j]) {
				j--;
				nums[j] = nums[j] + nums[j+1];
				count++;
			}
			else {
				i++;
				nums[i] = nums[i] + nums[i-1];
				count++;
			}
		}
		System.out.println(Arrays.toString(nums));
		System.out.println("Minimum operations required to make an array palindrome : "+count);
	}

	// 1*100 + 1*10  + 1*1

	private static void isElementArrayPallindromed(int[] nums) {

		boolean flag = true;
		for(int i=0;i<nums.length;i++) {
			
			int num = nums[i];
			int sum = 0;
			while(num!=0) {
				sum = sum*10 + num%10;
				num= num/10;
			}
			if (sum != nums[i])
				flag = false;
		}
		
		System.out.println(flag);
	}

}
