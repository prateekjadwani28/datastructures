package com.dsa.miscellaneous;

import java.util.Stack;

public class MS30_FindACelebrity {

	public static void main(String[] args) {

		int nums[][] = {{ 0, 0, 1, 0 },
						{ 0, 0, 1, 0 },
						{ 0, 0, 0, 0 },
						{ 0, 0, 1, 0 } }; 

		findCeleb(nums);
	}

	private static void findCeleb(int[][] nums) {

		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < nums.length; i++) {
			stack.push(i);
		}
		
		while(stack.size() >= 2) {
			int i = stack.pop();
			int j = stack.pop();
			
			if(nums[i][j] == 1) { // means i know j ---> i cannot be celebrity
				stack.push(j);
			}
			else { // means j is not known by i ----> j is not celebrity.
				stack.push(i);
			}
		}
		
		int pot = stack.pop();
		
		for(int i = 0; i < nums.length; i++) {
			if(i != pot) {
				if(nums[i][pot] == 0 || nums[pot][i] == 1) {
					System.out.println("No celebrity");
					return;
				}
			}
		}
		
		System.out.println("Celebrity found is : " + pot);
	}

}
