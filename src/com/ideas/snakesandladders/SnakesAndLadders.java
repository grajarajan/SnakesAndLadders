package com.ideas.snakesandladders;

import com.ideas.snakesandladders.game.AutoPlayerGame;
import com.ideas.snakesandladders.game.SinglePlayerGame;
import com.ideas.snakesandladders.game.TwoPlayerGame;

import java.util.Scanner;

/**
 * Snakes and Ladders - an Ancient Indian board game
 *
 * This game is developed using TDD and later added main method as it will give user a choice to play with program
 *
 */
public class SnakesAndLadders {
	private static int numOfPlayers = 0;
	private static Scanner scanner = new Scanner(System.in);

/**
 * main method introduced to
 * @param args
 */
	public static void main(String[] args) {
		String userInput;

		System.out.println(Constants.WELCOME_USER);
		while(true) {

			userInput = scanner.nextLine();
			if (userInput.matches(Constants.ONLY_NUMBERS)) {

					numOfPlayers = Integer.parseInt(userInput);
					play();
					break;

			} else {
				System.out.println(Constants.INVALID_PLAYER_INPUT);
			}
		}
		scanner.close();
	}

/**
 * Decides the kind of game from number of Players
 */
	public static boolean play() {

		if (numOfPlayers == 0) {
			return new AutoPlayerGame().play(scanner);

		} else if (numOfPlayers == 1) {
			return new SinglePlayerGame().play(scanner);

		} else if (numOfPlayers == 2) {
			return new TwoPlayerGame().play(scanner);

		} else {
			System.out.println(Constants.INVALID_PLAYER_INPUT);
		}
		return false;
	}

/**
 * The below two methods were used for development purpose as I developed the game using TDD
 */
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public void setDiceInputs(Scanner scanner) {
		this.scanner = scanner;
	}

}
