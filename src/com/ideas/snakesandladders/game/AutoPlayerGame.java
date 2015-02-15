package com.ideas.snakesandladders.game;

import java.util.Random;
import java.util.Scanner;

/**
 * Auto Player game implementation if User inputs 0.
 * Both the players are played by computer itself
 */
public class AutoPlayerGame extends Game{

	@Override
	public boolean play(Scanner scanner) {

		while(true) {
			player1.setUserInput(1 + Math.round(new Random().nextInt(6)));
			player2.setUserInput(1 + Math.round(new Random().nextInt(6)));

			if(gameBoard.move(player1, player2)) {
				break;
			}

		}
		return true;
	}

}
