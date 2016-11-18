package edu.neumont.teamgift.clue.board;

import edu.neumont.teamgift.clue.Player;

/**
 * A controller for all aspects of game.
 */
public class GameMaster {
    /**
     * The amount of players in the game.
     * TODO Prompt for number of players
     */
    private int numPlayers = 0;
    /**
     * The list of players in the game.
     */
    private Player[] playerList = new Player[numPlayers];

    /**
     * The people available in the game to choose from.
     * TODO Prompt for player select if we want
     */
    private String[] people = {"Colonel Mustard", "Miss Scarlet", "Professor Plum", "Mr. Green", "Mrs. White",
            "Mrs. Peacock"};

    /**
     * The game board.
     */
    private Board board;

    /**
     * Creates the game board.
     */
    public final void createBoard() {
        // TODO Get the path that will be used.
        // board = new Board();
    }

    /**
     * Creates all the players in the game, and stores them into player list.
     */
    public final void createPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            Player p = new Player(board, i + 1, people[i]);
            playerList[i] = p;
        }
    }

    /**
     * Handles the players turn and its movement.
     *
     * @param p The player that is currently running its turn.
     */
    public final void takeTurn(final Player p) {
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
                checkValidMove = true;
                int rollReamining = roll - spaceLeft;
                // TODO get new move location
            }
        }
    }

}
