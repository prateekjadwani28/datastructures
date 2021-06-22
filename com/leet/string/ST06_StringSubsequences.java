package com.leet.string;

public class ST06_StringSubsequences {

	public static void main(String[] args) {

		String str = "abc";
		printAllSubsequences(str,0,str.length(),"");
	}

	private static void printAllSubsequences(String str, int i, int length, String res) {

		if(i==length)
			System.out.println(res);
		else {
			
			printAllSubsequences(str, i+1, length, res);
			res = res + str.charAt(i);
			printAllSubsequences(str, i+1, length, res);
		}
	}
}
