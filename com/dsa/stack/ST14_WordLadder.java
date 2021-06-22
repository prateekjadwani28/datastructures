package com.dsa.stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ST14_WordLadder {

	public static void main(String[] args) {

		String beginWord = "hit";
		String endWord = "cog";
		
		Set<String>wordList =new HashSet<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		
		System.out.println(findShortestChainLength(wordList,beginWord,endWord));
	}
	
	// hit --> hot --> dot --> dog --> cog
	private static int findShortestChainLength(Set<String> wordList, String beginWord, String endWord) {
		
		if(!wordList.contains(endWord))
			return 0;
		int level = 0;
		
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		
		while(!queue.isEmpty()) {
			
			level = level + 1;
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				
				char[] curr = queue.peek().toCharArray();
				queue.poll();
				
				for(int j=0;j<curr.length;j++) {
					// Retain the original character
	                // at the current position
	                char orig_char = curr[j];
					
					for(char c ='a';c<'z';c++) {
						
						curr[j] = c;
						if(String.valueOf(curr).equals(endWord))
							return level + 1;
						
						if(!wordList.contains(String.valueOf(curr)))
							continue;
						
						wordList.remove(String.valueOf(curr));
						queue.add(String.valueOf(curr));
					}
					
					// Restore the original character
	                // at the current position
	                curr[j] = orig_char;
				}
			}
		}
		return 0;
	}

}
