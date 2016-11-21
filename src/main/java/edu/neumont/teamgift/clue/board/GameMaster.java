package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.cards.Dealer;

import java.text.spi.NumberFormatProvider;
import java.util.ArrayList;
import java.util.List;

/**
 * A controller for all aspects of game.
 */
public class GameMaster {
	/**
	 * The people available in the game to choose from. TODO Prompt for player
	 * select if we want
	 */
	private final String[] people = { "Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
			"Mrs. Peacock" };
	private int numPlayers = 6;
	/**
	 * The game board.
	 */
	private final Board board;
	/**
	 * The list of players in the game. TODO Make sure to resize array based on
	 * amount of players.
	 */
	private final List<Player> playerList;

	/**
	 * Initializes the board.
	 */
	public GameMaster() {
		board = new Board("hi"); // TODO Get path to board.

		playerList = new ArrayList<>();
		createPlayers();

		runGame();
	}

	/**
	 * Create new GameMaster.
	 */
	public void runGame() {
		Dealer dealer = new Dealer();
		// TODO Number of players
		// TODO Name selection if we want
		// Create players
		dealer.createCards();
		// Shuffle cards
		dealer.shuffle();
		// Set killer case file
		dealer.setKiller();
		dealer.printKillerCaseFile();
		// TODO Deal rest of cards
		/*
		 * for (int i = 0; i < game.getPlayerList().length; i++) {
		 * System.out.println(game.getPlayerList()[i].getName() +
		 * " This is round " + i); }
		 */
		// Create board
		// game.createBoard();
		// Create cards
		// dealer.printCards();

		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Player " + getPlayerList(i).getID() + ": " + getPlayerList(i).getName());
			for (int j = 0; j < getPlayerList(i).getDeck().size(); j++) {
				System.out.println(getPlayerList(i).getDeck().get(j).getName());
			}
			System.out.print("\n");
		}
		// TODO Win condition
		// TODO Take turns through players
		while (!this.areThereWinners()) {
			for (int i = 0; i < numPlayers; i++) {
				if (this.areThereWinners()) {
					break;
				}
				this.takeTurn(this.getPlayerList(i));
			}
		}
		// TODO print this.whoWon();
	}

	/**
	 * Creates all the players in the game, and stores them into player list.
	 */
	public final void createPlayers() {
		// TODO get the number of players and set it
		/*
		 * The amount of players in the game. TODO Prompt for number of players
		 */

		for (int i = 0; i < numPlayers; i++) {
			Player p = new Player(board, i + 1, people[i]);
			playerList.add(p);
		}
	}

	/**
	 * Get all players in the game.
	 *
	 * @return The array of the players.
	 */
	public final Player getPlayerList(int index) {
		return playerList.get(index);
	}

	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int i){
		numPlayers = i;
	}

	/**
	 * Get the board for the game.
	 *
	 * @return The current board.
	 */
	public final Board getBoard() {
		return board;
	}

	public boolean areThereWinners() {
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getWinner()) {
				return true;
			}
		}
		return false;
	}

	public Player whoWon() {
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getWinner()) {
				return playerList.get(i);
			}
		}
		Player p = new Player(board, 0, null);
		return p;
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
