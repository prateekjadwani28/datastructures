package com.dsa.array;

import java.util.Collections;
import java.util.PriorityQueue;


public class A03_KthLargest {

	public static void main(String[] args) {

		int nums[] = {9,2,4,1,7,3,8}; // 1 2 3 4 7 8 9
		
		findKthMin(nums,3);
		findKthMax(nums,3);
		
	}

	private static void findKthMin(int[] nums, int k) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < k; i++)
		{
			maxHeap.add(nums[i]);
		}

		for(int i = k; i < nums.length; i++)
		{
			if (nums[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
		}
		System.out.println(maxHeap.peek());
	
		
	}

	private static void findKthMax(int[] nums, int k) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i < k; i++)
		{
			minHeap.add(nums[i]);
		}

		for(int i = k; i < nums.length; i++)
		{
			if (nums[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(nums[i]);
			}
		}
		System.out.println(minHeap.peek());
	}
}
