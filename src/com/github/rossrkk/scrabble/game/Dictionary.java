package com.github.rossrkk.scrabble.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	public static ArrayList<String> dict = new ArrayList<String>();
	
	//load the dictionary from a file
	public static void loadDict(String file) {
		Scanner sc;
		try {
			sc = new Scanner(new File(file));
			//loop through the whole file for words
			while(sc.hasNext()){
		        String s = sc.next();
		        dict.add(s);
		    }
			
		} catch (FileNotFoundException e) {
			System.out.println("Error, dictionary file not found");
		}
	}
	
	//return whether a word is a real word
	public static boolean isWord(String word) {
		for (int i = 0; i < dict.size(); i ++) {
			if (dict.get(i).equalsIgnoreCase(word)) {
				return true;
			}
		}
		return false;
	}
}
