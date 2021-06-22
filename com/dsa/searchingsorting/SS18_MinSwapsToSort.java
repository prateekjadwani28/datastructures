package com.dsa.searchingsorting;

import java.util.Arrays;
import java.util.HashMap;

// Refer Code Library

public class SS18_MinSwapsToSort {
	
	public static int minimumSwapsRequired(int arr[], int length) {
		// 1,5,4,3,2
		int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, length); // Taking temp array.
 
        // Hashmap which stores the
        // indexes of the input array
        HashMap<Integer, Integer> h
            = new HashMap<Integer, Integer>();
 
        Arrays.sort(temp); // 1,2,3,4,5 // temp array sorted. Now compare temp Array with original Array.
        for (int i = 0; i < length; i++) 
        {
            h.put(arr[i], i); // 1 --> 0 , 5 --> 1, 4 --> 2, 3 --> 3, 2 --> 4
        }
        for (int i = 0; i < length; i++) 
        {
 
            // This is checking whether
            // the current element is
            // at the right place or not
            if (arr[i] != temp[i]) 
            {
                ans++;
                int init = arr[i];
 
                // If not, swap this element
                // with the index of the
                // element which should come here
                swap(arr, i, h.get(temp[i]));
 
                // Update the indexes in
                // the hashmap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
		
	}
      
	 public static void swap(int[] arr, int i, int j)
	    {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int array[] = {1,5,4,3,2};
       int length = array.length;
       int swapCount = SS18_MinSwapsToSort.minimumSwapsRequired(array, length);
       System.out.println("Minimum Swaps Required is : " + swapCount);
	}

}