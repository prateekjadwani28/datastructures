package com.dsa.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class MS06_MinimumWindowSubstring {

	public static void main(String[] args) {

		String s = "TOTMTAPTAT";
		String t = "TTA";

		System.out.println(findMinimumWindow(s,t));
	}

	// T==2 A==1
	private static String findMinimumWindow(String s, String t) {

		String ans = "";
		Map<Character,Integer> map2 = new HashMap<>();

		for(Character ch : t.toCharArray())
			map2.put(ch, map2.getOrDefault(ch, 0)+1);

		int mct = 0; // match count
		int dmct = t.length(); // desired match count

		//TOTMTAPTAT
		Map<Character,Integer> map1 = new HashMap<>();
		int i = 0;
		int j = 0;

		while(true) {

			boolean flag1 = false;
			boolean flag2 = false;

			//acquire
			while(j<s.length() && mct < dmct) {
				
				// Adding characters of first string to a map
				char ch = s.charAt(j);
				map1.put(ch, map1.getOrDefault(ch, 0)+1);

				// If current element is present in the second string's map, then that is a valid one and increase match count
				// don't need to bother about the extra elements as it would not be an add on to the match count 
				if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0))
					mct++;

				flag1 = true;
				j++;
			}
			
			//collect answers and release
			//TOTMTAPTAT
			while(i<j && mct==dmct) {
				
				// getting a new shorten string and storing it as answer
				String temp = s.substring(i,j);
				if(ans.length()==0 || temp.length() < ans.length())
					ans = temp;
				
				//now the element from the start of the window, we need to remove it from the window to check if we any another smallest window containing all characters
				// remove it from the map if it has only element else decrement its count
				char ch = s.charAt(i);
				if(map1.get(ch) == 1)
					map1.remove(ch);
				else
					map1.put(ch, map1.get(ch)-1);
				
				// if we have eliminated a character which was a part of the second string then decrement the match count 
				if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0))
					mct--;
				flag2 = true;
				i++;
				
			}
			if(flag1==false && flag2==false)
				break;
		}
		return ans;
	}
}
