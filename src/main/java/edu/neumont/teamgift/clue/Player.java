package edu.neumont.teamgift.clue;

import edu.neumont.teamgift.clue.board.Board;
import edu.neumont.teamgift.clue.cards.Deck;

/**
 * A playable character in the game containing information necessary for the player to play.
 */
public class Player {

    /**
     * The board the player is on.
     */
    private Board board;

    /**
     * The id of the player, used for primary identification of player, next to name.
     */
    private int id;
    /**
     * The name of the in game player.
     */
    private String name;
    /**
     * The cards the player holds.
     */
    private Deck deck;
    /**
     * The position of the player on the board.
     */
    private Vector2i position;

    /**
     * Creates a player initializing its board, the id, and its name.
     * @param parentBoard The board the player is on.
     * @param playerID The id of the player.
     * @param playerName The name of the player.
     */
    public Player(final Board parentBoard, final int playerID, final String playerName) {
        this.board = board;

        this.id = id;
        this.name = name;

        this.deck = new Deck();
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public Deck getDeck() {
        return deck;
    }

	/*
     * public void addCard(Card newCard) { cards.add(newCard); }
	 */

    public Vector2i getPosition() {
        return position;
    }

    public void setPosition(Vector2i newPosition) {
        position = newPosition;
    }

    public Board getBoard() {
        return this.board;
    }

    /**
     * Attempts to make a move on the board.
     * @param newPosition The new position to move to.
     * @param maxDistance The max number of tiles they can travel.
     * @return Returns the amount of tiles it took for that make the move;
     * Returns -1 if move was not able to be made.
     */
    public int makeMove(Vector2i newPosition, int maxDistance) {
        Path p = new Path(getBoard(), getPosition(), newPosition, maxDistance);
        if (p.isPossible()) {
            return p.getMoves();
        }
        return -1;
    }

    public boolean isInGame() {
        return board != null;
    }

}
