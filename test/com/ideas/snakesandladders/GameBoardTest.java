package com.ideas.snakesandladders;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Test case to test whole function of snakes and ladders
 */
public class GameBoardTest extends TestCase {

	GameBoard gameBoard = new GameBoard();
	Scanner scanner = null;

/**
 * Test for single player input
 */
	public void testGameWithSinglePlayer() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/SinglePlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		assertTrue(gameBoard.move(1, scanner));

	}

/**
 * Test for two players input
 */
	public void testGameWithTwoPlayers() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/TwoPlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		assertTrue(gameBoard.move(2, scanner));

	}
/**
 * Test for three players input
 */
	public void testGameWithThreePlayers() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/ThreePlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		assertTrue(gameBoard.move(3, scanner));

	}

	/**
	 * Test for four players input
	 */
	public void testGameWithFourPlayers() {
		try {
			scanner = new Scanner(new FileInputStream("./test/resources/ThreePlayerInput.txt"));
		} catch (Exception ex) {
			assertTrue(false);
		}

		assertTrue(gameBoard.move(4, scanner));

	}

/**
 * test the new positions
 */
	public void testNewPositionValues() {
		assertEquals(1, gameBoard.getNewPositions(1, 5));
		assertEquals(116, gameBoard.getNewPositions(121,5));
		assertEquals(120, gameBoard.getNewPositions(120,5));
	}

/**
 * test snake positions
 */
	public void testSnakePositions(){
		assertEquals(3, gameBoard.isSnakeOrLadder(13));
		assertEquals(25, gameBoard.isSnakeOrLadder(31));
		assertEquals(8, gameBoard.isSnakeOrLadder(46));
		assertEquals(12, gameBoard.isSnakeOrLadder(52));
		assertEquals(20, gameBoard.isSnakeOrLadder(80));
		assertEquals(60, gameBoard.isSnakeOrLadder(98));
		assertEquals(2, gameBoard.isSnakeOrLadder(114));
	}

/**
 * test ladder positions
 */
	public void testLadderPositions(){
		assertEquals(15, gameBoard.isSnakeOrLadder(4));
		assertEquals(52, gameBoard.isSnakeOrLadder(12));
		assertEquals(102, gameBoard.isSnakeOrLadder(35));
		assertEquals(70, gameBoard.isSnakeOrLadder(51));
		assertEquals(81, gameBoard.isSnakeOrLadder(65));
		assertEquals(97, gameBoard.isSnakeOrLadder(78));
		assertEquals(119, gameBoard.isSnakeOrLadder(105));
	}

/**
 * test players generation
 */
	public void testGeneratePlayers() {
		assertEquals(3, gameBoard.generatePlayers(3).size());
	}
}
