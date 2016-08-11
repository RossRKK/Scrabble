package com.github.rossrkk.scrabble.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.github.rossrkk.scrabble.util.Coord;

public class Player {
	public String name;
	public int score = 0;
	
	public Player(String name) {
		this.name = name;
		getLetters();
	}
	//the letters currently held by the player
	public ArrayList<Letter> letters = new ArrayList<Letter>();//bad things will happen if you put something that isn't a letter in here
	
	public void getLetters() {
		int toGet = 7 - letters.size();
		
		for (int i = 0; i < toGet; i ++) {
			letters.add(Letters.getLetter());
		}
	}
	
	//a method run when it is this players turn
	public void turn(boolean first) {
		Scanner sc = new Scanner(System.in);
		System.out.println(name + "\'s turn.");
		Board.print();
		String printLetters = "You have the letters: ";
		for (int i = 0; i < letters.size(); i ++) {
			printLetters = printLetters + letters.get(i).toDisp;
		}
		System.out.println(printLetters);
		System.out.println("Please enter the word you would like to play:");
		String word = sc.nextLine().toUpperCase();
		//check if it is a real word
		if (Dictionary.isWord(word)) {
			System.out.println("Valid word");
		} else {
			while (Dictionary.isWord(word)) {
				System.out.println("Invalid Word\nPlease re-enter the word you would like to play:");
				word = sc.nextLine().toUpperCase();
			}
		}
		System.out.println("Is the word played down or across?");
		String dir = null;
		while (dir == null) {
			String response = sc.nextLine();
			if (response.equalsIgnoreCase("across")) {
				dir = "across";
			} else if (response.equalsIgnoreCase("down")) {
				dir = "down";
			} else {
				System.out.println("Invalid response. Please enter either \"Down\" or \"Across\".");
			}
		}
		System.out.println(word + " is being played " + dir);
		
		System.out.println("Please enter the starting x coordinate of the word (furthest left letter)");
		int x = -1;
		while (x < 0) {
			int posX = sc.nextInt() - 1;
			if (posX < 15 && posX >= 0) {
				x = posX;
			} else {
				System.out.println("Please enter a whole number between 1 and 15");
			}
		}
		
		System.out.println("Please enter the starting y coordinate of the word (furthest left letter)");
		int y = -1;
		while (y < 0) {
			int posY = sc.nextInt() - 1;
			if (posY < 15 && posY >= 0) {
				y = posY;
			} else {
				System.out.println("Please enter a whole number between 1 and 15");
			}
		}
		System.out.println(word + " is being played " + dir + " starting at position: (" + x + ", " + y + ").");
		Coord start = new Coord(x, y);
		
		//work out which letters are valid for use
		ArrayList<Letter> posLetters = new ArrayList<Letter>();
		posLetters.addAll(letters);
		try {
			if (dir.equalsIgnoreCase("across")) {
				for (int i = 0; i < word.length(); i ++) {
					if (Board.board[x + i][y] != null) {
						posLetters.add(Board.board[x + i][y]);
					}
				} 
			} else {
				for (int i = 0; i < word.length(); i ++) {
					if (Board.board[x][y + i] != null) {
						posLetters.add(Board.board[x][y + i]);
					}
				} 
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Your word doesn't fit on the board. You lose your turn.");
			return;
		}
		
		ArrayList<Letter> backup = new ArrayList<Letter>();
		for (int i = 0; i < letters.size(); i ++) {
			backup.add(letters.get(i));
		}
		
		//check if we have the letters to make the word
		boolean hasLetters = true;
		for (int i = 0; i < word.length(); i ++) {
			Letter letter = new Letter(word.charAt(i));
			
			//check if letter is in posLetters
			boolean isPos = false;
			for (int j = 0; j < posLetters.size(); j ++) {
				if (posLetters.get(j).value == letter.value) {
					isPos = true;
				}
			}
			if (isPos) {
				//remove the letter from poLetters and letters if its played
				for (int j = 0; j < posLetters.size(); j++) {
					if (posLetters.get(j).value == letter.value) {
						posLetters.remove(j);
						break;
					}
				}
				for (int j = 0; j < letters.size(); j++) {
					if (letters.get(j).value == letter.value) {
						letters.remove(j);
						break;
					}
				}
			} else {
				hasLetters = false;
			}
		}
		
		if((posLetters.size() > 7 || first) && hasLetters && Board.addToBoard(word, dir, start)) {
			//calculate the score
			int score = Board.getScore(word, dir, start);
			this.score += score;
			System.out.println("You scored " + score + " for this word. Your total score is: " + this.score);
		} else {
			//restore the letters arraylist from the backup
			letters.clear();
			for (int i = 0; i < backup.size(); i++) {
				letters.add(backup.get(i));
			}
			
			System.out.println("The word doesn't fit there with the letters you have. You have lost your turn.");
		}
		
		getLetters();

	}
}
