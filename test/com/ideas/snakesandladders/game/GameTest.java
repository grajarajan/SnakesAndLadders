package com.ideas.snakesandladders.game;

import junit.framework.TestCase;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.util.Scanner;

public class GameTest extends TestCase {

public void testSnakesAndLAdders_auto_player_invalid() {
	Scanner scanner = null;
	try {
		scanner = new Scanner(new FileInputStream("./test/resources/ValidInvalidMixed.txt"));
	} catch (Exception ex) {
		assertTrue(false);
	}
	Game mockedGame = Mockito.mock(Game.class, Mockito.CALLS_REAL_METHODS);
	assertEquals(4, mockedGame.getValidInput(scanner));

}
}
