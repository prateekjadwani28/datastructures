package com.dsa.miscellaneous;

import java.util.Arrays;

public class MS03_MaxPairProduct {

	public static void main(String[] args) {

		int nums [] = {1, -4, 3, 6, -7, 0 }; // -7 -4 0 1 3 6
		//findMaxProductPairUsingSorting(nums);
		System.out.println();
		findMaxProductPairEfficientWay(nums);
	}


	private static void findMaxProductPairUsingSorting(int[] nums) {

		System.out.println("Sorting Technique");
		System.out.println("------------------");
		int n = nums.length;
		Arrays.sort(nums);

		int product1 = nums[0] * nums[1];
		int product2 = nums[n-1] * nums[n-2];

		if(product1>product2) {

			System.out.println("Max Product Pair is : " +nums[0] +","+nums[1]);
			System.out.println("Max Product is : "+ nums[0] * nums[1]);
		}

		else {

			System.out.println("Max Product Pair is : " +nums[n-1] +","+nums[n-2]);
			System.out.println("Max Product is : "+ nums[n-1] * nums[n-2]);
		}

	}

	//{1, -4, 3, 6, -7, 0 }
	private static void findMaxProductPairEfficientWay(int[] nums) {

		System.out.println("Single Traversal Technique");
		System.out.println("---------------------------");

		int n = nums.length;

		if(n < 2) {
			System.out.println("There is no pair available : Array is too short");
			return;
		}

		if(n == 2) {
			System.out.println("Max Product Pair is : " +nums[0] +","+nums[1]);
			System.out.println("Max Product is : "+ nums[0] * nums[1]);
			return;
		}

		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		
		
		for(int i=0;i<n;i++) {
			
			if(nums[i] > firstMax) {
				secondMax = firstMax;
				firstMax = nums[i];
			}
			else if (nums[i] > secondMax)
				secondMax = nums[i];
			
			if(nums[i] < 0 && nums[i] < firstMin) {
				secondMin = firstMin;
				firstMin = nums[i];
			}
			else if(nums[i] < 0 && nums[i] < secondMin)
				secondMin = nums[i];
		}
		
		if(firstMin * secondMin > firstMax * secondMax) {
			System.out.println("Max Product Pair is : " +firstMin +","+secondMin);
			System.out.println("Max Product is : "+ firstMin * secondMin);
		}
		else {
			System.out.println("Max Product Pair is : " +firstMax +","+secondMax);
			System.out.println("Max Product is : "+ firstMax * secondMax);
		}
	}

}
