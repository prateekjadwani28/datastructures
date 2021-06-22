package com.dsa.miscellaneous;

import java.util.Arrays;

public class MS18_MinimumPlatform {

	public static void main(String[] args) {

		int arrival[] = {120,50,550,200,700,850};
		int depart[] = {600,550,700,500,900,1000};
		
		findMinimumPlatoformsRequired(arrival,depart);
	}

	private static void findMinimumPlatoformsRequired(int[] arrival, int[] depart) {
		
		// 50 120 200 550 700 850
		//500 550 600 700 900 1000
		Arrays.sort(arrival);
		Arrays.sort(depart);
		
		int i = 1;
		int j = 0;
		int platform = 1;
		int maxPlatform = 1;
		
		while(i<arrival.length && j<depart.length) {
			
			if(arrival[i] <= depart[j]) {
				platform++;
				i++;
			}
			else {
				platform--;
				j++;
			}
			
			maxPlatform = Math.max(maxPlatform, platform);
		}
		
		System.out.println("Minimum platforms required are : "+maxPlatform);
	}
}
