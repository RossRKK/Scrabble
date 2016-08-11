package com.github.rossrkk.scrabble.game;

import java.util.ArrayList;
import java.util.Scanner;

import com.github.rossrkk.scrabble.util.Coord;

public class Player {
	public String name;
	public int score = 0;
	
	public Player(String name) {
		this.name = name;
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
	public void turn() {
		Scanner sc = new Scanner(System.in);
		System.out.println(name + "\'s turn.");
		Board.print();
		System.out.println("Please enter the word you would like to play:");
		String word = sc.nextLine();
		//check if it is a real word
		if (Dictionary.isWord(word)) {
			System.out.println("Valid word");
		} else {
			while (Dictionary.isWord(word)) {
				System.out.println("Invalid Word\nPlease re-enter the word you would like to play:");
				word = sc.nextLine();
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
		System.out.println(word + "is being played " + dir);
		
		boolean canGo = false;
		
		while (!canGo) {
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
			if(Board.addToBoard(word.toUpperCase(), dir, start)) {
				canGo = true;
			} else {
				System.out.println("The word doesn't fit there. You have lost your turn.");
			}
			int score = Board.getScore(word.toUpperCase(), dir, start);
			this.score += score;
			System.out.println("You scored " + score + " for this word. Your total score is: " + this.score);
			
			Board.print();
		}
	}
}
