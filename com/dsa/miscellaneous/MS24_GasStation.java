package com.dsa.miscellaneous;

public class MS24_GasStation {

	public static void main(String[] args) {

		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int station = calculateGasStation(gas, cost);
		System.out.println(station);
	}

	private static int calculateGasStation(int[] gas, int[] cost) {

		int sum = 0;
		
		for(int i=0;i<gas.length;i++) 
			sum += gas[i] - cost[i];
		
		if(sum<0)
			return -1;
		
		int tankCapacity = 0;
		int start = 0;
		
		for(int i=0;i<gas.length;i++) {
			
			tankCapacity = tankCapacity + gas[i] - cost[i];
			if(tankCapacity < 0) {
				start = i + 1;
				tankCapacity = 0;
			}
		}
		return start;
	}

}
