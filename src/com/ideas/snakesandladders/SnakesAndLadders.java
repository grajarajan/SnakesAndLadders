package com.ideas.snakesandladders;

import java.util.Scanner;

/**
 * Snakes and Ladders - an Ancient Indian board game
 *
 */
public class SnakesAndLadders {

	private static Scanner scanner = new Scanner(System.in);

/**
 * main method
 *
 * @param args
 */
	public static void main(String[] args) {

		System.out.println(Constants.WELCOME_USER);
		while(true) {

			String userInput = scanner.nextLine();
			if (userInput.matches(Constants.ONLY_NUMBERS)) {

				GameBoard gameBoard = new GameBoard();
				gameBoard.move(Integer.parseInt(userInput), scanner);

				break;

			} else {
				System.out.println(Constants.INVALID_PLAYER_INPUT);
			}
		}
		scanner.close();
	}

}
