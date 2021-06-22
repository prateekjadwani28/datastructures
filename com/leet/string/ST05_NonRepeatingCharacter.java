package com.leet.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class ST05_NonRepeatingCharacter {

	public static void main(String[] args) {

		String s = "geeksforgeeks";
		findNonRepeatingCharacterByHashing(s);
		findNonRepeatingCharacterByCountArray(s);
	}

	private static void findNonRepeatingCharacterByCountArray(String str) {

		int temp [] = new int[256];
		
		for(int i = 0; i<256; i++)
	        temp[i] = -1;
		
		for(int i = 0; i<str.length(); i++) {
	        if(temp[str.charAt(i)] == -1) {
	        	temp[str.charAt(i)] = i;
	        }else {
	        	temp[str.charAt(i)] = -2;
	        }
	    }
	 
	    int res =  Integer.MAX_VALUE;
	    
	    for(int i = 0; i<256; i++) {
	    	 
	        // If this character is not -1 or -2 then it
	        // means that this character occured only once
	        // so find the min index of all characters that
	        // occur only once, that's our first index
	        if(temp[i] >= 0)
	            res = Math.min(res, temp[i]);
	    }
	    
	    if(res ==  Integer.MAX_VALUE) {
	    	System.out.println("No repeating character present");
	    }
	    else {
	    	System.out.println("The first non repeating character is : " +str.charAt(res));
	    	
	    }
		
	}

	private static void findNonRepeatingCharacterByHashing(String s) {

		Map<Character,Integer> map = new LinkedHashMap<>();
		
		for(int i=0;i<s.length();i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		
		for(Map.Entry entry : map.entrySet()) {
			if((int)entry.getValue() == 1) {
				System.out.println("The first non repeating character is : " +entry.getKey());
				return;
			}
		}
	}

}
