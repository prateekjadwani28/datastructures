package com.dsa.searchingsorting;

//Refer Tushar Roy code
//Incl = Max sum till any particular point including that element.(current element may or may not be included)
//Excl = Max sum till any particular point excluding that element.

public class SS12_MaxSumWithNoAdjacents {
	
	// 4,1,1,4,2,1
	public static int maxSum(int array[], int length) {
		int incl = array[0]; // Assigning first element as incl
		int excl = 0;
		for(int i=1; i < length; i++) {
			int temp = incl;
			incl = Math.max(incl, excl + array[i]);
			excl = temp;
		}
		
		return incl;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {4,1,1,4,2,1};
		int length = array.length;
		int maxElement = SS12_MaxSumWithNoAdjacents.maxSum(array, length);
     System.out.println("Max Sum of not adjacent elements is : " + maxElement);
	}

}
