package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Player;

public class GameMaster {
	// TODO Prompt for number of players
	private int numPlayers = 0;
	private Player[] playerList = new Player[numPlayers];
	// TODO Prompt for player select if we want
	private String[] people = { "Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
	"Mrs. Peacock" };
	private Board board;
	public void createBoard(){
		// TODO Get the path that will be used.
		//board = new Board();
	}
	public void createPlayers(){
		for(int i = 0; i < numPlayers; i++){
			Player p = new Player(board, i + 1, people[i]);
			playerList[i] = p;
		}
	}
	
	
}
