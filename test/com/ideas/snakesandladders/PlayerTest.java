package com.ideas.snakesandladders;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	public void testPosition(){
		Player player = new Player();
		player.setCurrentPosition(10);
		assertEquals(10, player.getCurrentPosition());

	}
}
