package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Notepad;
import edu.neumont.teamgift.clue.Player;
import edu.neumont.teamgift.clue.SpriteLoader;
import edu.neumont.teamgift.clue.board.tiles.Start;
import edu.neumont.teamgift.clue.board.tiles.Tile;
import edu.neumont.teamgift.clue.board.tiles.TileRegistry;
import edu.neumont.teamgift.clue.cards.Dealer;
import edu.neumont.teamgift.clue.front.MainManager;
import edu.neumont.teamgift.clue.front.gui.ActionMenu;
import edu.neumont.teamgift.clue.front.gui.NotepadGui;
import edu.neumont.teamgift.clue.interfaces.Updatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A controller for all aspects of game.
 */
public class GameMaster implements Updatable {

	/**
	 * The people available in the game to choose from. TODO Prompt for player
	 * select if we want
	 */
	private final String[] people = { "Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
			"Mrs. Peacock" };
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
	 * The amount of players in the game.
	 */
	// noinspection CheckStyle
	private int numPlayers = 6;

	/**
	 * The turn of the game.
	 */
	private int turn = 0;

	/**
	 * The current player.
	 */
	private Player currentPlayer;

	/**
	 * The current action menu.
	 */
	private ActionMenu currentActionMenu;

	/**
	 * Initializes the board.
	 */
	private Dealer dealer;

	public GameMaster() {
		MainManager.getInstance().registerUpdatable(this);

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the path of the project directory: ");
		// TODO make final variable that gets file from project dir.
		String path = in.nextLine();

		board = new Board(this, path);

		SpriteLoader.pathToSprites = path + "/sprites";
		SpriteLoader.init();
		TileRegistry.init();

		Notepad.init(this);
		playerList = new ArrayList<>();
		createPlayers();
		runGame();
		setupNotepads();
	}

	/**
	 * Create new GameMaster.
	 */
	public void runGame() {
		dealer = new Dealer();
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
		dealer.dealCards(this);
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Player " + getPlayer(i).getID() + ": " + getPlayer(i).getName());
			for (int j = 0; j < getPlayer(i).getDeck().size(); j++) {
				System.out.println(getPlayer(i).getDeck().get(j).getName());
			}
			System.out.print("\n");
		}
		// TODO Win condition
		// TODO Take turns through players
		/*
		 * while (!this.areThereWinners()) { for (int i = 0; i < numPlayers;
		 * i++) { if (this.areThereWinners()) { break; }
		 * this.getPlayer(i).getNotepad(); // this.takeTurn(this.getPlayer(i));
		 * } }
		 */
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

		Tile[] startTiles = getBoard().getTiles(Start.class);
		for (int i = 0; i < numPlayers; i++) {
			Player p = new Player(board, i, people[i], this);
			p.setSprite(SpriteLoader.getSprite(SpriteLoader.pathToSprites + "/players/" + p.getName() + ".png"));

			for (Tile t : startTiles) {
				if (((Start) t).getContainingPlayer() == null) {
					p.setPosition(t.getPosition());
					getBoard().addPlayer(p);
					break;
				}
			}

			playerList.add(p);
		}
	}

	private void setupNotepads() {
		for (Player i : playerList) {
			i.setNotepadGUI(new NotepadGui(this, i.getID()));
		}
	}

	/**
	 * Get a specific player in the game.
	 *
	 * @param index
	 *            The index of the player needed.
	 * @return The array of the players.
	 */
	public final Player getPlayer(final int index) {
		return playerList.get(index);
	}
	//
	// for (int i = 0; i < numPlayers; i++) {
	// Player p = new Player(board, i, people[i], this);
	// p.setSprite(new Sprite(new Vector3i(0, 0, 0)));
	// playerList.add(p);
	// p.setNotepadGUI(new NotepadGui(this, p.getID()));
	// }
	// }

	/**
	 * Get the number of players.
	 *
	 * @return The amount of players.
	 */
	public int getNumPlayers() {
		return numPlayers;
	}

	/**
	 * Set the amount of players.
	 *
	 * @param i
	 *            The amount of players.
	 */
	public void setNumPlayers(final int i) {
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

	/**
	 * Checks if there is a winner in any of the players.
	 *
	 * @return Returns whether a player has won or not.
	 */
	public boolean areThereWinners() {
		return playerList.stream().filter(Player::getWinner).count() > 0;
	}

	/**
	 * Get the winner of the game.
	 *
	 * @return The player that has won.
	 */
	public Player whoWon() {
		return playerList.stream().filter(Player::getWinner).findFirst().orElse(null);
	}

	/**
	 * Handles the players turn and its movement.
	 *
	 * @param p
	 *            The player that is currently running its turn.
	 */
	public final void takeTurn(final Player p, final int r) {
		// TODO output p.getName() turn
		// TODO add options: roll dice or travel through secret passage if
		// present
		// TODO Check if doors are blocked
		// TODO add done button to turn
		int roll = r;
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
	public ArrayList<String> whatMatches(Player whoSuggested, ArrayList<String> arrayList){
		ArrayList<String> whatIsTheSame = new ArrayList<String>();
		Player p = whoHasSuggested(whoSuggested, arrayList);
		if(p.equals(whoSuggested)){
			return whatIsTheSame;
		}
		for(int i = 0; i < arrayList.size(); i++){
			for(int j = 0; j < p.getDeck().size(); j++){
				if(arrayList.get(i).equals(p.getDeck().get(j))){
					whatIsTheSame.add(arrayList.get(i));
				}
			}
		}
		return whatIsTheSame;
	}

	private Player whoHasSuggested(Player whoSuggested, ArrayList<String> arrayList) {
		int whereWeAre = numPlayers + whoSuggested.getID();
		for (int i = whoSuggested.getID() + 1; i < numPlayers + whoSuggested.getID(); i++) {
			if (whereWeAre > numPlayers) {
				whereWeAre -= numPlayers;
			}
			for (int j = 0; j < getPlayer(whereWeAre).getDeck().size(); j++) {
				for (int k = 0; k < arrayList.size(); k++) {
					if (getPlayer(whereWeAre).getDeck().get(j).getName().equals(arrayList.get(k))) {
						return getPlayer(whereWeAre);
					}
				}
			}
		}
		return whoSuggested;
	}

	/**
	 * This will be called over and over again, so use it for whatever needs to
	 * be done.
	 */
	@Override
	public void update() {
		// TODO Manage game.
	}

	public void makeAccusation(Player whoIsAccusing, String player, String weapon, String room) {
		if (isAccusationTrue(weapon, player, room)) {
			whoIsAccusing.setWinner();
		} else {
			whoIsAccusing.setInGame(false);
		}
	}

	public boolean isAccusationTrue(String player, String weapon, String room) {
		return weapon.equals(dealer.getKillerCaseFile().get(0).getName())
				&& player.equals(dealer.getKillerCaseFile().get(1).getName())
				&& room.equals(dealer.getKillerCaseFile().get(2).getName());
	}

	/**
	 * Handle moving to the next turn.
	 */
	public void nextTurn() {
		turn++;
		currentPlayer.getNotepad().close();
		currentPlayer = playerList.get(turn % getNumPlayers());
		currentPlayer.getNotepad().open();
		// AccusationSuggestionMenu suggestion = new
		// AccusationSuggestionMenu(this, 0,
		// "Suggestion");
		// System.out.println(suggestion.getAnswers() + "1");
	}

	public Player getCurrentPlayer() {
		return playerList.get(turn % getNumPlayers());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start() {
		currentPlayer = playerList.get(turn % getNumPlayers());
		currentPlayer.getNotepad().open();
		currentActionMenu = new ActionMenu(this);
	}
}
