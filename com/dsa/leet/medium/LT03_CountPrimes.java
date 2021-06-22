package com.dsa.leet.medium;

public class LT03_CountPrimes {

	public static void main(String[] args) {

		int num = 22;
		findAllPrimes(num);
	}

	private static void findAllPrimes(int num) {
		
		if(num<=1)
			return;
		
		boolean[] primes  = new boolean[num+1];
		
		// No need to travel till num because a number can be represented by two 
		// as product of two numbers : one of the number will be smaller than
		// sqrt of n and other will be greater than sqrt n
		// Ex : 22 = 2*11 
		//Sqrt(22) = 4 --> 2 is < than 4 and 11 is > than 4
		// so now we will traverse till sqrt of num and mark all of its multiple as NP
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(!primes[i]) {
				// marking all multiple of i as not prime
				// elements are marked from i*i because before that the numbers will 
				// already be marked by other multiples
				// Ex : 10 15 20 will get marked by 2 and 3, so for 5 will start directly from 25
				for(int j=i*i; j<=num; j=i+j)
					primes[j] = true;
			}
		}
		
		for(int i=2; i<primes.length;i++)
			if(!primes[i])
				System.out.print(i +" ");
	}

}
