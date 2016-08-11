package com.github.rossrkk.scrabble.game;

import java.util.ArrayList;

import com.github.rossrkk.scrabble.util.Coord;

public class Board {
	public static Coord[] TW= new Coord[]{new Coord(0, 0), new Coord(7, 0), new Coord(14, 0),
		new Coord(0, 7), new Coord(14, 7),
		new Coord(0,14), new Coord(7, 14), new Coord(14, 14)}; //location of each triple word
	
	public static Coord[] DW = {}; //location of each double word
	public static Coord[] DL = {}; //location of each double letter
	public static Coord[] TL = {}; //location of each triple letter
	
	public static int length = 15; //side length of the board
	
	//0,0 is the top left
	public static Letter[][] board = new Letter[length][length]; //saves each letter on the board
	
	//return the score of a word played
	public static int getScore(String word, String dir, Coord start) {
		ArrayList<Integer> wordMult = new ArrayList<Integer>();
		int score = 0;
		//get the score for each letter taking into account double and triple letters
		Coord pos = start;
		for (int i = 0; i < word.length(); i ++) {
			boolean special = false; //tracks whether the score has been added yet or not
			for (int j = 0; j < TL.length; j ++) {
				if (TL[j].x == pos.x && TL[j].y == pos.y) {
					score += new Letter(word.charAt(i)).score * 3;
					special = true;
				}
			}
			if (!special) {
				for (int j = 0; j < DL.length; j ++) {
					if (DL[j].x == pos.x && DL[j].y == pos.y) {
						score += new Letter(word.charAt(i)).score * 2;
						special = true;
					}
				}
			}
			
			if (!special) {
				score += new Letter(word.charAt(i)).score;
			}
			
			//check if we're on a word multiplier
			for (int j = 0; j < DW.length; j++) {
				if (DW[j].x == pos.x && DW[j].y == pos.y) {
					wordMult.add(new Integer(2));
				}
			}
			for (int j = 0; j < TW.length; j++) {
				if (TW[j].x == pos.x && TW[j].y == pos.y) {
					wordMult.add(new Integer(3));
				}
			}
			
			for (int j = 0; j < wordMult.size(); j++) {
				score = score * ((Integer)wordMult.get(j)).intValue();
			}
			
			//move along
			if (dir.equalsIgnoreCase("down")) {
				pos.y ++;
			} else {
				pos.x ++;
			}
		}
		
		return score;
	}
	
	//add a word to the board
	public static boolean addToBoard(String word, String dir, Coord start) {
		//duplicate the board so it can be replaced if the word doesn't fit
		Letter[][] backUpBoard = new Letter[15][15];
		for (int i = 0; i < board.length; i++) {
		    System.arraycopy(board[i], 0, backUpBoard[i], 0, board[0].length);
		}
		
		Coord pos = start;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			//if the space is blank or the same letter (playing over an existing word)
			if (!isBlocked(pos, letter)) {
				board[pos.x][pos.y] = new Letter(letter);
			} else {
				//remove the letters from the board as they can't be played
				for (int j = 0; j < backUpBoard.length; j++) {
				    System.arraycopy(backUpBoard[j], 0, board[j], 0, backUpBoard[0].length);
				}
				//return that the process failed
				return false;
			}
			
			if (dir.equalsIgnoreCase("Down")) {
				pos.y ++;
			} else {
				pos.x ++;
			}
		}
		return true;
	}
	
	//return whether a position is filled or matches the letter
	public static boolean isBlocked(Coord pos, char val) {
		return board[pos.x][pos.y] != null && !(board[pos.x][pos.y].value == val);
	}
	
	//print the board to the console
	public static void print() {
		System.out.println("------------------------------");
		for (int y = 0; y < length; y ++) {
			String out = "|";
			//add each value for x to a string to be printed
			for (int x = 0; x < length; x++) {
				if (board[x][y] != null) {
					out = out + board[x][y].toDisp;
				} else {
					out = out + " "; 
				}
				out = out + "|";
			}
			System.out.println(out);
			System.out.println("------------------------------");
		}
	}
}
