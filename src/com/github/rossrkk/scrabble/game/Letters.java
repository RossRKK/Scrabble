package com.github.rossrkk.scrabble.game;

import java.util.ArrayList;
import java.util.Random;

public class Letters {
	//this class deals with the letters not held by players
	public static ArrayList<Letter> letters = new ArrayList<Letter>();//bad things will happen if anything that isn't a letter goes in this array list
	
	public static int[] dist = new int[]{9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 
			4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
	public static char[] chars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	
	public static void setup() {
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < dist[i]; j++) {
				letters.add(new Letter (chars[i]));
			}
		}
	}
	
	//choose a letter from the bag
	public static Letter getLetter() {
		//produce a random number
		Random ran = new Random();
		int index = ran.nextInt(letters.size());
		//selects the letter and removes it
		Letter out = letters.get(index);
		letters.remove(index);
		return out;
	}
}
