package com.ideas.snakesandladders.game;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Test for Single Player game
 */
public class SinglePlayerGameTest extends TestCase {

	public void testSinglePlayer() {
		SinglePlayerGame singlePlayerGame = new SinglePlayerGame();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/SinglePlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}
		assertTrue(singlePlayerGame.play(scanner));
	}

}
