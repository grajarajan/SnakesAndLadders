package com.ideas.snakesandladders.bl;

import com.ideas.snakesandladders.Constants;
import com.ideas.snakesandladders.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Business Logic implementation for the Snakes and Ladder Game
 */
public class GameBoard {

	// It is a 10 * 12 matrix as mentioned in the problem
	private final int MAXIMUM_POSITIONS = 10 * 12 ;

	private Map<Integer, Integer> ladders;
	private Map<Integer, Integer> snakes;

	private int player1CurrentPos = 0, player2CurrentPos = 0;

/**
 * Constructor will initialize the Snakes and Ladders map
 */
	public GameBoard() {
		ladders = new HashMap();
		snakes = new HashMap();

		populateLaddersAndSnakes();
		printLaddersAndSnakesPositions();
	}

/**
 * Move the positions of the Players
 *
 * @param player1
 * @param player2
 * @return true, if there is a Winner
 * false, if it is only position change for the Player/s
 */
	public boolean move(Player player1, Player player2) {

		int player1DiceVal = player1.getUserInput();

		printMessage("Player1 current position : " + player1CurrentPos);
		printMessage("Player1 dice value : " + player1DiceVal);

		player1CurrentPos = isSnakeOrLadder(player1CurrentPos + player1DiceVal);

		if (player1CurrentPos == MAXIMUM_POSITIONS) {
			printMessage("Winner : Player1");
			return true;
		}

		player1CurrentPos = getNewPositions(player1CurrentPos, player1DiceVal);

		int player2DiceVal = player2.getUserInput();
		printMessage("Player2 current position : " + player2CurrentPos);
		printMessage("Player2 dice value : " + player2DiceVal);

		player2CurrentPos = isSnakeOrLadder(player2CurrentPos + player2DiceVal);

		if (player2CurrentPos == MAXIMUM_POSITIONS) {
			printMessage("Winner : Player2");
			return true;
		}
		player2CurrentPos = getNewPositions(player2CurrentPos, player2DiceVal);

		return false;
	}

/**
 * Get the new position for the Player
 * If the position exceeds maximum position of matrix then ignore the move
 *
 * @param currPos
 * @param diceVal
 * @return new position of the Player
 */
	public int getNewPositions(int currPos, int diceVal) {
		if (currPos > MAXIMUM_POSITIONS) {
			printMessage("New position " + currPos + " exceeds max position "
				             + MAXIMUM_POSITIONS + ", So skipping current move.");
			currPos -= diceVal;
		} else {
			printMessage("New position : " + currPos);
		}

		printMessage("");
		return currPos;
	}

/**
 * Decides if the current position found ladder and snake
 *
 * @param position
 * @return If the position found snake or ladder their respective position.
 * else return the original position
 */
	public int isSnakeOrLadder(int position) {

		if (ladders.get(position) != null) {
			System.out.println(Constants.FOUND_LADDER + position);
			return ladders.get(position);
		}

		if (snakes.get(position) != null) {
			System.out.println(Constants.FOUND_SNAKE + position);
			return snakes.get(position);
		}

		return position;
	}

/**
 * Initialize Ladder and Snakes Map. Initializing 7/7 Ladders/snakes.
 */
	private void populateLaddersAndSnakes() {

		ladders.put(4, 15);
		ladders.put(12, 52);
		ladders.put(35, 102);
		ladders.put(51, 70);
		ladders.put(65, 81);
		ladders.put(78, 97);
		ladders.put(105, 119);

		snakes.put(13, 3);
		snakes.put(31, 25);
		snakes.put(46, 8);
		snakes.put(52, 12);
		snakes.put(80, 20);
		snakes.put(98, 60);
		snakes.put(114, 2);

	}

/**
 * Print Snakes and Ladders positions
 */
	private void printLaddersAndSnakesPositions() {

		printMessage("Ladder Map");
		for(Map.Entry entry : ladders.entrySet()){
			System.out.println("Start : " + entry.getKey() + " End : " + entry.getValue());
		}

		printMessage("Snake Map");
		for(Map.Entry entry : snakes.entrySet()){
			System.out.println("Start : " + entry.getKey() + " End : " + entry.getValue());
		}

		printMessage("");
	}

/**
 * Just for print purpose. This can be replaced with log4j or logback
 * @param msg
 */
	private void printMessage (String msg) {
		System.out.println(msg);
	}
}
