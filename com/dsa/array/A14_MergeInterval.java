package com.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A14_MergeInterval {

	public static void main(String[] args) {

		int [] [] nums = {{6,8}, {1,9}, {2,4}, {4,7}, {11,12}};
		 System.out.println("Final Merged overlap Intervals are : " + Arrays.deepToString(mergeIntervals(nums)));
	}

	
	//1 9 -- 2 4 -- 4 7 -- 6 8 -- 11 
	private static int[][] mergeIntervals(int[][] nums) {

		List<int[]> result = new ArrayList<>();
		if(nums == null || nums.length==0 )
			return result.toArray(new int[0][]);
		
		Arrays.sort(nums,(a,b)-> a[0]-b[0]);
		int start = nums[0][0];
		int end = nums[0][1];
		
		for(int[] i: nums) {
			if(i[0]<=end) {
				end = Math.max(end, i[1]);
			}
			else {
				result.add(new int[] {start,end});
				start = i[0];
				end = i[1];
			}
		}
		result.add(new int[] {start,end});
		
		return result.toArray(new int[0][]);
	}
}
