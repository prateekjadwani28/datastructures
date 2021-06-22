package com.leet.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ST15_FrequentWords {

	public static void main(String[] args) {

		String s = "Hello How are you I am fine My name is Prateek what is your name I hope you are doing fine";
		
		String str [] = s.split(" ");
		System.out.println(findKthFrequentWord(str,2));
	}

	private static String findKthFrequentWord(String[] strings, int k) {

		Map<String,Integer> map = new HashMap<>();
		
		for(String str : strings) 
			map.put(str, map.getOrDefault(str, 0)+1);
		
		List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list,  new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				String one = ((String)((Map.Entry) o1).getKey()).toLowerCase();
				String two = ((String)((Map.Entry) o2).getKey()).toLowerCase();
				return one.compareTo(two);
			}
		});
		
		Collections.sort(list,  new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				Integer one = (int)((Map.Entry) o1).getValue();
				Integer two = (int)((Map.Entry) o2).getValue();
				return one.compareTo(two);
			}
		});
		
		
		if(list.size() > k) {
			
			for(Map.Entry entry : list) {
				
				if((Integer)entry.getValue() == k) {
					return (String)entry.getKey();
				}
			}
			
		}
			
		return null;
	}

}
