package com.dsa.array;

public class A38_SubarrayWithSumK {

	public static void main(String[] args) {

		int nums[] = {1,4,3,20,2,10,7};
		findSubarray(nums,14);
	}

	private static void findSubarray(int[] nums, int k) {

		int left=0;
		int right=0;
		int sum=0;

		while(left<=nums.length&&right<=nums.length) {

			if(sum == k) {
				System.out.println(left+" "+(right-1));
				break;
			}
			else if(sum<k) {
				sum = sum + nums[right];
				right++;
			}
			else {
				sum = sum - nums[left];
				left++;
			}
		}
	}
}
