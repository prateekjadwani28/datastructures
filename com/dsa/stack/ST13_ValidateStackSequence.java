package com.dsa.stack;

import java.util.Stack;

public class ST13_ValidateStackSequence {

	public static void main(String[] args) {

		int pushed[] = {1,2,3,4,5};
		int popped[] = {4,5,3,1,2}; // 4 3 5 1 2
		
		System.out.println(" Stack sequences are valid : "+validateSequence(pushed,popped));
	}

	// greedy approach
	private static boolean validateSequence(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for(int num : pushed) {
			stack.push(num);
			while(!stack.isEmpty() && stack.peek() == popped[j]) {
				stack.pop();
				j++;
			}
		}
		return j==pushed.length;
	}
}
