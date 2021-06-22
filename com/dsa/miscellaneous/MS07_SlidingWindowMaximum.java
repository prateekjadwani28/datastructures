package com.dsa.miscellaneous;

import java.util.Collections;
import java.util.PriorityQueue;

public class MS07_SlidingWindowMaximum {

	public static void main(String[] args) {

		int nums[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		// 3 3 5 5 6 7 -- 5 5 6 7
		findMaximumSlidingWindow(nums,k);
	}

	private static void findMaximumSlidingWindow(int[] nums, int k) {

		 PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		int i = 0;
		for(;i<k;i++) 
			maxHeap.add(nums[i]);
		
		System.out.print(maxHeap.peek()+" ");
		maxHeap.remove(nums[0]);
		
		for(;i<nums.length;i++) {
			
			maxHeap.add(nums[i]);
			System.out.print(maxHeap.peek()+" ");
			maxHeap.remove(nums[i-k+1]);
		}
			
	}
}
