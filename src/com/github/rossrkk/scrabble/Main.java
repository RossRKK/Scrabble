package com.github.rossrkk.scrabble;

import com.github.rossrkk.scrabble.game.Board;
import com.github.rossrkk.scrabble.util.Coord;

public class Main {
	public static void main(String args[]) {
		Board.addToBoard("APPLE", "across", new Coord(0,0));
		Board.addToBoard("PEN", "down", new Coord(2,0));
		Board.print();
	}
	
	//accept the players input
	public static void playerGo() {
		
	}
	
	//run the bot's turn
	public static void botGo() {
		
	}
}
