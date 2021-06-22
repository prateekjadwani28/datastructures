package com.dsa.array;

public class A23_MaxProductSubArray {

	public static void main(String[] args) {

		int nums[] = {6, -3, -10, 0, 2};
		findProductWithOnePass(nums);
		findProductWithTwoPass(nums); // -1, -2, -3, 4
	}

	private static void findProductWithTwoPass(int[] nums) {

		int maxProduct = 0, currentProduct = 1;

		for(int i=0;i<nums.length;i++) {

			currentProduct = currentProduct * nums[i]; 
			maxProduct = Math.max(maxProduct, currentProduct);
			if(currentProduct==0)
				currentProduct=1;
		}
		currentProduct = 1;
		
		for(int i=nums.length-1;i>=0;i--) {

			currentProduct = currentProduct * nums[i];
			maxProduct = Math.max(maxProduct, currentProduct);
			if(currentProduct==0)
				currentProduct=1;
		}

		System.out.println(maxProduct);
	}

	//6, -3, -10, 0, 2
	private static void findProductWithOnePass(int[] nums) {

		int min = nums[0],max=nums[0],product=nums[0];
		for(int i=1;i<nums.length;i++) {

			if(nums[i] < 0) {
				int temp = min;
				min = max;
				max = temp;
			}
			max = Math.max(nums[i], max*nums[i]);
			min = Math.min(nums[i], min*nums[i]);

			if(max>product)
				product = max;
		}

		System.out.println(product);
	}

}
