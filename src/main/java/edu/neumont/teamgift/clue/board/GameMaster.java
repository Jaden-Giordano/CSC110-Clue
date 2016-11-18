package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Notepad;
import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.cards.Deck;

/**
 * A controller for all aspects of game.
 */
@SuppressWarnings("unused")
public class GameMaster {
	/**
	 * The amount of players in the game. TODO Prompt for number of players
	 */
	@SuppressWarnings("CanBeFinal")
	private int numPlayers = 6;
	/**
	 * The list of players in the game. TODO Make sure to resize array based on
	 * amount of players.
	 */
	@SuppressWarnings({ "MismatchedReadAndWriteOfArray", "CanBeFinal" })
	private Player[] playerList = new Player[numPlayers];

	/**
	 * The people available in the game to choose from. TODO Prompt for player
	 * select if we want
	 */
	private final String[] people = { "Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
			"Mrs. Peacock" };

	/**
	 * The game board.
	 */
	@SuppressWarnings("CanBeFinal")
	private Board board;

	/**
	 * Creates the game board.
	 */
	@SuppressWarnings("EmptyMethod")
	public final void createBoard() {
		// TODO Get the path that will be used.
		// board = new Board();
	}

	/**
	 * Creates all the players in the game, and stores them into player list.
	 */
	public final void createPlayers() {
		// TODO get the numplayers and set it
		for (int i = 0; i < numPlayers; i++) {
			Notepad notepad = new Notepad();
			Deck deck = new Deck();
			Player p = new Player(board, i + 1, people[i], notepad, deck);
			playerList[i] = p;
		}
	}

	public Player[] getPlayerList() {
		return playerList;
	}

	/**
	 * Handles the players turn and its movement.
	 *
	 * @param p
	 *            The player that is currently running its turn.
	 */
	public final void takeTurn(final Player p) {
		// TODO output p.getName() turn
		// TODO add options: roll dice or travel through secret passage if
		// present
		// TODO Check if doors are blocked
		// TODO add done button to turn
		Die d = new Die();
		int roll = d.rollDie();
		boolean checkValidMove = false;
		while (!checkValidMove) {
			checkValidMove = true;
			// TODO output to user how many moves
			// TODO get Vector2i form somewhere
			// TODO change null to Vector2i
			int spaceLeft = p.makeMove(null, roll);
			if (spaceLeft == -1) {
				checkValidMove = false;
				// TODO output invalid move
			} else if (spaceLeft > 0) {
				checkValidMove = false;
				roll -= spaceLeft;
				// @SuppressWarnings("UnusedAssignment")
				// TODO get new move location
			}
		}
	}

}
