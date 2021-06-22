package com.dsa.stack;

import java.util.Stack;

public class ST06_NextGreaterElement {

	public static void main(String[] args) {

		int nums[] = {11,9,13,21,3};
		findNextGreaterElementUsingBruteForce(nums);
		findNextGreaterElementUsingStack(nums);
	}

	/* whenever in a two loops, if jth is dependent of ith then, it could also be 
	solved with stack*/
	private static void findNextGreaterElementUsingStack(int[] nums) {
		
		Stack<Integer> s = new Stack<>();
		int[] result = new int[nums.length];
		
		for(int i=nums.length-1;i>=0;i--) {
			
			while(!s.empty() && nums[i]>s.peek()) {
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

	private static void findNextGreaterElementUsingBruteForce(int[] nums) {

		for(int i=0;i<nums.length;i++) {
			
			int next = -1;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[j]>nums[i]) {
					next = nums[j];
					break;
				}
			}
			System.out.println("Number : " +nums[i] +" --> " +next);
		}
	}
	
	
}
