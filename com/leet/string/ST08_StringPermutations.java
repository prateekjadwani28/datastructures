package com.leet.string;

public class ST08_StringPermutations {

	public static void main(String[] args) {

		String str = "ABC";
		performPermute(str,0,str.length()-1);
	}

	private static void performPermute(String str, int l, int r) {

		if(l == r)
			System.out.println(str);
		else {
			for(int i=l;i<=r;i++) {
				str = swap(str,l,i);
				performPermute(str, l+1, r);
				str = swap(str,l,i);
			}
		}
	}

	private static String swap(String str, int i, int j) {
		char [] tempArray = str.toCharArray();
		char temp = tempArray[i];
		tempArray[i] = tempArray[j];
		tempArray[j] = temp;

		return String.valueOf(tempArray);
	}

}
