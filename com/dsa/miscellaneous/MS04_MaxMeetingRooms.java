package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MS04_MaxMeetingRooms {

	public static void main(String[] args) {

		int start[] = {1, 3, 0, 5, 8, 5};
		int finish[] = {2, 4, 6, 7, 9, 9};
		
		int n = start.length;
		findMaxMeetings(start,finish,n);
	}


	private static void findMaxMeetings(int[] start, int[] finish, int n) {

		List<Meeting> list = new ArrayList<Meeting>();
		
		for(int i=0;i<n;i++)
			list.add(new Meeting(start[i],finish[i],i+1));
		
		Collections.sort(list, new MeetingComparator());
		System.out.print(list.get(0).pos+" ");
		int limit = list.get(0).end;
		
		for(int i=1;i<n;i++) {
			
			if(list.get(i).start >= limit) {
				limit = list.get(i).end;
				System.out.print(list.get(i).pos+ " ");
			}
		}
	}

}

class Meeting{
	
	int start;
	int end;
	int pos;
	
	
	public Meeting(int start, int end, int pos) {
		super();
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class MeetingComparator implements Comparator<Meeting>{

	@Override
	public int compare(Meeting o1, Meeting o2) {
		Integer i1 = o1.end;
		Integer i2 = o2.end;
		
		if(i1>i2)
			return 1;
		else if(i1<i2)
			return -1;
		else if(o1.pos<o2.pos)
			return -1;
		return 1;
	}
}
