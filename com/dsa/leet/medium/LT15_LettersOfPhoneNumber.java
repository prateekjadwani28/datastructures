package com.dsa.leet.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LT15_LettersOfPhoneNumber {

	public static void main(String[] args) {

		String digits = "23";
		Map<Character,String> map = new HashMap();
		map.put('1', "1");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		List<String> ans = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		findCombinationLetters(digits,0,ans,sb,map);
		
		System.out.println(ans);
	}

	private static void findCombinationLetters(String digits, int i, List<String> ans, StringBuilder sb,
			Map<Character, String> map) {
		if(i == digits.length()) {
			ans.add(sb.toString());
			return;
		}

		String current = map.get(digits.charAt(i));
		for(int k=0; k<current.length(); k++) {
			
			sb.append(current.charAt(k));
			findCombinationLetters(digits, i+1, ans, sb, map);
			sb.deleteCharAt(sb.length()-1);
		}
	}

}
