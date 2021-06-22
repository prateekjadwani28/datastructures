package com.dsa.searchingsorting;

public class SS09_AdjacentElementIndex {

	public static void main(String[] args) {

		int nums[] = {5,6,7,10,11,13,14,16};

		findIndexOfElement(nums,2,13);
		findIndexOfElementByAbhi(nums,2,13);
	}
	// 5 7 9 11
	private static void findIndexOfElement(int[] nums, int k, int num) {
		int i=0;
		while(i<nums.length) {
			if(nums[i] == num)
				break;
			int diff = Math.abs(num - nums[i]);
			i =  i +  Math.max(1, diff/k);
		}
		System.out.println("Element found at index : " +i);
	}

	// 5 7 9 11 13 15 17 
	private static void findIndexOfElementByAbhi(int[] array, int k, int num) {
		int i = 0;
		int answer = 0;
		while(i < array.length) {
			if(array[i] == num) {
				answer = i;
				break;
			}
			int y = Math.max(1, Math.abs(array[i] - num)/k); // To keep track of next iterative steps to get x with atmost adjacent difference k.
			i = i + y;
		}
		System.out.println(answer);
	}
}