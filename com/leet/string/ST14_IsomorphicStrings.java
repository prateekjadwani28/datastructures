package com.leet.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ST14_IsomorphicStrings {

	public static void main(String[] args) {

		String s1 = "badc";
		String s2 = "tata";

		System.out.println(AreIsomorphic(s1,s2));
	}
	// a==x b==y
	private static boolean AreIsomorphic(String s, String t) {
		int[] mappingDictStoT = new int[256];
		Arrays.fill(mappingDictStoT, -1);

		int[] mappingDictTtoS = new int[256];
		Arrays.fill(mappingDictTtoS, -1);

		for (int i = 0; i < s.length(); ++i) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			// Case 1: No mapping exists in either of the dictionaries
			if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
				mappingDictStoT[c1] = c2;  
				mappingDictTtoS[c2] = c1;
			}

			// Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
			// it doesn't match in either of the dictionaries or both 
			else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
				return false;
			}
		}

		return true;
	}

}
