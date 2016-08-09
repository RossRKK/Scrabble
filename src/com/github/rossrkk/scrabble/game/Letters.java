package com.github.rossrkk.scrabble.game;

import java.util.ArrayList;
import java.util.Random;

public class Letters {
	//this class deals with the letters not held by players
	public static ArrayList<Letter> letters = new ArrayList<Letter>();//bad things will happen if anything that isn't a letter goes in this array list
	
	public static void setup() {
		//TODO make it so that each letter gets added the correct number of times
		for(int i = 0; i < 26; i++) {
			letters.add(new Letter('A'));
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
