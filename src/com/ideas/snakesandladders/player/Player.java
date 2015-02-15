package com.ideas.snakesandladders.player;

/**
 * Player POJO which will get input from user and deliver where-ever it is needed
 */

public class Player{
	private int userInput = 0;

	public void setUserInput(int userInput){
		this.userInput = userInput;
	}

	public int getUserInput() {
		return userInput;
	}

}
