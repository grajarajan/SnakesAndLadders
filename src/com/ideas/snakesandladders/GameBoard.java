package com.ideas.snakesandladders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Business Logic implementation for the Snakes and Ladder Game
 */
public class GameBoard {

	// It is a 10 * 12 matrix as mentioned in the problem
	private final int MAXIMUM_POSITIONS = 10 * 12 ;

	private Map<Integer, Integer> ladders;
	private Map<Integer, Integer> snakes;

/**
 * Constructor will initialize the Snakes and Ladders map
 */
	public GameBoard() {
		ladders = new HashMap();
		snakes = new HashMap();

		populateLaddersAndSnakes();
		printLaddersAndSnakesPositions();
	}

	public boolean move(int numberOfPlayers, Scanner scanner) {
		List<Player> players = generatePlayers(numberOfPlayers);

		while (true) {
			for (int i = 0; i < numberOfPlayers; i++) {
				Player player = players.get(i);

				printMessage("Player" + (i+1) + "'s current position : " + player.currentPosition);
				printMessage("Please enter Player"+ (i+1) + "'s dice value :");

				int playerDiceVal = getValidInput(scanner);

				int playerCurrentPos = isSnakeOrLadder(player.currentPosition + playerDiceVal);

				if (playerCurrentPos == MAXIMUM_POSITIONS) {
					printMessage("Winner : Player" + (i+1));
					return true;

				} else {

					player.setCurrentPosition(getNewPositions(playerCurrentPos, playerDiceVal));
				}
			}
		}
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
	 *  Accept only less than 7 int values from users.
	 *
	 * @param scanner
	 * @return user input value
	 */
	private int getValidInput(Scanner scanner) {

		while (true) {
			String input = scanner.nextLine();

			if(input.isEmpty() || !input.matches(Constants.ONLY_NUMBERS)) {
				System.out.println(Constants.INVALID_DICE_INPUT);

			} else {
				int val = Integer.parseInt(input);

				if (val > 6) {
					System.out.println(Constants.INVALID_DICE_INPUT);

				} else {
					return val;
				}
			}
		}
	}

/**
 * Just for print purpose. This can be replaced with log4j or logback
 * @param msg
 */
	private void printMessage (String msg) {
		System.out.println(msg);
	}

/**
 * Generates numbers of players
 *
 * @param numberOfPlayers
 * @return player's list
 */
	public List<Player> generatePlayers(int numberOfPlayers){
		List<Player> players = new ArrayList<>(numberOfPlayers);

		for(int i =0 ; i < numberOfPlayers ; i++) {
			players.add(new Player());
		}
		return players;
	}
}
