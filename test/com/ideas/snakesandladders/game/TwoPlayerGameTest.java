package com.ideas.snakesandladders.game;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Test for Two Player game
 */
public class TwoPlayerGameTest extends TestCase {

	public void testSinglePlayer() {
		TwoPlayerGame twoPlayerGame = new TwoPlayerGame();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/TwoPlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}
		assertTrue(twoPlayerGame.play(scanner));
	}

}
