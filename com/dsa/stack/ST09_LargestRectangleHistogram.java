package com.dsa.stack;

import java.util.Stack;

public class ST09_LargestRectangleHistogram {

	public static void main(String[] args) {

		int heights[] = {2,1,5,6,2,3};
		findLargestArea(heights,heights.length);
	}

	private static void findLargestArea(int[] heights, int length) {

		int left [] = new int[length];
		int right [] = new int[length];
		
		Stack<Integer> stack = new Stack<>();
		
		//We need to find the width and for that we will find the left point of width and right point of width
		for(int i=0; i<length; i++) {
			if(stack.isEmpty()) {
				left[i] = 0;
				stack.push(i);
			}
			else {
				
				while(!stack.isEmpty() && heights[stack.peek()] >=heights[i])
					stack.pop();
				if(stack.isEmpty())
					left[i] = 0;
				else 
					left[i] = stack.peek() + 1;
				stack.push(i);
			}
		}
		
		//
		while(!stack.isEmpty())
			stack.pop();
		
		//
		for(int i=length-1; i>=0; i--) {
			if(stack.isEmpty()) {
				right[i] = length-1;
				stack.push(i);
			}
			else {
				
				while(!stack.isEmpty() && heights[stack.peek()] >=heights[i])
					stack.pop();
				if(stack.isEmpty())
					right[i] = length-1;
				else
					right[i] = stack.peek() - 1;
				stack.push(i);
			}
		}
		
		//after getting the all the possible widths, we would calculate the max area 
		int maxArea = 0;
		for(int i=0;i<heights.length;i++)
			maxArea = Math.max(maxArea, heights[i] * (right[i] - left[i] + 1));
		
		System.out.println("Largest area of a rectangle in histogram is : "+maxArea);
	}
}
