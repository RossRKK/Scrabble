package com.github.rossrkk.scrabble.game;

import java.util.ArrayList;

public class Player {
	//the letters currently held by the player
	public ArrayList letters = new ArrayList();//bad things will happen if you put something that isn't a letter in here
	
	public void getLetters() {
		int toGet = 7 - letters.size();
		
		for (int i = 0; i < toGet; i ++) {
			letters.add(Letters.getLetter());
		}
	}
	
	//a method run when it is this players turn
	public void turn() {
		
	}
}
