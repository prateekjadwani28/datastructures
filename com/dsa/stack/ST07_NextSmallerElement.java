package com.dsa.stack;

import java.util.Stack;

public class ST07_NextSmallerElement {

	public static void main(String[] args) {

		int nums[] = {13,7,6,12};
		//findNextGreaterElementUsingBruteForce(nums);
		findNextSmallerElementUsingStack(nums);
	}

	private static void findNextSmallerElementUsingStack(int[] nums) {
		
		Stack<Integer> s = new Stack<>();
		int[] result = new int[nums.length];
		
		for(int i=nums.length-1;i>=0;i--) {
			
			while(!s.empty() && nums[i]<s.peek()) {
				s.pop();
			}
			if(s.empty())
				result[i] = -1;
			else
				result[i] = s.peek();
			
			s.push(nums[i]);
		}
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}
}
