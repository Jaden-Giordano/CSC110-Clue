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

	public void createBoard() {
		// TODO Get the path that will be used.
		// board = new Board();
	}

	public void createPlayers() {
		for (int i = 0; i < numPlayers; i++) {
			Player p = new Player(board, i + 1, people[i]);
			playerList[i] = p;
		}
	}

	public void takeTurn(Player p) {
		Die d = new Die();
		int roll = d.rollDie();
		boolean checkValidMove = false;
		while (!checkValidMove) {
			checkValidMove = true;
			// TODO get Vector2i form somewhere
			// TODO change null to Vector2i
			int spaceLeft = p.makeMove(null, roll);
			if (spaceLeft == -1) {
				checkValidMove = false;
			} else if (spaceLeft > 0) {
				checkValidMove = false;
				int rollReamining = roll - spaceLeft;
				// TODO get new move location
			}
		}
	}

}
