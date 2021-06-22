package com.dsa.leet.medium;

public class LT60_RepeatingNumberIndexes {

	public static void main(String[] args) {

		int nums[] = {1,2,2,6,6,6,6,6,6,6,3,4,7,2,2,2,2,2,9};
		findIndexes(nums,nums.length);
	}

	private static void findIndexes(int[] nums, int n) {
		int count = 1;
		int maxCount = 0;
		int keyNum = 0;
		int endIndex = 0;

		for(int i=0; i<n; i++) {

			if(i+1 < n) {
				if(nums[i] == nums[i+1]){
					count++;
					if(maxCount < count) {
						maxCount = count;
						keyNum = nums[i];
						endIndex = i+1;
					}
				}
				else
					count = 1;
			}
		}
		
		System.out.println("Most Repeated Number : " +keyNum);
		System.out.println("Start Index : " +(endIndex - maxCount + 1));
		System.out.println("End Index : " +(endIndex));
		
	}
}
