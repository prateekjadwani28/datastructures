package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MS26_RandomSongs {

	public static void main(String[] args) {
		List<String> songs = new ArrayList<>();
		songs.add("Mere Sohneya");
		songs.add("Bekhayali");
		songs.add("Kaise Hua");
		songs.add("Pehla Pyaar");
		songs.add("Tera Ban Jaunga");
		songs.add("Yeh Aaina");
		songs.add("Tujhe Kitna Chahien Aur Hum");
		
		findNextSong(songs);
	}

	private static void findNextSong(List<String> songs) {
		Random random = new Random();
		
		for(int index = 0; index<songs.size();) {
			int secondIndex = random.nextInt(songs.size());
			swap(index,secondIndex,songs);
			break;
		}
		for(int i=0; i<songs.size(); i++) {
			
			if(i < songs.size() - 1)
				System.out.print(songs.get(i) + " , ");
			else
				System.out.print(songs.get(i));
		}
		System.out.println();
		System.out.println("Current Song Playing : "+songs.get(0));
	}

	private static void swap(int index, int secondIndex, List<String> songs) {
		
		String firstSong = songs.get(index);
		String secondSong = songs.get(secondIndex);
		
		songs.set(secondIndex,firstSong);
		songs.set(index, secondSong);
	}

}
