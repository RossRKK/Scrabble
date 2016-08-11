package com.github.rossrkk.scrabble;

import java.util.ArrayList;
import java.util.Scanner;

import com.github.rossrkk.scrabble.game.Letters;
import com.github.rossrkk.scrabble.game.Player;


public class Main {
	//TODO make it so that letters aren't taken from your hand if they're already on the board
	//TODO make scoring correct
	//TODO score other words played
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	public static void main(String args[]) {
		Letters.setup();
		addPlayers();
		
		players.get(0).turn(true);
		for (int i = 1; i < players.size(); i ++) {
			players.get(i).turn(false);
		}
		while (true /*insert condition for end of the game here*/) {
			for (int i = 0; i < players.size(); i ++) {
				players.get(i).turn(false);
			}
		}
	}
	
	//add all of the players to the game
	public static void addPlayers() {
		boolean done = false;
		Scanner sc = new Scanner(System.in);
		while (!done) {
			System.out.println("Would you like to add a player? (Y/N)");
			String resp = sc.nextLine();
			while (!(resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("n"))) {
				System.out.println("Please enter either \"Y\" or \"N\"");
				resp = sc.nextLine();
			}
			if (resp.equalsIgnoreCase("y")) {
				System.out.println("Please enter the name of the player");
				Player player = new Player(sc.nextLine());
				players.add(player);
			} else {
				done = true;
			}
		}
	}
}
