package com.ideas.snakesandladders;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Test case to test whole function of snakes and ladders
 */
public class SnakesAndLaddersTest extends TestCase {
	SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
	Scanner scanner = null;

/**
 * Test for two player input
 */
	public void testSnakesAndLAdders_two_player() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/TwoPlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		snakesAndLadders.setNumOfPlayers(2);
		snakesAndLadders.setDiceInputs(scanner);

		assertTrue(SnakesAndLadders.play());

	}

/**
 * Test for single player input
 */
	public void testSnakesAndLAdders_single_player() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/SinglePlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		snakesAndLadders.setNumOfPlayers(1);
		snakesAndLadders.setDiceInputs(scanner);

		assertTrue(SnakesAndLadders.play());

	}

/**
 * Test for auto Player [with no input]
 */
	public void testSnakesAndLAdders_auto_player() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/AutoPlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		snakesAndLadders.setNumOfPlayers(0);
		snakesAndLadders.setDiceInputs(scanner);

		assertTrue(SnakesAndLadders.play());

	}
}
