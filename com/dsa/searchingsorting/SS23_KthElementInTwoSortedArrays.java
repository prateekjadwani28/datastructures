package com.dsa.searchingsorting;

public class SS23_KthElementInTwoSortedArrays {

	public static void main(String[] args) {

		int arr1[] = {100, 112, 256, 349, 770};
		int arr2[] = {72, 86, 113, 119, 265, 445, 892};
		
		findKthElement(arr1,arr2,8);
	}

	private static void findKthElement(int[] arr1, int[] arr2, int k) {

		int i=0;
		int j=0;
		
		int index=0;
		while(i<arr1.length && j<arr2.length) {
			
			if(arr1[i]<arr2[j]) { 
				index++;
				if(index==k) {
					System.out.println("The "+ k +"th element is : " +arr1[i]);
					break;
				}
				i++;
			}
			else {
				index++;
				if(index==k) {
					System.out.println("The "+ k +"th element is : " +arr2[j]);
					break;
				}
				j++;
			}
		}
		
		while(i<arr1.length) {
			index++;
			if(index==k)
				System.out.println("The "+ k +"th element is : " +arr1[i]);
			i++;
		}
		
		while(j<arr2.length) {
			index++;
			if(index==k)
				System.out.println("The "+ k +"th element is : " +arr2[j]);
			j++;
		}
	}

}
