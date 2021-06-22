package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MS23_KeysAndRooms {

	public static void main(String[] args) {
		
		List<List<Integer>> mainList = new ArrayList<List<Integer>>();
		
		List<Integer> roomzerolist = new ArrayList<Integer>();
	       roomzerolist.add(1);
	       roomzerolist.add(3);
	       List<Integer> roomonelist = new ArrayList<Integer>();
	       roomonelist.add(3);
	       roomonelist.add(0);
	       roomonelist.add(1);
	       List<Integer> roomtwolist = new ArrayList<Integer>();
	       roomtwolist.add(2);
	       List<Integer> roomthreelist = new ArrayList<Integer>();
	       roomthreelist.add(0);
	       
	       mainList.add(roomzerolist);
	       mainList.add(roomonelist);
	       mainList.add(roomtwolist);
	       mainList.add(roomthreelist);
	       
	       boolean visit = canVisitAllRooms(mainList);
	       System.out.println(visit);
	}

	private static boolean canVisitAllRooms(List<List<Integer>> mainList) {

		Set<Integer> set = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(0);
		set.add(0);
		
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			
			List<Integer> list = mainList.get(temp);
			for(int i : list) {
				if(!set.contains(i)) {
					set.add(i);
					queue.add(i);
				}
			}
		}
		return mainList.size() == set.size();
	}

}
