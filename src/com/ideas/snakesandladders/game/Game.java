package com.ideas.snakesandladders.game;

import com.ideas.snakesandladders.Constants;
import com.ideas.snakesandladders.bl.GameBoard;
import com.ideas.snakesandladders.player.Player;

import java.util.Scanner;

/**
 * Abstract class which lets its children to implement their own move algorithm.
 * Accepts only less than 7 as dice value input from user
 */
public abstract class Game {
	protected int val = 0;
	protected String input = null;
	protected Player player1 = new Player();
	protected Player player2 = new Player();
	protected GameBoard gameBoard = new GameBoard();

/**
 * business logic impl by children
 * @param scanner
 * @return
 */
	abstract boolean play (Scanner scanner);

/**
 *  Accept only less than 7 int values from users.
 *
 * @param scanner
 * @return user input value
 */
	public int getValidInput(Scanner scanner) {

		while (true) {
			input = scanner.nextLine();

			if(input.isEmpty()) {
				System.out.println(Constants.INVALID_DICE_INPUT);

			} else {
				val = Integer.parseInt(input);

				if (val > 6) {
					System.out.println(Constants.INVALID_DICE_INPUT);

				} else {
					return val;
				}
			}
		}
	}
}
