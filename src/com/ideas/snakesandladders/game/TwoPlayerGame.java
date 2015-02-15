package com.ideas.snakesandladders.game;

import com.ideas.snakesandladders.Constants;

import java.util.Scanner;

/**
 * Two Player Game implementation where User will input values for both the players
 */

public class TwoPlayerGame extends Game{

	@Override
	public boolean play(Scanner scanner) {

		while(true) {

			System.out.println(Constants.INPUT_PLAYER1_DICE_VALUE);
			player1.setUserInput(getValidInput(scanner));

			System.out.println(Constants.INPUT_PLAYER2_DICE_VALUE);
			player2.setUserInput(getValidInput(scanner));

			if(gameBoard.move(player1, player2)) {
				break;
			}
		}

		return true;
	}
}
