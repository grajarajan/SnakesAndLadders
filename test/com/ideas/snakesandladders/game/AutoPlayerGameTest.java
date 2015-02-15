package com.ideas.snakesandladders.game;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Test for auto Player  game [with no input from User]
 */
public class AutoPlayerGameTest extends TestCase {

 	public void testAutoPlayer() {
		AutoPlayerGame autoPlayerGame = new AutoPlayerGame();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/AutoPlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}
		assertTrue(autoPlayerGame.play(scanner));
	}

}
