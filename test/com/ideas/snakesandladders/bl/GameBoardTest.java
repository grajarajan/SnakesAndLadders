package com.ideas.snakesandladders.bl;

import com.ideas.snakesandladders.player.Player;
import junit.framework.TestCase;

public class GameBoardTest extends TestCase{
	GameBoard gameBoard;
	Player player1;
	Player player2;

	protected void setUp() throws Exception {
		gameBoard = new GameBoard();
		player1 = new Player();
		player2 = new Player();
	}

	public void testMove_normal() {

		player1.setUserInput(5);
		player2.setUserInput(6);

		assertFalse(gameBoard.move(player1, player2));
	}

	public void testMove_end_player1() {
		player1.setUserInput(120);
		player2.setUserInput(6);

		assertTrue(gameBoard.move(player1, player2));
	}

	public void testMove_end_player2() {
		player1.setUserInput(1);
		player2.setUserInput(120);

		assertTrue(gameBoard.move(player1, player2));
	}

	public void testPositionUpdate_regular() {
		assertEquals(5, gameBoard.getNewPositions(5, 6));
	}

	public void testPositionUpdate_max() {
		assertEquals(119, gameBoard.getNewPositions(125, 6));
	}

/**
 * Snake Map
 Start : 80 End : 20
 Start : 98 End : 60
 Start : 114 End : 2
 Start : 52 End : 12
 Start : 13 End : 3
 Start : 46 End : 8
 Start : 31 End : 25

 Ladder Map
 Start : 65 End : 81
 Start : 35 End : 102
 Start : 51 End : 70
 Start : 4 End : 15
 Start : 105 End : 119
 Start : 12 End : 52
 Start : 78 End : 97
 */

	public void testSnakePosition() {
		assertEquals(12, gameBoard.isSnakeOrLadder(52));
		assertEquals(20, gameBoard.isSnakeOrLadder(80));
		assertEquals(60, gameBoard.isSnakeOrLadder(98));
		assertEquals(25, gameBoard.isSnakeOrLadder(31));
	}

	public void testLadderPosition() {
		assertEquals(81, gameBoard.isSnakeOrLadder(65));
		assertEquals(15, gameBoard.isSnakeOrLadder(4));
		assertEquals(52, gameBoard.isSnakeOrLadder(12));
		assertEquals(70, gameBoard.isSnakeOrLadder(51));
	}
}
