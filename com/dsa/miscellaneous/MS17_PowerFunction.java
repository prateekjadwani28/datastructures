package com.dsa.miscellaneous;

public class MS17_PowerFunction {

	public static void main(String[] args) {
		
		int num = 4;
		int n = -3;
		
		System.out.println("The "+n+" power of number "+num+" is "+findPowerUtil(num,n));
	}

	// if a number is positive then we will multiply it to n times, and if a number is negative we will multiply the number n positive times and divide it by 1
	private static double findPowerUtil(int num, int n) {
		
		if(n > 0)
			return findPower(num,n);
		else
			return 1/findPower(num,Math.abs(n));
	}

	// we will try to make even sets of num, so when n is odd then we will send num * power * power
	private static double findPower(int num, int n) {
		
		if(n==0)
			return 1;
		
		double power = findPower(num, n/2);
		if(n%2 == 0)
			return power * power;
		else
			return num * power * power;
			
	}

}
