package com.github.rossrkk.scrabble.game;

public class Dictionary {
	public static String[] dict;
	
	//load the dictionary from a file
	public static void loadDict(String file) {
		
	}
	
	//return whether a word is a real word
	public static boolean isWord(String word) {
		for (int i = 0; i < dict.length; i ++) {
			if (dict[i].equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}
}
