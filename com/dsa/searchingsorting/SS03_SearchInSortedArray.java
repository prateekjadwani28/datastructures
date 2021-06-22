package com.dsa.searchingsorting;

public class SS03_SearchInSortedArray {

	public static void main(String[] args) {

		int nums[] = {4,5,6,7,0,1,2};
		searchElement(nums,6);
		// 8,9,10,2,3,4,5
	}

	private static void searchElement(int[] nums,int k) {

		int left = 0;
		int right = nums.length-1;
		int mid=0;
		
		while(left<=right) {
			
			mid = (left+right)/2;
			
			if(nums[mid] == k)
				break;
			else if(nums[left]<=nums[mid]) {
				
				if(nums[left]<=k && k<nums[mid])
					right = mid-1;
				else
					left = mid + 1;
			}
			else {
				
				if(nums[mid]<k && k<=nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		System.out.println(mid);
	}

}
