package com.dsa.searchingsorting;

// Refer Code Library code.

public class SS07_RepeatingAndMissing {
	
	//int array[] = {2,4,1,2,5};
	public static void repeatingAndMissing(int array[], int length) {
		int repeat = 0;
		int miss = 0;
		
		// Logic for Repeating element
		for(int i=0; i < length; i++) {
			if(array[Math.abs(array[i]) - 1] < 0) {
				repeat = Math.abs(array[i]);
			}
			else {
				array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1]; 
				/*
				 *  2 -4 1 2 5
				 *  2 -4 1 -2 5
				 * -2 -4 1 -2 -5
				 * */
				
			}
		}
		// Logic for Missing element
		for(int j=0; j < array.length; j++) {
			if(array[j] > 0) {
				miss = j + 1;
				break;
			}
		}
		
		System.out.println("Repeated element is :" + repeat);
		System.out.println("Missing element is :" + miss);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int array[] = {2,4,1,2,5};
        int length = array.length;
        SS07_RepeatingAndMissing.repeatingAndMissing(array, length);
	}

}