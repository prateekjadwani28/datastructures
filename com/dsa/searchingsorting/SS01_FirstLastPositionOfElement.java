package com.dsa.searchingsorting;

public class SS01_FirstLastPositionOfElement {

	public static void main(String[] args) {

		int nums [] = {1,3,5,5,5,5,67,123,125};
		findPositions(nums,5);
		findPositionsByOneWay(nums,5);
	}

	private static void findPositionsByOneWay(int[] nums, int k) {
		
		int leftIndex = binarySearch(nums,k,true);
		int rightIndex = binarySearch(nums,k,false);
		
		System.out.println(leftIndex+" "+(rightIndex));
	}

	private static int binarySearch(int[] nums, int k, boolean flag) {

		int left=0;
		int right=nums.length-1;
		int mid=0;
		int res=0;
		while(left<=right) {

			mid = (left+right)/2;

			if(nums[mid]==k) {
				res = mid;
				if(flag)
					right = mid - 1;
				else
					left = mid + 1;
			}
			else if(nums[mid]>k)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return res;
	}

	private static void findPositions(int[] nums, int k) {

		int left=0;
		int right=nums.length-1;
		int mid=0;
		int first=-1,last=-1;

		while(left<right) {

			mid = (left+right)/2;

			if(nums[mid]==k) {
				break;
			}
			else if(nums[mid]>k)
				right = mid - 1;
			else
				left = mid + 1;
		}

		for(int i=0;i<mid;i++) {
			if(nums[i]==k) {
				first = i;
				break;
			}
		}

		for(int i=nums.length-1;i>mid;i--) {
			if(nums[i]==k) {
				last = i;
				break;
			}
		}
		System.out.println(first +" "+last);
	}
}