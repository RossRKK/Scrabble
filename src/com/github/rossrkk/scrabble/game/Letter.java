package com.github.rossrkk.scrabble.game;

public class Letter {
	public int score; //the score the letter gets
	public String toDisp; //the string that is printed in the board
	public char value; //the value that should be used when checking if this letter is part of a valid word
	
	public Letter(char val) {
		//TODO make the scores what they actually are in the game
		value = val;
		//set the score and display for each letter
		switch(val) {
		case 'A':
			score = 1;
			toDisp = "A";
			break;
		case 'B':
			score = 3;
			toDisp = "B";
			break;
		case 'C':
			score = 1;
			toDisp = "C";
			break;
		case 'D':
			score = 3;
			toDisp = "D";
			break;
		case 'E':
			score = 1;
			toDisp = "E";
			break;
		case 'F':
			score = 3;
			toDisp = "F";
			break;
		case 'G':
			score = 1;
			toDisp = "G";
			break;
		case 'H':
			score = 3;
			toDisp = "H";
			break;
		case 'I':
			score = 1;
			toDisp = "I";
			break;
		case 'J':
			score = 3;
			toDisp = "J";
			break;
		case 'K':
			score = 1;
			toDisp = "K";
			break;
		case 'L':
			score = 3;
			toDisp = "L";
			break;
		case 'M':
			score = 1;
			toDisp = "M";
			break;
		case 'N':
			score = 3;
			toDisp = "N";
			break;
		case 'O':
			score = 1;
			toDisp = "O";
			break;
		case 'P':
			score = 3;
			toDisp = "P";
			break;
		case 'Q':
			score = 1;
			toDisp = "Q";
			break;
		case 'R':
			score = 3;
			toDisp = "R";
			break;
		case 'S':
			score = 1;
			toDisp = "S";
			break;
		case 'T':
			score = 3;
			toDisp = "T";
			break;
		case 'U':
			score = 1;
			toDisp = "U";
			break;
		case 'V':
			score = 3;
			toDisp = "V";
			break;
		case 'W':
			score = 1;
			toDisp = "W";
			break;
		case 'X':
			score = 3;
			toDisp = "X";
			break;
		case 'Y':
			score = 1;
			toDisp = "Y";
			break;
		case 'Z':
			score = 3;
			toDisp = "Z";
			break;
		}
	}
}
