package com.dsa.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ST10_SlidingWindowMaximum {

	public static void main(String[] args) {

		int nums [] = {31,10,11,9,7,10,19}; 
		int k = 3;
		// 31 11 
		//findMaxArrayUsingBruteForce(nums,k); 7-3+1= 5
		System.out.println(Arrays.toString(nums));
		System.out.println();
		findMaxArrayUsingQueue(nums,k);
	}

	 // A Dequeue (Double ended queue)
    // based method for printing
    // maximum element of
    // all subarrays of size k
    static void findMaxArrayUsingQueue(int arr[], int k)
    {
         
        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();
 
        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < k; ++i)
        {
            
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[Qi.peekLast()]<=arr[i])
               
                // Remove from rear
                Qi.removeLast();
 
            // Add new element at rear of queue
            Qi.addLast(i);
        }
 
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < arr.length; ++i)
        {
         
            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            System.out.print(arr[Qi.peek()] + " ");
 
            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <=
                                             i - k)
                Qi.removeFirst();
 
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                              arr[Qi.peekLast()])
                Qi.removeLast();
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
 
        // Print the maximum element of last window
        System.out.print(arr[Qi.peek()]);
    }


	private static void findMaxArrayUsingBruteForce(int[] nums, int k) {

		int max = 0;
		for(int i=0;i<=nums.length-k;i++) {
			
			max=nums[i];
			for(int j=0;j<k;j++) {
				if(nums[i+j] > max)
					max = nums[i+j];
			}
			System.out.print(max+" ");
		}
	}
}
