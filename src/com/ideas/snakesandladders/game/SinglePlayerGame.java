package com.ideas.snakesandladders.game;

import com.ideas.snakesandladders.Constants;

import java.util.Random;
import java.util.Scanner;

/**
 * Single Player Game implementation.
 * It accepts one Player input and other Player will be played by computer
 */
public class SinglePlayerGame extends Game {

	@Override
	public boolean play(Scanner scanner) {

		while(true) {

			System.out.println(Constants.INPUT_PLAYER1_DICE_VALUE);

			player1.setUserInput(getValidInput(scanner));
			player2.setUserInput(1 + Math.round(new Random().nextInt(6)));

			if(gameBoard.move(player1, player2)) {
				break;
			}

		}
		return true;
	}

}
