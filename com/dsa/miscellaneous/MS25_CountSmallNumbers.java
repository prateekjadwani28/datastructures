package com.dsa.miscellaneous;

import java.util.Stack;

public class MS25_CountSmallNumbers {

	public static void main(String[] args) {

		int nums[] = {5,2,6,1};
		countSmallNumbersThanSelf(nums,nums.length);
	}

	private static void countSmallNumbersThanSelf(int[] nums, int length) {

		Stack<Integer> stack = new Stack<>();
		int result[] = new int[length];

		for(int i=length-1;i>=0;i--) {
			int count = 0;
			int end = 0;
			while(!stack.isEmpty() && stack.peek() < nums[i] && end!=stack.size()) {
				count++;
			}
			if(stack.empty())
				result[i] = 0;
			else
				result[i] = count;

			stack.push(nums[i]);
		}

		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}

}
