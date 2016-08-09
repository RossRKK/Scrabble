package com.github.rossrkk.scrabble;

import com.github.rossrkk.scrabble.game.Dictionary;


public class Main {
	public static void main(String args[]) {
		Dictionary.loadDict("/usr/share/dict/british-english");
		Dictionary.loadDict("/usr/share/dict/american-english");
		System.out.println(Dictionary.isWord("squiz"));
	}
}
