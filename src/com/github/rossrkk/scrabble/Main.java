package com.github.rossrkk.scrabble;

import com.github.rossrkk.scrabble.game.Letter;
import com.github.rossrkk.scrabble.game.Letters;
import com.github.rossrkk.scrabble.game.Player;

public class Main {
	public static void main(String args[]) {
		Letters.setup();
		Player player1 = new Player();
		player1.getLetters();
		String out = "|";
		for (int i = 0; i < player1.letters.size(); i ++) {
			out = out + ((Letter)player1.letters.get(i)).toDisp + "|";
		}
		System.out.println(out);
	}
}
